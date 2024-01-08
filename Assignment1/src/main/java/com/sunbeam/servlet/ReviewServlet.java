package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;
@WebServlet("/reviews")
public class ReviewServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside Post");

		doGet(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Inside Post");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		UserPojo curUser = (UserPojo)session.getAttribute("curUser");
		try(ReviewDao rdao = new ReviewDao())
		{
		List<ReviewPojo>list = rdao.findAll();
		
		out.println("<h5>Review List</h5>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<th>ID</th>");
		out.println("<th>MOVIE ID</th>");
		out.println("<th>REVIEW</th>");
		out.println("<th>RATING</th>");
		out.println("<th>USER ID</th>");
		out.println("<th>MODIFIED DATE</th>");
		out.println("<th></th>");
		out.println("</thead>");
		out.println("<tbody>");
		
				for(ReviewPojo p: list)
				{
					out.println("<tr>");	
					out.printf("<td>%s</td>\r\n",p.getId());
					out.printf("<td>%s</td>\r\n",p.getMovieId());
					out.printf("<td>%s</td>\r\n",p.getReview());
					out.printf("<td>%s</td>\r\n",p.getRating());
					out.printf("<td>%s</td>\r\n",p.getUserId());
				 	out.printf("<td>%s</td>\r\n",p.getModified());
				 	//if(p.getUserId() == curUser.getId())
					out.printf("<td><a href='reviewdel?id=%s'><img src='delete.png' alt='Delete' width='24' height='24'/></a></td>\r\n",p.getId());
				 	out.println("<td>");
					out.println("</tr>");
				}
		out.println("</tbody>");
		out.println("</table>");
		out.println("<a href='options'>Back</a>");

		
	}
	catch(Exception e1)
	{
		e1.printStackTrace();	
	}
 }
}

