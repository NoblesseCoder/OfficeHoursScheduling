package com.company;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

import static com.company.Main.credentials;

public class QueueTableModel extends AbstractTableModel {
    String[] queueColumnNames = {"Index","Name","Status"};
    List<Person> queueData = new ArrayList<>();

    public QueueTableModel(){
        int initNumPersons = (int)(Math.random() * ((4 - 1) + 1)) + 1;
        for(int i=0;i<initNumPersons;i++){
            queueData.add(new Person(i+1,"Person"+(i+1),"Active","person_"+(i+1)+"@gmail.com"));
            credentials.put("person_"+(i+1)+"@gmail.com","123");
        }
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
            case 0: return personObj.getIdNum();
            case 1: return personObj.getName();
            case 2: return personObj.getStatus();
            case 3: return personObj.getEmail();
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
        for(int i=index+1;i<queueData.size();i++){
            int currIdNum = queueData.get(i).getIdNum();
            queueData.get(i).setIdNum(currIdNum-1);
        }
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
