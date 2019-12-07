package com.company;
import javax.swing.*;

public class Main extends JFrame
{
    public static void main(String[] args) {
        JFrame jr = new JFrame("Assessment2");
        CirclePanel panel = new CirclePanel();
        jr.setContentPane(panel);
        panel.addMouseListener(new CircleClickListener(panel));
        jr.setSize(600,360);
        jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jr.setVisible(true);
    }
}
