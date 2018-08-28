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
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/js/page.js"></script>
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath }/type_out?type=addToType" method="post" class="form-inline">
        <div>
            <%--<a class="btn btn-primary box_relative" href="${pageContext.request.contextPath }/brand_detail?type=export">导入</a>--%>
            <%--<c:out value="${brand}"></c:out>--%>
            <br>
            <br>
            <div class="form-group">
                <span>类型名称&nbsp;</span><input type="text" name="typeName" class="form-control" >
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>类型描述&nbsp;</span>
                <textarea  name="typeDescribe" class="form-control" style="width: 200px;height: 150px"></textarea>
            </div>
            <br>
            <br>
            <input class="btn btn-warning" type="submit" value="添加">
            <input class="btn btn-warning" type="reset" value="重置">
            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/brand_out?type=addToBrand">添加</a>--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/type_out">返回</a>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">


</script>
</html>
