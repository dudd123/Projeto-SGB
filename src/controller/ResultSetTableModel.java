package controller;

import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;

public class ResultSetTableModel extends AbstractTableModel {
    
    private DataBaseConnection dbConnection;
    private int numberOfRows = 0;
            
    public ResultSetTableModel(String query) throws SQLException {
        
        dbConnection = DataBaseConnection.getInstance();
        
        setQuery(query);
    }
    
    public void setQuery(String query) throws SQLException {
        
        dbConnection.executeQuery(query);
        
        dbConnection.getResultSet().last();
        numberOfRows = dbConnection.getResultSet().getRow();
        
        // NOTIFICA A JTABLE QUE O MODELO FOI ALTERADO
        fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        return numberOfRows;
    }

    @Override
    public int getColumnCount() {
        try {
            return dbConnection.getMetaData().getColumnCount();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        try { 
            dbConnection.getResultSet().absolute(row + 1);
            return dbConnection.getResultSet().getObject(column + 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        try {
            return dbConnection.getMetaData().getColumnLabel(column + 1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return "";
    }
    
    public void disconnectFromDatabase() {
        try {
            dbConnection.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}