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
@WebServlet("/SearchProfile")
public class SearchProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);	
		try{
			out.print("<form action='SearchProfile' method='post'>"
					+ "<table>"
					+ "<tr><td>Search By : </td><td><input type='radio' name='preference' value='village'/>Village</td><td><input type='radio' name='preference' value='name'/>Name</td></tr>"
					+"<tr><td></tr>"
					+"<tr><td>Enter Text : </td><td><input type='text' name='searchData'/></td></td><td><input type='submit' name='Search' value='Search'/></td></tr>"
					+ "</table></form>");
		}catch(Exception e){out.print(e);}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		String preference=request.getParameter("preference");
		String data=request.getParameter("searchData");
		try{
			Services service=new Services();
			ArrayList<Member> memberList=service.showAllMembers();
			out.print("<table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Member ID</td><td>Name</td><td>Address</td><td>Mobile</td><td>Balance</td></tr>");
			for(Member m:memberList){
				if(preference.equalsIgnoreCase("village")&& m.memberAddress.contains(data)){
				out.print("<tr><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.contact+"</td><td>"+m.balance+"</td></tr>");
				}
				if(preference.equalsIgnoreCase("name")&& m.memberName.contains(data)){
					out.print("<tr><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.contact+"</td><td>"+m.balance+"</td></tr>");
				}
			}
			out.print("</table>");
		}catch(Exception e){out.print(e);}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		doGet(request,response);
	}

}
