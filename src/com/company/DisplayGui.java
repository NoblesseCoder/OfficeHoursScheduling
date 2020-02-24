package com.company;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.HashMap;


public class DisplayGui extends JFrame{
    private JPanel topPanel;
    private JPanel btnPanel;
    private JScrollPane scrollPane;

    public DisplayGui(HashMap<String,String> credentials){

        QueueTableModel queueTableModel = new QueueTableModel();
        JTable queueTable = new JTable(queueTableModel);
        queueTable.setDefaultEditor(Object.class, null);

        setTitle("Office Hours Scheduling");
        setSize(800,800);
        setBackground(Color.gray);
        topPanel = new JPanel();
        btnPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);
        scrollPane = new JScrollPane(queueTable);
        topPanel.add(scrollPane,BorderLayout.CENTER);

        // Add Button
        JButton addButton = new JButton("Add Yourself");
        addButton.addActionListener(actionEvent -> {
            String[] info = getInformation();
            if (info != null){
                credentials.put(info[1],info[2]);
                Person person = new Person(info[0],info[1]);
                queueTableModel.addRow(person);
            }
            System.out.println(Arrays.toString(info));
        });

        // Remove Button
        JButton removeButton = new JButton("Remove Yourself");
        removeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        // Pause Button
        JButton pauseButton = new JButton("Pause Yourself");
        pauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        // Unpause button
        JButton unPauseButton = new JButton("Unpause Yourself");
        unPauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //tf.setText("Welcome to Javatpoint.");
            }
        });

        btnPanel.add(addButton);
        btnPanel.add(removeButton);
        btnPanel.add(pauseButton);
        btnPanel.add(unPauseButton);
    }
    public static String[] getInformation(){

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        JTextField nameField = new JTextField(5);
        JTextField emailField = new JTextField(5);
        JTextField sessionCode = new JTextField(5);
        pane.add(new JLabel("Enter Name"));
        pane.add(nameField);
        pane.add(new JLabel("Enter Email"));
        pane.add(emailField);
        pane.add(new JLabel("Enter Session code"));
        pane.add(sessionCode);
        int result = JOptionPane.showConfirmDialog(null, pane, "Enter credentials", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{nameField.getText(),emailField.getText(), sessionCode.getText()};
        }
        return null;
    }
}
