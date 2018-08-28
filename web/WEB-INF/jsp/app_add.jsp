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
        .pageTest {
            width: 1000px;
            height: 5px;
            margin-top: 5px;
        }

        .activP {
            background-color: #367fa9 !important;
            color: #fff !important;
        }

        td {
            text-align: center;
        }

        .box_relative {
            position: relative;
            left: 0px;
        }
    </style>

    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.fr.js"></script>
    <script type="text/javascript" src="js/page.js"></script>


    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">

    <script type="text/javascript">
        $(function () {
            $('#submit').click(function () {
                return window.confirm("您确定添加吗?");
            })
        });

        function test() {
            var IDs = new Array();
            $.each($('input:checkbox:checked'),function(){
                IDs.push($(this).val());
            });

            $.ajax({                                     //AJAX获取二级的部门信息。 注意：这里的ajax采用的是jquery里面的方法，使用前需要导入jquery库。
                url:'${pageContext.request.contextPath }/app_out?type=json',
                type:'POST',
                dataType:'JSON',
                data:{
                    IDs:JSON.stringify(IDs)
                },
                success:function (jsonStr){
                    alert(jsonStr.toString());
                },
                error:function(data){
                    alert("error");
                }
            })
        }
    </script>

</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/app_out?type=query" method="post">
        <div>
            <div class="form-group">
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
                    选择商品
                </button>

                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">选择商品</h4>
                            </div>
                            <div class="modal-body">
                                <c:forEach items="${products}" var="product" varStatus="s">
                                    <div>
                                        <label>
                                            <input type="checkbox" name="productId" class="checkbox-inline"
                                            value="${product.productId}">
                                            <span class="btn">
                                                    ${product.productName}|${product.productType}|${product.productColor}
                                            </span>
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="test()">OK
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <br>
                <br>

                <table id="table" border="1" class="table table-striped table-bordered table-hover">
                    <tr>
                        <th>商品串码</th>
                        <th>商品品牌</th>
                        <th>商品型号</th>
                        <th>商品颜色</th>
                        <th>商品供应商</th>
                        <th>商品跟踪信息</th>
                        <th>返厂配置</th>
                        <th colspan="3">操作</th>
                    </tr>
                </table>
            </div>

            <div class="form-group">
                <label>返厂地点:</label>
                <input type="text" name="docuMaker" class="form-control">
            </div>

            <div class="form-group">
                <label>返厂原因:</label>
                <textarea name="docuMaker" class="form-control"></textarea>
            </div>

            <div class="form-group">
                <label>备注:</label>
                <textarea name="docuMaker" class="form-control"></textarea>
            </div>
        </div>


        <input type="submit" id="submit" class="btn btn-info" value="保存">
        <a class="btn btn-info box_relative"
           href="${pageContext.request.contextPath }/app_out">返回</a>

    </form>
</div>
</body>
</html>
