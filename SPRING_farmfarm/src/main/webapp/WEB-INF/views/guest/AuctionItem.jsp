<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 --> 
		

<div class="wrap">

<div class="section layout-sm no-padding">
    <div class="container text-center no-padding">
        <img src="${images}main/auctionBanner.png" alt="농펀상회 메인 베너" class="img-responsive">
    </div>
</div>
<div class="section layout-sm" style="padding-top: 0px;">
    <div class="container">
    	<c:forEach var="dto" items="${dtos}">
			<div class="col-xs-6 no-padding">
            	<a href="AuctionItemContent?auc_no=${dto.auc_no}"><img style="width: 450px; height: 300px; position:relative;" src="${images}main/${dto.stock_image}" alt="${dto.auc_title}" class="img-responsive"></a>
             			<h2 style=" color: #777">${dto.auc_title}</h2>
             			<h3 style=" color: #777">${dto.auc_startPrice} 부터~</h3>
			</div>               
        </c:forEach>
     </div>
</div>
</div>



<!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>
 <!-- 4.푸터 -->
 
    <footer>
	<%@include file="../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 
</body>
</html>