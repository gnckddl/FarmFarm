
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
<!-- 헤더시작 -->
<header>
   <%@include file="../Header.jsp" %>
</header>
<!-- 헤더끝 --> 

<div class="container">
   <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form class="form-horizontal" action="LetterList" method="post">
          <fieldset>
            <legend class="text-center"><h2><P>요청게시판 글쓰기</P></h2></legend>
    
            <!-- 글번호 input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="name">글번호</label>
              <div class="col-md-9">
                <input id="boa_id" name="boa_id" type="text" placeholder="${dto.boa_id}" class="form-control" disabled="disabled">
              </div>
            </div>
    
            <!-- 작성자 input-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">아이디</label>
              <div class="col-md-9">
                <input id="email" name="email" type="text" placeholder="${dto.letterwritter}" class="form-control" disabled="disabled">
              </div>
            </div>
    
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">요청상품</label>
              <div class="col-md-9">
                <textarea id="email" name="email" type="text" placeholder="${dto.lettersubject}" class="form-control" rows="1" ></textarea>
              </div>
            </div>
    
           <!-- Message body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">요청내용</label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" name="message" placeholder="${dto.lettercontent}" rows="5" ></textarea>
              </div>
            </div>
       
        <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <input type="submit" class="btn btn-primary btn-lg" value="작성"/>
                <input type="reset" class="btn btn-primary btn-lg" value="취소"/>
                <input class="btn btn-primary btn-lg" type="button" value="목록" onclick="window.location='RequestBoard'">
              </div>
            </div>
          </fieldset>
          </form>
        </div>
      </div>
   </div>
</div>

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