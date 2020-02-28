package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class QueueCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,
                                                   boolean hasFocus, int row, int column){

        QueueTableModel queueTableModel = (QueueTableModel) table.getModel();
        Object val = queueTableModel.getValueAt(row,2);
        if(val.equals("Active"))
            setBackground(Color.white);
        if(val.equals("Pause"))
            setBackground(Color.red);
        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
    }
}
