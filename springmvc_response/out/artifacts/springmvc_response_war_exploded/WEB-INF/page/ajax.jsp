<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/25
  Time: 23:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        pageContext.setAttribute("ctx",request.getContextPath());
    %>
    <script src="${ctx}/scripts/jquery.js" type="text/javascript"></script>
</head>
<body>
<a>获取用户信息</a>
<div id="div">

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        $.ajax({
            url: '${ctx}/json',
            type: 'get',
            contentType:'json',
            success: function (data) {
                // alert(data);
                $('#div').append("<ul>");
                data.forEach(item=>{
                    $('#div').append("<li>"+item.name+"</li>");
                });
                $('#div').append("</ul>");
            }
        });
    });
</script>
</body>
</html>
