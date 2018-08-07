<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>펀드 진행내역</title>
</head>
<body>

   <!-- 헤더 -->
   <%@ include file="../Header.jsp" %>
       
    <!-- 관리자 사이드 바 -->
   <%@ include file="../HostSideBar.jsp" %>
    
    <section id="main-content">
          <section class="wrapper">
             <h3><i class="fa fa-angle-right"></i> 펀드 진행내역</h3>
             <div class="row">
               <!-- 펀드 진행내역 시작 -->
               <div class="col-md-12 mt">
                  <!-- 펀드 완료내역 시작 -->
               <div class="content-panel">
                  <table class="table table-hover">
                     <h4>
                        <i class="fa fa-angle-right"></i> 펀드 완료내역  (${cnt}건)
                     </h4>
                     <hr>
                     <thead>
                        <tr>
                           <th style="width: 5%">번호</th>
                           <th style="width: 5%">코드</th>
                           <th style="width: 5%">상태</th>
                           <th style="width: 15%">상품 이미지</th>
                           <th style="width: 15%">펀드 제목</th>
                           <th style="width: 10%">참여인원</th>
                           <th style="width: 10%">작성일</th>
                           <th style="width: 10%">펀드 기간</th>
                           <th style="width: 5%">상태</th>
                        </tr>
                     </thead>
                     <tbody>
                     <!-- 게시글이 있으면 -->
                        <c:if test="${cnt >0}"> 
                        <c:if test="${fund_status != 0}">
                     <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
                        <c:forEach var="dto" items="${dtos}">
                        <c:if test="${dto.fund_status ==3 || dto.fund_status ==4 }">
                        <tr>
                                 <td>${number1}
                              <c:set var="number1" value="${number1-1}"/>   
                                </td>
                                <td>${dto.fund_no}</td>
                                <td>${dto.fund_status}</td>
                                <td><img src="${images}auction/${dto.stock_image}" width="100px"></td>
                                <td>${dto.fund_title}</td>
                                <td>${dto.fund_join} 명</td>
                                <td>${dto.fund_regDate}</td>
                                <td>${dto.fund_endDate}</td>
                                <td>              
                                   <c:if test="${dto.fund_status ==3}">
                                       <button type="button" class="btn btn-round btn-default">
                                       <i class="fa fa-times"></i> 중단
                                       </button>
                                    </c:if>       
                                    <c:if test="${dto.fund_status ==4}">
                                       <button type="button" class="btn btn-primary" >
                                          <i class="fa fa-check"></i> 완료
                                       </button>
                                   </c:if>
                                 </td>
                        </tr>
                        </c:if>
                        </c:forEach>
                        </c:if>
                        </c:if>
                        <!-- 게시글이 없으면 -->
                        <c:if test="${cnt==0}">
                           <tr>
                              <td colspan="9" align="center">
                                    펀드완료건이 없습니다.!!
                              </td>
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
                     <li class="disabled"><a href="FundList_end.ad?${startPage - pageBlock}">
                     <span class="glyphicon glyphicon-chevron-left"></span></a></li>
                  </c:if>
                           
                     <c:forEach var ="i" begin="${startPage}" end="${endPage}">
                        <c:if test="${i == currentPage}">
                           <li class="active"><a href="FundList_end.ad?pageNum=${i}">${i}</a></li>
                        </c:if>
                        
                        <c:if test="${i != currentPage}">
                           <li><a href="FundList_end.ad?pageNum=${i}">${i}</a></li>
                        </c:if>
                     </c:forEach>
                     
                     <c:if test="${pageCount > endPage}">
                     <li><a href="FundList_end.ad?pageNum=${startPage + pageBlock}"><span
                           class="glyphicon glyphicon-chevron-right"></span></a></li>
                     </c:if>
                  </ul>
               </c:if>
               <!-- 페이지 컨트롤 종료 -->
               </div><!-- /col-md-12 -->
               <!-- 펀드 진행내역 끝 -->
             </div>
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