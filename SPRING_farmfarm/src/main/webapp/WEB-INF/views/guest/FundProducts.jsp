<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<html>
<script type="text/javascript">
   function goCategory(num){
      if(num==0){
         window.location="FundProducts";
         
      }
      else
         window.location="FundProducts?stock_kind="+num;
   }

</script>
<style>
.section-title {
    padding: 0px;
    font-weight: 700;
    font-size: 24px;
    color: #555;
    letter-spacing: 0px;
    margin: 0;
    line-height: 150%;
}

.col-sm-8 {
  width: 66.66666667%;
}

.col-sm-1, .col-sm-2, .col-sm-3, .col-sm-4, .col-sm-5, .col-sm-6, .col-sm-7, .col-sm-8, .col-sm-9, .col-sm-10, .col-sm-11, .col-sm-12 {
  float: left;
}

.col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
  position: relative;
  min-height: 1px;
  padding-right: 15px;
  padding-left: 15px;
}

.item-filter .item-btn-left {
    text-align: left !important;
    height: 38px;
    background-color: #E0E1E2;
    padding: 0;
    margin-bottom: 20px;
    margin-right: 10px;
}

.btn {
    box-shadow: none !important;
}

.item-filter .icon-side {
    height: 38px;
    width: 38px;
    background-color: #D7D7D8;
    color: #646465;
    text-align: center;
    line-height: 38px;
    float: left;
    border-radius: 3px 0 0 3px;
    font-size: 15px;
}

.item-filter .text-side {
    height: 38px;
    width: 80px;
    text-align: center;
    color: #777;
    font-size: 13px;
    padding-right: 5px;
    line-height: 38px;
    border-radius: 0 0 3px 3px;
    font-weight: 600;
    float: left;
    letter-spacing: 0px;
}

.item-filter .text-side-short {
    width: 70px;
}

.dropdown_toggle{
color: #999 !important;

padding:0px;
}





</style>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<body>
<!-- 헤더시작 -->
   <%@include file="../Header.jsp" %>
<!-- 헤더끝 -->  
   <!--본문내용 시작 -->
   <div class="section section-bg-gray layout-md">
    <div class="container" >

        <!-- 기본헤더 -->
        <div class="row">
            <!-- 타이틀 -->
            <div class="col-xs-12 col-sm-12 section-header-sm">
                                <h1 class="section-title center">
                    펀드상품 전체보기
                    <!-- 카테고리만 선택할 경우 : 채소-농산물 펀드보기 -->
                    <!-- 지역만 선택할 경우 : 서울/경기 펀드보기 -->
                    <!-- 카테고리와 지역 함께 선택할 경우 : 서울/경기 채소-농산물 펀드보기 -->
                </h1>
                                <h3 class="section-subtitle center"></h3>
            </div>
        </div>
        <!-- 기본헤더 -->

        <!-- 서브헤더 -->
         <!-- 카테고리별 -->
        <div class="row item-filter hidden-xs">
            <div class="col-sm-8" style="padding-bottom: 20px;" >
                <!-- 아래쪽으로 리스트가 추가되어 나온다 --><a href="#" class="dropdown-toggle"
                  data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false"><b style="font-size: 15px; color: #777;">전체</b><span class="caret"></span></a><!-- caret : 아래 화살표 클릭시 아이콘이 나오게 함 -->
                 <ul class="dropdown-menu">
                     <li><a onclick="goCategory(0);">전체</a></li>
                       <li><a onclick="goCategory(1);">이벤트</a></li>
                     <li><a onclick="goCategory(2);" >농산물</a></li>
                     <li><a onclick="goCategory(3);">축산물</a></li>
                     <li><a onclick="goCategory(4);">수산물</a></li>
                     <li><a onclick="goCategory(5);">건강유기농</a></li>
                     <li><a onclick="goCategory(6);">버섯류</a></li>
                     <li><a onclick="goCategory(7);">주류</a></li>
                     <li><a onclick="goCategory(8);">기타</a></li>
                  </ul> 
               
            </div>
        </div>
         <!-- 카테고리별 -->
      <!-- 서브헤더 -->
   <c:if test="${cnt > 0}">
   <c:forEach var="dto" items="${dtos}">
       <div class="card" oncontextmenu="return false" ondragstart="return false" onselectstart="return false" style="width: 503px; height:600px; float: left; margin-left: 20px;">
                        <div class="card-image">
                            <div class="card-image-bg">
                                <img src="${images}fund/${dto.stock_image}" style="width:501px; height:400px"><!-- areafix -->
                            </div>
                            <div class="heart-counter" onclick="location.href='FundProductsContent?fund_no=${dto.fund_no}&pageNum=${pageNum}&number=${number}'">
                              
                            </div>
                            <div class="heart-circle">
                                <i class="fa fa-heart icon-isHeartOn"></i>
                            </div>
                        </div>
                        <div class="card-content" onclick="location.href='FundProductsContent?fund_no=${dto.fund_no}&pageNum=${pageNum}&number=${number}'">
                            <div class="card-title grey-text text-darken-4 ellipsis2">
                                   <b style="color: #777;">${dto.fund_title}</b>
                            </div>
                               <div class="card-action">
                           <h5 class="farmer-name activator"><span><b style="color: #777;">${dto.mem_id} 농부의펀드</b></span></h5>
                               <div class="funding-graph">
                                   <div class="graph-bar" style="width:100%;"></div>
                               </div>
                              <div class="funding-status">
                                  <h5 class="left"><strong><fmt:formatNumber value="${dto.fund_join*dto.stock_price}" pattern="#,###,###"/>원</strong><br>모임 <small style="color: #1ab394; font-weight: bold;">${ ((dto.fund_join*dto.stock_price) / dto.fund_price)*100}%</small></h5>
                                  <h5 class="left"><strong>${dto.fund_join}명</strong><br>참여</h5>
                             </div>
                        </div>
                        </div>
               </div>
      </c:forEach>
     </c:if> 
  </div>
  </div>   
             <!-- 페이지 컨트롤 시작 -->
                  <div class="clearfix" align="center" style="display: block;">
                  <ul class="pagination">
                     <c:if test="${startPage > pageBlock}">
                        <li><a href="FundProducts?${startPage - pageBlock}&boa_category=${boa_category}">
                        <span class="glyphicon glyphicon-chevron-left"></span></a></li>
                     </c:if>
                     
                     <c:forEach var ="i" begin="${startPage}" end="${endPage}">
                        <c:if test="${i == currentPage}">
                           <li class="active"><a href="FundProducts?pageNum=${i}&boa_category=${boa_category}">${i}</a></li>
                        </c:if>
                        
                        <c:if test="${i != currentPage}">
                           <li><a href="FundProducts?pageNum=${i}&boa_category=${boa_category}">${i}</a></li>
                        </c:if>
                     </c:forEach>
                     
                     <c:if test="${pageCount > endPage}">
                        <li><a href="FundProducts?pageNum=${startPage + pageBlock}&boa_category=${boa_category}">
                        <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                     </c:if>
                  </ul>
                  </div>
                  <!-- 페이지 컨트롤 종료 -->

   
   <!--본문내용 끝  -->
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