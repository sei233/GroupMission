<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: spades
  Date: 2018/8/27
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/gift_out?type=addToGift" method="post" class="form-inline">
    <div>
        <div class="form-group">
            <span>类别&nbsp;</span>
            <select class="btn btn-default" name="typeName">
                <option value="">请选择</option>

                <c:forEach items="${type_list}" var="ttt" varStatus="s">
                    <option value="${ttt}">${ttt}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <br>
        <div class="form-group">
            <span >品牌&nbsp;</span>
            <select class="btn btn-default" name="brandName">
                <option value="">请选择</option>
                <c:forEach items="${brand_list}" var="brand" varStatus="s">
                    <option value="${brand}">${brand}</option>
                </c:forEach>
            </select>
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>型号&nbsp;</span>
            <input  name="giftModel" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>颜色&nbsp;</span>
            <input  name="giftColor" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>赠品名称&nbsp;</span>
            <input  name="giftName" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>采购价&nbsp;</span>
            <input  name="adoptPrice" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>采购部门&nbsp;</span>
            <input  name="adoptDepartment" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>赠品价格&nbsp;</span>
            <input  name="giftPrice" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>库存&nbsp;</span>
            <input  name="giftNumber" class="form-control">
        </div>
        <br>
        <br>
        <div class="form-group">
            <input class="btn btn-warning" type="submit" value="添加">
            <input class="btn btn-warning" type="reset" value="重置">
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/gift_out">返回</a>
        </div>
    </div>
</form>
</body>
</html>
