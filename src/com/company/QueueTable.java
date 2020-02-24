package com.company;

import javax.swing.table.AbstractTableModel;

public class QueueTable extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }

    public boolean isCellEditable(int row, int column){
        return false;
    }
}
