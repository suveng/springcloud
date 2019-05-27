<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${request.contextPath}/static/layui/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${request.contextPath}/static/layui/style/admin.css" media="all">
    <link rel="stylesheet" href="${request.contextPath}/static/layui/style/login.css" media="all">
    <title>登入 - 后台</title>
    <#include "head_script.ftl">
</head>

<body>
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>后台-登录</h2>
            <p>测试系统 by suveng@163.com</p>
        </div>


        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username"
                       for="LAY-user-login-username"></label>
                <input id="username" type="text" name="username" lay-verify="required" placeholder="用户名"
                       class="layui-input" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password"
                       for="LAY-user-login-password"></label>
                <input id="password" type="password" name="password" lay-verify="required"
                       placeholder="密码" class="layui-input" autocomplete="off">
            </div>
            <div class="layui-form-item">
                <button id="login" class="layui-btn layui-btn-fluid">登
                    入
                </button>
            </div>
            <div class="layui-form-item">
                <button type="reset" class="layui-btn layui-btn-fluid">重 置</button>
            </div>
        </div>

    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© ${.now?string["yyyy-MM-dd"]} <a href="" target="_blank">suveng@163.com</a></p>
    </div>

</div>

<#include "footer_script.ftl">
<script>
    /**
     * 系统
     */
    $(function () {
        console.log("jquery ready");

        $("#login").click(function () {
            loginFunc()
        });
        $(document).keyup(function (event) {
            //按下回车键
            if (event.ctrlKey && event.which === 13) {
                loginFunc();
            } else if (event.which === 13) {
                layer.msg("请按ctrl+enter键提交", {icon: 1, time: 1000})
            }
        })
    });

    var loginFunc = function () {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username == null || username === undefined || username === '' || password === '' || password == null || password === undefined) {
            layer.msg('请填写完整用户名和密码', {icon: 5, time: 2000});
        }
        $.ajax({
            url: "/user/login",
            type: "post",
            data: {"username":username,"password":password},
            dataType: "json",
            success: function (res) {
                console.log("返回数据:" + res);
            }
        })
    }

</script>
</body>
</html>
