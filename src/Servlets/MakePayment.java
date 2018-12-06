package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Services.Services;
@WebServlet("/MakePayment")
public class MakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.html");
		}else{
			String email=(String)session.getAttribute("username");
			out.print("<span style='float:right margin-right:50px'>Hello "+email+"</span>");
		}
		int custID=Integer.parseInt(request.getParameter("custID"));
		double amount=Double.parseDouble(request.getParameter("amount"));
		Services service=new Services();
		try {
			boolean successful=service.makePayment(custID,amount);
			if(successful==true)
				out.println("<h2>Member Profile Updated</h2>");
			else
				out.println("<h2>Member Profile not updated</h2>");
		}catch(Exception e) {
			out.println("<p>Error Occured</p>");
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
