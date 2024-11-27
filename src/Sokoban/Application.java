package Sokoban;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        MapInfo mapInfo = application.start();
        boolean isRunning = true;
        while (isRunning) {
            isRunning = application.playGame(mapInfo);
        }
    }

    public MapInfo start() {
        StageReader reader = new StageReader();
        String stage = reader.receiveStage();
        MapInfo mapInfo = reader.parseStage(stage);
        System.out.println(mapInfo.getStageName());
        return mapInfo;
    }

    public boolean playGame(MapInfo mapInfo) {
        PlayerCommand command = new PlayerCommand();

        char[] commandList = command.getInputCommand(mapInfo);
        for(char commandWord : commandList) {
            if(command.isMovable(commandWord, mapInfo)) {
                movePlayer(commandWord, mapInfo);
            } else {
                if(commandWord=='q'|| commandWord=='Q') {
                    printEndingMessage();
                    return false;
                } else {
                    freezePlayer(commandWord, mapInfo);
                }
            }
        }
        return true;
    }

    public void movePlayer(char command, MapInfo mapInfo) {
        StageReader reader = new StageReader();
        switch (Character.toLowerCase(command)) {
            case 'w':
                mapInfo.moveUp();
                reader.printStage(mapInfo);
                System.out.println(command + ": 위로 이동합니다.");
                System.out.println();
                break;
            case 'a':
                mapInfo.moveLeft();
                reader.printStage(mapInfo);
                System.out.println(command + ": 왼쪽으로로 이동합니다.");
                System.out.println();
                break;
            case 's':
                mapInfo.moveDown();
                reader.printStage(mapInfo);
                System.out.println(command + ": 아래로 이동합니다.");
                System.out.println();
                break;
            case 'd':
                mapInfo.moveRight();
                reader.printStage(mapInfo);
                System.out.println(command + ": 오른쪽으로 이동합니다.");
                System.out.println();
                break;
        }
    }

    public void freezePlayer(char command, MapInfo mapInfo) {
        StageReader reader = new StageReader();
        reader.printStage(mapInfo);
        System.out.println();
        System.out.println(command + ": (경고!) 해당 명령을 수행할 수 없습니다!");
        System.out.println();
    }

    public void printEndingMessage() {
        System.out.println("Bye~");
    }
}
