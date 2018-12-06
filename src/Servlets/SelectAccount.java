package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Member;
import Services.Services;
import java.util.ArrayList;
@WebServlet("/SelectAccount")
public class SelectAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);	
		try{
			Services service=new Services();
			ArrayList<Member> memberList=service.showAllMembers();
			out.print("<form action='ShowDetails' method='post'><table border='2' style='width:900px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Select</td><td>Member ID</td><td>Name</td><td>Address</td><td>Join Date</td><td>Balance</td></tr>");
			for(Member m:memberList){
				out.print("<tr><td><input type='radio' name='member' value="+m.memberID+"></td><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.joinDate+"</td><td>"+m.balance+"</td></tr>");
			}
			out.print("<tr></tr>");
			out.print("<tr><td></td><td><input type='submit' name='submit' value='Confirm Account'></td></tr>");
			out.print("</table></form>");
		}catch(Exception e){out.print(e);}
	request.getRequestDispatcher("footer.html").include(request, response);
	out.close();
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);
}

}
