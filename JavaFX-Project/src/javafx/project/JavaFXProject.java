/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.project;

import View.RegisterPage;
import View.ViewManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.User;

/**
 *
 * @author Yahya
 */
public class JavaFXProject extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     ViewManager.openRegisterPage();

        // User user = new User(1,"bahaa","123","bahaa@gmail.com","male","Admin");
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}