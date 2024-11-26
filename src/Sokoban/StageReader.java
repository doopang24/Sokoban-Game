package Sokoban;

public class StageReader {

    Converter converter = new Converter();

    public String receiveStage() {
        String input = """
                Stage 2
                  #######  
                ###  O  ###
                #    o    #
                # Oo P oO #
                ###  o  ###
                  #  O  #  
                  #######  
                """;
        return input.strip();
    }

    public MapInfo parseStage(String stage) {
        MapInfo mapInfo = new MapInfo();
        String[] lines = stage.split("\n");
        String stageName = lines[0];

        int height = lines.length - 1;
        int width = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            builder.append(lines[i]);
            if (i < lines.length - 1) {
                builder.append("\n");
            }
            if (lines[i].length() > width) width = lines[i].length();
        }
        String stageComposition = builder.toString();

        int[][] mapData = new int[height][width];
        int holeCount = 0;
        int ballCount = 0;
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            for (int j = 0; j < line.length(); j++) {
                char symbol = line.charAt(j);
                int value = converter.charToValue(symbol);
                mapData[i - 1][j] = value;
                if (value == 1) holeCount++;
                else if (value == 2) ballCount++;
                else if (value == 3) {
                    playerRow = i;
                    playerCol = j + 1;
                }
            }
        }
        mapInfo.setStageName(stageName);
        mapInfo.setInputStage(stageComposition);
        mapInfo.setMapData(mapData);
        mapInfo.setWidth(width);
        mapInfo.setHeight(height);
        mapInfo.setHoleCount(holeCount);
        mapInfo.setBallCount(ballCount);
        mapInfo.setPlayerRow(playerRow);
        mapInfo.setPlayerCol(playerCol);

        return mapInfo;
    }

    public String mapDataToStage(int[][] mapData, int height, int width) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char symbol = converter.valueToChar(mapData[i][j]);
                builder.append(symbol);
            }
            if (i < height - 1) builder.append("\n");
        }
        return builder.toString();
    }

    public void printStage(MapInfo mapInfo) {
        String stageStatus = mapDataToStage(mapInfo.getMapData(), mapInfo.getHeight(), mapInfo.getWidth());
        System.out.println();
        System.out.println(stageStatus);
        System.out.println();
    }
}
