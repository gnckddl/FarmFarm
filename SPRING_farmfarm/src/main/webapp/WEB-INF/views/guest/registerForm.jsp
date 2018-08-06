<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">
<title>회원가입</title>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<!-- 외부스타일 시트 적용 -->
</head>

<!-- 주소 찾기 API를 위한 스크립트  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('sample6_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('sample6_address2').focus();
            }
        }).open();
    }
</script>

<!-- 이메일 인증을 위한 자바스크립트 -->
<script type="text/javascript">
function email4(){

	var spec = "left=10,top=10,width=700,hight=550";
	spec += ",toolbar=no,menubar=no,status=no,scrollbars=no,resizeable=no";
	window.open("registerEmailConfirm?email1="+document.registerForm.email1.value+"&email2="+document.registerForm.email2.value,"팝업",spec);
	
}

function emailchk() {
	if (document.registerForm.email.value == 0)
		document.registerForm.email2.value = "";
	else
		document.registerForm.email2.value = document.registerForm.email.value;

}

</script>
<!-- 1.css 추가부분 -->
<style type="text/css">
	/* body {
	    padding-top: 90px;
	} */
	.panel-login {
		border-color: #ccc;
		-webkit-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
		-moz-box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
		box-shadow: 0px 2px 3px 0px rgba(0,0,0,0.2);
	}
	.panel-login>.panel-heading {
		color: #00415d;
		background-color: #fff;
		border-color: #fff;
		text-align:center;
	}
	.panel-login>.panel-heading a{
		text-decoration: none;
		color: #666;
		font-weight: bold;
		font-size: 15px;
		-webkit-transition: all 0.1s linear;
		-moz-transition: all 0.1s linear;
		transition: all 0.1s linear;
	}
	.panel-login>.panel-heading a.active{
		color: #029f5b;
		font-size: 18px;
	}
	.panel-login>.panel-heading hr{
		margin-top: 10px;
		margin-bottom: 0px;
		clear: both;
		border: 0;
		height: 1px;
		background-image: -webkit-linear-gradient(left,rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.15),rgba(0, 0, 0, 0));
		background-image: -moz-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
		background-image: -ms-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
		background-image: -o-linear-gradient(left,rgba(0,0,0,0),rgba(0,0,0,0.15),rgba(0,0,0,0));
	}
	.panel-login input[type="text"],.panel-login input[type="email"],.panel-login input[type="password"] {
		height: 45px;
		border: 1px solid #ddd;
		font-size: 16px;
		-webkit-transition: all 0.1s linear;
		-moz-transition: all 0.1s linear;
		transition: all 0.1s linear;
	}
	.panel-login input:hover,
	.panel-login input:focus {
		outline:none;
		-webkit-box-shadow: none;
		-moz-box-shadow: none;
		box-shadow: none;
		border-color: #ccc;
	}
	.btn-login {
		background-color: #59B2E0;
		outline: none;
		color: #fff;
		font-size: 14px;
		height: auto;
		font-weight: normal;
		padding: 14px 0;
		text-transform: uppercase;
		border-color: #59B2E6;
	}
	.btn-login:hover,
	.btn-login:focus {
		color: #fff;
		background-color: #53A3CD;
		border-color: #53A3CD;
	}
	.forgot-password {
		text-decoration: underline;
		color: #888;
	}
	.forgot-password:hover,
	.forgot-password:focus {
		text-decoration: underline;
		color: #666;
	}
	
	.btn-register {
		background-color: #1CB94E;
		outline: none;
		color: #fff;
		font-size: 14px;
		height: auto;
		font-weight: normal;
		padding: 14px 0;
		text-transform: uppercase;
		border-color: #1CB94A;
	}
	.btn-register:hover,
	.btn-register:focus {
		color: #fff;
		background-color: #1CA347;
		border-color: #1CA347;
	}
	
</style>
<body>



<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 --> 
<!--2 html 추가부분 -->
<!--loginForm.html을 다른이름으로 저장해서 registerForm.html로 저장한다.  -->
<!--1) display:none <=> display:block을 서로 바꾼다.
	2) 로그인의 class="active"를 회원가입쪽에 잘라서 붙인다.
	
  -->
<div class="container">
   	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-login">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-12">
							<a href="#" class="active" id="register-form-link">회원가입</a>
						</div>
					</div>
					<hr>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form id="registerForm" name="registerForm" action="registerPro" method="post" role="form" style="display: block;">
							<input type="hidden" name="hiddenId" value="0">
							<input type="hidden" name="hiddenemail" value="0">
							
								<div class="form-group">
									<input type="text" name="userId" id="userId" tabindex="1" class="form-control-sub" placeholder="아이디" value="">
									<input type="button" class="form-control-sub" value="중복확인" style="width:30%; margin-left:20px;" onclick="return clickCinfirm();">
								</div>

								<div class="form-group">
									<input type="password" name="userPassword" id="userPassword" tabindex="1" class="form-control" placeholder="비밀번호">
								</div>
								<div class="form-group">
									<input type="password" name="confirm-password" id="confirm-password" tabindex="1" class="form-control" placeholder="비밀번호 확인">
								</div>
								<div class="form-group">
								</div>
									<input type="text" name="userName" id="userName" tabindex="1" class="form-control" placeholder="이름" value="">
								<div class="form-group">
									<input type="text" name="hp" id="hp" tabindex="1" class="form-control" placeholder="휴대폰번호 -없이 입력" value="">
								</div>
								
								<!-- 주소찾기  API Start-->
								<div class="form-group">
									<input type="text" id="sample6_postcode" name="add1" placeholder="우편번호">
									<input type="button" onclick="sample6_execDaumPostcode()" class="form-control-sub" value="우편번호 찾기" 
										   style="width: 146px; margin-left: 15px; margin-bottom: 15px;"><br>
										   
									<input type="text" id="sample6_address" name="add2" placeholder="주소">
									<input type="text" id="sample6_address2" name="address" placeholder="상세주소">
								</div>
								<!-- 주소찾기  API End-->

								<div class="form-group">
									<input class="input" type="text" name="email1" maxlength="20"
										    style="width: 92px;"> 
									@<input class="input" type="text" name="email2" maxlength="20" 
									 		style="width: 92px;">
									 <input type="button" value="이메일인증" onclick="javascript:email4();">
								<select class="input" name="email" onchange="javascript:emailchk();">
									<option value="0">집적 입력</option>
									<option value="gmail.com">구글</option>
									<option value="daum.net">다음</option>
									<option value="naver.com">네이버</option>
								</select>
								</div>
								<div class="form-group">
									<div class="row">
										<div class="col-sm-6 col-sm-offset-3">
											<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="가입하기">
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
   <!-- 추가 -->
   <!-- 4.푸터 : 홈페이지의 기타 정보를 보여주는 역할을 수행한다.
      홈페이지의 가장 아래쪽에 위치하고 저작권, 개발자, 네비게이션 등을 포함한다.
    -->
    <!-- 4.푸터 -->
    <footer >
	<%@include file="../Footer.jsp" %>
    </footer>
   <!--푸터 끝  --> 
    
 	<!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>>
 <!-- 자바스크립트 공통부분 -->
 
 <!-- 3 js 추가부분 -->
 <script type="text/javascript">
 $(function() {

    $('#login-form-link').click(function(e) {
		$("#login-form").delay(100).fadeIn(100);
 		$("#register-form").fadeOut(100);
		$('#register-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});
	$('#register-form-link').click(function(e) {
		$("#register-form").delay(100).fadeIn(100);
 		$("#login-form").fadeOut(100);
		$('#login-form-link').removeClass('active');
		$(this).addClass('active');
		e.preventDefault();
	});

});
 </script>
 
 <script type="text/javascript">
 function clickCinfirm(){
	// 아이디값 미 입력시
	var target=document.registerForm.userId;
	if (!target.value) {
			alert(msg_id);
			target.focus();
			return false;
		}
	// 중복체크 눌렀을시
		/*
		 * window.open("주소","파일명","별칭[윈도우명]","속성");
		 * 
		 */
	 var url="confirmId?userId=" + target.value;
	 window.open(url, "confirm", "width=400, height=300, left=500, top=400");
 }
 </script>
   
</body>
</html>