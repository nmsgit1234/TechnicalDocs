package com.tutorial.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCPreparedStmt {

	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testdb";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //Insert records
		  String record6 = "insert into order_details values (?,?,?,?,?,?);";
	      pstmt = conn.prepareStatement(record6);
	      String record5 = "insert into order_details values (6,1000,'iPad',3,21200.00,63600.00);";

			 
	      pstmt.setInt(1,6);
	      pstmt.setInt(2, 1000);
	      pstmt.setString(3, "iPad");
	      pstmt.setInt(4,1);
	      pstmt.setFloat(5, 45000.00f);
	      pstmt.setFloat(6, 45000.00f);
	      pstmt.executeUpdate();
	      
		  //Select and display the records inserted.
		  String selectQuery = "select * from order_details;";
		  stmt = conn.createStatement();
	      rs = stmt.executeQuery(selectQuery);

	      //STEP 5: Extract data from result set
	      System.out.println("=====================================================");
	      System.out.println("order_details_id\torderid\titemname\tquantity\tprice\ttotal_price");
	      System.out.println("=====================================================");
	      while(rs.next()){
	         //Retrieve by column name
	         int order_details_id  = rs.getInt("order_details_id");
	         String orderid = rs.getString("orderid");
	         String itemname = rs.getString("itemname");
	         int quantity = rs.getInt("quantity");
	         float price = rs.getFloat("price");
	         float total_price = rs.getFloat("total_price");
	         //Display values
		      System.out.println(order_details_id + "\t" + orderid + "\t" + itemname + "\t" + quantity + "\t" + price + "\t" + total_price);	      }
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
	         if(pstmt!=null)
		            pstmt.close();
	         
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
