package com.example.demo1.AdminNotify;
import com.example.demo1.DBC;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class AdminNotification {

    public static void userCreated(String first_name, String last_name, String email){

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String full_name = first_name + " " + last_name;

        DBC connection = new DBC();
        Connection connectDB = connection.getConnection();

        String insertFields = "INSERT INTO admin_notification(user_full_name, user_mail, notification_date) VALUES ";
        String insertValues = "('"+ full_name + "','" + email + "','" + dateFormat.format(now) + "')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }


    public static void getNotification(){



    }



}
