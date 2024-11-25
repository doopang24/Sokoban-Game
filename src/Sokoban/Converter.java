package Sokoban;

import java.util.Map;
import java.util.HashMap;

public class Converter {

    private static final Map<Character, Integer> symbolToValue = new HashMap<>();
    private static final Map<Integer, Character> valueToSymbol = new HashMap<>();

    static {
        symbolToValue.put(' ', 0);
        symbolToValue.put('O', 1);
        symbolToValue.put('o', 2);
        symbolToValue.put('P', 3);
        symbolToValue.put('#', 4);

        valueToSymbol.put(0, ' ');
        valueToSymbol.put(1, 'O');
        valueToSymbol.put(2, 'o');
        valueToSymbol.put(3, 'P');
        valueToSymbol.put(4, '#');
    }

    public int charToValue(char symbol) {
        return symbolToValue.getOrDefault(symbol, -1);
    }

    public int valueToChar(int value) {
        return valueToSymbol.getOrDefault(value, '?');
    }
}
