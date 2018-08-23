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
            $('.pageTest').page({
                leng: 10,//分页总数
                activeClass: 'activP', //active 类样式定义
                clickBack: function (page) {
                    window.location.reload();
                }
            });

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

            $('#submit').click(function () {
                return window.confirm("您确定删除吗?");
            })
        });
    </script>

</head>
<body>
<br>
<div class="container">
    <form action="${pageContext.request.contextPath}/app_out?type=query" method="post" class="form-inline">
        <div>
            <div class="form-group">
                <label>返厂出库单号:</label>
                <input type="text" name="antiOutID" class="form-control" placeholder="返厂出库单号">
            </div>

            <div class="form-group">
                <label>返厂出库标志:</label>
                <select class="btn btn-default" name="outSign">
                    <option value="">请选择</option>
                    <option value="0">未出库</option>
                    <option value="1">已出库</option>
                </select>
            </div>

            <div class="form-group">
                <label>审核状态:</label>
                <select class="btn btn-default" name="approvalState">
                    <option value="">请选择</option>
                    <option value="1">不通过</option>
                    <option value="2">审批通过</option>
                    <option value="0">未审批</option>
                </select>
            </div>

            <div class="form-group">
                <label>制单人:</label>
                <input type="text" name="docuMaker" class="form-control" placeholder="制单人">
            </div>
        </div>
        <br>
        <div>
            <div class="form-group">
                <label for="dtp_input1">制单时间:</label>
                <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                     data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                    <input class="form-control" size="30" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
                <input type="hidden" name="docuTimeBegin" id="dtp_input1" value=""/><br/>
            </div>

            <div class="form-group">
                <label for="dtp_input2">至</label>
                <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                     data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input2">
                    <input class="form-control" size="30" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
                <input type="hidden" name="docuTimeEnd" id="dtp_input2" value=""/><br/>
            </div>
        </div>
        <br>
        <div>
            <div class="form-group">
                <label for="dtp_input3">审批时间:</label>
                <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                     data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input3">
                    <input class="form-control" size="30" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
                <input type="hidden" name="approvalTimeBegin" id="dtp_input3" value=""/><br/>
            </div>

            <div class="form-group">
                <label for="dtp_input4">至</label>
                <div class="input-group date form_datetime" data-date="2018-08-01T01:00:00Z"
                     data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input4">
                    <input class="form-control" size="30" type="text" value="" readonly>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                </div>
                <input type="hidden" name="approvalTimeEnd" id="dtp_input4" value=""/><br/>
            </div>
        </div>
        <br>
        <div>
            <div class="form-group">
                <a class="btn btn-info box_relative" href="${pageContext.request.contextPath }/app_out?type=addRe">添加</a>
                <a class="btn btn-info box_relative"
                   href="${pageContext.request.contextPath }/app_out?type=export">导出</a>
                <input type="submit" class="btn btn-info" value="查询">
            </div>
        </div>
    </form>

    <hr>

    <form action="${pageContext.request.contextPath}/app_out?type=delete" method="post">
        <div class="form-group">
            <input type="submit" id="submit" class="btn btn-danger" value="删除">
            <a class="btn btn-info box_relative"
               href="${pageContext.request.contextPath }/app_out?type=refresh">刷新</a>
        </div>

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
                            <c:if test="${appVo.app.approvalState == 0}">
                                <input type="checkbox" name="appID" value="${appVo.app.appID}">
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
