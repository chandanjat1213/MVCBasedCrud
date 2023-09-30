

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pp.Emp;
import pp.Rdao;


@WebServlet("/Show")
public class Show extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Rdao rd = new Rdao();
		try {
			List<Emp> al = rd.showEmp();
			if(al.isEmpty())
			{
				out.println("records not found");
			}
			else
			{
				out.println("<table align=center border=1px>");
				out.println("<tr>");
				out.println("<th>ID</th>");
				out.println("<th>Name</th>");
				out.println("<th>Salary</th>");
				out.println("</tr>");
				for(Emp e : al)
				{
					out.println("<tr>");
					out.println("<form action=Update>");
					out.println("<td>");
					out.println(e.getId());
					out.println("<input type=hidden name=id value="+e.getId()+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=name value="+e.getName()+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=number name=sal value="+e.getSal()+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=submit value=Update />");
					out.println("</td>");
					out.println("</form>");
					out.println("<td><a href=Delete?id="+e.getId()+">Delete</a></td>");
					out.println("</tr>");
				}
				out.println("</table>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
