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
    <form action="${pageContext.request.contextPath}/brand_detail?type=query" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text" name="condition" class="form-control" value="">
            </div>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/brand_out?type=find">查询</a>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/brand_out?type=add">添加</a>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/brand_out?type=export">导出</a>
        </div>

        <div class="form-group">

        </div>
    </form>
</div>
</body>
</html>
