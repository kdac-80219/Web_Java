package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.sunbeam.dao.MovieDao;
import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.MoviePojo;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;

@WebServlet("/addreviews")
public class AddReviewServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 PrintWriter out=resp.getWriter();
		   resp.setContentType("text/html");
		   System.out.println("Inside Add Review GET");
		   ServletContext ctx = req.getServletContext();
			String message = (String) ctx.getInitParameter("title");
			out.printf("<h2 text-align=center>%s</h2>",message);
			
			   
			   out.println("<html>");
			   out.println("<head>");
			   out.println("<title>Add Review</title>");
			   out.println("</head>");
			   out.println("<body>");
			   out.println("<form method='post' action='addreviews' >");
			   out.printf("Movie Id: <input type='text' name='movie_id' /><br/><br/>");
			   out.printf("Review: <input type='text' name='review' /><br/><br/>");
			   out.printf("Rating: <input type='text' name='rating' /><br/><br/>");
			   out.printf("Modified: <input type='date' name='modified_date' /><br/><br/>");
			   out.printf("<input type='submit' value='Add' /><br/><br/><hr/><hr/>");
			   out.println("</body>");
			   out.println("</form>");
			   out.println("</html>");
			   
			   out.println("<html>");
			   out.println("<head>");
			   out.println("<title>Add Review</title>");
			   out.println("</head>");
			   out.println("<body>");
			   out.println("<form >");
			   try(MovieDao mdao = new MovieDao())
				{
					List<MoviePojo> list = mdao.findAll();
					out.println("<h>MOVIES LIST</h>");
					out.println("<table border='1'>");
					out.println("<thead>");
					out.println("<th>ID</th>");
					out.println("<th>TITLE</th>");
					out.println("<th>RELEASE DATE</th>");
					out.println("</thead>");
					out.println("<tbody>");
					for(MoviePojo m:list)
					{
						out.println("<tr>");
						out.printf("<td>%s</td>\r\n",m.getId());
						out.printf("<td>%s</td>\r\n",m.getName());
						out.printf("<td>%s</td>\r\n",m.getDate());
						out.println("</tr>");
					}
					out.println("</tbody>");
					out.println("</table>");
					
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					throw new ServletException(e1);
				}
			   out.println("</body>");
			   out.println("</form>");
			   out.println("</html>");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Inside Post");
		resp.setContentType("text/html");
		
		 HttpSession session=req.getSession();
		 UserPojo user= (UserPojo) session.getAttribute("curUser");
		 
		PrintWriter out = resp.getWriter();
		
	
		 System.out.println("Print it");
		ReviewPojo rp = new ReviewPojo();
		
		String movieId = req.getParameter("movie_id");
		int mid = Integer.parseInt(movieId);
		rp.setMovieId(mid);
		
		String review = req.getParameter("review");
		rp.setReview(review);
		
		String rating = req.getParameter("rating");
		int rat = Integer.parseInt(rating);
		rp.setRating(rat);
		
		System.out.println("User Id :");
		rp.setUserId(user.getId());
		
		String date = req.getParameter("modified_date");
		Date d = java.sql.Date.valueOf(date);
		rp.setModified(date);
		
		try(ReviewDao rd = new ReviewDao())
		{
			int cnt=0;
			cnt = rd.save(rp);
			if(cnt>0)
			{
				out.println("<h4>Review Added Successfully!!!!</h4>");
			}
			else
			{
				out.println("<h4>Something went wrong!!!</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("reviews");
		
	}
	
}
