package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class QueueTableModel extends AbstractTableModel {
    String[] queueColumnNames = { "Index","Email", "Name"};
    List<Person> queueData = new ArrayList<Person>();

    public QueueTableModel(){
        queueData.add(new Person(1,"abc@gmail.com","abc"));
    }

    @Override
    public String getColumnName(int column) {
        return queueColumnNames[column];
    }

    @Override
    public int getRowCount() {
        return queueData.size();
    }

    @Override
    public int getColumnCount() {
        return queueColumnNames.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person personObj = queueData.get(row);
        switch(col){
            case 0: return personObj.getIndex();
            case 1: return personObj.getName();
            case 2: return personObj.getEmail();
            default : return null;
        }

    }

    public boolean isCellEditable(int row, int column){
        return false;
    }


    public void addData(Person person){
        queueData.add(person);
    }


}
