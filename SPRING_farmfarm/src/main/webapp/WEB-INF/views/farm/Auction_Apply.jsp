<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->  

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<script src="http://momentjs.com/downloads/moment-with-locales.js"></script>
<script src="http://momentjs.com/downloads/moment-timezone-with-data.js"></script>

  <div class="row">
    <div class="col-md-5 col-md-offset-4" style="margin-bottom:170px; margin-top:150px;">
      <form class="form-horizontal" role="form">
        <fieldset>

          <!-- Form Name -->
          <legend>경매 상품 등록하기</legend>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">상품 이미지</label>
            <div class="col-sm-6">
              <input type="file" name="stock_img" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">상품명</label>
            <div class="col-sm-10">
              <input type="text" placeholder="상품명" name="sInfo_name" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">상품 특징</label>
            <div class="col-sm-10">
              <input type="text" placeholder="상품특징" name="sInfo_detail" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">무게</label>
            <div class="col-sm-4">
              <input type="text" placeholder="무게" name="sInfo_kg" class="form-control">
            </div>

            <label class="col-sm-2 control-label" for="textinput">수량</label>
            <div class="col-sm-4">
              <input type="text" placeholder="개수" name="sInfo_ea" class="form-control">
            </div>
          </div>

          <!-- Text input-->
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">상품 가격</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Country" name="sInfo_price" class="form-control">
            </div>
          </div>
          
          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">등록일</label>
            <div class="col-sm-10">
              <input type="text" placeholder="Country" name="sInfo_regDate" class="form-control">
            </div>
          </div>

<div class="container">
	<div class="row" >
        <form class="form-horizontal col-sm-7 col-sm-offset-2" action="" method="post">
            <div class="form-group registration-date">
                <label class="control-label col-sm-1" for="registration-date">기간 마감</label>
            	<div class="input-group registration-date-time col-sm-4">
            		<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span></span>
            		<input class="form-control" name="registration_date" id="registration-date" type="date">
            		<span class="input-group-addon" id="basic-addon1"><span class="glyphicon glyphicon-time" aria-hidden="true"></span></span>
            		<input class="form-control" name="registration_time" id="registration-time" type="time">
            	</div>
            </div>
        </form>
	</div>
</div>

          <div class="form-group">
            <label class="col-sm-2 control-label" for="textinput">상품 종류</label>
            <div class="col-sm-3">
              <!-- <input type="text" placeholder="Country" name="sInfo_kind" class="form-control"> -->
              <select name="sInfo_kind" class="form-control">
              	<option value="">이벤트</option>
              	<option value="">농산</option>
              	<option value="">축산</option>
              	<option value="">수산</option>
              	<option value="">건강·유기농</option>
              	<option value="">주류</option>
              	<option value="">기타</option>
              </select>
            </div>
          </div>

          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <div class="pull-right">
                <button type="submit" class="btn btn-default">취소</button>
                <button type="submit" class="btn btn-primary">상품 등록</button>
              </div>
            </div>
          </div>

        </fieldset>
      </form>
    </div><!-- /.col-lg-12 -->
</div><!-- /.row -->




	
 <!-- 4.푸터 -->
    <footer >
	<%@include file="../Footer.jsp" %>
    </footer>
   <!--푸터 끝  --> 
    
 	<!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>
</body>
</html>