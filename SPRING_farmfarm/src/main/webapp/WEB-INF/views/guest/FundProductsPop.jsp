
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
          <form class="form-horizontal" action="FundJoinPro?stock_price=${stock_price}&fund_no=${fund_no}&doFrom_id=${donateDto.doForm_id}" method="post">
          
          <fieldset>
            <legend class="text-center"><h2><P>펀드상품참여</P></h2></legend>
          
            <!-- 글번호 input-->
            <div class="form-group">
              <div class="col-md-9">
              
              </div>
            </div>
    
            <!-- 작성자 input-->
        <legend style="font-size: 15px">
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">펀드명</label>
              <div class="col-md-9">
                <input class="form-control" type="text" name="fund_title" id="fund_title" disabled="disabled" value="${fund_title}" style="font-size:20px; margin-left: 20%; width: 65%">
                <!-- submit hidden값 -->
                <input type="hidden" name="fund_no" value="${dto.fund_no}">
              </div>
            </div>
            <div class="form-group" >
              <label class="col-md-3 control-label" for="fund_price">펀드금액 *</label>
              <div class="col-md-9">
                 <input class="form-control" type="text" name="fund_Price" id="fund_Price" disabled="disabled" style="font-size:20px; margin-left: 20%; width: 65%" value="${stock_price}">
              </div>
            </div>
          </legend>
          
          <legend style="font-size: 15px">
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">기부 단체명</label>
              <div class="col-md-9">
                <select name="doOrg_id" class="form-control" style="font-size:15px; margin-left: 20%; width: 65%">
                   <option value="" selected>기부안함</option>
                   <c:forEach var="donateDto" items="${donateDtos}">
                      <option value="${donateDto.doForm_id}">${donateDto.doOrg_name}</option>
                       
                   </c:forEach>
                </select>
              </div>
            </div>
            <div class="form-group" >
              <label class="col-md-3 control-label" for="nowPrice">기부 금액</label>
              <div class="col-md-9">
                 <input class="form-control" type="number" name="dona_price" id="dona_price" step="100"  style="font-size:20px; margin-left: 20%; width: 65%" >
              </div>
            </div>
          </legend>
          
        <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <input type="submit" class="btn btn-primary btn-lg" value="참여하기"/>
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