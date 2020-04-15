<%--
  Created by IntelliJ IDEA.
  User: 超
  Date: 2019/12/13
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>驾校在线练习测评系统 登录页面</title>
</head>
<body>
<form action="/web/login" method="get">
    账号:<input type="text" name="userId"><br><br>
    密码:<input type="password" name="password"><br><br>
    是否是管理员:<input type="checkbox" name="is" value="1"><br><br>
    <input type="submit" value="submit">
</form>
<form action="<%=request.getContextPath() %>/index.jsp"><br>
    <input type="submit" value="返回">
</form>
<%
    if (session.getAttribute("message") != null) {
%>
<%=session.getAttribute("message")%>
<%
    }
%>
</body>
</html>
