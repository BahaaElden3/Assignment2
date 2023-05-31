/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Bahaa El-Den
 */

public class DB {
    
    private static DB db = null;
    
    private DB(){
        
    }
    
    public static DB getInstance() {
        if(db == null){
            db = new DB();
            return db;
        }else{
            return db;
        }
    }
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    
    public java.sql.Connection getConnection() throws ClassNotFoundException, SQLException{
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank"
                , "root", "");
        return conn;
    }
        
}
