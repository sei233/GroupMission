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

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/js/page.js"></script>
    <link rel="stylesheet" href="/css/page.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">

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
    <form action="${pageContext.request.contextPath}/app_out?type=query" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="返厂出库单号">
            </div>

            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="返厂出库标志">
            </div>

            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="审核状态">
            </div>

            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="制单人">
            </div>


            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/app_out?type=add">添加</a>
            <a class="btn btn-warning box_relative"
               href="${pageContext.request.contextPath }/app_out?type=export">导出</a>
        </div>

        <div>
            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="制单时间">
            </div>

            <div class="form-group">
                <input type="text" name="condition" class="form-control" placeholder="审批时间">
            </div>

            <input type="submit" class="btn btn-info" value="查询">
            <a class="btn btn-warning box_relative"
               href="${pageContext.request.contextPath }/app_out?type=delete">删除</a>
        </div>

        <br>
        <br>
        <div class="form-group">
            <table id="table" border="1" class="table table-striped table-bordered table-hover">
                <tr>
                    <th>序号</th>
                    <th></th>
                    <th>返厂出库单号</th>
                    <th>返厂出库标志</th>
                    <th>制单人</th>
                    <th>制单时间</th>
                    <th>审批人</th>
                    <th>审批状态</th>
                    <th colspan="3">操作</th>
                </tr>
                <c:forEach items="${appVos}" var="appVo" varStatus="s">
                    <tr class="active">
                        <td>${appVo.app.appID}</td>
                        <td>
                            <c:if test="${appVo.app.approvalState != 1}">
                                <input type="checkbox">
                            </c:if>
                        </td>
                        <td>${appVo.app.antiOutID}</td>
                        <td>${appVo.outSign}</td>
                        <td>${appVo.app.docuMaker}</td>
                        <td>${appVo.app.docuTime}</td>
                        <td>${appVo.app.approver}</td>
                        <td>${appVo.approvalState}</td>
                        <td><a class="btn btn-primary"
                               href="${pageContext.request.contextPath }/app_out?type=look&&id=${appVo.app.appID}">查看</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/app_out?type=update&&id=${appVo.app.appID}">修改</a>
                        </td>
                        <td><a class="btn btn-danger"
                               href="${pageContext.request.contextPath }/app_out?type=follow&&id=${appVo.app.appID}">审核跟踪</a>
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
