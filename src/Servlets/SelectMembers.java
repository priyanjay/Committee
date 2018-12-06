package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Services.Services;
@WebServlet("/SelectMembers")
public class SelectMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//request.getRequestDispatcher("header.html").include(request, response);
		String[] results = request.getParameterValues("members");
		ArrayList<Integer> members=new ArrayList<Integer>();
		if(results.length!=20) {
			request.getRequestDispatcher("NewComittee.html").include(request, response);
			out.println("<p>You have not selected 20 members</p>");
			return;
		}else {
			for (int i = 0; i < results.length; i++) {
				members.add(Integer.parseInt(results[i])); 
			}
		}
		Services service=new Services();
		try {
			int comiteeId=service.startCommittee(NewComittee.name,NewComittee.amount,NewComittee.rate,members);
			out.println("\t\t\tGenerated Committee ID is "+comiteeId);
			request.getRequestDispatcher("index.html").include(request, response);
	}catch(Exception e) {
		out.println("<p>Error Occured</p>");
	}
	//	request.getRequestDispatcher("footer.html").include(request, response);
	out.close();
}

}
