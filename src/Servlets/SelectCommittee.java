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

/**
 * Servlet implementation class SelectCommittee
 */
@WebServlet("/SelectCommittee")
public class SelectCommittee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		int id=Integer.parseInt(request.getParameter("comittee"));
		Services service=new Services();
		try {
		ArrayList<Member> remaining =service.getAvailableMembers(id);
		out.print("<table border='2' style='width:800px;'>");
		out.print("<tr style='background-color:grey;color:white'><td>Member ID</td><td>Name</td><td>Address</td><td>Join Date</td><td>Balance</td></tr>");
		for(Member m:remaining){
			out.print("<tr><td>"+m.memberID+"</td><td>"+m.memberName+"</td><td>"+m.memberAddress+"</td><td>"+m.joinDate+"</td><td>"+m.balance+"</td></tr>");
		}
		out.print("</table>");
			
		}catch(Exception e) {
			
		}
		doGet(request, response);
	}

}
