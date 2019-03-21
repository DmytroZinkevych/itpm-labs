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
		List<Alien> aliens = AlienRepository.getAll();
		request.setAttribute("aliens", aliens);
		RequestDispatcher rd = request.getRequestDispatcher("aliens.jsp");
		rd.forward(request, response);
	}
}
