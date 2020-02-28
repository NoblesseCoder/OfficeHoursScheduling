package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import static com.company.Main.credentials;

public class QueueTableModel extends AbstractTableModel {
    String[] queueColumnNames = {"Name"};
    List<Person> queueData = new ArrayList<>();

    public QueueTableModel(){
        queueData.add(new Person("PersonA","person_a@gmail.com","Active"));
        credentials.put("person_a@gmail.com","123");
        queueData.add(new Person("PersonB","person_b@gmail.com","Active"));
        credentials.put("person_b@gmail.com","123");
        queueData.add(new Person("PersonC","person_c@gmail.com","Active"));
        credentials.put("person_c@gmail.com","123");
        queueData.add(new Person("PersonD","person_d@gmail.com","Active"));
        credentials.put("person_d@gmail.com","123");
        queueData.add(new Person("PersonE","person_e@gmail.com","Active"));
        credentials.put("person_e@gmail.com","123");
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

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }


    public void addRow(Person person){
        queueData.add(person);
        this.fireTableDataChanged();
    }

    public void deleteRow(int index) {
        queueData.remove(index);
        this.fireTableDataChanged();
    }

    public void pauseRow(int index) {
        Person each = queueData.get(index);
        if(each.getStatus().equals("Active"))
            each.setStatus("Pause");
        this.fireTableDataChanged();
    }

    public void unPauseRow(int index) {
        Person each = queueData.get(index);
        if (each.getStatus().equals("Pause"))
            each.setStatus("Active");
        this.fireTableDataChanged();
    }

}
