<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/25
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
    pageContext.setAttribute("ctp",request.getContextPath());
    %>
</head>
<body>
<form action="${ctp}/submit">
    用户:格式  用户名-年龄
    <input type="text" name="user"><br/>
    <input type="submit">提交</input>
</form>
</body>
</html>
