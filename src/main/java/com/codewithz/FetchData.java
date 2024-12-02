package com.codewithz;

import java.sql.*;
import java.time.LocalDate;

public class FetchData {

    public static void main(String[] args) {

        String url="jdbc:postgresql://localhost:5432/CWZ-YT";
        String user="postgres";
        String password="admin";

        try{
            Class.forName("org.postgresql.Driver");
            Connection con=DriverManager.getConnection(url,user,password);

            System.out.println("Connection established successfully !!");

            String query="Select name,email,phone,account_creation_date from customer";
            PreparedStatement pstmt=con.prepareStatement(query);
            ResultSet rs=pstmt.executeQuery();

            while(rs.next()){
                String name=rs.getString("name");
                String email=rs.getString("email");
                long phone=rs.getLong("phone");
                LocalDate accountCreationDate=rs.getObject("account_creation_date", LocalDate.class);

                System.out.println("------------------------------------------------------------------");
                System.out.println("Name: "+name);
                System.out.println("Email: "+email);
                System.out.println("Phone: "+phone);
                System.out.println("Account Creation Date: "+accountCreationDate);
                System.out.println("--------------------------------------------------------------------");
            }

            con.close();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
