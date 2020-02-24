package com.company;

import javax.swing.table.AbstractTableModel;

public class QueueTableModel extends AbstractTableModel {
    String[] queueColumnNames = { "Index","Email", "Name"};

    public QueueTableModel(){

    }

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person personObj = data.get(row);
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
}
