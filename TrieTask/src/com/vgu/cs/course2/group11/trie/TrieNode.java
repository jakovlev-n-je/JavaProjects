package com.vgu.cs.course2.group11.trie;

public class TrieNode {

    private int count;

    private boolean last;

    private final TrieNode[] subnodes;

    private final char symbol;

    public TrieNode(char symbol, boolean last, int count) {
        this.symbol = symbol;
        this.last = last;
        this.count = count;
        this.subnodes = new TrieNode[32];
    }

    public int getCount() {
        return count;
    }

    public boolean getLast() {
        return last;
    }

    public char getSymbol() {
        return symbol;
    }

    public TrieNode[] getSubnodes() {
        return subnodes;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setLast(boolean last) {
        this.last = last;
    }
}
