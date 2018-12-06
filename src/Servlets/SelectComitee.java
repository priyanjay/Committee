package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Committee;
import Services.Services;
@WebServlet("/SelectComitee")
public class SelectComitee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		Services service=new Services();
		ArrayList<Committee> comitteeList=new ArrayList<Committee>();
		try {
			out.print("<h2>Please Select One Committee </h2>");
			comitteeList=service.showAllComittee();
			out.print("<form action='FindCommonBid' method='post'><table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Select</td><td>Committee ID</td><td>Name</td><td>Total Value</td><td>Start Date</td><td>Remaining Members</td></tr>");
			for(Committee m:comitteeList){
				out.print("<tr><td><input type='radio' name='comittee' value="+m.committeeID+"></td><td>"+m.committeeID+"</td><td>"+m.name+"</td><td>"+m.totalValue+"</td><td>"+m.startDate+"</td><td>"+m.remaining+"</td></tr>");
			}
			out.print("<tr><input type ='submit' name='submit' value='Select Comitee'/></tr></table></form");
			
		}catch(Exception e) {
			e.printStackTrace();	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
