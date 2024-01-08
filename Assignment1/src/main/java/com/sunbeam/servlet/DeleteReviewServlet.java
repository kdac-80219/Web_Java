package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.spi.CalendarNameProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewDao;
import com.sunbeam.pojo.ReviewPojo;
import com.sunbeam.pojo.UserPojo;
@WebServlet("/reviewdel")
public class DeleteReviewServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reviewId = req.getParameter("id");
		int id = Integer.parseInt(reviewId);
		int cnt=0;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
//		HttpSession session = req.getSession();
//		UserPojo curUser = (UserPojo)session.getAttribute("curUser");
//		
//		out.println("<a href='reviews?type=all'>All Reviews</a> | ");
//		out.println("<a href='reviews?type=my'>My Reviews</a> | ");
//		out.println("<a href='reviews?type=shared'>Shared Reviews</a>");
//		
//		try(ReviewDao rdao = new ReviewDao())
//		{
//			String type = req.getParameter("type");
//			List<ReviewPojo> list = new ArrayList<>();
//			if(type==null || type.equals("all"))
//			 list = rdao.findAll();
//			else if(type.equals("my"))
//			 list = rdao.findByUserId(curUser.getId());
//			else if(type.equals("shared"))
//			list = rdao.getSharedReviewsWithUser(curUser.getId());
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		
		
		try(ReviewDao dao = new ReviewDao())
		{
			cnt = dao.deleteById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("reviews");
		rd.forward(req, resp);
	}
}
