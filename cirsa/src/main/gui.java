package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui {


    private static DetectPatterns detectPatterns = new DetectPatterns();
    private static GenerateJSON generateJSON = new GenerateJSON();

    public static void main(String[] args) {

        //Creating the Frame
        JFrame frame = new JFrame("SportTextToJSON Converter - CIRSA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080, 200);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        JLabel labelInput = new JLabel("Enter Text:");
        JTextField textField = new JTextField(10); // accepts upto 10 characters
        textField.setText("F.C. Barcelona 3-2 Real Madrid");
        JButton convertButton = new JButton("Convert");
        JLabel labelOutput = new JLabel("JSON output:");
        JLabel labelOutputContent = new JLabel("{ \"teamAName\": \"F.C. Barcelona\", \"teamBName\": \"Real Madrid\",\n" +
                "\"teamAScore\": \"3\", \"teamBScore\": \"2\" }");



        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelOutputContent.setText(gui.getJSONOuput(textField.getText()));
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

    public static String getJSONOuput(String input){


        String sportResult = detectPatterns.detectSportPattern(input);
        return generateJSON.getJSONBySport(sportResult);


        //return "{ \"teamAName\": \"F.C. Barcelona\", \"teamBName\": \"Real Madrid\",\n" + "\"teamAScore\": \"3\", \"teamBScore\": \"2\" }";

    }

}
