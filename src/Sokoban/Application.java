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
        reader.printStage(mapInfo);
        return mapInfo;
    }

    public void playGame(MapInfo mapInfo) {
        PlayerCommand command = new PlayerCommand();

        char[] commandList = command.getInputCommand();
        for(char commandWord : commandList) {
            if(command.isMovable(commandWord, mapInfo)) {
                movePlayer(commandWord, mapInfo);
            } else {
                if(commandWord=='q'|| commandWord=='Q') {
                    printEndingMessage();
                    return;
                } else {
                    freezePlayer(commandWord, mapInfo);
                }
            }
        }
    }

    public void movePlayer(char command, MapInfo mapInfo) {
        StageReader reader = new StageReader();
        switch (command) {
            case 'w'|'W':
                mapInfo.moveUp();
                break;
            case 'a'|'A':
                mapInfo.moveLeft();
                break;
            case 's'|'S':
                mapInfo.moveDown();
                break;
            case 'd'|'D':
                mapInfo.moveRight();
                break;
        }
        reader.printStage(mapInfo);
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
