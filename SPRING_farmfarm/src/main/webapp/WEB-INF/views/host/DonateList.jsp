<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기부 내역</title>
</head>
<body>

   <!-- 헤더 -->
   <%@ include file="../Header.jsp"%>

   <!-- 관리자 사이드 바 -->
   <%@ include file="../HostSideBar.jsp"%>

   <section id="main-content">
      <section class="wrapper">
      <h3>
         <i class="fa fa-angle-right"></i> 기부 내역
      </h3>
      <div class="row">
         <!-- 기부 현황 시작 -->
         <div class="col-md-12 mt">
            <div class="content-panel">
               <table class="table table-hover">
                  <h4>
                     <i class="fa fa-angle-right"></i> 기부 내역 (3건)
                  </h4>
                  <hr>
                  <thead>
                     <tr>
                        <th style="width: 5%">번호</th>
                        <th style="width: 15%">기부 상품</th>
                        <th style="width: 10%">기부 업체</th>
                        <th style="width: 30%">기부 제목</th>
                        <th style="width: 10%">기부 액수</th>
                        <th style="width: 10%">이름</th>
                        <th style="width: 10%">기부일</th>
                     </tr>
                  </thead>
                  <tbody>
                     <!-- 회원 목록이 있으면  -->
                     <c:if test="${cnt>0}">
                        <c:forEach var="dto" items="${dtos}">
                           <tr>
                              <td>${number}<c:set var="number" value="${number-1}" /></td>
                              <td><img src="${hostImage}/watermelon.jpg" width="100px"></td>
                              <td><img src="${hostImage}/${dto.doOrg_image}" width="100px"></td>
                              <td>${dto.dona_title}</td>
                              <td>${dto.dona_price}</td>
                              <td>${dto.mem_id}</td>
                              <td>${dto.dona_date}</td>
                           </tr>
                        </c:forEach>
                     </c:if>
                  </tbody>
               </table>
            </div>
            <!--/content-panel -->
         </div>
         <!-- /col-md-12 -->
         <!-- 기부 현황 끝 -->
      </div>
      <!-- row -->

      <!-- 페이지 컨트롤 시작 -->
      <c:if test="${cnt>0 }">
         <div class="clearfix"></div>
         <ul class="pagination pull-right">
         <c:if test="${startPage > pageBlock}">
            <li class="disabled"><a href="DonateList.ad?${startPage - pageBlock}">
            <span class="glyphicon glyphicon-chevron-left"></span></a></li>
         </c:if>
                  
            <c:forEach var ="i" begin="${startPage}" end="${endPage}">
               <c:if test="${i == currentPage}">
                  <li class="active"><a href="DonateList.ad?pageNum=${i}">${i}</a></li>
               </c:if>
               
               <c:if test="${i != currentPage}">
                  <li><a href="DonateList.ad?pageNum=${i}">${i}</a></li>
               </c:if>
            </c:forEach>
            
            <c:if test="${pageCount > endPage}">
            <li><a href="DonateList.ad?pageNum=${startPage + pageBlock}"><span
                  class="glyphicon glyphicon-chevron-right"></span></a></li>
            </c:if>
         </ul>
      </c:if>
      <!-- 페이지 컨트롤 종료 -->

      </section>
   </section>

   <!-- 관리자 푸터 -->
   <footer> <%@ include file="../HostFooter.jsp"%>
   </footer>

   <!-- 푸터 -->
   <footer> <%@ include file="../Footer.jsp"%>
   </footer>

</body>
</html>