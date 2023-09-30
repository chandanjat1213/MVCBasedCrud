<jsp:useBean id="e" class="pp.Emp"></jsp:useBean>
<jsp:useBean id="rd" class="pp.Rdao"></jsp:useBean>
<jsp:setProperty property="*" name="e"/>
<% 
   int  i = rd.empAdd(e);
%>
<%=i+" emp added"%>