<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ 부트스트랩 적용 <헤더가 적용되지 않는 페이지이기 때문에 css 분리 적용 가능> ---------->

<script type="text/javascript">
function Gosubmit(){
	opener.name = "LetterList";	//부모창 이름설정
	document.LTwriteform.target=opener.name;	//대상을 부모창으로 설정
	document.LTwriteform.action = "LTWritePro";
	document.LTwriteform.submit();
	self.close();
}
</script>
<!-- 페이지 내 자체 CSS -->
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	P { 
		font-family: 'Nanum Pen Script', cursive; 
		}		
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */
#lettersubmit{
width: 84px; height: 31px; border-top-width: 1px; 
margin-top: -5; padding-top: 5px;
padding-bottom: 5px; border-bottom-width: 0px;
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
background-color: #1CA347;
border-color: #1CA347;
}

#reset{
width: 102px;
height: 31px;
padding-bottom: 5px;
padding-top: 5px;
}

#button{
width: 102px;
height: 31px;
padding-top: 5px;
padding-bottom: 5px;
}
</style>

<title>쪽지쓰기</title>
</head>
<body>
	<h1 align="center"><p>쪽지문의</p></h1>
		<div class="container">
			<div class="col-md-5">
    			<div class="form-area">  
      				<form method="post" name="LTwriteform" action="LTWritePro">
						<input type="hidden" name="boa_id" value="${boa_id}">
        				<br style="clear:both">

    						<div class="form-group">
								<input type="text" class="form-control" id="name" name="mem_id" value="${sessionScope.userId}" readonly="readonly">
							</div>
							
							<div class="form-group">
								<input type="text" class="form-control" id="name" name="letter_id" placeholder="문의하실 농부 ID를 입력하세요">
							</div>
							
							
							<div class="form-group">
								<input type="text" class="form-control" id="email" name="boa_subject" placeholder="제목" required>
							</div>
                    		<div class="form-group">
                    			<textarea class="form-control" type="textarea" name="boa_content" id="message" placeholder="문의내용" maxlength="140" rows="7"></textarea>
                        			<span class="help-block"><h4><p id="characterLeft" class="help-block ">담당 농부님 부재 시 답변은 1~2일 소요되실 수 있습니다.</p></h4></span>                    
                    		</div>
								 <input type="button" id="lettersubmit" class="form-control btn btn-login" value="제출" onclick="javascript:Gosubmit();">
								 <input class="form-control btn btn-login" id="reset" type="reset" value="다시쓰기">
								 <input class="form-control btn btn-login" id="button" type="button" value="쪽지함가기" onclick="self.close();">
	 				</form>
	 		</div>
		</div>
	</div>
</body>
</html>