<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: spades
  Date: 2018/8/22
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="LoginController?type=login" method="post" class="form-inline">
        <div>
            <br>
            <br>
            <div class="form-group">
                <span>用户账号&nbsp;</span><input type="text" name="userAccount" class="form-control" >
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >用户密码&nbsp;</span><input type="password" name="userPassword" class="form-control" >
            </div>
            <br>
            <br>
            <input class="btn btn-warning" type="submit" value="登录">
            <%--<form action="LoginController?type=login" method="post" class="form-inline">--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/LoginController?type=update">修改密码</a>

            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/login">返回</a>--%>
        </div>


    </form>
</div>
</body>
<script type="text/javascript">
    var msg = "${msg}";
    if (msg=='loginfail'){
        alert("登录失败,用户账号或密码错误");
        window.location.replace("${pageContext.request.contextPath }/login.jsp");
    }
    if(msg=='updatesucc'){
        alert("修改成功");
        window.location.replace("${pageContext.request.contextPath }/login.jsp");
    }

</script>
</html>
