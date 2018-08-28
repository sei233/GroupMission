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
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/js/page.js"></script>
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/activityAPC_out?type=find" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text"  name="id" class="form-control" placeholder="请输入活动 id或名称">
                <input class="btn btn-warning" type="submit"  value="查询" onclick="return check(this.form)">
                <a class="btn btn-info box_relative" href="${pageContext.request.contextPath }/activityAPC_out?type=add">添加</a>
            </div>
            <br>
            <br>
        </div>
        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">
                <tr>
                    <th>编号</th>
                    <th>活动名称</th>
                    <th>活动开始时间</th>
                    <th>活动价格</th>
                    <th>调价幅度</th>
                    <th>审批状态</th>
                    <th colspan="3">操作</th>
                </tr>
                <c:forEach items="${activity_list}" var="activity" varStatus="s">
                    <tr class="active">
                        <td>${activity.activityId}</td>
                        <td>${activity.activityName}</td>
                        <td>${activity.beginTime}</td>
                        <td>${activity.activityPrice}</td>
                        <td>${activity.priceRange}</td>
                        <td>${activity.approveState}</td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/activityAPC_out?type=show&&id=${activity.activityId}">查看</a>
                        </td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/activityAPC_out?type=update&&id=${activity.activityId}">修改</a>
                        </td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/activityAPC_out?type=delete&&id=${activity.activityId}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">
    var msg = "${msg}";
    if(msg=='deletesucc'){
        alert("删除成功");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if (msg=='deletefail'){
        alert("删除失败");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if(msg=='addsucc'){
        alert("添加成功");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if (msg=='addfail'){
        alert("添加失败");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if(msg=='updatesucc'){
        alert("修改成功");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if (msg=='updatefail'){
        alert("修改失败");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }
    if (msg=='kk'){
        alert("空空如也");
        window.location.replace("${pageContext.request.contextPath }/activityAPC_out");
    }

    function check(form) {
        if (form.id.value==null || form.id.value==""){
            alert("请输入您要查找的编号或名称！");
            return false;
        }
        return true;
    }
</script>
</html>
