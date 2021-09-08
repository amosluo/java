<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/24
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <%
    pageContext.setAttribute("ctx",request.getContextPath());

    %>
  </head>
  <body>
  <img src="${ctx}/images/hzy.jpg"/>
  $END$
  </body>
</html>
