<%@page import="pp.Emp"%>
<%@page import="java.util.List"%>
<jsp:useBean id="rd" class="pp.Rdao"></jsp:useBean>
<table align="center" border="1px">
<tr>
<th>Id</th>
<th>Name</th>
<th>Salary</th>
</tr>
<% 
  List<Emp> al = rd.showEmp();
  for(Emp e : al)
  {
	 %>
	 <tr>
	 <form action="update.jsp">
	 <td><%=e.getId() %><input type="hidden" name="id" value="<%=e.getId() %>"/></td>
	 <td><input type="text" name="name" value="<%=e.getName() %>"/></td>
	 <td><input type="number" name="sal" value="<%=e.getSal() %>"/></td>
	 <td><input type="submit" value="update"/></td>
	 </form>
	 <td><a href="delete.jsp?id=<%=e.getId() %>">Delete</a></td>
	 </tr>
	 <%
  }
%>
</table>