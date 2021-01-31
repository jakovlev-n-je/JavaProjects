package com.vgu.cs.course2.group11.frames;

import com.vgu.cs.course2.group11.exceptions.BigFunctionException;
import com.vgu.cs.course2.group11.exceptions.InputFunctionException;
import com.vgu.cs.course2.group11.draw.DrawJPanel;

import javax.swing.*;
import java.awt.*;

public class GraphicFrame extends Frame {

    private JLabel label;
    private JTextField functionField;
    private JButton drawButton;
    private JButton clearButton;
    private JPanel toolbar;
    private DrawJPanel drawJPanel;
    private JPanel contentPanel;

    private final int width = 1275;
    private final int height = 927;
    private final int indent = 20;

    public GraphicFrame() {
        setLabel();
        setFunctionField();
        setDrawButton();
        setClearButton();
        setToolbar();
        setDrawPane();
        setContentPane();
    }

    private void setLabel() {
        label = new JLabel("Введите f(x): ");
        label.setBounds(indent, indent, 80, 30);
    }

    private void setFunctionField() {
        functionField = new JTextField();
        functionField.setBounds(5 * indent, indent, 200, 30);
    }

    private void setDrawButton() {
        drawButton = new JButton("Построить график");
        drawButton.setBounds(indent, 3 * indent, 280, 30);
        drawButton.addActionListener(e -> {
            try {
                drawJPanel.drawGraph(drawJPanel.getGraphics(), functionField.getText());
                clearButton.setEnabled(true);
                JOptionPane.showMessageDialog(null,
                        "График функции успешно построен!", "Успех", JOptionPane.INFORMATION_MESSAGE);
            } catch (InputFunctionException invalidFunction) {
                JOptionPane.showMessageDialog(null,
                        "Неверно введена функция!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            } catch (BigFunctionException bigFunction) {
                JOptionPane.showMessageDialog(null,
                        "График функции невозможно построить на графической панели!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void setClearButton() {
        clearButton = new JButton("Очистить панель");
        clearButton.setEnabled(false);
        clearButton.setBounds(indent, 5 * indent, 280, 30);
        clearButton.addActionListener(e -> {
            drawJPanel.clear(drawJPanel.getGraphics());
            drawJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            clearButton.setEnabled(false);
            JOptionPane.showMessageDialog(null,
                    "Панель для рисования графиков функции успешно очищена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setToolbar() {
        toolbar = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, 318, 148);
            }
        };
        toolbar.setBounds(indent, indent, 320, 150);
        toolbar.setLayout(null);
        toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        toolbar.add(label);
        toolbar.add(functionField);
        toolbar.add(drawButton);
        toolbar.add(clearButton);
    }

    private void setDrawPane() {
        drawJPanel = new DrawJPanel();
        drawJPanel.setBounds(indent * 18, indent, width, height);
        drawJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setContentPane() {
        contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, width, height);
        contentPanel.setLayout(null);
        contentPanel.add(toolbar);
        contentPanel.add(drawJPanel);
        contentPanel.setOpaque(true);
    }

    public static void run() {
        JFrame frame = new JFrame("Построение графика функции");
        frame.setPreferredSize(new Dimension(1671, 1006));
        frame.setContentPane(new GraphicFrame().contentPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
