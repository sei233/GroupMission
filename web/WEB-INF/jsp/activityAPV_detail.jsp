<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>

    <style type="text/css">
        td {
            text-align: center;
        }

        .box_relative {
            position: relative;
            left: 0px;
        }
    </style>

    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap-datetimepicker.fr.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>


    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-datetimepicker.min.css">

    <script type="text/javascript">
        $(function () {
            $('.form_datetime').datetimepicker({
                //language:  'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0,
                showMeridian: 1
            });
            $('.form_date').datetimepicker({
                language: 'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                minView: 2,
                forceParse: 0
            });
            $('.form_time').datetimepicker({
                language: 'fr',
                weekStart: 1,
                todayBtn: 1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 1,
                minView: 0,
                maxView: 1,
                forceParse: 0
            });
        });
    </script>

</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/activityAPV_out" method="post" class="form-inline">
        <div class="form-group">
            <span>活动编号</span>
            <input type="text" name="activityId" class="form-control" value="${activity.activityId}" readonly="readonly">
        </div>
        <br>
        <br><div class="form-group">
            <span>活动名称</span>
            <input type="text" name="activityName" class="form-control" value="${activity.activityName}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>开始时间</span>
            <input type="text" class="form-control" value="${activity.beginTime}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>结束时间</span>
            <input type="text" class="form-control" value="${activity.endTime}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>商品id&nbsp;</span><input type="text" name="goodId" class="form-control" value="${activity.goodId}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>商品名称&nbsp;</span><input type="text" name="goodName" class="form-control" value="${activity.goodName}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>商品价格&nbsp;</span><input type="text" name="goodPrice" class="form-control" value="${activity.goodPrice}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>活动商品数量&nbsp;</span><input type="text" name="activityNumber" class="form-control" value="${activity.activityNumber}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>调价幅度（百分比1-100）</span>
            <input type="text" name="priceRange" class="form-control" value="${activity.priceRange}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>活动原因</span>
            <input type="text" name="reason" class="form-control" value="${activity.reason}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>备注</span>
            <input type="text" name="remarks" class="form-control" value="${activity.remarks}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>审批状态</span>
            <input type="text" name="remarks" class="form-control" value="${activity.approveState}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>审批评语</span>
            <input type="text" name="remarks" class="form-control" value="${activity.approveComment}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>审核时间</span>
            <input type="text" name="remarks" class="form-control" value="${activity.approveDate}" readonly="readonly">
        </div>
        <br>
        <br>
        <div class="form-group">
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/activityAPV_out">返回</a>
        </div>
    </form>
</div>
</body>
</html>
