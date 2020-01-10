<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
if(session.getAttribute("user")==null){
	out.println("<script>alert('请登录后操作！');location='login.jsp';</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vvv聊天室 - 聊天室</title>
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/jsTree/style.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
    
</head>
<body class="gray-bg">
    <div class="">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox chat-view">
                    <div class="ibox-title">
 						聊天窗口[当前用户:${user.nickname }]
 						<small class="pull-right text-muted"><a href="logout.action">退出登录</a></small>
                    </div>
                    <div class="ibox-content" >
                        <div class="row">
                            <div class="col-md-9">
                                <div id="allMessage" class="chat-discussion" style="height:720px;">
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="chat-users" style="height:720px;">
                                    <div id="allUser" class="users-list">
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="img/a.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a>伤城Simple</a>
                                            </div>
                                        </div>
                                        <div class="chat-user">
                                            <img class="chat-avatar" src="img/a.jpg" alt="">
                                            <div class="chat-user-name">
                                                <a>伤城Simple</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="chat-message-form">
                                    <div class="form-group">
                                        <textarea id="contents" class="form-control message-input" name="message" placeholder="输入消息内容"></textarea>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <button id="btnSend" class="btn btn-primary block full-width m-b">发 送 消 息</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript">
    $(function(){
    	showMsg();
    	showUsers();
    	$('#btnSend').click(function(){
   			$.post('addMsg.action',{contents:$('#contents').val()});
   			$('#contents').val('');
   		});
    });
    function showMsg(){
    	$.post('showMsg.action',null,function(data){
	   		$('#allMessage').html(data);
	   	});
    	setTimeout('showMsg()',2000);
    }
   	function showUsers(){
    	$.post('showUser.action',null,function(data){
	   		$('#allUser').html(data);
	   	});
    	setTimeout('showUsers()',2000);
    }
    </script>
</body>
</html>

