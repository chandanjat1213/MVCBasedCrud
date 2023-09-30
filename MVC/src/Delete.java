

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Rdao;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String  i = request.getParameter("id");
		int id = Integer.parseInt(i);
		Rdao rd = new Rdao();
		try {
			int d = rd.deleteEmp(id);
			RequestDispatcher rd1 = request.getRequestDispatcher("Show");
			rd1.include(request, response);
			out.println( d+" record deleted");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
