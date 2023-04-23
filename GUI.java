import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame {
    public GUI() {
        super();
        JLabel amttrashc = new JLabel("Amount of Trash Collecters: ");
        JTextField trashc = new JTextField("", 10);

        JLabel amttrash = new JLabel("Amount of Trash: ");
        JTextField trash = new JTextField("", 10);
        JButton submit = new JButton("Submit", null);

        this.setSize(400,150);
        JPanel top = new JPanel();
        top.add(amttrashc);
        top.add(trashc);
        //top.add(submit);
        this.add(top, BorderLayout.NORTH);

        JPanel mid = new JPanel();
        mid.add(amttrash);
        mid.add(trash);
        this.add(mid, BorderLayout.CENTER);
        this.add(submit, BorderLayout.SOUTH);


    }

    public static void main(String[] args) {
        GUI g = new GUI();
        g.setVisible(true);
        
    }
    
}
