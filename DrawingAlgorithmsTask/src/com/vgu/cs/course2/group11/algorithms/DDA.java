package com.vgu.cs.course2.group11.algorithms;

import java.awt.*;
import java.awt.geom.Line2D;

public class DDA {

    public static void draw(int x0, int y0, int x1, int y1, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        float length = Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
        float dx = (x1 - x0) / length;
        float dy = (y1 - y0) / length;
        float x = x0;
        float y = y0;
        for (int i = 0; i <= length; i++) {
            x += dx;
            y += dy;
            g2.draw(new Line2D.Float(x, y, x, y));
        }
    }

    public static void clear(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, 300, 300);
    }
}
