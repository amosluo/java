<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/26
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <%
        pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
<a href="${ctp}/i18n">国际化页面登录</a>
</body>
</html>
