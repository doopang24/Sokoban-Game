package Sokoban;

import java.util.Scanner;

public class PlayerCommand {

    public char[] getInputCommand() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("SOKOBAN>");
                String command = scanner.nextLine();
                char[] commandList = command.toCharArray();
                for (char word : commandList) {
                    if (!Character.isLetter(word) || word == ' ') {
                        throw new IllegalArgumentException();
                    }
                }
                return commandList;
            } catch (Exception e) {
                System.out.println("(경고) 지원하지 않는 명령입니다!");
            }
        }
    }

    public boolean isMovable(char word, MapInfo mapInfo) {
        if (word == 'w' || word == 'W' || word == 'a' || word == 'A' || word == 's' || word == 'S' || word == 'd' || word == 'D') {
            return mapInfo.checkWay(word);
        } else {
            return false;
        }
    }
}


