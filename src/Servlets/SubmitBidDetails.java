package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.Services;
@WebServlet("/SubmitBidDetails")
public class SubmitBidDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	request.getRequestDispatcher("header.html").include(request, response);
		int member=Integer.parseInt(request.getParameter("member"));
		double maxBid=Double.parseDouble(request.getParameter("maxBid"));
		Services service=new Services();
		try {
			double share =service.closeBid(FindCommonBid.comID,member,maxBid);
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<h2>Share is finalized as : "+share+"</h2>");
			out.println("<h2>All Profiles Updated</h2>");
		}catch(Exception e) {
			out.println("<p>Error Occured</p>");	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
