package com.epam.rd.autocode.bstprettyprint;

import static com.epam.rd.autocode.bstprettyprint.SpaceWriter.makeSpaces;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.DOUBLE_ROOT;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.DOWN;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.DOWN_ROOT;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.INDENT;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.LINE;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.SPACE;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.UP;
import static com.epam.rd.autocode.bstprettyprint.TreeConstants.UP_ROOT;

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
            stringBuilder.append(right.printTree(true, INDENT));
        }

        stringBuilder.append(printNodeValue());

        if (left != null) {
            stringBuilder.append(left.printTree(false, INDENT));
        }

        return stringBuilder.toString();
    }

    private String printNodeValue() {
        StringBuilder stringBuilder = new StringBuilder();

        if (right != null && left != null) {
            stringBuilder.append(value.toString()).append(DOUBLE_ROOT);
        }
        if (right != null && left == null) {
            stringBuilder.append(value.toString()).append(UP_ROOT);
        }
        if (right == null && left != null) {
            stringBuilder.append(value.toString()).append(DOWN_ROOT);
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
            stringBuilder.append(right.printTree(true, indent + spaces + (isRight ? SPACE : LINE)));
        }

        stringBuilder.append(indent);
        stringBuilder.append(spaces);

        if (isRight) {
            stringBuilder.append(UP);
        } else {
            stringBuilder.append(DOWN);
        }

        stringBuilder.append(printNodeValue());

        if (left != null) {
            stringBuilder.append(left.printTree(false, indent + spaces + (isRight ? LINE : SPACE)));
        }

        return stringBuilder.toString();
    }
}