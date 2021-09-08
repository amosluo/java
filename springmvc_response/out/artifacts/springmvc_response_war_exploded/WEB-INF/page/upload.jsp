<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/26
  Time: 21:58
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
<form action="${ctp}/testUpload" method="post" enctype="multipart/form-data">
    文件: <input type="file" name="file"/><br><br>
    描述: <input type="text" name="desc"/><br><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
