<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/editStu.css"/>
</head>


<body align="center">
<font face="华文行楷" size=10 color="green" >
<br>
<h4>更新数据：</h4>
<form action="edit.html" method="post">
</font>

<font face="黑体" >
<input  type="hidden" name="id" value="${e.id}"><br>
电话号码：<input  type="text" name="phone" value="${e.phone}"><br>
<br>
Q Q 号码：<input type="text" name="qq" value="${e.qq}"><br>
<br>
家庭住址：<input  type="text" name="address" value="${e.address}"><br>
<br>
</font>
<input type="submit" value="提交">
<button><a href="stulist.html">取消</a></button><br>

</form>
</body>
</html>