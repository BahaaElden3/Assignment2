/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;

/**
 *
 * @author Bahaa El-Den
 */
public class User {
    private int id; 
    private String username;
    private String password;
    private String email;
    private String gender;
    private String role;

    public User( String username, String password, String email, String gender, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public int save() throws SQLException, ClassNotFoundException{
        Connection c = DB.getInstance().getConnection();
        PreparedStatement ps = null;
        int recordCounter = 0 ;
        
        String sql = "INSERT INTO USERS (ID,USERNAME,PASSWORD,EMAIL,GENDER,ROLE)"
                + "VALUES(?,?,?,?,?,?);";
        ps = c.prepareStatement(sql);
        ps.setInt(1,this.getId());
        ps.setString(2,this.getUsername());
        ps.setString(3,this.getPassword());
        ps.setString(4,this.getEmail());
        ps.setString(5,this.getGender());
        ps.setString(6,this.getRole());
        
        recordCounter= ps.executeUpdate();
        if(recordCounter>0){
            System.out.println(this.getUsername()+"User was added successfuly!");
        }   
        if(ps != null){
            ps.close();
        }
        c.close();
        return recordCounter;
        }
    }
