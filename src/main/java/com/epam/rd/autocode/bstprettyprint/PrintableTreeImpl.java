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
        if (value > current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value < current.value) {
            current.right = addRecursive(current.right, value);
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
