package com.example.demo1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //nothing already!
    }




    public void loginButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isBlank()==false  && enterPasswordField.getText().isBlank() == false){
            if(usernameTextField.getText().equals("Admin@gmail.com") && enterPasswordField.getText().equals("admin")){
                validateLoginAdmin(event);
            }else {
                validateLoginUser(event);
            }
        }else{
            loginMessageLabel.setText("Please, fill all fields!");
        }

    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }



    private void validateLoginUser(ActionEvent event) {
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        String verifyLoginUser = "SELECT count(1) FROM users WHERE username = '"+ usernameTextField.getText() +"' AND password	='"+ enterPasswordField.getText() +"'  ";
        try {

            Statement statement = connectionDB.createStatement();
            ResultSet queryResultUser = statement.executeQuery(verifyLoginUser);

                    while(queryResultUser.next()){
                        if(queryResultUser.getInt(1)==1){
                            //loginMessageLabel.setText("Congratulations User!");

                            SceneController scene = new SceneController();
                            scene.switchToSplashScreenScene(event);
                        }else{
                            loginMessageLabel.setText("Invalid login. Please try again!");
                        }
                    }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    private void validateLoginAdmin(ActionEvent event) {
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        String verifyLoginUser = "SELECT count(1) FROM users WHERE login = '"+ usernameTextField.getText() +"' AND password	='"+ enterPasswordField.getText() +"'  ";
        try {

            Statement statement = connectionDB.createStatement();
            ResultSet queryResultUser = statement.executeQuery(verifyLoginUser);

            while(queryResultUser.next()){
                if(queryResultUser.getInt(1)==1){
                    //loginMessageLabel.setText("Congratulations Admin!");

                    //User user = new User(queryResultUser.getString(1),queryResultUser.getString(2),queryResultUser.getString(3),queryResultUser.getString(4));
                    SceneController scene = new SceneController();
                    scene.switchToAdminMainScene(event);

                }else{
                    loginMessageLabel.setText("Invalid login. Please try again!");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public void createAccountForm(ActionEvent event){
        try{
            SceneController scene = new SceneController();
            scene.switchToRegisterScene(event);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


}

