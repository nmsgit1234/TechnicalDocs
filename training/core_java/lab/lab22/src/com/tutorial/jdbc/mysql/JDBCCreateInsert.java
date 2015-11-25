package com.tutorial.jdbc.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCreateInsert {
	
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

		      //Create table
		      StringBuilder sbr = new StringBuilder();
		      sbr.append("create table order_details (");
			  sbr.append("order_details_id int,");
			  sbr.append("orderid int,");
			  sbr.append("itemname varchar(20),");
			  sbr.append("quantity int,");
			  sbr.append("price numeric(10,2),");
			  sbr.append("total_price numeric(10,2),");
			  sbr.append("primary key (order_details_id),");
			  sbr.append("foreign key (orderid) references orders(orderid)");
			  sbr.append(");");
		      
		      stmt = conn.createStatement();
		      stmt.executeUpdate(sbr.toString());
		      
		      //Insert records
			  String record1 = "insert into order_details values (1,1000,'computer',1,21000.00,21000.00);";
			  String record2 = "insert into order_details values (2,1000,'tv',5,18000.00,90000.00);";
			  String record3 = "insert into order_details values (3,1000,'flash drive',8,549.00,4392.00);";
			  String record4 = "insert into order_details values (4,1000,'hard disk',1,700.00,700.00);";
			  String record5 = "insert into order_details values (5,1000,'mobile phone',3,21200.00,63600.00);";

			  stmt.executeUpdate(record1);
			  stmt.executeUpdate(record2);
			  stmt.executeUpdate(record3);
			  stmt.executeUpdate(record4);
			  stmt.executeUpdate(record5);
		      
			  //Select and display the records inserted.
			  String selectQuery = "select * from order_details;";
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
