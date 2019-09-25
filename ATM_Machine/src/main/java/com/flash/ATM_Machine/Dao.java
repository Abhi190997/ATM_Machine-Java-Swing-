package com.flash.ATM_Machine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    

	String url = "jdbc:mysql://localhost:3306/customerdb"; 
    String user = "abhi"; 
    String pass = "password";
    String DriverClass = "com.mysql.cj.jdbc.Driver";
    
    Connection con;
    
    public Connection getCon() throws ClassNotFoundException, SQLException {
    	
    	Class.forName(DriverClass);
    	con = DriverManager.getConnection(url,user,pass);
    	return con;
    }
    
}

