package main.view;

import main.services.DetectPatterns;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main class - Generate Java Swing GUI to interact with user.
 */
public class GUI {


    private static DetectPatterns detectPatterns = new DetectPatterns();


    public static void main(String[] args) {

        //Creating the Frame
        JFrame frame = new JFrame("SportTextToJSON Converter - CIRSA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1620, 200);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel labelInput = new JLabel("Enter Text:");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        //textField.setText("F.C. Barcelona 3-2 Real Madrid");
        //textField.setText("Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko");
        textField.setText("Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter");

        JButton convertButton = new JButton("Convert");
        JLabel labelOutput = new JLabel("JSON output:");

        JTextField labelOutputContent = new JTextField("{ \"teamAName\": \"F.C. Barcelona\", \"teamBName\": \"Real Madrid\",\n" +
                "\"teamAScore\": \"3\", \"teamBScore\": \"2\" }");
        labelOutputContent.setEditable(false);
        labelOutputContent.setBackground(null); //this is the same as a JLabel
        labelOutputContent.setBorder(null); //remove the border


        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelOutputContent.setText(detectPatterns.validateRegexFormat(textField.getText()));
            }
        });


        panel.add(labelInput); // Components Added using Flow Layout
        panel.add(textField);
        panel.add(convertButton);
        panel.add(labelOutput);
        panel.add(labelOutputContent);


        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);
    }


}
