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
          <fieldset>
            <legend class="text-center"><h2><P>쪽지열람</P></h2></legend>
    
            <!--input Form-->
            <div class="form-group">
              <label class="col-md-3 control-label" for="email">작성자</label>
              <div class="col-md-9">
                <input id="email" name="email" type="text" placeholder="${dto.mem_id}" class="form-control" disabled="disabled">
              </div>
            </div>
    
	      <div class="form-group">
	              <label class="col-md-3 control-label" for="email">수신자</label>
	              <div class="col-md-9">
	                <input id="email" name="email" type="text" placeholder="${dto.letter_id}" class="form-control" disabled="disabled">
	              </div>
	            </div>
    
    		 <div class="form-group">
              <label class="col-md-3 control-label" for="email">작성일</label>
              <div class="col-md-9">
                <fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${dto.boa_regDate}"/>
              </div>
            </div>
    
      		<div class="form-group">
              <label class="col-md-3 control-label" for="email">글제목</label>
              <div class="col-md-9">
                <input id="email" name="email" type="text" placeholder="${dto.boa_subject}" class="form-control" disabled="disabled">
              </div>
            </div>
    
    
            <!-- Message body -->
            <div class="form-group">
              <label class="col-md-3 control-label" for="message">상세 문의 내용</label>
              <div class="col-md-9">
                <textarea class="form-control" id="message" name="message" placeholder="${dto.boa_content}" rows="5" readonly="readonly"></textarea>
              </div>
            </div>
    
            <!-- Form actions -->
            <!-- 1. 작성한 쪽지 확인 창 -->
            <div class="form-group">
              <div class="col-md-12 text-right">
              <tr>
              <td>
                <button class="btn btn-primary btn-lg" onclick="self.close();">확인</button>
             </td>
              </tr>
              </div>
            </div>
          </fieldset>
        </div>
      </div>
	</div>
</div>
</body>
</html>