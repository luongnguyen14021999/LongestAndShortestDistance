package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class CirclePanel extends Panel {
    public LinkedList<Circle> circles = new  LinkedList<Circle>();
    public LinkedList<Line> lines = new LinkedList<Line>();

    public void addCircle(Circle circle) {
        circles.add(circle);
        this.repaint();
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    double max = 0;
    double min = 0;
    double a = 0;
    int x = 0;
    int y = 0;
    int x0 = 0;
    int y0 = 0;
    @Override
    public void paint(Graphics g)
    {
        for (Circle c : circles) {
            if (circles.indexOf(c) > 0)
            {
                this.addLine(new Line(circles.get(circles.indexOf(c) - 1).getX() + 5, circles.get(circles.indexOf(c) - 1).getY() + 5, circles.get(circles.indexOf(c)).getX() + 5, circles.get(circles.indexOf(c)).getY() + 5, Color.black));
                g.setColor(Color.black);
                g.drawLine(circles.get(circles.indexOf(c) - 1).getX() + 5, circles.get(circles.indexOf(c) - 1).getY() + 5, circles.get(circles.indexOf(c)).getX() + 5, circles.get(circles.indexOf(c)).getY() + 5);
            }
            g.setColor(Color.black);
            g.drawLine( circles.getLast().getX()+ 5, circles.getLast().getY() + 5, circles.getFirst().getX() + 5, circles.getFirst().getY() + 5);
            for(Circle p: circles)
            {
                min = min + Math.abs((circles.getFirst().getX()-p.getX())*(circles.getFirst().getX()-p.getX())+(circles.getFirst().getY()-p.getY())*(circles.getFirst().getY()-p.getY()));
            }
            for (Circle c1 : circles) {
                for (Circle c2 : circles)
                {
                    a = a + Math.abs((c1.getX() - c2.getX()) * (c1.getX() - c2.getX()) + (c1.getY() - c2.getY()) * (c1.getY() - c2.getY()));
                }
                if (a > max && circles.lastIndexOf(c) > 1 )
                {
                    max = a;
                    x = c1.getX();
                    y = c1.getY();
                }
                if(a<min && circles.indexOf(c) > 1)
                {
                    min = a;
                    x0 = c1.getX();
                    y0 = c1.getY();
                }
                if (a == min && circles.lastIndexOf(c) <= 1)
                {
                    max = a;
                    x0 = circles.getFirst().getX();
                    y0 = circles.getFirst().getY();
                }
                a = 0;
            }
            for (Circle c3 : circles)
            {
                if (c3.getX() == x && c3.getY() == y) {
                    g.setColor(Color.blue);
                    g.fillOval(x, y, 10, 10);
                } else if(c3.getX() == x0 && c3.getY() == y0) {
                    g.setColor(Color.red);
                    g.fillOval(x0, y0, 10, 10);
                } else {
                    g.setColor(Color.black);
                    g.fillOval(c3.getX(), c3.getY(), 10, 10);
                }
            }

            }
        }
    }








