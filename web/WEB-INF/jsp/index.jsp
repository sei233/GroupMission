<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: 石乾
  Date: 2018/7/18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <style type="text/css">
        .pageTest {
            width: 1000px;
            height: 5px;
            margin-top: 5px;
        }

        .activP {
            background-color: #367fa9 !important;
            color: #fff !important;
        }

        td {
            text-align: center;
        }

        .box_relative{
            position: absolute;
            right: 200px;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/js/page.js"></script>
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <script type="text/javascript">
        $(function () {
            $('.pageTest').page({
                leng: 10,//分页总数
                activeClass: 'activP', //active 类样式定义
                clickBack: function (page) {
                    window.location.reload();
                }
            });
        });
    </script>

</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/application?type=query" method="post" class="form-inline">
        <input type="text" id="condition" name="condition" class="form-control" placeholder="想查询的游戏">
        <input type="submit" class="btn btn-info" value="查询">
        <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/application?type=add">添加游戏</a>
    </form>

    <table id="table" border="1" class="table table-striped table-bordered table-hover">
        <tr>
            <th>序号</th>
            <th></th>
            <th>返厂入库单号</th>
            <th>返厂入库标志</th>
            <th>制单人</th>
            <th>制单时间</th>
            <th>审批人</th>
            <th>审批状态</th>
            <th>操作</th>
            <th>操作</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${apps}" var="app" varStatus="s">
            <tr class="active">
                <td>${app.appID}</td>
                <td><input type="checkbox"></td>
                <td>${app.antiOutID}</td>
                <td>${app.antiOutSign}</td>
                <td>${app.docuMaker}</td>
                <td>${app.docuTime}</td>
                <td>${app.approver}</td>
                <td>${app.approvalState}</td>
                <td><a class="btn btn-primary"
                       href="${pageContext.request.contextPath }/application?type=look&&id=${app.appID}">查看</a></td>
                <td><a class="btn btn-danger"
                       href="${pageContext.request.contextPath }/application?type=update&&id=${app.appID}">修改</a></td>
                <td><a class="btn btn-danger"
                       href="${pageContext.request.contextPath }/application?type=follow&&id=${app.appID}">审核跟踪</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="11">
                <!--必须要的div-->
                <div class="pageTest"></div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
