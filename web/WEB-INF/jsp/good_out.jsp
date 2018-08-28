<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        /*.pageTest {*/
            /*width: 1000px;*/
            /*height: 5px;*/
            /*margin-top: 5px;*/
        /*}*/
        /*.activP {*/
            /*background-color: #367fa9 !important;*/
            /*color: #fff !important;*/
        /*}*/
        td {
            text-align: center;
        }
        .box_relative {
            position: relative;
            left: 0px;
        }
    </style>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">



</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/good_out?type=find" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text" id="id" name="id" class="form-control" placeholder="请输入商品名称或编号">
            </div>
            <input class="btn btn-warning" type="submit"  value="查询" onclick="return check(this.form)">
            <a class="btn btn-info box_relative" href="${pageContext.request.contextPath }/good_out?type=add1">添加一类商品</a>
            <a class="btn btn-info box_relative" href="${pageContext.request.contextPath }/good_out?type=add2">添加二类商品</a>
            <%--<a class="btn btn-warning box_relative"--%>
               <%--href="${pageContext.request.contextPath }/good_out?type=export">导出</a>--%>
            <br>
            <br>

        </div>

        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">
                <tr>
                    <th>序号</th>
                    <th>商品名称</th>
                    <th>商品分类</th>
                    <th>商品品牌</th>
                    <th>商品型号</th>
                    <th>商品颜色</th>
                    <th colspan="4">操作</th>
                </tr>
                <c:forEach items="${good_list}" var="good" varStatus="s">
                    <tr class="active">
                        <%--<td>${good.gooodId}</td>--%>
                        <td>${good.goodId}</td>
                        <td>${good.goodName}</td>
                        <td>${good.goodType}</td>
                        <td>${good.goodBrand}</td>
                        <td>${good.goodModel}</td>
                        <td>${good.goodColor}</td>

                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/good_out?type=show&&id=${good.goodId}">查看</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/good_out?type=update&&id=${good.goodId}">修改</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/good_out?type=delete&&id=${good.goodId}">删除</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/activityAPC_out?type=loadGood&&id=${good.goodId}">促销选用</a>
                        </td>
                    </tr>
                </c:forEach>
                <%--<tr>--%>
                    <%--<td colspan="11">--%>
                        <%--<!--必须要的div-->--%>
                        <%--<div class="pageTest"></div>--%>
                    <%--</td>--%>
                <%--</tr>--%>
            </table>
        </div>
    </form>
</div>
</body>
<script type="text/javascript">

    function check(form) {
        // alert("来了");
        if (form.id.value==null || form.id.value==""){
            alert("请输入您要查找的品牌编号或名称！");
            return false;
        }
        return true;
    }
    var msg = "${msg}";
    if(msg=='deletesucc'){
        alert("删除成功");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if (msg=='deletefail'){
        alert("删除失败");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if(msg=='addsucc'){
        alert("添加成功");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if (msg=='addfail'){
        alert("添加失败");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if(msg=='updatesucc'){
        alert("修改成功");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if (msg=='updatefail'){
        alert("修改失败");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }
    if (msg=='kk'){
        alert("空空如也");
        window.location.replace("${pageContext.request.contextPath }/good_out");
    }

    // $(function () {
    //     $('.pageTest').page({
    //         leng: 10,//分页总数
    //         activeClass: 'activP', //active 类样式定义
    //         clickBack: function (page) {
    //             window.location.reload();
    //         }
    //     });
    // });
</script>
</html>
