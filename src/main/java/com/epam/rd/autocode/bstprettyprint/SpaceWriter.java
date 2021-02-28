package com.epam.rd.autocode.bstprettyprint;

public class SpaceWriter {

    public static String writeSpaces(int value) {
        StringBuilder space = new StringBuilder();
        int valueLength = String.valueOf(value).length();
        for (int i = 0; i < valueLength; i++) {
            space.append(" ");
        }
        return space.toString();
    }
}
