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

        function del() {
            return window.confirm("您确定删除吗?");
        }
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
            <th>游戏名</th>
            <th>标题</th>
            <th>下载量</th>
            <th>大小</th>
            <th>状态</th>
            <th>分类</th>
            <th>平台类型</th>
            <th>推荐类型</th>
            <th>最近更新</th>
            <th>操作</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${gamesList}" var="game" varStatus="s">
            <tr class="active">
                <td>${game.game.gameName}</td>
                <td>${game.game.gameTitle}</td>
                <td>${game.game.gameDownload}</td>
                <td>${game.game.gameSize}</td>
                <td>${game.gameStatus}</td>
                <td>${game.gameType}</td>
                <td>${game.gameOperation}</td>
                <td>${game.gameAdviseType}</td>
                <td>${game.gameUpdateDate}</td>
                <td><a class="btn btn-primary" href="${pageContext.request.contextPath }/application?type=update&&id=${game.game.gameId}">修改</a></td>
                <td><a class="btn btn-danger" onclick="return del()"
                       href="${pageContext.request.contextPath }/application?type=delete&&id=${game.game.gameId}">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="10">
                <!--必须要的div-->
                <div class="pageTest"></div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
