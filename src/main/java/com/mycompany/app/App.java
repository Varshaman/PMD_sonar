package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int a;
    	int b;
    
    	Connection conn = null;
	      Statement stmt = null;
	      try {
	         try {
	            Class.forName("com.mysql.jdbc.Driver");
	         } catch (Exception e) {
	            System.out.println(e);
	      }
	      conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/training_basic", "root", "Aman@12345");
	      System.out.println("Connection is created successfully:");
	      stmt = (Statement) conn.createStatement();
	      String query1 = "INSERT INTO InsertDemo " + "VALUES (144, 'Jow','NY')";
	      stmt.executeUpdate(query1);
	      query1 = "INSERT INTO InsertDemo " + "VALUES (45, 'Aman Varshney','India')";
	      stmt.executeUpdate(query1);
	      System.out.println("Record is inserted in the table successfully..................");
	      
	      Scanner sc=new Scanner(System.in);
  	  System.out.println("enter the Id to serach");
	      int c=sc.nextInt();
	      String query2="SELECT * FROM training_basic.insertdemo WHERE Id = "+c;
	      ResultSet rs=stmt.executeQuery(query2);
	      while(rs.next()) {
	    	  int id=rs.getInt("Id");
	    	  String Name=rs.getString("Name");
	    	  String address=rs.getString("address");
	    	  System.out.format("%s,%s,%s\n",id,Name,address);
	      }
	      } catch (SQLException excep) {
	         excep.printStackTrace();
	      } catch (Exception excep) {
	         excep.printStackTrace();
	      } finally {
	         try {
	            if (stmt != null)
	               conn.close();
	         } catch (SQLException se) {}
	         try {
	            if (conn != null)
	               conn.close();
	         } catch (SQLException se) {
	            se.printStackTrace();
	         }  
	      }
	      System.out.println("Please check it in the MySQL Table......... ……..");
	     
    }
}
