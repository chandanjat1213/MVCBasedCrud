

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Emp;
import pp.Rdao;

/**
 * Servlet implementation class AddEmp
 */
@WebServlet("/AddEmp")
public class AddEmp extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		String name = request.getParameter("name");
		String s = request.getParameter("sal");
		int sal = Integer.parseInt(s);
		
		Emp e = new Emp();
		e.setId(id);
		e.setName(name);
		e.setSal(sal);
		
		Rdao rd = new Rdao();
		try {
			int a = rd.empAdd(e);
		    out.println(a+" emp added");
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}

}
