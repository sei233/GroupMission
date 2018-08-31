<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adorn
  Date: 2018/8/23
  Time: 下午2:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改权限信息</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/js/page.js"></script>
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/PermissionController?type=updateToPermission" method="post" class="form-inline">
        <div>
            <%--<a class="btn btn-primary box_relative" href="${pageContext.request.contextPath }/permission_detail?type=export">导入</a>--%>
            <%--<c:out value="${permission}"></c:out>--%>
            <div class="form-group">
                <span>权限编号&nbsp;</span><input type="text" name="permissionId" class="form-control" value="${permission.permissionId}"readonly="readonly" style="background: rgba(195,238,238,0.13)">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>权限名称&nbsp;</span><input type="text" name="permissionName" class="form-control" value="${permission.permissionName}">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>权限描述&nbsp;</span>
                <input  name="permissionDesc" class="form-control"  value="${permission.permissionDesc}">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >权限操作&nbsp;</span><input type="text" name="permissionOps" class="form-control" value="${permission.permissionOps}">
            </div>
            <br>
            <br>

            <input class="btn btn-warning" type="submit" value="修改">
            <%--<input class="btn btn-warning" type="reset" value="重置">--%>
            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/permission_out?type=addToPermission">添加</a>--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/permission_out">返回</a>
        </div>


    </form>
</div>
</body>
<script type="text/javascript">


</script>
</html>

