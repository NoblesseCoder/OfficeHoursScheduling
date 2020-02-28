package com.company;


import java.awt.*;
import javax.swing.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;


public class DisplayGui extends JFrame{

    public DisplayGui(HashMap<String,String> credentials){

        QueueTableModel queueTableModel = new QueueTableModel();
        JTable queueTable = new JTable(queueTableModel);
        queueTable.getColumnModel().getColumn(0).setWidth(10);
        queueTable.setDefaultEditor(Object.class, null);

        // Button Panel & Queue Panel
        setTitle("Office Hours Scheduling");
        setSize(800,800);
        setBackground(Color.blue);
        JPanel topPanel = new JPanel();
        JPanel btnPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(queueTable);
        topPanel.add(scrollPane,BorderLayout.CENTER);

        JButton addButton = new JButton("Add Yourself");
        JButton removeButton = new JButton("Remove Yourself");
        JButton pauseButton = new JButton("Pause Yourself");
        JButton unPauseButton = new JButton("Unpause Yourself");
        removeButton.setEnabled(false);
        pauseButton.setEnabled(false);
        unPauseButton.setEnabled(false);

        for (int i =0; i<queueTableModel.getColumnCount();i++) {
            queueTable.setDefaultRenderer(queueTable.getColumnClass(i), new QueueCellRenderer());
        }

        // Global Mouse Listener
        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if(event.getID() == MouseEvent.MOUSE_CLICKED) {
                MouseEvent mevent = (MouseEvent) event;
                int row = queueTable.rowAtPoint(mevent.getPoint());
                if(row == -1) {
                    queueTable.clearSelection();
                    removeButton.setEnabled(false);
                    pauseButton.setEnabled(false);
                    unPauseButton.setEnabled(false);
                    addButton.setEnabled(true);
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);

        // QueueTable EventHandler
        queueTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if(mouseEvent.getClickCount()>=1){
                    addButton.setEnabled(false);
                    removeButton.setEnabled(true);
                    if(queueTableModel.getValueAt(queueTable.getSelectedRow(),2).equals("Active"))
                        pauseButton.setEnabled(true);
                    else
                        pauseButton.setEnabled(false);
                    if(queueTableModel.getValueAt(queueTable.getSelectedRow(),2).equals("Pause"))
                        unPauseButton.setEnabled(true);
                    else
                        unPauseButton.setEnabled(false);
                }
                else{
                    removeButton.setEnabled(false);
                    pauseButton.setEnabled(false);
                    unPauseButton.setEnabled(false);
                    addButton.setEnabled(false);
                }
            }
        });

        // Add Button Event Handler
        addButton.addActionListener(actionEvent -> {
            String[] info = getInformation();
            if (info != null){
                if(info[0].equals("") || info[1].equals("") || info[2].equals("")){
                    JOptionPane.showMessageDialog(null, "Enter valid credentials, Try again!");
                }
                else {
                    if(credentials.containsKey(info[1])){
                        JOptionPane.showMessageDialog(null, "Duplicate Entry, Try again!");
                    }
                    else {
                        credentials.put(info[1], info[2]);
                        Person person = new Person(queueTableModel.getRowCount()+1,info[0],"Active", info[1]);
                        queueTableModel.addRow(person);
                        JOptionPane.showMessageDialog(null, "Add Successful!");
                    }
                }
            }
        });

        // Remove Button Event Handler
        removeButton.addActionListener(actionEvent -> {
            int deleteRowIndex = queueTable.getSelectedRow();
            String deletePersonEmail = queueTableModel.getValueAt(deleteRowIndex,3).toString();
            String deletePersonName = queueTableModel.getValueAt(deleteRowIndex,1).toString();
            String sessionCode = getSessionCode(deletePersonName);
            if(sessionCode.equals("-1"))
                return;
            // Actually supposed to check: sessionCode.equals(credentials.get(deletePersonEmail))
            if(true){
                queueTableModel.deleteRow(deleteRowIndex);
                JOptionPane.showMessageDialog(null, "Remove Successful!");
                removeButton.setEnabled(false);
                pauseButton.setEnabled(false);
                unPauseButton.setEnabled(false);
                addButton.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong Session code, Try again!");
            }

        });

        // Pause Button Event Handler
        pauseButton.addActionListener(actionEvent -> {
            int index = queueTable.getSelectedRow();
            String pausePersonEmail = queueTableModel.getValueAt(index, 3).toString();
            String pausePersonName = queueTableModel.getValueAt(index, 1).toString();
            String sessionCode = getSessionCode(pausePersonName);
            if(sessionCode.equals("-1"))
                return;
            // Actually supposed to check: sessionCode.equals(credentials.get(pausePersonEmail))
            if(true) {
                queueTableModel.pauseRow(index);
                JOptionPane.showMessageDialog(null,"Pause Successfull");
                removeButton.setEnabled(false);
                pauseButton.setEnabled(false);
                unPauseButton.setEnabled(false);
                addButton.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong session password, Try again!");
            }

        });

        // Unpause button Event Handler
        unPauseButton.addActionListener(actionEvent -> {
            int index = queueTable.getSelectedRow();
            String unPausePersonEmail = queueTableModel.getValueAt(index, 3).toString();
            String unPausePersonName = queueTableModel.getValueAt(index, 1).toString();
            String sessionCode = getSessionCode(unPausePersonName);
            if(sessionCode.equals("-1"))
                return;
            // Actually supposed to check: sessionCode.equals(credentials.get(unPausePersonEmail))
            if(true) {
                queueTableModel.unPauseRow(index);
                JOptionPane.showMessageDialog(null,"UnPause Successful");
                removeButton.setEnabled(false);
                pauseButton.setEnabled(false);
                unPauseButton.setEnabled(false);
                addButton.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Wrong session password, Try again!");
            }
        });

        btnPanel.add(addButton);
        btnPanel.add(removeButton);
        btnPanel.add(pauseButton);
        btnPanel.add(unPauseButton);
    }

    public static String[] getInformation(){
        // Queries input information from the user

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

    public static String getSessionCode(String name){
        // Queries session code from the user
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(0, 2, 2, 2));
        JTextField sessionCode = new JTextField(5);
        pane.add(new JLabel(name+" Enter Session Code"));
        pane.add(sessionCode);
        int result = JOptionPane.showConfirmDialog(null, pane, "Enter credentials", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            return sessionCode.getText();
        }
        return "-1";
    }

}


