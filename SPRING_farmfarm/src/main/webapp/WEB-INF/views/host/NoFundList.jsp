<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>미등록 경매내역</title>
</head>
<body>

   <!-- 헤더 -->
   <%@ include file="../Header.jsp" %>
    
    <!-- 관리자 사이드 바 -->
   <%@ include file="../HostSideBar.jsp" %>
    
    <section id="main-content">
          <section class="wrapper">
             <h3><i class="fa fa-angle-right"></i> 미등록 펀드내역</h3>
            <div class="row">
               <!-- 펀드 진행내역 시작 -->
                     <div class="col-md-12 mt">
                        <div class="content-panel">
                             <table class="table table-hover">
                               <h4><i class="fa fa-angle-right"></i> 미등록 펀드내역 (${cnt}건)</h4>
                               <hr>
                                 <thead>
                                 <tr>
                                     <th style="width:5%">번호</th>
                                     <th style="width: 5%">코드</th>
               						 <th style="width: 5%">상태</th>
                                     <th style="width:15%">상품 이미지</th>
                                     <th style="width:15%">펀드 제목</th>
                                     <th style="width:10%">경매 파트너</th>
                                     <th style="width:10%">작성일</th>
                                     <th style="width:10%">펀드 기간</th>
                                     <th style="width:5%"></th>
                                 </tr>
                                 </thead>
                                 <tbody>
                                 <!-- 게시글이 있으면 -->
                           <c:if test="${cnt>0}"> 
                           <c:if test="${d_state != 0}">
                           <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
                              <c:forEach var="dto" items="${dtos}">
         
                                 <tr>
                                     <td>${number}
										<c:set var="number" value="${number-1}"/>	
                                     </td>
                                     <td>${dto.fund_no}</td>
                    				<td>${dto.fund_status}</td>
                                     <td><img src="${images}fund/${dto.stock_image}" width="100px"></td>
                                     <td>${dto.fund_title}</td>
                                     <td>${dto.farm_key}</td>
                                     <td>${dto.fund_regDate}</td>
                                     <td>${dto.fund_endDate}</td>
                                     <td>                     
                                        <button type="button" class="btn btn-theme04" onclick="window.location='fundOk.ad?fund_no=${dto.fund_no}&fund_status=${fund_status}&pageNum=${pageNum}'">
                                        	<i class="fa fa-heart"> 승인</i>
                                        </button>
                             			<button type="button" class="btn btn-default" onclick="window.location='fundDelete.ad?fund_no=${dto.fund_no}&fund_status=${fund_status}&pageNum=${pageNum}'">
                                        	<i class="fa fa-times"></i> 삭제
                           				</button>
                             		</td>
                                 </tr>
                                 </c:forEach>
                                 </c:if>
                                 </c:if>
                                 <!-- 게시글이 없으면 -->
                           <c:if test="${cnt==0}">
                              <tr>
                                 <td colspan="6" align="center">
                                   	 펀드신청이 없습니다.!!
                                 </td>
                              </tr>
                           </c:if>
                                 </tbody>
                             </table>
                          </div> <!--/content-panel -->
                     </div><!-- /col-md-12 -->
                     <!-- 미등록 경매내역 끝 -->
            </div><!-- row -->
            
            <!-- 페이지 컨트롤 시작 -->
   <c:if test="${cnt>0 }">
      <div class="clearfix"></div>
      <ul class="pagination pull-right">
      <c:if test="${startPage > pageBlock}">
         <li class="disabled"><a href="NofundList.ad?${startPage - pageBlock}">
         <span class="glyphicon glyphicon-chevron-left"></span></a></li>
      </c:if>
               
         <c:forEach var ="i" begin="${startPage}" end="${endPage}">
            <c:if test="${i == currentPage}">
               <li class="active"><a href="NofundList.ad?pageNum=${i}">${i}</a></li>
            </c:if>
            
            <c:if test="${i != currentPage}">
               <li><a href="NofundList.ad?pageNum=${i}">${i}</a></li>
            </c:if>
         </c:forEach>
         
         <c:if test="${pageCount > endPage}">
         <li><a href="NofundList.ad?pageNum=${startPage + pageBlock}"><span
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
   <footer>
      <%@ include file="../Footer.jsp" %>
    </footer>
</body>
</html>