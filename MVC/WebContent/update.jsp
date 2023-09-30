<jsp:useBean id="e" class="pp.Emp"></jsp:useBean>
<jsp:useBean id="rd" class="pp.Rdao"></jsp:useBean>
<% 
 int id = Integer.parseInt(request.getParameter("id"));
 String name = request.getParameter("name");
 int sal = Integer.parseInt(request.getParameter("sal"));
 
 e.setId(id);
 e.setName(name);
 e.setSal(sal);
 int i = rd.updateEmp(e);
 RequestDispatcher rd1 = request.getRequestDispatcher("Show.jsp");
 rd1.include(request, response);
 out.println(i+" record updated");
%>