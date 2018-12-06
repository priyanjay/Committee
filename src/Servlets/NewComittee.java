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
@WebServlet("/NewComittee")
public class NewComittee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name=null;
	public static double amount=0;
	public static double rate=0;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		name=request.getParameter("name");
		amount=Double.parseDouble(request.getParameter("totalValue"));
		rate=Double.parseDouble(request.getParameter("rate"));
		Services service=new Services();
		try {
			out.print("<h2>Select 20 Members</h2>");
			ArrayList<Member> memberList=service.showAllMembers();
			out.print("<form action='SelectMembers' method='post'><table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Select</td><td>Member ID</td><td>Name</td><td>Address</td><td>Join Date</td><td>Balance</td></tr>");
			for(Member m:memberList){
				out.print("<tr><td><input type='checkbox' name='members' value="+m.memberID+"></td><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.joinDate+"</td><td>"+m.balance+"</td></tr>");
			}
			out.print("<tr><input type='submit' name='submit' value='Add Members'/></tr></table></form>");
		}catch(Exception e) {
			e.printStackTrace();	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
