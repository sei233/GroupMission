<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adorn
  Date: 2018/8/23
  Time: 上午10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/RoleController?type=addToRole" method="post" class="form-inline">
        <div>
            <%--<a class="btn btn-primary box_relative" href="${pageContext.request.contextPath }/role_detail?type=export">导入</a>--%>
            <%--<c:out value="${role}"></c:out>--%>
            <br>
            <br>
            <div class="form-group">
                <span>角色名称&nbsp;</span><input type="text" name="roleName" class="form-control" >
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>角色描述&nbsp;</span>
                <textarea  name="roleDesc" class="form-control" style="width: 200px;height: 150px"></textarea>
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >角色状态&nbsp;</span> <select class="btn btn-default" name="roleStatus">
                <option value="">请选择</option>
                <option value="有效">有效</option>
                <option value="无效">无效</option>
            </select>
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >角色部门&nbsp;</span><input type="text" name="roleDept" class="form-control" >
            </div>
            <br>
            <br>
            <input class="btn btn-warning" type="submit" value="添加">
            <input class="btn btn-warning" type="reset" value="重置">
            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/role_out?type=addToRole">添加</a>--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/role_out">返回</a>
        </div>


    </form>
</div>
</body>
<script type="text/javascript">


</script>
</html>
