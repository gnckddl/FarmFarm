<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="resources/css/bootstrap.css">
<!-- 구글폰트 적용을 위한 LINK LOAD -->
 <link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet">

<!--스크립트 공통부분  -->
  <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
<!--스크립트 공통부분  -->

<style type="text/css">
.check
{
    opacity:0.5;
	color:#996;
}

/* 폰트적용 */
P{
font-family: 'Cabin', sans-serif;
 }
</style>

</head>
<body>
<!-- 헤더시작 -->
	<%@include file="../../Header.jsp" %>
<!-- 헤더끝 --> 

<div class="container">
<h1 align="center"><p>&nbsp;&nbsp;주말농장 신청</p></h1>
<h4>파트너 분들은 저희 팜팜을 통해 소유하신 농장에 대한 주말농장 개설을 하실 수 있습니다.</h4>
<h4>각 테마별로 분류된 농장 개설 예시를 참조하여 제출 버튼을 눌러 주세요(사진클릭)</h4>
<!-- 농장별 분류 -->
<!-- 1.상추 -->
	<div class="row">
		<div class="form-group">	
		<div class="col-md-3"><label class="btn btn-primary" 
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
  		<img src="resources/images/farmer/farmview01.PNG" alt="상추농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
  		<input type="button" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off" onclick="window.location.href='ChooselettuceFarm'"></label>
  		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">채소</p></h4>
  		</div>
		
<!-- 2.야채 -->		
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview02.PNG" alt="유기농 야채농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk2" id="item4" value="val2" class="hidden" autocomplete="off" onclick="window.location.href='Choosevegetable'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">야채</p></h4>
		</div>
<!-- 3.호박 -->	
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview03.PNG" alt="호박농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk3" id="item4" value="val3" class="hidden" autocomplete="off" onclick="window.location.href='Choosepumpkin'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">과일</p></h4>
		</div>
<!-- 4.수박 -->		
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview04.PNG" alt="꽃님이네 수박농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk4" id="item4" value="val4" class="hidden" autocomplete="off" onclick="window.location.href='Choosewatermelon'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">가족농장</p></h4>
		</div>
		</div>
<!-- 5.감귤 -->		
		<div class="form-group">	
		<div class="col-md-3"><label class="btn btn-primary" 
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
  		<img src="resources/images/farmer/farmview05.PNG" alt="청출어람 감귤농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
  		<input type="button" name="chk1" id="item4" value="val1" class="hidden" autocomplete="off" onclick="window.location.href='Choosetangerine'"></label>
  		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">하우스 재배</p></h4>
  		</div>
		
<!-- 6.포도 -->		
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview06.PNG" alt="포도밭사나이의 농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk2" id="item4" value="val2" class="hidden" autocomplete="off" onclick="window.location.href='Choosegrapes'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">약재</p></h4>
		</div>
<!-- 7.인삼 -->		
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview07.PNG" alt="인삼재배농장 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk3" id="item4" value="val3" class="hidden" autocomplete="off" onclick="window.location.href='ChooseGinseng'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">인삼</p></h4>
		</div>

<!-- 8.사과 -->
		<div class="col-md-3"><label class="btn btn-primary"
		style=" height: 130px; width: 190px; padding-right: 10px; padding-left: 10px; padding-top: 10px; padding-bottom: 10px; margin-bottom: 100px;">
		<img src="resources/images/farmer/farmview08.PNG" alt="우리네 사과 가족농원 신청" class="img-thumbnail img-check" style="width: 169px; height: 109px;">
		<input type="button" name="chk4" id="item4" value="val4" class="hidden" autocomplete="off" onclick="window.location.href='ChooseApple'"></label>
		<h4><p style="margin-top: -100;margin-right: 60px;" align="center">곡물</p></h4>
		</div>
		</div>
		
	</div>	
</div>

 <!-- 4.푸터 -->
    <footer >
	<%@include file="../../Footer.jsp" %>
    </footer>
   <!--푸터 끝  --> 
</body>
</html>