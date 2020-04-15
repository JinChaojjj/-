<%@ page import="entity.Manager" %><%--
  Created by IntelliJ IDEA.
  User: 超
  Date: 2019/12/9
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    Manager manager= (Manager) session.getAttribute("manager");
%>
    <%=manager.getManager_username()%>管理员登录成功<<br>
    <a href="<%=request.getContextPath() %>/user.manager" style="color: red">用户管理</a><br>
    <a href="<%=request.getContextPath() %>/a.showAll">管理题目</a><br>
    <a href="<%=request.getContextPath()%>/dropout">退出</a><br>


</body>
</html>
