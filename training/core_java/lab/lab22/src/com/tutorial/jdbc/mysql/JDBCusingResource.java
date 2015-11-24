package com.tutorial.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCusingResource {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testdb";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test";
	   
	   public static void main(String[] args) {
	   //Connection conn = null;
	   //Statement stmt = null;
	   ResultSet rs = null;
	      //STEP 2: Register JDBC driver
	   try{
		      Class.forName("com.mysql.jdbc.Driver");
	   } catch(Exception ex){
		   ex.printStackTrace();
	   }

	   try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			   Statement stmt = conn.createStatement();
			   ){

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      //conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      //stmt = conn.createStatement();
	      String sql;
	      sql = "select customerid,customername,address,city,postalcode,country from customers";
	      rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      System.out.println("=====================================================");
	      System.out.println("ID\tCustomer Name\tAddress\tCity\tPostalCode\tCountry");
	      System.out.println("=====================================================");
	      while(rs.next()){
	         //Retrieve by column name
	         int id  = rs.getInt("customerid");
	         String name = rs.getString("customername");
	         String address = rs.getString("address");
	         String city = rs.getString("city");
	         String postalcode = rs.getString("postalcode");
	         String country = rs.getString("country");
	         //Display values
		      System.out.println(id + "\t" + name + "\t" + address + "\t" + city + "\t" + postalcode + "\t" + country);	      }
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }
	   System.out.println("=====================================================");
	}//end main
	
}
