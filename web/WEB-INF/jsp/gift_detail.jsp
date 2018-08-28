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
    <form action="/gift_out?type=updateThis" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <span>编号&nbsp;</span><input type="text" name="giftId" class="form-control" value="${gift.giftId}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>赠品名称&nbsp;</span><input type="text" name="goodType" class="form-control" value="${gift.giftName}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >型号&nbsp;</span><input type="text" name="goodBrand" class="form-control" value="${gift.giftModel}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>价格&nbsp;</span>
                <input  name="goodModel" class="form-control" value="${gift.giftPrice}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>颜色&nbsp;</span>
                <input  name="goodColor" class="form-control" value="${gift.giftColor}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>采购价&nbsp;</span>
                <input  name="goodName" class="form-control" value="${gift.adoptPrice}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>采购部门&nbsp;</span>
                <input  name="goodAdoptPrice" class="form-control" value="${gift.adoptDepartment}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>库存&nbsp;</span>
                <input  name="goodMarketPrice" class="form-control" value="${gift.giftNumber}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>类型&nbsp;</span>
                <input  name="goodShopPrice" class="form-control" value="${gift.typeName}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>品牌&nbsp;</span>
                <input  name="goodNumber" class="form-control" value="${gift.brandName}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/gift_out">返回</a>
            </div>
        </div>
    </form>
</div>
</body>
<script type="text/javascript"></script>
</html>
