package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/options")
public class OptionsServlet extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		ServletContext ctx = req.getServletContext();
		String message = (String) ctx.getInitParameter("title");
		out.printf("<h2 text-align=center>%s</h2>",message);
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Options</title>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<a href='reviews'>Show Reviews</a>");
		out.println("<br/><br/>");
		out.println("<a href='addmovie' >Add Movie</a>");
		out.println("<br/><br/>");
		out.println("<a href='movies' >Show All Movie</a>");
		out.println("<br/><br/>");
		out.println("<a href='addreviews' >Add Reviews</a>");

		
		out.println("</body>");
		out.println("</html>");
		
	}

}
