package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Member;
import Services.Services;
@WebServlet("/FindCommonBid")
public class FindCommonBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int comID=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		comID=Integer.parseInt(request.getParameter("comittee"));
		Services service=new Services();
		try {
			double amount1=service.getBaseBid(comID);
			ArrayList<Member> remaining =service.getAvailableMembers(comID);
			out.print("<form action='SubmitBidDetails' method='post'><table border='2' style='width:800px;'>");
			out.print("<tr><td>Common Bid Amount:</td><td>"+amount1+"</td></tr>");
			out.print("<tr>Select Member who wins the Bidding:</tr></table>");
			out.print("<table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Select</td><td>Member ID</td><td>Name</td><td>Address</td><td>Join Date</td><td>Balance</td></tr>");
			for(Member m:remaining){
				out.print("<tr><td><input type='radio' name='member' value="+m.memberID+" required></td><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.joinDate+"</td><td>"+m.balance+"</td></tr>");
			}
			out.print("<tr><td>Enter Maximum Bid Amount:</td><td><input type='text' name='maxBid' required /></td></tr>");
			out.print("<tr><td></td><td></td><td><input type ='submit' name='submit' value='Close Bidding'/></td></tr></table></form");
			
		}catch(Exception e) {
			e.printStackTrace();	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
