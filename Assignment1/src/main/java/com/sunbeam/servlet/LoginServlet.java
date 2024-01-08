package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserInterfaceDao;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Post");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println("Email : "+email + " and Password : "+password);
		
		ServletContext ctx = req.getServletContext();
		String message = (String) ctx.getInitParameter("title");
		out.printf("<h2 text-align=center>%s</h2>",message);
		
		HttpSession session = req.getSession();
		
		try(UserDao udao = new UserDao())
		{
			UserPojo user = udao.findByEmail(email);
			System.out.println("User Found : "+user);
			
			if(user!=null && user.getPassword().equals(password))
			{
				resp.sendRedirect("options");
				
				session.setAttribute("curUser", user);
				System.out.println("**** Login Successfully!!!!!");
			}
			else
			{
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h>Invalid Username or Password!!!</h>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
