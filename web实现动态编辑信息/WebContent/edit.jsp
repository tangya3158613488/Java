<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

请在下面表单编辑新数据，然后提交<br>

<form action="edit.html" method="post">
	<input type="hidden" name="id" value="${e.id}">
	新员工名字：<input type="text" name="name" value="${e.name}"><br>
	员工编号：<input type="text" name="empNo" value="${e.empNo}"><br>
	年龄：<input type="text" name="age" value="${e.age}"><br>
	性别：<input type="text" name="gender" value="${e.gender}"><br>
	手机号：<input type="text" name="phone" value="${e.phone}"><br>
	<input type="submit" value="提交"><br>
</form>
</body>
</html>