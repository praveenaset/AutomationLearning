package com.utiba.qa.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloWorld {

	public static void main(String[] args) throws SQLException {
		System.out.println("Hello World");
		System.out.println("hey");
		System.out.println("hey245");
		System.out.println("another change1");
		
		
		Connection c = null;
		Statement stmt=null;
		
	    try {
	       Class.forName("org.postgresql.Driver");
	       c = DriverManager
	          .getConnection("jdbc:postgresql://localhost:5432/referenceDB",
	          "postgres", "admin");
	    } catch (Exception e) {
	       e.printStackTrace();
	       System.err.println(e.getClass().getName()+": "+e.getMessage());
	       System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    
	    
	    stmt = c.createStatement();
	    
	    ResultSet rs = stmt.executeQuery( "select * from public.\"employee\" ;" );
	  
	   
	    while(rs.next()) {
	    	
	    	int employeeID = rs.getInt("ID");

	         String  empName = rs.getString("Name");

	         String empDepartment  = rs.getString("Department");
	         
	         int empSalary = rs.getInt("Salary");

	         System.out.println(employeeID+" "+empName+" "+empDepartment+" "+empSalary);

	         System.out.println();
	    }
	    
	    if(c!=null) {
	    	try {
				c.close();
				System.out.println("Closed database successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    

	}
	
	

}
