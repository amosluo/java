<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/24
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctp", request.getContextPath());
    %>
</head>
<body>
<form action="${ctp}/testUser" method="post">
    ID:<input type="text" name="id"><br/>
    name:<input type="text" name="name"><br/>
    age:<input type="text" name="age"><br/>
    gender:<input type="text" name="gender"><br/>
    <button type="submit">提交</button>
</form>
</body>
</html>
