package controller;

// CAMADA DE PERSISTÊNCIA

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class DataAccessObject {
    
    private DataBaseConnection dbConnection;
    
    private String table;
    private boolean novel;
    private boolean changed;
    
    // PADRÃO UNIT OF WORK
    private HashMap<String, Object> dirty;
    
    public DataAccessObject(String table) {
        dbConnection = DataBaseConnection.getInstance();
        
        this.table = table;
        this.novel = true;
        this.changed = false;
        
        dirty = new HashMap<String, Object>();
    }
    
    public void insert() throws SQLException {
        if(this.novel && this.changed) {
            String sql;

            sql = "INSERT INTO " + this.table;
            
            String fields = "";
            String values = "";
            boolean first = true;
            
            for(String k : dirty.keySet()) {
                if(first) {
                    first = false;
                } else {
                    fields += ",";
                    values += ",";
                }
                
                fields += k;
                
                Object v = dirty.get(k);
                if(v != null) {                    
                    if(v instanceof String) {
                        values += "'" + v + "'";
                    } else{
                        values += v;
                    }
                    
                } else{
                    values += "NULL";
                }
            }
            
            sql += " (" + fields + ")";
            sql += " VALUES";
            sql += " (" + values + ")";

            dbConnection.executeSQL(sql);
            this.novel = false;
            this.changed = false;
            dirty.clear();
        }
    }

    public void update() throws SQLException {
        if(!this.novel && this.changed) {
            String sql;
            
            sql = "UPDATE " + this.table + " SET ";
            
            String set = "";
            boolean first = true;
            
            for(String k : dirty.keySet()) {
                if(first) {
                    first = false;
                } else {
                    set += ",";
                }
                
                set += k + "=";
                Object v = dirty.get(k);
                
                if(v instanceof String) {
                    set += "'" + v + "'";
                } else {
                    set += v;
                }
            }
            
            sql += set;
            sql += " WHERE";
            sql += getWhereClauseForOneEntry();
            System.out.println(sql);
            dbConnection.executeSQL(sql);
            this.changed = false;
            dirty.clear();
        }
    }
    
    public void delete() throws SQLException, Exception {
        String sql;
        
        sql = "DELETE FROM " + this.table;
        sql += " WHERE";
        sql += getWhereClauseForOneEntry();
        
        dbConnection.executeSQL(sql);
    }
    
    public void load() throws SQLException, Exception {
        String sql;
        
        sql = "SELECT * FROM " + this.table + " WHERE";
        sql += getWhereClauseForOneEntry();
        
        dbConnection.executeQuery(sql);
        
        boolean status = dbConnection.getResultSet().next();
        
        if(status){
            ArrayList<Object> data = new ArrayList<Object>();
        
            for(int i = 1; i <= dbConnection.getMetaData().getColumnCount(); i++){
                data.add(dbConnection.getResultSet().getObject(i));
            }
            
            fill(data);
            
            this.novel = false;
            this.changed = false;
            dirty.clear();
        }
    }
    
    public void save() throws SQLException {
        if(this.novel && this.changed) {
            insert();
        }
        
        if(!this.novel && this.changed) {
            update();
        }
    }
    
    public void disconnectFromDatabase() throws SQLException {
        dbConnection.disconnect();
    }
    
    protected void addChange(String key, Object value) {
        dirty.put(key, value);
        this.changed = true;
    }

    public abstract void fill(ArrayList<Object> data) throws Exception;
    
    public abstract String getWhereClauseForOneEntry();
    
}
