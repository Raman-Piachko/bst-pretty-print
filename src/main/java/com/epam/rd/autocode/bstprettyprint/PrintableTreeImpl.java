package com.epam.rd.autocode.bstprettyprint;

public class PrintableTreeImpl implements PrintableTree {
    Node root;

    public PrintableTreeImpl() {
    }

    @Override
    public void add(int i) {
        root = addRecursive(root, i);
    }


    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value > current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value < current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }

    @Override
    public String prettyPrint() {
        return root.toString();
    }
}