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

    <%--<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>--%>
    <script src="/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/css/bootstrap.min.css">

    <script type="text/javascript">
        $(function () {
            $('#submit').click(function () {
                return window.confirm("您确定添加吗?");
            })
        });
    </script>
</head>
<body bgcolor="#FFFFCC">
<br>
<form action="${pageContext.request.contextPath }/game/add.action" method="post"
      enctype="multipart/form-data">
    <div class="container">
        <div class="form-group">
            <div><label class="control-label">游戏名称</label></div>
            <div>
                <input class="form-control" type="text" name="gameName" placeholder="游戏名称">
            </div>
        </div>

        <div class="form-group">
            <div><label>游戏标题</label></div>
            <div>
                <input class="form-control" type="text" name="gameTitle" placeholder="游戏标题">
            </div>
        </div>

        <div class="form-group">
            <div><label>游戏大小</label></div>
            <div>
                <input class="form-control" type="text" name="gameSize" placeholder="游戏大小">
            </div>
        </div>

        <%--<div>--%>
        <%--<div><label>游戏图标</label></div>--%>
        <%--<div>--%>
        <%--<input type="file"  name="gameIcon"/>--%>
        <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <div><label>游戏详情图片</label></div>
            <div>
                <input class="btn btn-primary" type="file" name="gamepic"/>
            </div>
        </div>

        <div class="form-group">
            <div><label>ios下载地址</label></div>
            <div>
                <input class="form-control" type="text" name="gameIosaddress" placeholder="ios下载地址">
            </div>
        </div>

        <div class="form-group">
            <div><label>android下载地址</label></div>
            <div>
                <input class="form-control" type="text" name="gameAndroidaddress" placeholder="android下载地址">
            </div>
        </div>

        <div class="form-group">
            <div style="display: inline-block">
                <div><label>推荐类型</label></div>
                <div>
                    <select class="btn btn-default" name="gameAdviseType">
                        <option value="">请选择</option>
                        <option value="0">普通</option>
                        <option value="1">最新</option>
                        <option value="2">精选</option>
                        <option value="3">首页推荐</option>
                    </select>
                </div>
            </div>
            <div style="display: inline-block">
                <div><label>状态</label></div>
                <div>
                    <select class="btn btn-default" name="gameStatus">
                        <option value="">请选择</option>
                        <option value="0">下线</option>
                        <option value="1">启用</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div style="display: inline-block">
                <div><label>游戏分类</label></div>
                <div>
                    <select class="btn btn-default" name="gameType">
                        <option value="">请选择</option>
                        <option value="0">休闲益智</option>
                        <option value="1">网络游戏</option>
                        <option value="2">动作冒险</option>
                        <option value="3">棋牌中心</option>
                        <option value="4">飞行射击</option>
                        <option value="5">经营策略</option>
                        <option value="6">角色扮演</option>
                        <option value="7">体育竞技</option>
                    </select>
                </div>
            </div>
            <div style="display: inline-block">
                <div><label>平台类型</label></div>
                <div>
                    <select class="btn btn-default" name="gameOperation">
                        <option value="">请选择</option>
                        <option value="0">all</option>
                        <option value="1">ios</option>
                        <option value="2">android</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="form-group">
            <div><label>游戏描述</label></div>
            <div>
                <textarea class="form-control input-sm" name="gameDescription" placeholder="游戏描述"></textarea>
            </div>
        </div>
        <input id="submit" class="btn btn-info" type="submit" value="保存">
    </div>
</form>

</body>
</html>
