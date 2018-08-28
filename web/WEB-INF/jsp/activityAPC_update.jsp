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
    <form action="${pageContext.request.contextPath}/activityAPC_out?type=updateThis" method="post" class="form-inline">
        <div class="form-group">
            <span>活动编号</span>
            <input type="text" name="activityId" class="form-control" value="${activity.activityId}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>活动名称</span>
            <input type="text" name="activityName" class="form-control" value="${activity.activityName}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <label for="dtp_input1">开始时间</label>
            <%--<span>开始时间</span>--%>
            <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                 data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                <input class="form-control" size="30" type="text" value="${activity.beginTime}">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" name="beginTime" id="dtp_input1" value=""/><br/>
        </div>
        <div class="form-group">
            <label for="dtp_input2">结束时间</label>
            <%--<span>结束时间<span/>--%>
            <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                 data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
                <input class="form-control" size="30" type="text" value="${activity.endTime}">
                <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
            </div>
            <input type="hidden" name="endTime" id="dtp_input2" value=""/><br/>
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
            <span>活动商品数量&nbsp;</span><input type="text" name="activityNumber" class="form-control" value="${activity.activityNumber}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>调价幅度（百分比1-100）</span>
            <input type="text" name="priceRange" class="form-control" value="${activity.priceRange}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>活动原因</span>
            <input type="text" name="reason" class="form-control" value="${activity.reason}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <span>备注</span>
            <input type="text" name="remarks" class="form-control" value="${activity.remarks}">
        </div>
        <br>
        <br>
        <div class="form-group">
            <input class="btn btn-warning box_relative" type="submit" value="修改">
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/activityAPC_out">返回</a>
        </div>
    </form>
</div>
</body>
</html>
