import javax.swing.JFrame;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class GUI extends JFrame {
    public GUI() {
        super();
        JLabel amttrashc = new JLabel("Amount of Trash Collecters: ");
        JTextField trashc = new JTextField("", 10);

        JLabel amttrash = new JLabel("Amount of Trash: ");
        JTextField trash = new JTextField("", 10);
        JButton submit = new JButton("Submit", null);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String numTrash = trash.getText();
                String numCollectors = trashc.getText();
                String rounds = "100"; // or any other value you want to use
                String randSeed = "42"; // or any other value you want to use
        
                String[] command = {"bash", "-c", "java Simulator " + numTrash + " " + numCollectors + " " + rounds + " " + randSeed + " | java -jar Plotter.jar"};
        
                try {
                    ProcessBuilder builder = new ProcessBuilder(command);
                    builder.redirectErrorStream(true);
                    Process process = builder.start();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                    reader.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

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
