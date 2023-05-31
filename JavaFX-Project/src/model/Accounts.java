/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Bahaa El-Den
 */
public class Accounts {
    private int id; 
    private int user_id;
    private int account_number;
    private String userName;
    private String currancy;
    private double balance;
    private Date date;

    public Accounts(int user_id, int account_number, String userName, String currancy, double balance, Date date) {
        this.user_id = user_id;
        this.account_number = account_number;
        this.userName = userName;
        this.currancy = currancy;
        this.balance = balance;
        this.date = date;
    }

    public Accounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCurrancy() {
        return currancy;
    }

    public void setCurrancy(String currancy) {
        this.currancy = currancy;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
       public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0 ;
        
        String sql = "INSERT INTO `accounts`(`id`, `user_id`, `account_number`, `username`, `currency`, `balance`,"
                + "`creation_date`) VALUES"
                + "?,?,?,?,?,?,?";

        ps = c.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.setInt(2,this.getUser_id());
        ps.setInt(3,this.getAccount_number());
        ps.setString(4,this.getUserName());
        ps.setString(5,this.getCurrancy());
        ps.setDouble(6,this.getBalance());
        ps.setDate(6,this.getDate());
        
        recordCounter= ps.executeUpdate();
        if(recordCounter>0){
            System.out.println(this.getUser_id()+"Account was added successfuly!");
        }   
        if(ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;
        }
    
   
}
