package com.tutorial.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableUpdatableRS {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testdb";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	      
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
	         
	         rs.updateString("address", address + ",INDIA");
	         rs.updateRow();
		      System.out.println(id + "\t" + name + "\t" + address + "\t" + city + "\t" + postalcode + "\t" + country);	      
		}
	      
	      //Inserting a row directly in the resultset.
	      rs.moveToInsertRow();
	      rs.updateInt("customerid", 6);
	      rs.updateString("customername", "Santosh");
	      rs.updateString("address", "123,54th cross, Hebbal");
	      rs.updateString("city", "Mysore");
	      rs.updateString("postalcode", "570023");
	      rs.updateString("country", "India");
	      
	      rs.insertRow();
	      rs.beforeFirst();
	      
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("=====================================================");
	}//end main	
	

}
