

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Emp;
import pp.Rdao;


@WebServlet("/Update")
public class Update extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int sal = Integer.parseInt(request.getParameter("sal"));
		
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setSal(sal);
		
		Rdao rd = new Rdao();
		try {
			int i = rd.updateEmp(e);
			RequestDispatcher rd1 = request.getRequestDispatcher("Show");
			rd1.include(request, response);
			out.println(i+" record updated");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}

}
