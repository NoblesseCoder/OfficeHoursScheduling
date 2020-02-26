package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class QueueTableModel extends AbstractTableModel {
    String[] queueColumnNames = {"Name", "Email", "Status"};
    List<Person> queueData = new ArrayList<Person>();

    public QueueTableModel(){
        queueData.add(new Person("PersonA","person_a@gmail.com","Active"));
        queueData.add(new Person("PersonB","person_b@gmail.com","Active"));
        queueData.add(new Person("PersonC","person_c@gmail.com","Active"));
        queueData.add(new Person("PersonD","person_d@gmail.com","Active"));
        queueData.add(new Person("PersonE","person_e@gmail.com","Active"));
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
            case 0: return personObj.getName();
            case 1: return personObj.getEmail();
            case 2: return personObj.getStatus();
            default : return null;
        }

    }

    public boolean isCellEditable(int row, int column){
        return false;
    }


    public void addRow(Person person){
        queueData.add(person);
        this.fireTableDataChanged();
    }

    public void deleteRow(int index)
    {
        if (queueData.get(index).getStatus() == "Active" && index < queueData.size() - 1) {
            for (int i = index + 1; i < queueData.size(); i++) {
                if (queueData.get(i).getStatus() == "Active") {
                    queueData.set(index, queueData.get(i));
                    queueData.remove(i);
                    break;
                }
            }
        }
        else {
            queueData.remove(index);
        }
        //queueData.remove(index);
        this.fireTableDataChanged();
    }


}
