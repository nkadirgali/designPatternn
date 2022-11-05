package com.example.demo1;

import com.example.demo1.AdminNotify.AdminNotification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new Scene(root, 520, 400);
        stage.getIcons().add(new Image(String.valueOf("C:\\Users\\Lenovo\\Desktop\\ASSA-main\\src\\main\\resources\\com\\images\\3gisLogo.png")));
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}