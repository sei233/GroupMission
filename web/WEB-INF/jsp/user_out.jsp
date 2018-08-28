<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adorn
  Date: 2018/8/22
  Time: 下午4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <script type="text/javascript">
        $(function () {
            $('.pageTest').page({
                leng: 10,//分页总数
                activeClass: 'activP', //active 类样式定义
                clickBack: function (page) {
                    window.location.reload();
                }
            });
        });
    </script>

</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/user_out?type=query" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="用户编号">
            </div>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/user_out?type=find">查询</a>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/user_out?type=add">添加</a>

        </div>
        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">

                <tr>
                    <th>编号</th>
                    <%--<th></th>--%>
                    <th>账户</th>
                    <th>名字</th>
                    <th>部门</th>
                    <th>性别</th>
                    <th>状态</th>
                    <th>职位</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>角色</th>
                    <th>备注1</th>
                    <th>备注2</th>
                    <th>备注3</th>
                    <th>备注4</th>
                    <th>备注5</th>

                    <th colspan="3">操作</th>
                </tr>
                <c:forEach items="${user_list}" var="user" varStatus="s">
                    <tr class="active">
                        <td>${user.userId}</td>
                        <td>${user.userAccount}</td>
                        <td>${user.userName}</td>
                        <td>${user.userDept}</td>
                        <td>${user.userSex}</td>
                        <td>${user.userStatus}</td>
                        <td>${user.userTitle}</td>
                        <td>${user.userPhone}</td>
                        <td>${user.userEmail}</td>
                        <td>${user.userRole}</td>
                        <td>${user.userRemark1}</td>
                        <td>${user.userRemark2}</td>
                        <td>${user.userRemark3}</td>
                        <td>${user.userRemark4}</td><
                        <td>${user.userRemark5}</td>

                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/user_out?type=delate&&id=${user.userId}">删除</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/user_out?type=update&&id=${user.userId}">修改</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="11">
                        <!--必须要的div-->
                        <div class="pageTest"></div>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>
</body>
</html>
