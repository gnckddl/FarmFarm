
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- 페이지 내 자체 CSS -->
<html>
<head>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
   P { 
      font-family: 'Nanum Pen Script', cursive; 
      }
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */

body {padding-top:20px;}

</style>
</head>
<body>

<div class="container">
   <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form class="form-horizontal" action="AuctionJoinPro" method="post">
          <fieldset>
            <legend class="text-center"><h2><P>경매 입찰</P></h2></legend>
          
            <!-- 글번호 input-->
            <div class="form-group">
              <div class="col-md-9">
              
              </div>
            </div>
    
            <!-- 작성자 input-->
        <legend style="font-size: 15px">
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">상품명</label>
              <div class="col-md-9">
                <input class="form-control" type="text" name="nowPrice" id="nowPrice" disabled="disabled" value="${dto.stock_name}" style="font-size:20px; margin-left: 20%; width: 65%">
                <!-- submit hidden값 -->
                <input type="hidden" name="auc_no" value="${dto.auc_no}">
              </div>
            </div>
            <div class="form-group" >
              <label class="col-md-3 control-label" for="nowPrice">입찰 금액 *</label>
              <div class="col-md-9">
              	<input class="form-control" type="number" name="nowPrice" id="nowPrice" step="1000" min="0" style="font-size:20px; margin-left: 20%; width: 65%">
              </div>
            </div>
       	</legend>
       	
       	
        <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <input type="submit" class="btn btn-primary btn-lg" value="입찰"/>
                <input class="btn btn-primary btn-lg" type="button" value="닫기" onclick="self.close();">
              </div>
            </div>
          </fieldset>
          </form>
        </div>
      </div>
   </div>
</div>

</body>
</html>