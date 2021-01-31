package com.vgu.cs.course2.group11.tree;

import com.vgu.cs.course2.group11.exceptions.SplayTreeException;

public class SplayTree {

    private Node root;

    private int size;

    public SplayTree() {
        root = null;
        size = 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public String getValue(int key) throws SplayTreeException {
        Node node = find(key);
        if (node == null) {
            throw new SplayTreeException("The specified key does not exist");
        }
        return node.getValue();
    }

    public int getSize() {
        return size;
    }

    public void insert(int key, String value) throws SplayTreeException {
        if (find(key) != null) {
            throw new SplayTreeException("The specified key already exists");
        }
        Node child = root;
        Node parent = null;
        while (child != null) {
            parent = child;
            if (key > parent.getKey()) {
                child = child.getRight();
            } else {
                child = child.getLeft();
            }
        }
        child = new Node(key, value, parent);
        if (parent == null) {
            root = child;
        } else if (key > parent.getKey()) {
            parent.setRight(child);
        } else {
            parent.setLeft(child);
        }
        splay(child);
        size++;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() throws SplayTreeException {
        if (root == null) {
            throw new SplayTreeException("Tree is empty");
        }
        traverse(root);
    }

    public void remove(int key) throws SplayTreeException {
        Node node = find(key);
        if (node == null) {
            throw new SplayTreeException("The specified key does not exist");
        }
        removeNode(node);
    }

    private Node find(int key) throws SplayTreeException {
        Node child = root;
        Node parent = null;
        while (child != null) {
            parent = child;
            if (key > child.getKey()) {
                child = child.getRight();
            } else if (key < child.getKey()) {
                child = child.getLeft();
            } else {
                splay(child);
                return child;
            }
        }
        if (parent != null) {
            splay(parent);
            return null;
        }
        return null;
    }

    private void removeNode(Node node) throws SplayTreeException {
        if (node == null) {
            return;
        }
        splay(node);
        if ((node.getLeft() != null) && (node.getRight() != null)) {
            Node min = node.getLeft();
            while (min.getRight() != null) {
                min = min.getRight();
            }
            min.setRight(node.getRight());
            node.getRight().setParent(min);
            node.getLeft().setParent(null);
            root = node.getLeft();
        } else if (node.getRight() != null) {
            node.getRight().setParent(null);
            root = node.getRight();
        } else if (node.getLeft() != null) {
            node.getLeft().setParent(null);
            root = node.getLeft();
        } else {
            root = null;
        }
        size--;
    }

    private void rotate(Node child, Node parent, boolean isLeft) throws SplayTreeException {
        if ((child == null) || (parent == null) || (isLeft ?
                parent.getLeft() != child :
                parent.getRight() != child)
                || (child.getParent() != parent)) {
            throw new SplayTreeException("Invalid parameters");
        }
        if (parent.getParent() != null) {
            if (parent == parent.getParent().getLeft()) {
                parent.getParent().setLeft(child);
            } else {
                parent.getParent().setRight(child);
            }
        }
        if (isLeft ? child.getRight() != null : child.getLeft() != null) {
            if (isLeft) {
                child.getRight().setParent(parent);
            } else {
                child.getLeft().setParent(parent);
            }
        }
        child.setParent(parent.getParent());
        parent.setParent(child);
        if (isLeft) {
            parent.setLeft(child.getRight());
            child.setRight(parent);
        } else {
            parent.setRight(child.getLeft());
            child.setLeft(parent);
        }
    }

    private void splay(Node node) throws SplayTreeException {
        while (node.getParent() != null) {
            Node parent = node.getParent();
            Node grandParent = parent.getParent();
            if (grandParent == null) {
                rotate(node, parent, node == parent.getLeft());
            } else {
                if (node == parent.getLeft()) {
                    if (parent == grandParent.getLeft()) {
                        rotate(parent, grandParent, true);
                        rotate(node, parent, true);
                    } else {
                        rotate(node, node.getParent(), true);
                        rotate(node, node.getParent(), false);
                    }
                } else {
                    if (parent == grandParent.getLeft()) {
                        rotate(node, node.getParent(), false);
                        rotate(node, node.getParent(), true);
                    } else {
                        rotate(parent, grandParent, false);
                        rotate(node, parent, false);
                    }
                }
            }
        }
        root = node;
    }

    private void traverse(Node root) {
        if (root != null) {
            traverse(root.getLeft());
            System.out.printf(" %d", root.getKey());
            traverse(root.getRight());
        }
    }
}