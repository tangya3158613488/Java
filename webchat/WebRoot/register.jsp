<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Mirrored from www.zi-han.net/theme/hplus/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vvv聊天室 - 注册</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>
<body class="gray-bg">
    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">vvv</h1>
            </div>
            <h3>欢迎使用vvv软件</h3>
            <p>创建一个vvv新账户</p>
            <form class="m-t" role="form" action="reg.action" method="post">
                <div class="form-group">
                    <input name="loginname" type="text" class="form-control" placeholder="请输入账号" required="">
                </div>
                <div class="form-group">
                    <input name="loginpwd" type="password" class="form-control" placeholder="请输入密码" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请再次输入密码" required="">
                </div>
                <div class="form-group">
                    <input name="nickname" type="password" class="form-control" placeholder="请输入昵称" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>
                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
                </p>
            </form>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/register.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 20 Jan 2016 14:19:52 GMT -->
</html>

