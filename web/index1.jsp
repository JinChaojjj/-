<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 超
  Date: 2019/12/13
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>驾校在线练习测评系统 主页</title>
</head>
<body>
<%
    User user= (User) session.getAttribute("user");
%>
<%=user.getUser_username()%>&nbsp;&nbsp;&nbsp;用户已登录
<a href="<%=request.getContextPath() %>/mockTest.jsp">试卷测试</a>
<a href="<%=request.getContextPath() %>/b.showAll">全部习题测试</a>
<a href="<%=request.getContextPath() %>/wrong.jsp">错题</a>
<a href="<%=request.getContextPath() %>/dropout">退出</a>

</body>
</html>
