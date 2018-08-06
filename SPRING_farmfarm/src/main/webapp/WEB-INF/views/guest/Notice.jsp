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
               <div class="col-xs-12 col-sm-12 section-header-sm section-itemview-top-title">
                  <h1 class="section-title center">[공지사항]</h1>
                  <h3 class="section-subtitle center">팜팜이 알려드립니다.</h3>
               </div>
            </div>
         </div>
      </div>
      <!-- 상단영역 -->

      <!-- 하단영역 -->
      <div class="section section-bg-white layout-md section-itemview-bottom">
         <div class="container">
            <div id="vertical-timeline" class="vertical-container dark-timeline">
               
               <!-- 공지사항 시작 -->
               <c:forEach var="dto" items="${dtos}">
                  <div class="vertical-timeline-block">
                     <div class="vertical-timeline-icon navy-bg">
                        <i class="fa fa-bullhorn"></i>
                     </div>
                     <div class="vertical-timeline-content">
                        <!-- 공지사항 제목 시작 -->
                        <h2>
                           <a href="NoticeContent?boa_id=${dto.boa_id}&pageNum=${pageNum}">${dto.boa_subject}</a>
                        </h2>
                        <!-- 공지사항 제목 끝 -->
                        <!-- 공지사항 작성 날짜 시작 -->
                        <span class="vertical-date">
                           <small>${dto.boa_regDate2}</small>
                        </span>
                        
                        <!-- 관리자일 경우만 수정, 삭제 버튼 나오게 한다. -->
                        <c:if test="${sessionScope.grade == 3}">
                        <div class="pagination pull-right">
                           <!-- 공지사항 수정 버튼 -->
                           <a href="NoticeContent?boa_id=${dto.boa_id}&pageNum=${pageNum}">
                           <button class="btn btn-warning btn-xs">
                              <i class="fa fa-pencil"></i>
                           </button>
                           </a>
                           <!-- 공지사항 수정 버튼 -->

                     <script type="text/javascript">
                        function noticeDeleteCheck(boa_id, pageNum){
                           var boa_id = boa_id;
                           var pageNum = pageNum;
                           
                           var noticeDeleteCheck = confirm("정말 삭제하시겠습니까?");
                           
                           if(noticeDeleteCheck){
                              location.href="NoticeDelete?boa_id="+boa_id+"&pageNum="+pageNum;
                           } else{
                              return false;
                           }
                        }
                     </script>
                           
                           <!-- 공지사항 삭제 버튼 -->
                           <button class="btn btn-danger btn-xs" onclick="noticeDeleteCheck(${dto.boa_id}, ${pageNum});">
                              <i class="fa fa-trash-o "></i>
                           </button>
                           <!-- 공지사항 삭제 버튼 -->
                        </div>
                        <!-- 공지사항 작성 날짜 끝 -->
                        </c:if>
                     </div>
                  </div>
               </c:forEach>
               <!-- 공지사항 종료 -->
               
               <div class="row text-center">
                  <!-- 페이지 컨트롤 시작 -->
                  <div class="clearfix"></div>
                  <ul class="pagination">
                     <c:if test="${startPage > pageBlock}">
                        <li class="disabled"><a href="Notice?${startPage - pageBlock}">
                        <span class="glyphicon glyphicon-chevron-left"></span></a></li>
                     </c:if>
                     
                     <c:forEach var ="i" begin="${startPage}" end="${endPage}">
                        <c:if test="${i == currentPage}">
                           <li class="active"><a href="Notice?pageNum=${i}">${i}</a></li>
                        </c:if>
                        
                        <c:if test="${i != currentPage}">
                           <li><a href="Notice?pageNum=${i}">${i}</a></li>
                        </c:if>
                     </c:forEach>
                     
                     <c:if test="${pageCount > endPage}">
                        <li><a href="Notice?pageNum=${startPage + pageBlock}">
                        <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                     </c:if>
                  </ul>
                  <!-- 페이지 컨트롤 종료 -->
               </div>
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