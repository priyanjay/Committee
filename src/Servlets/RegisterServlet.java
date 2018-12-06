package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.MemberDao;
import Services.Services;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		String name=request.getParameter("name");
		String address=request.getParameter("village");
		String contact=request.getParameter("contact");
		double amount=Double.parseDouble(request.getParameter("balance"));
		Services service=new Services();
		try {
			MemberDao.createTable();
		int success=service.addMember(name,address,amount,contact);
		out.print("<p>Generated Account Number is : "+success+"</p>");
		}catch(Exception e) {
		e.printStackTrace();	
		}
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
