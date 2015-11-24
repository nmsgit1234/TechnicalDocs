package com.tutorial.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class JDBCusingDataSource {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			DataSource ds = MySQLDataSourceFactory.getMySQLDataSource();
			conn = ds.getConnection();
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "select customerid,customername,address,city,postalcode,country from customers";
			rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			System.out
					.println("=====================================================");
			System.out
					.println("ID\tCustomer Name\tAddress\tCity\tPostalCode\tCountry");
			System.out
					.println("=====================================================");
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("customerid");
				String name = rs.getString("customername");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String postalcode = rs.getString("postalcode");
				String country = rs.getString("country");
				// Display values
				System.out.println(id + "\t" + name + "\t" + address + "\t"
						+ city + "\t" + postalcode + "\t" + country);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out
				.println("=====================================================");
	}// end main

}
