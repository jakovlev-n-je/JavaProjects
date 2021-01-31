package com.vgu.cs.course2.group11.frames;

import com.vgu.cs.course2.group11.algorithms.Bresenham;
import com.vgu.cs.course2.group11.algorithms.DDA;
import com.vgu.cs.course2.group11.algorithms.Wu;

import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel bresenhamJPanel;
    private JPanel ddaJPanel;
    private JPanel wuJPanel;
    private JPanel bresenhamToolbar;
    private JPanel ddaToolbar;
    private JPanel wuToolbar;
    private JButton drawBresenham;
    private JButton clearBresenham;
    private JButton drawDDA;
    private JButton clearDDA;
    private JButton drawWu;
    private JButton clearWu;
    private JLabel x0LabelBresenham;
    private JLabel y0LabelBresenham;
    private JLabel x1LabelBresenham;
    private JLabel y1LabelBresenham;
    private JLabel x0LabelDDA;
    private JLabel y0LabelDDA;
    private JLabel x1LabelDDA;
    private JLabel y1LabelDDA;
    private JLabel x0LabelWu;
    private JLabel y0LabelWu;
    private JLabel x1LabelWu;
    private JLabel y1LabelWu;
    private JSpinner x0Bresenham;
    private JSpinner y0Bresenham;
    private JSpinner x1Bresenham;
    private JSpinner y1Bresenham;
    private JSpinner x0DDA;
    private JSpinner y0DDA;
    private JSpinner x1DDA;
    private JSpinner y1DDA;
    private JSpinner x0Wu;
    private JSpinner y0Wu;
    private JSpinner x1Wu;
    private JSpinner y1Wu;
    private JPanel contentPanel;

    private final int panelWidth = 302;
    private final int panelHeight = 302;
    private final int toolbarWidth = 302;
    private final int toolbarHeight = 202;
    private final int fieldWidth = 95;
    private final int indent = 20;
    private final int help = 25;

    public DrawFrame() {
        setLabel1();
        setLabel2();
        setLabel3();
        setBresenhamJPanel();
        setBresenhamToolbar();
        setDDAJPanel();
        setDDAToolbar();
        setWuJPanel();
        setWuToolbar();
        setContentPane();
    }

    private void setLabel1() {
        label1 = new JLabel("Алгоритм Брезенхема");
        label1.setBounds(indent + 10, indent - 5, panelWidth, indent);
    }

    private void setLabel2() {
        label2 = new JLabel("Алгоритм DDA");
        label2.setBounds(panelWidth + indent * 2 + 10, indent - 5, panelWidth, indent);
    }

    private void setLabel3() {
        label3 = new JLabel("Алгоритм Сяолиня Ву");
        label3.setBounds(panelWidth * 2 + indent * 3 + 10, indent - 5, panelWidth, indent);
    }

    private void setBresenhamJPanel() {
        bresenhamJPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, panelWidth - 1, panelHeight - 1);
            }
        };
        bresenhamJPanel.setBounds(indent, indent * 2 + 5, panelWidth, panelHeight);
        bresenhamJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setBresenhamToolbar() {
        bresenhamToolbar = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, toolbarWidth - 1, toolbarHeight - 1);
            }
        };
        bresenhamToolbar.setBounds(indent, panelWidth + indent * 3 + 5, toolbarWidth, toolbarHeight);
        bresenhamToolbar.setLayout(null);
        bresenhamToolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setX0Bresenham();
        setY0Bresenham();
        setX1Bresenham();
        setY1Bresenham();
        bresenhamToolbar.add(x0LabelBresenham);
        bresenhamToolbar.add(y0LabelBresenham);
        bresenhamToolbar.add(x1LabelBresenham);
        bresenhamToolbar.add(y1LabelBresenham);
        bresenhamToolbar.add(x0Bresenham);
        bresenhamToolbar.add(y0Bresenham);
        bresenhamToolbar.add(x1Bresenham);
        bresenhamToolbar.add(y1Bresenham);
        setDrawBresenham();
        setClearBresenham();
        bresenhamToolbar.add(drawBresenham);
        bresenhamToolbar.add(clearBresenham);
    }

    private void setDDAJPanel() {
        ddaJPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, panelWidth - 1, panelHeight - 1);
            }
        };
        ddaJPanel.setBounds(panelWidth + indent * 2, indent * 2 + 5, panelWidth, panelHeight);
        ddaJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setDDAToolbar() {
        ddaToolbar = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, toolbarWidth - 1, toolbarHeight - 1);
            }
        };
        ddaToolbar.setBounds(panelWidth + indent * 2, panelWidth + indent * 3 + 5, toolbarWidth, toolbarHeight);
        ddaToolbar.setLayout(null);
        ddaToolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setX0DDA();
        setY0DDA();
        setX1DDA();
        setY1DDA();
        ddaToolbar.add(x0LabelDDA);
        ddaToolbar.add(y0LabelDDA);
        ddaToolbar.add(x1LabelDDA);
        ddaToolbar.add(y1LabelDDA);
        ddaToolbar.add(x0DDA);
        ddaToolbar.add(y0DDA);
        ddaToolbar.add(x1DDA);
        ddaToolbar.add(y1DDA);
        setDrawDDA();
        setClearDDA();
        ddaToolbar.add(drawDDA);
        ddaToolbar.add(clearDDA);
    }

    private void setWuJPanel() {
        wuJPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, panelWidth - 1, panelHeight - 1);
            }
        };
        wuJPanel.setBounds(panelWidth * 2 + indent * 3, indent * 2 + 5, panelWidth, panelHeight);
        wuJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setWuToolbar() {
        wuToolbar = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.fillRect(1, 1, toolbarWidth - 1, toolbarHeight - 1);
            }
        };
        wuToolbar.setBounds(panelWidth * 2 + indent * 3, panelWidth + indent * 3 + 5, toolbarWidth, toolbarHeight);
        wuToolbar.setLayout(null);
        wuToolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setX0Wu();
        setY0Wu();
        setX1Wu();
        setY1Wu();
        wuToolbar.add(x0LabelWu);
        wuToolbar.add(y0LabelWu);
        wuToolbar.add(x1LabelWu);
        wuToolbar.add(y1LabelWu);
        wuToolbar.add(x0Wu);
        wuToolbar.add(y0Wu);
        wuToolbar.add(x1Wu);
        wuToolbar.add(y1Wu);
        setDrawWu();
        setClearWu();
        wuToolbar.add(drawWu);
        wuToolbar.add(clearWu);
    }

    private void setDrawBresenham() {
        drawBresenham = new JButton("Построить прямую линию");
        drawBresenham.setBounds(indent + 1, indent * 5 + 1, toolbarWidth - (indent * 2 + 2), 30);
        drawBresenham.addActionListener(e -> {
            int x0 = (int) x0Bresenham.getValue();
            int y0 = (int) y0Bresenham.getValue();
            int x1 = (int) x1Bresenham.getValue();
            int y1 = (int) y1Bresenham.getValue();
            if ((x0 > panelWidth || y0 > panelHeight || x1 > panelWidth || y1 > panelHeight) ||
                    (x0 <= 0 || y0 <= 0 || x1 <= 0 || y1 <= 0)) {
                JOptionPane.showMessageDialog(null,
                        "Введенные значения являются недопустимыми для отрисовки!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Bresenham.draw(x0, y0, x1, y1, bresenhamJPanel.getGraphics());
            clearBresenham.setEnabled(true);
            JOptionPane.showMessageDialog(null,
                    "Прямая линия было успешно построена!", "Успех", JOptionPane.INFORMATION_MESSAGE);

        });
    }

    private void setClearBresenham() {
        clearBresenham = new JButton("Очистить панель");
        clearBresenham.setEnabled(false);
        clearBresenham.setBounds(indent + 1, indent * 6 + 31, toolbarWidth - (indent * 2 + 2), 30);
        clearBresenham.addActionListener(e -> {
            Bresenham.clear(bresenhamJPanel.getGraphics());
            clearBresenham.setEnabled(false);
            JOptionPane.showMessageDialog(null,
                    "Панель для отрисовки прямых линий успешно очищена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setDrawDDA() {
        drawDDA = new JButton("Построить прямую линию");
        drawDDA.setBounds(indent + 1, indent * 5 + 1, toolbarWidth - (indent * 2 + 2), 30);
        drawDDA.addActionListener(e -> {
            int x0 = (int) x0DDA.getValue();
            int y0 = (int) y0DDA.getValue();
            int x1 = (int) x1DDA.getValue();
            int y1 = (int) y1DDA.getValue();
            if ((x0 > panelWidth || y0 > panelHeight || x1 > panelWidth || y1 > panelHeight) ||
                    (x0 <= 0 || y0 <= 0 || x1 <= 0 || y1 <= 0)) {
                JOptionPane.showMessageDialog(null,
                        "Введенные значения являются недопустимыми для отрисовки!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            DDA.draw(x0, y0, x1, y1, ddaJPanel.getGraphics());
            clearDDA.setEnabled(true);
            JOptionPane.showMessageDialog(null,
                    "Прямая линия было успешно построена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setClearDDA() {
        clearDDA = new JButton("Очистить панель");
        clearDDA.setEnabled(false);
        clearDDA.setBounds(indent + 1, indent * 6 + 31, toolbarWidth - (indent * 2 + 2), 30);
        clearDDA.addActionListener(e -> {
            DDA.clear(ddaJPanel.getGraphics());
            clearDDA.setEnabled(false);
            JOptionPane.showMessageDialog(null,
                    "Панель для отрисовки прямых линий успешно очищена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setDrawWu() {
        drawWu = new JButton("Построить прямую линию");
        drawWu.setBounds(indent + 1, indent * 5 + 1, toolbarWidth - (indent * 2 + 2), 30);
        drawWu.addActionListener(e -> {
            int x0 = (int) x0Wu.getValue();
            int y0 = (int) y0Wu.getValue();
            int x1 = (int) x1Wu.getValue();
            int y1 = (int) y1Wu.getValue();
            if ((x0 > panelWidth || y0 > panelHeight || x1 > panelWidth || y1 > panelHeight) ||
                    (x0 <= 0 || y0 <= 0 || x1 <= 0 || y1 <= 0)) {
                JOptionPane.showMessageDialog(null,
                        "Введенные значения являются недопустимыми для отрисовки!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Wu.draw(x0, y0, x1, y1, wuJPanel.getGraphics());
            clearWu.setEnabled(true);
            JOptionPane.showMessageDialog(null,
                    "Прямая линия было успешно построена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setClearWu() {
        clearWu = new JButton("Очистить панель");
        clearWu.setEnabled(false);
        clearWu.setBounds(indent + 1, indent * 6 + 31, toolbarWidth - (indent * 2 + 2), 30);
        clearWu.addActionListener(e -> {
            Wu.clear(wuJPanel.getGraphics());
            clearWu.setEnabled(false);
            JOptionPane.showMessageDialog(null,
                    "Панель для отрисовки прямых линий успешно очищена!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void setX0Bresenham() {
        x0LabelBresenham = new JLabel("x0: ");
        x0LabelBresenham.setBounds(indent + 1, indent + 1, fieldWidth, indent + 1);
        x0Bresenham = new JSpinner();
        x0Bresenham.setBounds(indent + help + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setY0Bresenham() {
        y0LabelBresenham = new JLabel("y0: ");
        y0LabelBresenham.setBounds(fieldWidth + indent * 2 + help + 1, indent + 1, fieldWidth, indent + 1);
        y0Bresenham = new JSpinner();
        y0Bresenham.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setX1Bresenham() {
        x1LabelBresenham = new JLabel("x1: ");
        x1LabelBresenham.setBounds(indent + 1, indent * 3 + 1, fieldWidth, indent + 1);
        x1Bresenham = new JSpinner();
        x1Bresenham.setBounds(indent + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setY1Bresenham() {
        y1LabelBresenham = new JLabel("y1: ");
        y1LabelBresenham.setBounds(fieldWidth + indent * 2 + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
        y1Bresenham = new JSpinner();
        y1Bresenham.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setX0DDA() {
        x0LabelDDA = new JLabel("x0: ");
        x0LabelDDA.setBounds(indent + 1, indent + 1, fieldWidth, indent + 1);
        x0DDA = new JSpinner();
        x0DDA.setBounds(indent + help + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setY0DDA() {
        y0LabelDDA = new JLabel("y0: ");
        y0LabelDDA.setBounds(fieldWidth + indent * 2 + help + 1, indent + 1, fieldWidth, indent + 1);
        y0DDA = new JSpinner();
        y0DDA.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setX1DDA() {
        x1LabelDDA = new JLabel("x1: ");
        x1LabelDDA.setBounds(indent + 1, indent * 3 + 1, fieldWidth, indent + 1);
        x1DDA = new JSpinner();
        x1DDA.setBounds(indent + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setY1DDA() {
        y1LabelDDA = new JLabel("y1: ");
        y1LabelDDA.setBounds(fieldWidth + indent * 2 + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
        y1DDA = new JSpinner();
        y1DDA.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setX0Wu() {
        x0LabelWu = new JLabel("x0: ");
        x0LabelWu.setBounds(indent + 1, indent + 1, fieldWidth, indent + 1);
        x0Wu = new JSpinner();
        x0Wu.setBounds(indent + help + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setY0Wu() {
        y0LabelWu = new JLabel("y0: ");
        y0LabelWu.setBounds(fieldWidth + indent * 2 + help + 1, indent + 1, fieldWidth, indent + 1);
        y0Wu = new JSpinner();
        y0Wu.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent + 1, fieldWidth, indent + 1);
    }

    private void setX1Wu() {
        x1LabelWu = new JLabel("x1: ");
        x1LabelWu.setBounds(indent + 1, indent * 3 + 1, fieldWidth, indent + 1);
        x1Wu = new JSpinner();
        x1Wu.setBounds(indent + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setY1Wu() {
        y1LabelWu = new JLabel("y1: ");
        y1LabelWu.setBounds(fieldWidth + indent * 2 + help + 1, indent * 3 + 1, fieldWidth, indent + 1);
        y1Wu = new JSpinner();
        y1Wu.setBounds(fieldWidth + indent * 2 + help * 2 + 1, indent * 3 + 1, fieldWidth, indent + 1);
    }

    private void setContentPane() {
        contentPanel = new JPanel();
        contentPanel.setBounds(0, 0, 1002, 628);
        contentPanel.setLayout(null);
        contentPanel.add(label1);
        contentPanel.add(label2);
        contentPanel.add(label3);
        contentPanel.add(bresenhamJPanel);
        contentPanel.add(ddaJPanel);
        contentPanel.add(wuJPanel);
        contentPanel.add(bresenhamToolbar);
        contentPanel.add(ddaToolbar);
        contentPanel.add(wuToolbar);
        contentPanel.setOpaque(true);
    }

    public static void run() {
        JFrame frame = new JFrame("Построение прямых линий");
        frame.setPreferredSize(new Dimension(1002, 628));
        frame.setContentPane(new DrawFrame().contentPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
