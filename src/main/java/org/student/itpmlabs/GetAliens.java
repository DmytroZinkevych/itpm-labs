package org.student.itpmlabs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetAliens extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/maventry?serverTimezone=UTC", "root", "root");
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from alien");
			List<Alien> aliens = new ArrayList<>();
            while(resultSet.next()) {
            	Alien alien = new Alien(resultSet.getInt("aid"), resultSet.getString("aname"), resultSet.getString("tech"));
            	aliens.add(alien);
            }
            request.setAttribute("aliens", aliens);
            RequestDispatcher rd = request.getRequestDispatcher("aliens.jsp");
            rd.forward(request, response);	
		} catch(Exception e) {
			System.out.println("Can't connect to database:\n" + e.getMessage());
			out.println("Can't connect to database:<br> \n" + e.getMessage());
			e.printStackTrace();
		}
	}
}
