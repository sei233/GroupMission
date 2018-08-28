<%--
  Created by IntelliJ IDEA.
  User: spades
  Date: 2018/8/27
  Time: 10:41
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
    <form action="/good_out?type=add1ToGood" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath }/good_out?type=selectfg">选择产品</a>
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>类别&nbsp;</span><input type="text" name="goodType" class="form-control" value="${product.productType}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span >品牌&nbsp;</span><input type="text" name="goodBrand" class="form-control" value="${product.productBrand}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>型号&nbsp;</span>
                <input  name="goodModel" class="form-control" value="${product.productModel}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>颜色&nbsp;</span>
                <input  name="goodColor" class="form-control" value="${product.productColor}" readonly="readonly">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>商品名称&nbsp;</span>
                <input  name="goodName" class="form-control">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>采购价&nbsp;</span>
                <input  name="goodAdoptPrice" class="form-control">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>市场价&nbsp;</span>
                <input  name="goodMarketPrice" class="form-control">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>商城价&nbsp;</span>
                <input  name="goodShopPrice" class="form-control">
            </div>
            <br>
            <br>
            <div class="form-group">
                <span>库存&nbsp;</span>
                <input  name="goodNumber" class="form-control">
            </div>
            <br>
            <br>
            <%--<div class="form-group">--%>
                <%--<span>是否可采购&nbsp;</span>--%>
                <%--<select class="btn btn-default" name="goodAdopt">--%>
                    <%--<option value="">请选择</option>--%>
                    <%--<option value="0">否</option>--%>
                    <%--<option value="1">是</option>--%>
                <%--</select>--%>
            <%--</div>--%>
            <%--<br>--%>
            <%--<br>--%>
            <div class="form-group">
                <span>操作人&nbsp;</span>
                <input  name="operator" class="form-control"></input>
            </div>
            <br>
            <br>
            <div class="form-group">
                <input class="btn btn-warning" type="submit" value="添加">
                <input class="btn btn-warning" type="reset" value="重置">
                <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/good_out">返回</a>
            </div>
        </div>
    </form>
</body>
</html>
