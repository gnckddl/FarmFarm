<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ----------> 
<html>
<head>   
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style type="text/css">
body#LoginForm{ background-image:url("resources/images/host/emailcheckerpaper.jpg"); background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}
.form-heading { color:#fff; font-size:23px;}
.panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
.panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
.login-form .form-control {
  background: #f7f7f7 none repeat scroll 0 0;
  border: 1px solid #d4d4d4;
  border-radius: 4px;
  font-size: 14px;
  height: 50px;
  line-height: 50px;
}
.main-div {
  background: #ffffff none repeat scroll 0 0;
  border-radius: 2px;
  margin: 10px auto 30px;
  max-width: 38%;
  padding: 50px 70px 70px 71px;
}

.login-form .form-group {
  margin-bottom:10px;
}
.login-form{ text-align:center;}
.forgot a {
  color: #777777;
  font-size: 14px;
  text-decoration: underline;
}
.login-form  .btn.btn-primary {
  background: #f0ad4e none repeat scroll 0 0;
  border-color: #f0ad4e;
  color: #ffffff;
  font-size: 14px;
  width: 100%;
  height: 50px;
  line-height: 50px;
  padding: 0;
}
.forgot {
  text-align: left; margin-bottom:30px;
}
.botto-text {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login-form .btn.btn-primary.reset {
  background: #ff9900 none repeat scroll 0 0;
}
.back { text-align: left; margin-top:10px;}
.back a {color: #444444; font-size: 13px;text-decoration: none;}
</style>
</head>
<script type="text/javascript">
function emailCheckDo(key){
	alert(key);
	if(key == document.getElementById('emailCheck').value){
		alert("이메일 인증 성공");
		opener.document.registerForm.hiddenemail.value="1";
		self.close();
	}else{
		alert("인증실패");
		return false;
	}
}
</script>

<body id="LoginForm">
<div class="container">
<div class="login-form">
<div class="main-div">
    <div class="panel">
   <p>팜팜 회원 가입에 필요한 <br>메일 인증키를 입력하세요</p>
   </div>
    <form id="Login">

        <div class="form-group">
			<input type="text" id="emailCheck" maxlength="10" class="form-control" required="required" placeholder="Your KEY password">
        </div>

        <div class="form-group">
			
        </div>
        <div class="forgot">
		</div>
		<input class="btn btn-primary" type="button" value="확인" onclick="return emailCheckDo('${key}');" style="width: 92px;">
		<input class="btn btn-primary" type="reset" value="취소" style="width: 92px;" onclick="self.close();">
    </div>
</div>
</div>
</body>
</html>