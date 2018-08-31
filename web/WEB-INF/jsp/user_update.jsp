<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: adorn
  Date: 2018/8/23
  Time: 下午2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <%--<script src="/js/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/page.js"></script>
    <link rel="stylesheet" href="css/page.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <form action="/UserController?type=updateToUser" method="post" class="form-inline">
        <div>
            <%--<a class="btn btn-primary box_relative" href="${pageContext.request.contextPath }/user_detail?type=export">导入</a>--%>
            <%--<c:out value="${user}"></c:out>--%>
            <div class="form-group">
                <span>用户编号&nbsp;</span><input type="text" name="userId" class="form-control" value="${user.userId}"readonly="readonly" style="background: rgba(195,238,238,0.13)">
            </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户账户&nbsp;</span><input type="text" name="userAccount" class="form-control" value="${user.userAccount}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span >用户姓名&nbsp;</span><input type="text" name="userName" class="form-control" value="${user.userName}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户部门&nbsp;</span><input type="text" name="userDept" class="form-control" value="${user.userDept}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户性别&nbsp;</span><select class="btn btn-default" name="userSex">
                    <option value="">请选择</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户状态&nbsp;</span><select class="btn btn-default" name="userStatus">
                    <option value="">请选择</option>
                    <option value="有效">有效</option>
                    <option value="无效">无效</option>
                </select>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户职位&nbsp;</span><select class="btn btn-default" name="userTitle">
                    <option value="">请选择</option>
                    <option value="员工">员工</option>
                    <option value="经理">经理</option>
                    <option value="处长">处长</option>
                </select>
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户电话&nbsp;</span><input type="text" name="userPhone" class="form-control" value="${user.userPhone}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户邮箱&nbsp;</span><input type="text" name="userEmail" class="form-control" value="${user.userEmail}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>用户角色&nbsp;</span><input type="text" name="userRole" class="form-control" value="${user.userRole}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>备注1&nbsp;</span><input type="text" name="userRemark1" class="form-control" value="${user.userRemark1}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>备注2&nbsp;</span><input type="text" name="userRemark2" class="form-control" value="${user.userRemark2}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>备注3&nbsp;</span><input type="text" name="userRemark3" class="form-control" value="${user.userRemark3}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>备注4&nbsp;</span><input type="text" name="userRemark4" class="form-control" value="${user.userRemark4}">
                </div>
                <br>
                <br>
                <div class="form-group">
                    <span>备注5&nbsp;</span><input type="text" name="userRemark5" class="form-control" value="${user.userRemark5}">
                </div>
                <br>
                <br>
            <input class="btn btn-warning" type="submit" value="修改">
            <%--<input class="btn btn-warning" type="reset" value="重置">--%>
            <%--<a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/user_out?type=addToUser">添加</a>--%>
            <a class="btn btn-warning box_relative" href="${pageContext.request.contextPath }/user_out">返回</a>
        </div>


    </form>
</div>
</body>
<script type="text/javascript">


</script>
</html>

