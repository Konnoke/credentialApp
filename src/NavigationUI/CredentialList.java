/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NavigationUI;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kevin
 */
public class CredentialList extends AbstractTableModel {

    //public ArrayList<String> usernames;
    private List<Credential> list = new ArrayList<Credential>();
    private String[] columnNames = {"Website/Application", "Username", "Password"};
    private String[] row[] = {{"Lionpath","abc123","password"}};

    public void setList(List<Credential> list) {
        this.list = list;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public int getRowCount() {
        return list.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getUsername();
            case 1:
                return list.get(rowIndex).getPassword();
            default:
                return null;
        }
    }

    void add(Object object, String[] split) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
