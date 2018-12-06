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
@WebServlet("/SearchCustomer")
public class SearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		Services service=new Services();
		ArrayList<Member> comitteeList=new ArrayList<Member>();
		try {
			out.print("<h2>Please Select One Customer </h2>");
			comitteeList=service.showAllMembers();
			out.print("<form action='MakePayment' method='post'><table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Select</td><td>Member ID</td><td>Name</td><td>Address</td><td>Mobile</td><td>Current Balance</td></tr>");
			for(Member m:comitteeList){
				out.print("<tr><td><input type='radio' name='custID' value="+m.memberID+"></td><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.balance+"</td></tr>");
			}
			out.print("<tr><td>Enter Amount to be Deposited:</td><td><input type='text' name='amount'></td></tr>");
			out.print("<tr><td></td><td></td><td><input type ='submit' name='submit' value='Update Balance'/></td></tr></table></form>");
			
		}catch(Exception e) {
			e.printStackTrace();	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
