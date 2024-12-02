package com.codewithz;

import java.sql.*;
import java.sql.DriverManager;
import java.time.LocalDate;

public class InsertData {
    public static void main(String[] args) {

        String url="jdbc:postgresql://localhost:5432/CWZ-YT";
        String user="postgres";
        String password="admin";

        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(url,user,password);

            System.out.println("Connection established successfully !!");

            String name="John";
            String email="john@gmail.com";
            long phone=998877441125L;
            LocalDate today=LocalDate.now();


            String query="Insert into customer(name,email,phone,account_creation_date) values(?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setString(1,name);
            pstmt.setString(2,email);
            pstmt.setLong(3,phone);
            pstmt.setObject(4,today);

            int rowsInserted=pstmt.executeUpdate();

            System.out.println("No of rows inserted: "+rowsInserted);

            con.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
