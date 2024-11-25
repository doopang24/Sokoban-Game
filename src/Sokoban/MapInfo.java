package Sokoban;

public class MapInfo {

    private String stageName;
    private String inputStage;
    private int[][] mapData;
    private int width;
    private int height;
    private int holeCount;
    private int ballCount;
    private int playerRow;
    private int playerCol;

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getInputStage() {
        return inputStage;
    }

    public void setInputStage(String inputString) {
        this.inputStage = inputString;
    }

    public int[][] getMapData() {
        return mapData;
    }

    public void setMapData(int[][] mapData) {
        this.mapData = mapData;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHoleCount() {
        return holeCount;
    }

    public void setHoleCount(int holeCount) {
        this.holeCount = holeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void setPlayerCol(int playerCol) {
        this.playerCol = playerCol;
    }

    public boolean checkWay(char command) {
        boolean check = false;
        switch (command) {
            case 'w' | 'W':
                if (mapData[playerRow - 1][playerCol] == 0) check = true;
                break;
            case 'a' | 'A':
                if (mapData[playerRow][playerCol - 1] == 0) check = true;
                break;
            case 's' | 'S':
                if (mapData[playerRow + 1][playerCol] == 0) check = true;
                break;
            case 'd' | 'D':
                if (mapData[playerRow][playerCol + 1] == 0) check = true;
                break;
        }
        return check;
    }

    public void moveUp() {
        playerRow--;
    }

    public void moveDown() {
        playerRow++;
    }

    public void moveLeft() {
        playerCol--;
    }

    public void moveRight() {
        playerCol++;
    }
}