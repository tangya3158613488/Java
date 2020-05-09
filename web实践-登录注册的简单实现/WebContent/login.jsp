<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
</head>

<body>
<form id="form1" name="form1" method="post" action="/Demo1/Login">
  <p>
    <label for="textfield">用户名</label>
    <input type="text" name="username" id="textfield" />
  </p>
  <p>
    <label for="textfield2">密码</label>
    <input type="text" name="userpwd" id="textfield2" />
  </p>
  <p>
  <input type="submit" name="button" id="button" value="登录" />
</p>
</form>

</body>
</html>