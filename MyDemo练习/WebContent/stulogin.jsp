<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生登录</title>
</head>
<style type="text/css">
body {
	background-image: url(file:///E|/MyWeb/a942c0b656fbf9a5100a295cddd6465a.jpg);
}
</style>
<body>
<div align="center">
  <h1>学生登录页面
  </h1>
</div>
<form id="form1" name="form1" method="post" action="/Mywork/StuLogin">
  <div align="center" style="width: 966px; height: 315px; ">
  	<p align="right">&nbsp;</p>
  	<p>
  	  <label for="textfield">学号</label>
  	  <input type="text" name="userid" id="textfield" />
  	</p>
      <p>
  		   <label for="textfield"> 密码</label>
        <input type="password" name="userpwd" id="textfield" style="width: 149px; "/>
     </p>
      <p>
        <input type="submit" name="button" id="button" value="登录" />      
      </p>
  </div>
  
</form>
<p>&nbsp;</p>

</body>
</html>