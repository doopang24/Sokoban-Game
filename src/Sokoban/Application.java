package Sokoban;

public class Application {
    public static void main(String[] args) {

        StageReader reader = new StageReader();
        String stage = reader.receiveStage();
        MapInfo mapInfo = reader.parseStage(stage);
        reader.printStage(mapInfo);
    }
}
