<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>


<html>
<meta name="viewport" content="width=device-width" , initial-scale="1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<script type="text/javascript">
function mainMove(num){
    window.location='FundProductsContent?fund_no='+num+'&number=1';
   
}

</script>
<!-- 외부스타일 시트 적용 -->
   
<!--스크립트 공통부분  -->
  <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
<body>

<!-- 헤더시작 -->
<header>
   <%@include file="../Header.jsp" %>
</header>
<!-- 헤더끝 --> 
 <!--슬라이드메뉴 시작  -->

   <h2></h2>
   <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
     <ol class="carousel-indicators">
       <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
       <li data-target="#myCarousel" data-slide-to="1" class=""></li>
       <li data-target="#myCarousel" data-slide-to="2" class=""></li>
     </ol>
     <div class="carousel-inner" role="listbox" >
       <div class="item active">
         <img src="resources/images/farm01.PNG" style="margin:0 auto;">
       </div>
       <div class="item">
         <img src="resources/images/farm02.PNG" style="margin:0 auto;">
       </div>
       <div class="item">
         <img src="resources/images/farm03.PNG" style="margin:0 auto;">
       </div>
     </div>
    
   </div>

   <hr>
   

 
  <!--슬라이드 끝  -->
  <!--인기 펀드 상품 시작  --> 
<div class="section section-bg-gray layout-sm">
    <div class="container">
        <div class="section-header center">
            <h1 class="center section-title" align="center">인기 펀드상품</h1><br><br>
        </div>
        <div class="row">
              <div>
                 <c:forEach var="dto" items="${dtos1}">
                      <div class="col-xs-12 col-sm-6 col-md-3 col-lg-3" style="height:55%;">
                        <div class="card" oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
                            <div class="card-image">
                                <div class="card-image-bg" >
                                    <img src="${images}fund/${dto.stock_image}" style="width:100%; height:250px;"><!-- areafix -->
                                </div>
                                <div class="heart-circle">
                                    <i class="fa fa-heart icon-isHeartOn"></i>
                                </div>
                            </div>
                            <div class="card-content" onclick="mainMove('${dto.fund_no}');">
                                <div class="card-title grey-text text-darken-4 ellipsis2">
                                   ${dto.fund_title}
                                </div>
                            </div>
                                <div class="card-action">
                                    <h5 class="farmer-name activator"><span>${dto.mem_id}</span> 농부의 펀드</h5>
                                    <div class="funding-graph">
                                           <c:set var="percent" value="${((dto.fund_join*dto.stock_price) / dto.fund_price)*100}"/>
                                          <c:if test="${percent>=100}"> 
                                             <c:set var="percent" value="100"/>
                                           </c:if> 
                                        <div class="graph-bar" style="width:${percent}%;"></div>
                                           
                                    </div>
                                    <div class="funding-status">
                                        <h5 class="left"><strong>${dto.fund_join*dto.stock_price}원</strong><br>모임 <small style="color: #1ab394; font-weight: bold;"> <fmt:formatNumber value="${ ((dto.fund_join*dto.stock_price) / dto.fund_price)*100}" pattern=".0"/>%</small></h5>
                                        <h5 class="left"><strong>${dto.fund_join}명</strong><br>참여</h5>
                                        <h5 class="left" style="margin-right:0;"><strong></strong><br></h5>
                                     </div>
                                </div>
                         
                        </div>
                    </div>
                 </c:forEach>
               </div>
            </div>
       </div>
</div>
 <!--인기 펀드 상품 시작  --> 
<!--이달의 농부  -->
<div class="section layout-sm">
    <div class="container">
       <div style="width: 550; height: 332px; background-size: cover; margin-left:35px; margin-bottom: 35px;">
           <a href="Donate">
                <img src="${images}host/dona.jpg" style="width:1075px; height:400px; "> 
           </a>
          </div>
    </div>
</div>
<!--이달의 농부  -->    

<!--인기 경매상품 -->
<div class="section section-bg-white layout-sm" style="padding-top: 0px; padding-bottom: 0px;">
    <div class="container">
        <div class="section-header center">
            <h1 class="center section-title" align="center">인기 경매상품</h1><br><br>
        </div>
        <div class="row">
    <div>
       <c:forEach var="dto" items="${dtos3}">
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
<!--인기 경매상품  -->

<!--신규펀드  -->
<div class="section section-bg-white layout-sm" style="padding-top: 0px;">
    <div class="container" >
        <div class="section-header center">
            <h1 class="center section-title">최신 펀드상품</h1><br><br>
        </div>
        <div class="row">
        <div>
        <c:forEach var="dto" items="${dtos2}">
        
                  <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" style="height:60%;">
                  <div class="card" oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
                      <div class="card-image">
                          <div class="card-image-bg"  onclick="mainMove('${dto.fund_no}');">
                              <img src="${images}fund/${dto.stock_image}" style="width:100%; height:300px;"><!-- areafix -->
                          </div>
                          
                          <div class="heart-circle">
                              <i class="fa fa-heart icon-isHeartOn"></i>
                          </div>
                      </div>
                      <div class="card-content" onclick="mainMove('${dto.fund_no}');">
                          <div class="card-title grey-text text-darken-4 ellipsis2">
                              ${dto.fund_title}
                          </div>
                      </div>
                       <div class="card-action">
                          <h5 class="farmer-name activator"><span>${dto.mem_id}</span> 농부의 펀드</h5>
                          <div class="funding-graph">
                              <c:set var="percent" value="${((dto.fund_join*dto.stock_price) / dto.fund_price)*100}"/>
                                 <c:if test="${percent>=100}"> 
                                    <c:set var="percent" value="100"/>
                                  </c:if> 
                               <div class="graph-bar" style="width:${percent}%;"></div>
                          </div>
                          <div class="funding-status">
                              <h5 class="left"><strong>${dto.fund_join*dto.stock_price}원</strong><br>모임 <small style="color: #1ab394; font-weight: bold;">${ ((dto.fund_join*dto.stock_price) / dto.fund_price)*100}%</small></h5>
                              <h5 class="left"><strong>${dto.fund_join}명</strong><br>참여</h5>
                             <h5 class="left" style="margin-right:0;"><strong></strong><br></h5>
                        </div>
                      </div>
                  </div>
              </div>
              </c:forEach>
              </div>
    </div>
</div>
</div>

<div class="row center btn-see-more">
    <button type="button" class="btn btn-primary btn-45" onclick="window.location='FundProducts'">더 많은 펀드상품 보기</button>
</div>
<!--이주의 신규펀드  -->

 <!-- 4.푸터 -->
    <footer >
   <%@include file="../Footer.jsp" %>
    </footer>
   <!--푸터 끝  --> 
    
</body>
</html>