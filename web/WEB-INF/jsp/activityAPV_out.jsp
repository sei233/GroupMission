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
    <form action="${pageContext.request.contextPath}/activityAPV_out?type=find" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text"  name="id" class="form-control" placeholder="请输入活动 id或名称">
                <input class="btn btn-warning" type="submit"  value="查询" onclick="return check(this.form)">
            </div>
            <br>
            <br>
            <div class="form-group">
                <label>审批状态 :</label>
                <select class="btn btn-default" name="approveState">
                    <option value="0">全部</option>
                    <option value="1">1级审核通过</option>
                    <option value="2">2级审核通过</option>
                    <option value="3">审核通过</option>
                    <option value="4">审核不通过</option>
                    <option value="5">未审核</option>
                </select>
            </div>
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
                    <th colspan="2">操作</th>
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
                               href="${pageContext.request.contextPath }/activityAPV_out?type=show&&id=${activity.activityId}">查看</a>
                        </td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/activityAPV_out?type=apv&&id=${activity.activityId}">审核</a>
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
    if(msg=='apvyes'){
        alert("审核成功");
        window.location.replace("${pageContext.request.contextPath }/activityAPV_out");
    }
    if (msg=='apvno'){
        alert("审核失败");
        window.location.replace("${pageContext.request.contextPath }/activityAPV_out");
    }
    if(msg=='apverr'){
        alert("审核出错，请检查审核状态");
        window.location.replace("${pageContext.request.contextPath }/activityAPV_out");
    }
    if (msg=='kk'){
        alert("空空如也");
        window.location.replace("${pageContext.request.contextPath }/activityAPV_out");
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
