package com.company;
import java.awt.*;
import java.awt.event.*;

public class CircleClickListener extends MouseAdapter
{
    private  CirclePanel panel;

    public CircleClickListener(CirclePanel panel)
    {
        super();
        this.panel = panel;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        panel.addCircle(new Circle(e.getX(),e.getY(),10,Color.black));
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }
}

