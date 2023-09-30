<jsp:useBean id="rd" class="pp.Rdao"></jsp:useBean>
<% 
 int id = Integer.parseInt(request.getParameter("id"));
 int i = rd.deleteEmp(id);
 RequestDispatcher rd1 = request.getRequestDispatcher("Show.jsp");
 rd1.include(request, response);
 out.println(i+" record deleted");
%>