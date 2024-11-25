package Sokoban;

import java.util.Map;
import java.util.HashMap;

public class Converter {

    private static final Map<Character, Integer> symbolToValue = new HashMap<>();

    static {
        symbolToValue.put(' ', 0);
        symbolToValue.put('O', 1);
        symbolToValue.put('o', 2);
        symbolToValue.put('P', 3);
        symbolToValue.put('#', 4);
    }

    public int charToValue(char symbol) {
        return symbolToValue.getOrDefault(symbol, -1);
    }
}
