package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.MovieDao;
import com.sunbeam.pojo.MoviePojo;

@WebServlet("/movies")
public class MovieListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Movie List</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form method='post' action='options'>");
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
		out.println("<a href='options'>Back</a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

}
