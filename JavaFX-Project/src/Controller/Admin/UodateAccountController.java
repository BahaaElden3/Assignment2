/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import View.ViewManager;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Accounts;


/**
 * FXML Controller class
 *
 * @author Bahaa El-Den
 */
public class UodateAccountController implements Initializable {

    @FXML
    private TextField date;

    @FXML
    private Button usersManagmentPageBtn;

    @FXML
    private TextField accountNum;

    @FXML
    private TextField balance;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button operationsPageBtn;

    @FXML
    private Button accountsPageBtn;

    @FXML
    private Button saveNewUserBtn;

    @FXML
    private TextField userID;

    @FXML
    private TextField username;

    @FXML
    private TextField currancy;
    @FXML
    private TextField userID1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

  @FXML
    void saveNewUser(ActionEvent event) throws SQLException, ClassNotFoundException {
        String userID = this.userID.getText();
        int user_id = Integer.parseInt(userID);
        
        String accountNum = this.accountNum.getText();
        int account_num = Integer.parseInt(accountNum);
        
        String username = this.username.getText();
        
        String currancy = this.currancy.getText();
        
        String balance_string = balance.getText();
            double balance_double = 0.0; 

            try {
                balance_double = Double.parseDouble(balance_string);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                
             String date_2 = date.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date3 = null;
            try {
                date3 = dateFormat.parse(date_2);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            java.sql.Date sqlCreationDate = new java.sql.Date(date3.getTime());        



            Accounts accounts = new Accounts(user_id,account_num,username,currancy,balance_double, (Date) date3);
            accounts.save();
        ViewManager.adminPage.changeSceneToAddNewAccount();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Inserted");
        alert.setContentText("User Addded Successfully");
        alert.showAndWait();

    }
    }

    @FXML
    void cancelUserCreation(ActionEvent event) {

    }


    @FXML
    void showUsersManagmentPage(ActionEvent event) {

    }

    @FXML
    void showAccountsPage(ActionEvent event) {

    }

    @FXML
    void showOperationsPage(ActionEvent event) {

    }
}

    

