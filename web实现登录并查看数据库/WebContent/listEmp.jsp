<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/listEmp.css" >
</head>
<body>
	<a href="/web2/emplist.html?current=1">第一页</a>
	<a href="/web2/emplist.html?current=2">第二页</a>
	<table>
	<tr>
		<td>员工id</td><td>员工姓名</td><td>员工年龄</td><td>员工性别</td><td>员工手机号</td><td>员工部门</td>
	</tr>
	<c:forEach items="${emps}" var="e">
		<tr>
			<td>${e.id}</td><td>${e.name}</td><td>${e.age}</td><td>${e.gender}</td><td>${e.phone}</td><td>${e.empNo}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>