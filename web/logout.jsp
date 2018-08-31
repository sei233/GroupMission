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
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <link href="css/axurerpprototype.css" type="text/css" rel="stylesheet">
</head>
<body>
<h3>欢迎您，${loginName}</h3>
<a href="${pageContext.request.contextPath}/LoginController?type=logout" target="_top">退出系统</a>
</body>
</html>
