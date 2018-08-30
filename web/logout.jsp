<%--
  Created by IntelliJ IDEA.
  User: adorn
  Date: 2018/8/30
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎您，${loginName}
<a href="${pageContext.request.contextPath}/LoginController?type=logout">退出登录</a>
</body>
</html>
