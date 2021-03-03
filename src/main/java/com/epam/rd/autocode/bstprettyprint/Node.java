package com.epam.rd.autocode.bstprettyprint;

import static com.epam.rd.autocode.bstprettyprint.SpaceWriter.makeSpaces;

public class Node {
    private Integer parent;
    private Integer value;
    private Node left, right;

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
        left.parent = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
        right.parent = value;
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

        stringBuilder.append('\n');
        return stringBuilder.toString();
    }


    private String printTree(boolean isRight, String indent) {
        StringBuilder stringBuilder = new StringBuilder();
        String spaces = makeSpaces(parent);

        if (right != null) {
            stringBuilder.append(right.printTree(true, indent + spaces + (isRight ? " " : "│")));
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
            stringBuilder.append(left.printTree(false, indent + spaces + (isRight ? "│" : " ")));
        }

        return stringBuilder.toString();
    }
}