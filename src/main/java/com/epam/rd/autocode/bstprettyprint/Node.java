package com.epam.rd.autocode.bstprettyprint;

import java.io.IOException;

import static com.epam.rd.autocode.bstprettyprint.SpaceWriter.writeSpaces;

public class Node {
    Integer value;
    Node left, right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (right != null) {
            stringBuilder.append(right.printTree(true, ""));
        }

        stringBuilder.append(printNodeValue());

        if (left != null) {

            stringBuilder.append(left.printTree(false, ""));

        }
        return stringBuilder.toString();
    }

    private String printNodeValue() {
        StringBuilder stringBuilder = new StringBuilder();
        if (value == null) {
            stringBuilder.append("<null>");
        } else {
            if (right != null && left != null) {
                stringBuilder.append(value.toString()).append("┤");
            }
            if (right != null && left == null) {
                stringBuilder.append(value.toString()).append("┘");
            }
            if (right == null && left != null) {
                stringBuilder.append(value.toString()).append("┐");
            }
            if (right == null && left == null) {
                stringBuilder.append(value.toString());
            }
        }

        stringBuilder.append('\n');
        return stringBuilder.toString();
    }


    private String printTree(boolean isRight, String indent){
        StringBuilder stringBuilder = new StringBuilder();
        String spaces = writeSpaces(value);
        if (right != null) {
            stringBuilder.append(spaces);
            stringBuilder.append(right.printTree(true, indent + (isRight ? " " : "│")));
        }

        stringBuilder.append(indent);

        if (isRight) {
            stringBuilder.append(spaces);
            stringBuilder.append("┌");
        } else {
            stringBuilder.append(spaces);
            stringBuilder.append("└");
        }

        stringBuilder.append(printNodeValue());

        if (left != null) {
            stringBuilder.append(left.printTree(false, indent + (isRight ? "  │" : "  ")));
        }

        return stringBuilder.toString();
    }
}
