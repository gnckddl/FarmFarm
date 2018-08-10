<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%><!-- 필수 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function AuctionProgress(num){
   window.open('AuctionProgress?auc_no='+num, 'auction_popup','top=100px, left=100px, height=600px, width=500px, scrollbars=yes');
}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>펀드 진행내역</title>
</head>
<body>

   <!-- 헤더 -->
   <%@ include file="../Header.jsp"%>

   <!-- 관리자 사이드 바 -->
   <%@ include file="../MemberSideBar.jsp"%>

   <section id="main-content"> <section class="wrapper">
   <h3>
      <i class="fa fa-angle-right"></i> 펀드 진행내역
   </h3>
   <div class="row">
      <!-- 펀드 진행내역 시작 -->
      <div class="col-md-12 mt">
         <!-- 펀드 진행내역 시작 -->
         <div class="content-panel">
            <table class="table table-hover">
               <h4>
                  <i class="fa fa-angle-right"></i> 펀드 진행내역 (${newCnt}건)
               </h4>
               <hr>
               <thead>
                  <tr>
                     <th style="width: 15%">이미지</th>
                     <th style="width: 15%">펀드 이름</th>
                     <th style="width: 7%">펀드 참여 금액</th>
                     <th style="width: 15%">종료일</th>
                     <th style="width: 10%">상태</th>
                  </tr>
               </thead>
               <tbody>
                  <!-- 게시글이 있으면 -->
                  <c:if test="${newCnt>0}">
                     <c:forEach var="dto" items="${newDtos}">
                        <tr>
                           <td><img src="${images}fund/${dto.stock_image}"
                              width="100px" height="60px"></td>
                           <td><a href="FundProductsContent?fund_no=${dto.fund_no}&number=1">${dto.fund_title}</a></td>
                           <td><fmt:formatNumber value="${dto.join_fundPrice}" pattern="#,###,###"/></td>
                           <td><fmt:formatDate value="${dto.fund_endDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                           <td>
                              <button type="button" class="btn btn-round btn-warning">
                                 <i> 진행중</i>
                              </button>
                           </td>
                        </tr>
                     </c:forEach>
                  </c:if>
                  
                  <!-- 게시글이 없으면 -->
                  <c:if test="${cnt==0}">
                     <tr>
                        <td colspan="9" align="center">펀드진행건이 없습니다.!!</td>
                     </tr>
                  </c:if>
               </tbody>
            </table>
         </div>
         <!-- 펀드 진행내역 끝 -->

         <!-- 페이지 컨트롤 시작 -->
         <c:if test="${cnt>0 }">
            <div class="clearfix"></div>
            <ul class="pagination pull-right">
               <c:if test="${startPage > pageBlock}">
                  <li class="disabled"><a
                     href="FundList_ing?${startPage - pageBlock}"> <span
                        class="glyphicon glyphicon-chevron-left"></span></a></li>
               </c:if>

               <c:forEach var="i" begin="${startPage}" end="${endPage}">
                  <c:if test="${i == currentPage}">
                     <li class="active"><a href="FundList_ing?pageNum=${i}">${i}</a></li>
                  </c:if>

                  <c:if test="${i != currentPage}">
                     <li><a href="FundList_ing?pageNum=${i}">${i}</a></li>
                  </c:if>
               </c:forEach>

               <c:if test="${pageCount > endPage}">
                  <li><a href="FundList_ing?pageNum=${startPage + pageBlock}"><span
                        class="glyphicon glyphicon-chevron-right"></span></a></li>
               </c:if>
            </ul>
         </c:if>
         <!-- 페이지 컨트롤 종료 -->
      </div>
      <!-- /col-md-12 -->
      <!-- 펀드 진행내역 끝 -->
   </div>
   </section> </section>


   <!-- 푸터 -->
   <footer> <%@ include file="../Footer.jsp"%>
   </footer>

</body>
</html>