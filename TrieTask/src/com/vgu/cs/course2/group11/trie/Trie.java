package com.vgu.cs.course2.group11.trie;

import com.vgu.cs.course2.group11.exceptions.UnknownSymbolException;

import java.util.LinkedList;
import java.util.List;

public class Trie {

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0', false, 0);
    }

    public void add(String word) throws UnknownSymbolException {
        TrieNode current = root;
        char[] letters = word.toLowerCase().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int index = getLetterIndex(letters[i]);
            boolean end = i == letters.length - 1;
            if (current.getSubnodes()[index] == null) {
                current.getSubnodes()[index] = new TrieNode((char) (index + 1072), end, end ? 1 : 0);
            } else if (current.getSubnodes()[index].getLast() && end) {
                current.getSubnodes()[index].setCount(current.getSubnodes()[index].getCount() + 1);
            }
            current = current.getSubnodes()[index];
        }
    }

    public int getWordCount(String word) throws UnknownSymbolException {
        TrieNode node = getLastNode(word);
        return node == null ? 0 : node.getCount();
    }

    public List<Word> pickUp(String word) throws UnknownSymbolException {
        TrieNode node = getLastNode(word);
        if (node == null) {
            return new LinkedList<>();
        }
        List<Word> words = new LinkedList<>();
        for (TrieNode subnode : getNotNullSubnodes(node)) {
            traverse(words, subnode, new StringBuilder(word));
        }
        words.sort((first, second) -> first.getCount() <= second.getCount() ? first.getCount() < second.getCount() ? 1 : 0 : -1);
        return words;
    }

    public void remove(String word) throws UnknownSymbolException {
        TrieNode parent = root;
        int childIndex = 0;
        TrieNode current = root;
        for (char letter : word.toCharArray()) {
            int index = getLetterIndex(letter);
            if (current.getSubnodes()[index] == null)
                return;
            if (current.getSubnodes()[index].getLast()) {
                if (current.getSubnodes()[index].getCount() > 1) {
                    current.getSubnodes()[index].setCount(current.getSubnodes()[index].getCount() - 1);
                } else {
                    parent = current;
                    childIndex = index;
                }
            }
            current = current.getSubnodes()[index];
        }
        if (childIndex == 0) {
            return;
        }
        if (parent.getSubnodes()[childIndex].getLast()) {
            parent.getSubnodes()[childIndex].setCount(parent.getSubnodes()[childIndex].getCount() - 1);
            if (parent.getSubnodes()[childIndex].getCount() < 1) {
                parent.getSubnodes()[childIndex].setLast(false);
            }
        } else {
            parent.getSubnodes()[childIndex] = null;
        }
    }

    private TrieNode getLastNode(String word) throws UnknownSymbolException {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.getSubnodes()[getLetterIndex(word.charAt(i))] != null) {
                current = current.getSubnodes()[getLetterIndex(word.charAt(i))];
            } else {
                return null;
            }
        }
        return current;
    }

    private int getLetterIndex(char letter) throws UnknownSymbolException {
        if ('я' < letter || letter < 'а') {
            throw new UnknownSymbolException("Unknown symbol found");
        }
        return letter - 'а';
    }

    private List<TrieNode> getNotNullSubnodes(TrieNode node) {
        List<TrieNode> subnodes = new LinkedList<>();
        for (TrieNode subnode : node.getSubnodes()) {
            if (subnode != null) {
                subnodes.add(subnode);
            }
        }
        return subnodes;
    }

    private void traverse(List<Word> words, TrieNode root, StringBuilder word) {
        for (TrieNode subnode : getNotNullSubnodes(root)) {
            traverse(words, subnode, new StringBuilder(word).append(root.getSymbol()));
        }
        if (root.getLast()) {
            words.add(new Word(word.append(root.getSymbol()).toString(), root.getCount()));
        }
    }
}
