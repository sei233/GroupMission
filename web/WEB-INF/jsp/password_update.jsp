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
    <title>修改密码</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="LoginController?type=updateToUser" method="post" class="form-inline">
        <div>
            <%--<a class="btn btn-primary box_relative" href="${pageContext.request.contextPath }/user_detail?type=export">导入</a>--%>
            <%--<c:out value="${user}"></c:out>--%>
            <div class="form-group">
                <span>用户账户&nbsp;</span><input type="text" name="userAccount" class="form-control" >
            <br>
            <br>
            <div class="form-group">
                <span>原密码&nbsp;</span><input type="password" name="oldpassword" class="form-control" >
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>新密码&nbsp;</span><input type="password" name="newpassword" class="form-control" >
            </div>
            <br>
            <br>
            <input class="btn btn-warning" type="submit" value="修改">
            <%--<input class="btn btn-warning" type="reset" value="重置">--%>
            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/user_out?type=addToBrand">添加</a>--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/login.jsp">返回</a>
        </div>


    </form>
</div>
</body>
<script type="text/javascript">
    var msg = "${msg}";
    if (msg=='updatefail'){
        alert("修改失败，账号或密码错误，或者原密码新密码相同");
        window.location.replace("${pageContext.request.contextPath }/login.jsp");
    }
    if (msg=='passwordillegal'){
        alert("密码必须大于8位，并包含字母、数字");
        window.location.replace("${pageContext.request.contextPath }/login.jsp");
    }

</script>
</html>
