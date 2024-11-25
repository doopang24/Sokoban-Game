package Sokoban;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        StageReader reader = new StageReader();
        PlayerCommand command = new PlayerCommand();

        String stage = reader.receiveStage();
        MapInfo mapInfo = reader.parseStage(stage);
        reader.printStage(mapInfo);

        char[] commandList = command.getInputCommand();
    }
}
