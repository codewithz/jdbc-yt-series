package com.codewithz;

import java.sql.*;
public class DatabaseConnection {

    public static void main(String[] args) {

        String url="jdbc:postgresql://localhost:5432/CWZ-YT";
        String user="postgres";
        String password="admin";

        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,user,password);

            System.out.println("Connection established successfully !!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
