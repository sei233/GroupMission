<%--
  Created by IntelliJ IDEA.
  User: 石乾
  Date: 2018/8/20
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h3>菜单</h3>
    <a class="btn btn-primary btn-block dropdown-toggle" href="${pageContext.request.contextPath}#"
       target=mainFrame>－ 首页</a>
    <div>
        <a class="btn btn-primary btn-block nav nav-header collapsed" data-toggle="collapse"
           data-target="#0"
           target=main>－ 商品与赠品管理
            <span class="caret"></span>
        </a>
        <ul id="0" class="nav nav-list collapse">
            <li>
                <a href="${pageContext.request.contextPath}/product_out"
                   target=mainFrame>－ 产品展示</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/good_out"
                   target=mainFrame>－ 商品管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/brand_out"
                   target=mainFrame>－ 商品品牌管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/type_out"
                   target=mainFrame>－ 商品类型管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/gift_out"
                   target=mainFrame>－ 赠品管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/activityAPC_out"
                   target=mainFrame>－ 促销活动申请</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/activityAPV_out"
                   target=mainFrame>－ 促销活动审批</a>
            </li>
        </ul>

        <a class="btn btn-primary btn-block nav nav-header collapsed" data-toggle="collapse"
           data-target="#1"
           target=main>－ B2C销售管理
            <span class="caret"></span>
        </a>
        <ul id="1" class="nav nav-list collapse">
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 订单显示</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 销售出库单</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 销售退货单</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 网店订单导入</a>
            </li>
        </ul>

        <a class="btn btn-primary btn-block nav nav-header collapsed" data-toggle="collapse"
           data-target="#2"
           target=main>－ 售后管理
            <span class="caret"></span>
        </a>
        <ul id="2" class="nav nav-list collapse">
            <li>
                <a href="${pageContext.request.contextPath}/app_out"
                   target=mainFrame>－ 返厂出库管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/app_in"
                   target=mainFrame>－ 返厂入库管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 退货申请管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}#"
                   target=mainFrame>－ 退货申诉记录管理</a>
            </li>
        </ul>

        <a class="btn btn-primary btn-block nav nav-header collapsed" data-toggle="collapse"
           data-target="#3"
           target=main>－ 系统管理
            <span class="caret"></span>
        </a>
        <ul id="3" class="nav nav-list collapse">
            <li>
                <a href="${pageContext.request.contextPath}/user_out"
                   target=mainFrame>－ 用户管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/role_out"
                   target=mainFrame>－ 角色管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/permission_out"
                   target=mainFrame>－ 权限管理</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/log"
                   target=mainFrame>－ 日志管理</a>
            </li>
        </ul>
    </div>
</div>

</body>
</html>
