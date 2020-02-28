package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class QueueCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected,
                                                   boolean hasFocus, int row, int column){

        this.setHorizontalAlignment(JLabel.CENTER);
        QueueTableModel queueTableModel = (QueueTableModel) table.getModel();
        Object val = queueTableModel.getValueAt(row,1);
        if(val.equals("Active"))
            setBackground(Color.white);
        if(val.equals("Pause"))
            setBackground(Color.white);
        return super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
    }
}
