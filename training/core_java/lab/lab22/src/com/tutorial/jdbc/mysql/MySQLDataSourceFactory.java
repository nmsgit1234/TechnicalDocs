package com.tutorial.jdbc.mysql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class MySQLDataSourceFactory {
	public static DataSource getMySQLDataSource() {
        Properties props = new Properties();
        InputStream fis = null;
        MysqlDataSource mysqlDS = null;
        try {
        	
        	fis = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
            //fis = new FileInputStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mysqlDS;
    }
     
}
