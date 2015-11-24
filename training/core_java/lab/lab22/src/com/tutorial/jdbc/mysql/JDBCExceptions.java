package com.tutorial.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExceptions {
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/testdb";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test2";
	   
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
	      stmt = conn.createStatement();
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
		   printSQLException(se);
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
	    	  printSQLException(se);
	      }//end finally try
	   }//end try
   System.out.println("=====================================================");
	}//end main
	
	
	
	public static void printSQLException(SQLException ex) {

	    for (Throwable e : ex) {
	        if (e instanceof SQLException) {
	            if (ignoreSQLException(
	                ((SQLException)e).
	                getSQLState()) == false) {

	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " +
	                    ((SQLException)e).getSQLState());

	                System.err.println("Error Code: " +
	                    ((SQLException)e).getErrorCode());

	                System.err.println("Message: " + e.getMessage());

	                Throwable t = ex.getCause();
	                while(t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    
	}
	
	public static boolean ignoreSQLException(String sqlState) {

	    if (sqlState == null) {
	        System.out.println("The SQL state is not defined!");
	        return false;
	    }

	    // X0Y32: Jar file already exists in schema
	    if (sqlState.equalsIgnoreCase("X0Y32"))
	        return true;

	    // 42Y55: Table already exists in schema
	    if (sqlState.equalsIgnoreCase("42Y55"))
	        return true;

	    return false;
	}
}
