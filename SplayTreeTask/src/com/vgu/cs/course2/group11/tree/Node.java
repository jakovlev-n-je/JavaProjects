package com.vgu.cs.course2.group11.tree;

public class Node {

    private Node parent;

    private Node left;

    private Node right;

    private final int key;

    private final String value;

    public Node(int key, String value, Node parent) {
        this.parent = parent;
        this.left = null;
        this.right = null;
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public Node getRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
