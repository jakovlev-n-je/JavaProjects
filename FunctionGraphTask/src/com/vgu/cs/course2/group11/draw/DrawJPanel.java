package com.vgu.cs.course2.group11.draw;

import com.vgu.cs.course2.group11.exceptions.BigFunctionException;
import com.vgu.cs.course2.group11.algorithms.Wu;
import com.vgu.cs.course2.group11.exceptions.InputFunctionException;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawJPanel extends JPanel {

    private final int width = 1275;
    private final int height = 927;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, width, height);
        g2.setColor(Color.BLACK);
        drawAxes(g2);
        drawCoordinates(g2);
    }

    public void clear(Graphics g) {
        g.clearRect(0, 0, width, height);
        paintComponent(g);
    }

    public void drawGraph(Graphics g, String line) throws BigFunctionException, InputFunctionException {
        Graphics2D g2 = (Graphics2D) g;
        Random random = new Random();
        g2.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
        Expression function;
        try {
            function = new ExpressionBuilder(line).
                    variables("x").build();
        } catch (Exception e) {
            throw new InputFunctionException();
        }
        try {
            float x0, y0, x1, y1;
            for (float x = -26; x <= 26; x += 0.01f) {
                x0 = getXCoordinate(x);
                y0 = getYCoordinate((float) function.setVariable("x", x).evaluate());
                x1 = getXCoordinate(x + 0.01f);
                y1 = getYCoordinate((float) function.setVariable("x", x + 0.01f).evaluate());
                if (Float.isNaN(y0) || Float.isNaN(y1)) {
                    continue;
                }
                if (checkSize(x0, y0, x1, y1, 5)) {
                    if (checkSize(x0, y0, x1, y1, 1.25f))
                        Wu.draw(x0, y0, x1, y1, g2);
                } else {
                    throw new BigFunctionException();
                }
            }
        } catch (BigFunctionException bigFunction) {
            throw new BigFunctionException();
        }
    }

    private boolean checkSize(float x0, float y0, float x1, float y1, float degree) {
        return Math.abs(x0) <= Math.pow(width, degree) && Math.abs(y0) <= Math.pow(height, degree) &&
                Math.abs(x1) <= Math.pow(width, degree) && Math.abs(y1) <= Math.pow(height, degree);
    }

    private void drawAxes(Graphics2D g2) {
        Wu.draw(0, (float) height / 2, width, (float) height / 2, g2); // ось абсцисс
        Wu.draw((float) width / 2, 0, (float) width / 2, height, g2); // ось ординат
    }

    private void drawCoordinates(Graphics2D g2) {
        g2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        FontMetrics metrics = g2.getFontMetrics();
        int i, number;
        for (i = 12, number = -25; i < width; i += 25, number++) {
            if (number == 0) {
                continue;
            }
            Wu.draw(i, (float) height / 2 - 3, i, (float) height / 2 + 3, g2);
            g2.drawString(Integer.toString(number), i - metrics.stringWidth(Integer.toString(number)) / 2, height / 2 + 20);
            if (number == 25) {
                g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
                g2.drawString("X", i - metrics.stringWidth("X") / 2, height / 2 - 10);
            }
        }
        g2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        metrics = g2.getFontMetrics();
        for (i = height - 13, number = -18; i > 13; i -= 25, number++) {
            if (number == 0) {
                continue;
            }
            Wu.draw((float) width / 2 - 3, i, (float) width / 2 + 3, i, g2);
            g2.drawString(Integer.toString(number), width / 2 + 10, i - metrics.getHeight() / 2 + metrics.getAscent());
            if (number == 18) {
                g2.setFont(new Font("Times New Roman", Font.BOLD, 12));
                g2.drawString("Y", width / 2 - 30 / 2, i - metrics.getHeight() / 2 + metrics.getAscent());
            }
        }
    }

    private float getXCoordinate(float x) {
        return (float) width / 2 + x * 25;
    }

    private float getYCoordinate(float y) {
        return (float) height / 2 - y * 25;
    }
}
