<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image: url(file:///E|/MyWeb/back1.jpeg);
}
</style>
</head>

<body>
<div align="center"> 
  <h3>报修申请表</h3>
</div>
<form action="" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <label for="textfield">
  </label>
  <div align="center">
    <p>宿舍号
      <input type="text" name="textfield" id="textfield" />
    </p>
    <p>
      <label for="textfield2">设备号</label>
      <input type="text" name="textfield2" id="textfield2" />
    </p>
    <p>
      <label for="textfield3">设备名</label>
      <input type="text" name="textfield3" id="textfield3" />
    </p>
    <p>
      <label for="textfield4">报修时间</label>
      <input type="text" name="textfield4" id="textfield4" />
    </p>
    <p>
      <label for="textfield5">
  报修原因</label>
      <input type="text" name="textfield5" id="textfield5" />
    </p>
    <td colspan="2" bgcolor="#FFFFFF">
        <input type="submit" name="button" id="button" value="提交" />
        <input type="submit" name="button" id="button" value="返回" />
    </td>
  </div>
</form>
<p align="center">&nbsp;</p>
</body>
</html>