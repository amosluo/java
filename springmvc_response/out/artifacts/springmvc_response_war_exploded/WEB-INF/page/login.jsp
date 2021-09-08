<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/25
  Time: 20:54
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
<form action="${ctp}/validation" method="post">
编号：<input type="text" name="id">${errors.id}<br/>
    姓名：<input type="text" name="name">${errors.name}<br/>
    年龄：<input type="text" name="age">${errors.age}<br/>
    性别：<input type="text" name="gender">${errors.gender}<br/>
    生日：<input type="text" name="birth">${errors.birth}<br/>
    邮箱：<input type="text" name="email">${errors.email}<br/>
    <input type="submit">提交</input><br/>
</form>
</body>
</html>
