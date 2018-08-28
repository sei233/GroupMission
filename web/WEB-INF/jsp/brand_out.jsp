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
    <form action="BrandController?type=find" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text"  name="id" class="form-control" placeholder="请输入查询 id或名称">
            </div>
            <input class="btn btn-warning" type="submit"  value="查询" onclick="return check(this.form)">
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/brand_out?type=add">添加</a>
        </div>
        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">
                <tr>
                    <th>编号</th>
                    <%--<th></th>--%>
                    <th>品牌名称</th>
                    <th>品牌网址</th>
                    <th>品牌描述</th>
                    <th colspan="3">操作</th>
                </tr>
                <c:forEach items="${brand_list}" var="brand" varStatus="s">
                    <tr class="active">
                        <td>${brand.brandId}</td>
                        <td>${brand.brandName}</td>
                        <td>${brand.brandWeb}</td>
                        <td>${brand.brandDescribe}</td>

                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/brand_out?type=show&&id=${brand.brandId}">查看</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/brand_out?type=update&&id=${brand.brandId}">修改</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/brand_out?type=delete&&id=${brand.brandId}">删除</a>
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
    // $(function () {
    //     $('.pageTest').page({
    //         leng: 10,//分页总数
    //         activeClass: 'activP', //active 类样式定义
    //         clickBack: function (page) {
    //             window.location.reload();
    //         }
    //     });
    // });
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
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if (msg=='deletefail'){
        alert("删除失败");
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if(msg=='addsucc'){
        alert("添加成功");
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if (msg=='addfail'){
        alert("添加失败");
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if(msg=='updatesucc'){
        alert("修改成功");
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if (msg=='updatefail'){
        alert("修改失败");
        window.location.replace("${pageContext.request.contextPath }/brand_out");
    }
    if (msg=='kk'){
        alert("空空如也");
        window.location.replace("${pageContext.request.contextPath }/type_out");
    }
</script>
</html>
