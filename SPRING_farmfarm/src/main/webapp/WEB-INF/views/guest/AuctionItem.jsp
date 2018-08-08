<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<html>
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<head>
<body>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 --> 
		

<div class="section layout-sm">
    <div class="container">
       <div style="width: 550; height: 332px; background-size: cover; margin-left:35px; margin-bottom: 35px;">
           <a href="#">
                <img src="${images}main/auctionBanner.png" style="width:1075px; height:400px; "> 
           </a>
          </div>
    </div>
</div>
<!--이달의 농부  -->    

<!--인기 경매상품 -->
<div class="section section-bg-white layout-sm" style="padding-top: 0px; padding-bottom: 0px;">
    <div class="container">
        <div class="section-header center">
            <h1 class="center section-title" align="center">경매 상품 목록</h1><br><br>
        </div>
        <div class="row">
    <div>
       <c:forEach var="dto" items="${dtos}">
                <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">
            <div class="card" oncontextmenu="return false" ondragstart="return false" onselectstart="return false" style="overflow: hidden;">
                <div class="card-image">
                    <div class="card-image-bg" onclick="window.location='AuctionItemContent?auc_no=${dto.auc_no}'">
                        <img src="${images}auction/${dto.stock_image}" style="width:100%; height:300px;"><!-- areafix -->
                    </div>
                    <div class="heart-counter" onclick="window.location='AuctionItemContent?auc_no=${dto.auc_no}'">
                       
                    </div>
                    <div class="heart-circle">
                        <i class="fa fa-heart icon-isHeartOn"></i>
                    </div>
                </div>
                <div class="card-content" onclick="window.location='AuctionItemContent?auc_no=${dto.auc_no}'">
                    <div class="card-title grey-text text-darken-4 ellipsis2">
                          ${dto.auc_title}
                    </div>
                </div>
                <div class="card-action">
                    <h5 class="farmer-name activator"><span>${dto.mem_id}</span> 농부의 펀드</h5>
                    <div class="funding-status">
                        <h3 class="left"><strong>${dto.auc_startPrice}원부터</strong></h3>
                    </div>
                </div>
            </div>
        </div>
     </c:forEach>
   </div>
             
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