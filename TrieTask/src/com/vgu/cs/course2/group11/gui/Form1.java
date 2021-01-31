package com.vgu.cs.course2.group11.gui;

import com.vgu.cs.course2.group11.exceptions.UnknownSymbolException;
import com.vgu.cs.course2.group11.trie.Trie;
import com.vgu.cs.course2.group11.trie.Word;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class Form1 extends JFrame {

    private static final int MAX_LIST_SIZE = 3;

    private JPanel contentPane;
    private JButton addButton;
    private JTextField addField;
    private JTextArea dictionaryArea;
    private JTextField inputField;
    private JTextArea outputArea;
    private JButton pickUpButton;
    private JButton removeButton;
    private JTextField removeField;

    private final Trie trie;

    public Form1() {
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        dictionaryArea.setBorder(new LineBorder(Color.BLACK, 1));
        outputArea.setBorder(new LineBorder(Color.BLACK, 1));
        trie = new Trie();

        addButton.addActionListener(e -> {
            String word = addField.getText().toLowerCase().trim();
            addField.setText("");
            if (checkCorrectness(word)) {
                try {
                    trie.add(word);
                } catch (UnknownSymbolException unknownSymbolException) {
                    unknownSymbolException.printStackTrace();
                }
                if (!dictionaryArea.getText().contains(word + '\n')) {
                    dictionaryArea.setText(dictionaryArea.getText() + word + '\n');
                }
                JOptionPane.showMessageDialog(contentPane, "Слово было успешно добавлено в словарь!");
            } else {
                JOptionPane.showMessageDialog(contentPane, "Задано некорректное слово!");
            }
        });

        removeButton.addActionListener(e -> {
            String word = removeField.getText().toLowerCase().trim();
            removeField.setText("");
            if (checkCorrectness(word)) {
                try {
                    trie.remove(word);
                    if (trie.getWordCount(word) == 0) {
                        dictionaryArea.setText(dictionaryArea.getText().replace(word + '\n', ""));
                    }
                } catch (UnknownSymbolException unknownSymbolException) {
                    unknownSymbolException.printStackTrace();
                }
                JOptionPane.showMessageDialog(contentPane, "Слово было успешно удалено из словаря!");
            } else {
                JOptionPane.showMessageDialog(contentPane, "Задано некорректное слово!");
            }
        });

        pickUpButton.addActionListener(e -> {
            String word = inputField.getText().toLowerCase().trim();
            inputField.setText("");
            if (checkCorrectness(word)) {
                try {
                    List<Word> words = trie.pickUp(word);
                    if (words.size() == 0) {
                        outputArea.setText("Слова не найдены!");
                        return;
                    }
                    StringBuilder output = new StringBuilder();
                    for (int i = 0; i < words.size(); i++) {
                        if (i >= MAX_LIST_SIZE) {
                            break;
                        }
                        output.append(words.get(i)).append('\n');
                    }
                    outputArea.setText(output.toString()
                    );
                } catch (UnknownSymbolException unknownSymbolException) {
                    unknownSymbolException.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(contentPane, "Задано некорректное слово!");
            }
        });
    }

    public static void run() {
        JFrame jf = new JFrame("Подбор окончаний");
        jf.setPreferredSize(new Dimension(800, 500));
        jf.setContentPane(new Form1().contentPane);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setVisible(true);
    }

    private boolean checkCorrectness(String text) {
        if (text.equals("")) {
            return false;
        }
        for (char symbol : text.toCharArray()) {
            if ('я' < symbol || symbol < 'а') {
                return false;
            }
        }
        return true;
    }
}
