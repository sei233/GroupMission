<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 石乾
  Date: 2018/7/18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>

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
    <form action="${pageContext.request.contextPath}/product_out?type=find" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text"  name="id" class="form-control" placeholder="请输入查询 id或名称">
                <input class="btn btn-warning" type="submit"  value="查询">
                <%--onclick="return check(this.form)"--%>
            </div>

            <br>
            <br>
            <div class="form-group">
                <label>颜色:</label>
                <select class="btn btn-default" name="pro_color">
                    <option value="">请选择</option>
                    <c:forEach items="${color_list}" var="color" varStatus="s">
                        <option value="${color}">${color}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>型号:</label>
                <select class="btn btn-default" name="pro_model">
                    <option value="">请选择</option>
                    <c:forEach items="${model_list}" var="model" varStatus="s">
                        <option value="${model}">${model}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label>品牌:</label>
                <select class="btn btn-default" name="pro_brand">
                    <option value="">请选择</option>
                    <c:forEach items="${brand_list}" var="brand" varStatus="s">
                        <option value="${brand}">${brand}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
            <label>类型:</label>
            <select class="btn btn-default" name="pro_type">
                <option value="">请选择</option>
                <c:forEach items="${type_list}" var="type1" varStatus="s">
                    <option value="${type1}">${type1}</option>
                </c:forEach>
            </select>
        </div>
        </div>
        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">
                <tr>
                    <th>存档编号</th>
                    <%--<th></th>--%>
                    <th>产品名称</th>
                    <th>产品品牌</th>
                    <th>产品分类</th>
                    <th>产品型号</th>
                    <th>产品颜色</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${product_list}" var="product" varStatus="s">
                    <tr class="active">
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productBrand}</td>
                        <td>${product.productType}</td>
                        <td>${product.productModel}</td>
                        <td>${product.productColor}</td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/good_out?type=choosefg&&id=${product.productId}">选择</a>
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
    var msg = "${msg}";
    if (msg=='kk'){
        alert("空空如也");
        window.location.replace("${pageContext.request.contextPath }/type_out");
    }
    /*function check(form) {
        // alert("来了");
        if (form.id.value==null || form.id.value==""){
            alert("请输入您要查找的品牌编号或名称！");
            return false;
        }
        return true;
    }*/

</script>
</html>
