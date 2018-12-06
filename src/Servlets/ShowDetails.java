package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Transaction;
import Services.Services;

@WebServlet("/ShowDetails")
public class ShowDetails extends HttpServlet {
	private static final long serialVersionUID = 1L; 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.html").include(request, response);
		int id=Integer.parseInt(request.getParameter("member"));
		Services service=new Services();
		try {
			ArrayList<Transaction>tList=service.getStatement(id);
			out.print("<h2>Customer's All Transactions</h2>");
			out.print("<table border='2' style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Trans ID</td><td>Date</td><td>Type</td><td>Amount</td><td>Balance</td></tr>");
			for(Transaction t:tList) {
				out.println("<tr><td>"+t.transactionID+"</td><td>"+t.transactionDate+"</td><td>"+t.transactionType+"</td><td>"+t.amount+"</td><td>"+t.balance+"</td></tr>");
			}
		out.print("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		}catch(Exception e) {
			
		}
		doGet(request, response);
	}

}
