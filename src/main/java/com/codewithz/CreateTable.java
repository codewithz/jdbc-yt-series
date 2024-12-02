package com.codewithz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
    public static void main(String[] args) {

        String url="jdbc:postgresql://localhost:5432/CWZ-YT";
        String user="postgres";
        String password="admin";

        try{
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection(url,user,password);

            System.out.println("Connection established successfully !!");

            String query="Create table test ( id int ,name text)";
            PreparedStatement pstmt=con.prepareStatement(query);

            boolean created=pstmt.execute();

            if(!created){
                System.out.println("Table created");
            }
            else{
                System.out.println("Table not created");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
