package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    private static HashMap<String,String> credentials = new HashMap<>();

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Office Hours Scheduling");

        // Implementing Queue using JTables
        JTable queueTable = new JTable(new QueueTableModel());
        queueTable.setDefaultEditor(Object.class, null);
        queueTable.setBounds(50, 500, 900, 400);

        // Add Button
        JButton addButton = new JButton("Add Yourself");
        addButton.setBounds(50,100,200,50);
        addButton.addActionListener(actionEvent -> {
            String[] info = getInformation();
            if (info != null)
                credentials.put(info[0],info[1]);
                //queueTable.a
            System.out.println(Arrays.toString(info));
        });

        // Remove Button
        JButton removeButton = new JButton("Remove Yourself");
        removeButton.setBounds(260,100,200,50);
        removeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        // Pause Button
        JButton pauseButton = new JButton("Pause Yourself");
        pauseButton.setBounds(470,100,200,50);
        pauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        // Unpause button
        JButton unPauseButton = new JButton("Unpause Yourself");
        unPauseButton.setBounds(680,100,200,50);
        unPauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        //mainFrame.add(queueTable);
        JScrollPane scrollPane = new JScrollPane(queueTable);
        scrollPane.setLocation(100,100);
        mainFrame.add(scrollPane);
        mainFrame.pack();
        //mainFrame.add(scrollPane);
        mainFrame.add(addButton);
        mainFrame.add(removeButton);
        mainFrame.add(pauseButton);
        mainFrame.add(unPauseButton);

        mainFrame.setSize(1000, 1000);
        //mainFrame.setLayout(null);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }

    public static String[] getInformation(){

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        JTextField emailField = new JTextField(5);
        JTextField sessionCode = new JTextField(5);
        pane.add(new JLabel("Enter Email"));
        pane.add(emailField);
        pane.add(new JLabel("Enter Session code"));
        pane.add(sessionCode);
        int result = JOptionPane.showConfirmDialog(null, pane, "Enter credentials", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{emailField.getText(), sessionCode.getText()};
        }
        return null;
    }
}

