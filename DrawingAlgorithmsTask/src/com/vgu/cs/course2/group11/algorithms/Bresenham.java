package com.vgu.cs.course2.group11.algorithms;

import java.awt.*;
import java.awt.geom.Line2D;

public class Bresenham {

    public static void draw(int x0, int y0, int x1, int y1, Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int dx = x1 - x0;
        int dy = y1 - y0;
        int incX = Integer.compare(dx, 0);
        int incY = Integer.compare(dy, 0);
        dx = Math.abs(dx);
        dy = Math.abs(dy);
        int pdx, pdy, es, el;
        if (dx > dy) {
            pdx = incX;
            pdy = 0;
            es = dy;
            el = dx;
        } else {
            pdx = 0;
            pdy = incY;
            es = dx;
            el = dy;
        }
        int x = x0;
        int y = y0;
        int err = el / 2;
        g2.draw(new Line2D.Float(x, y, x, y));
        for (int t = 0; t < el; t++) {
            err -= es;
            if (err < 0) {
                err += el;
                x += incX;
                y += incY;
            } else {
                x += pdx;
                y += pdy;
            }
            g2.draw(new Line2D.Float(x, y, x, y));
        }
    }

    public static void clear(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(1, 1, 300, 300);
    }
}
