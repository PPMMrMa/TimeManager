<%@ page contentType="text/html; charset=UTF-8" import="database.MySQLConnect"  pageEncoding="UTF-8" %>
<%@ page import="tool.ID" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="tool.UserDao" %>
<%@ page  %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>
</h1>
<%
    ArrayList arrayList= UserDao.Instance().getGroups("54535541241");
   for (int i=0;i<arrayList.size();i++){
       out.print(arrayList.get(i)+"<br>");
   }
%>
</body>
</html>