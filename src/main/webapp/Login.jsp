<%@ page contentType="text/html; charset=UTF-8" import="tool.ID" pageEncoding="UTF-8" %>
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
out.println(ID.Instance().GenerateGroupID());

%>
</body>
</html>