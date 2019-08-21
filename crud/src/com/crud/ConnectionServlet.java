package com.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ConnectionServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username="root";
		String password="";
		String jdbcURL="jdbc:mysql://localhost:3306/student";
		String driver="com.mysql.jdbc.Driver";
		
		try{
//			Get the PrintWriter obj
			PrintWriter writer = response.getWriter();
//			print msg
			writer.println("Connecting to db");
//			Load the Driver class
			Class.forName(driver);
//			Get connection
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			writer.println("Connected successfully");
//			close the connection
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
