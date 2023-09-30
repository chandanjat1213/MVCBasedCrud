<%@page import="pp.Emp"%>
<%@page import="java.util.List"%>
<jsp:useBean id="rd" class="pp.Rdao"></jsp:useBean>
<table align="center" border="1px">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Sal</th>
	</tr>
	<%
		int pno = Integer.parseInt(request.getParameter("pno"));
		int t = 5;
		
		if(pno==1)
		{
			pno=0;
		}
		else
		{
			pno = pno-1;
			pno = pno*t;
		}
		List<Emp> al = rd.showByPage(pno, t);
		for (Emp e : al) {
	%>
	<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName() %></td>
		<td><%=e.getSal() %></td>
	</tr>

	<%
		}
	%>
</table>
<%
 int c = 1;
 int l = rd.showEmp().size();
 for(int i=0; i<=l; i=i+5)
 {
	 %>
	 <a href="view.jsp?pno=<%=c %>"><%=c %></a>
	 <%
	 c++;
 }
%>