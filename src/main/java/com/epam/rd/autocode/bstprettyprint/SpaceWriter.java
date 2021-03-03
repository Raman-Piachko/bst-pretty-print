package com.epam.rd.autocode.bstprettyprint;

public class SpaceWriter {

    public static String makeSpaces(Integer value) {
        if (value == null) {
            return "";
        }

        StringBuilder space = new StringBuilder();
        int valueLength = String.valueOf(value).length();
        space.append(" ".repeat(valueLength));

        return space.toString();
    }
}