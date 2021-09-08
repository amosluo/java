<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/25
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <%

    pageContext.setAttribute("ctp", request.getContextPath());
    %>
</head>
<body>
<form action="${ctp}/login2" method="post">
    <fmt:message key="username"></fmt:message>:<input type="text" name="username"/><br/>
    <fmt:message key="password"></fmt:message>:<input type="password" name="password"/><br/>
</form>
</body>
</html>
