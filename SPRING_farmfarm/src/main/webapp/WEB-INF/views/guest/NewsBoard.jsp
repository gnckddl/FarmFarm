<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<html>
<!-- <link rel="stylesheet" href="resources/css/assets/bootstrap.css"> -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script   src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<body class="board-body">

   <!-- 헤더시작 -->
   <header>
      <%@include file="../Header.jsp"%>
   </header>
   <!-- 헤더끝 -->

   <!-- 관리자일 경우, 관리자 사이드바 추가 -->
   <c:if test="${sessionScope.grade == 3}">
      <%@ include file="../HostSideBar.jsp"%>
   </c:if>

   <!-- 관리자일 경우, section id="main-content" 적용 -->
   <c:if test="${sessionScope.grade == 3}">
      <section id="main-content">
   </c:if>
   <!-- 관리자가 아닐 경우, div class="wrap" 적용 -->
   <c:if test="${sessionScope.grade != 3}">
      <div class="wrap">
   </c:if>
   
      <!-- 상단영역 -->
      <div class="section section-bg-gray layout-md section-itemview-top">
         <div class="container">
            <!-- 펀드제목 -->
            <div class="row">
               <!-- 타이틀 -->
               <div
                  class="col-xs-12 col-sm-12 section-header-sm section-itemview-top-title">
                  <h1 class="section-title center">팜팜 이야기</h1>
                  <h3 class="section-subtitle center">팜팜의 소식을 전합니다.</h3>
               </div>
            </div>
         </div>
      </div>
      <!-- 상단영역 -->

      <!-- 하단영역 -->
      <div class="section section-bg-white layout-md section-itemview-bottom">
         <div class="container">
            <div id="vertical-timeline" class="vertical-container dark-timeline">
               <div class="vertical-timeline-block">
                  <div class="vertical-timeline-icon navy-bg">
                     <i class="fa fa-briefcase"><img src="resources/images/bag.png"></i>
                  </div>

                  <div class="vertical-timeline-content">
                     <h2>
                        <a href="#">팜팜 이벤트 소식 알림 신청</a>
                     </h2>
                     <span class="vertical-date"> <small>2018-07-06</small>
                     </span>
                  </div>
               </div>
               
               <div class="vertical-timeline-block">
                  <div class="vertical-timeline-icon navy-bg">
                     <i class="fa fa-briefcase"><img src="resources/images/bag.png"></i>
                  </div>

                  <div class="vertical-timeline-content">
                     <h2>
                        <a href="#">팜팜 이벤트 222</a>
                     </h2>
                     <span class="vertical-date"> <small>2018-07-23</small>
                     </span>
                  </div>
               </div>
               
               <div class="vertical-timeline-block">
                  <div class="vertical-timeline-icon navy-bg">
                     <i class="fa fa-briefcase"><img src="resources/images/bag.png"></i>
                  </div>

                  <div class="vertical-timeline-content">
                     <h2>
                        <a href="#">팜팜 이벤트 333</a>
                     </h2>
                     <span class="vertical-date"> <small>2018-07-24</small>
                     </span>
                  </div>
               </div>

                  <div class="row text-center">
                     <!-- 페이지 컨트롤 시작 -->
                     <div class="clearfix"></div>
                     <ul class="pagination">
                        <c:if test="${startPage > pageBlock}">
                           <li class="disabled"><a href="NewsBoard?${startPage - pageBlock}">
                           <span class="glyphicon glyphicon-chevron-left"></span></a></li>
                        </c:if>
                        
                        <c:forEach var ="i" begin="${startPage}" end="${endPage}">
                           <c:if test="${i == currentPage}">
                              <li class="active"><a href="#">${i}</a></li>
                           </c:if>
                           
                           <c:if test="${i != currentPage}">
                              <li><a href="NewsBoard?pageNum=${i}">${i}</a></li>
                           </c:if>
                        </c:forEach>
                        
                        <c:if test="${pageCount > endPage}">
                           <li><a href="NewsBoard?pageNum=${startPage + pageBlock}">
                           <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                        </c:if>
                     </ul>
                  </div>
                  <!-- 페이지 컨트롤 종료 -->
            </div>
         </div>
         <!-- /.container -->
      </div>
      <!-- /.content-wrapper -->

      

   <!-- 관리자일 경우, section id="main-content" 적용 -->
   <c:if test="${sessionScope.grade == 3}">
      </section>
   </c:if>
   <!-- 관리자가 아닐 경우, div class="wrap" 적용 -->
   <c:if test="${sessionScope.grade != 3}">
      </div>
   </c:if>

      <c:if test="${sessionScope.grade == 3}">
         <!-- 관리자일 경우, 관리자 푸터 적용 -->
         <footer>
            <%@ include file="../HostFooter.jsp" %>
         </footer>
      </c:if>
      
      <!-- 4.푸터 -->
      <footer>
         <%@include file="../Footer.jsp"%>
      </footer>
      <!--푸터 끝  -->

      <!-- 관리자가 아닐 경우, 스크립트 공통부분 적용 -->
      <c:if test="${sessionScope.grade != 3}">
         <!--스크립트 공통부분  -->
         <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
         <script src="resources/js/bootstrap.js"></script>
      </c:if>
</body>
</html>