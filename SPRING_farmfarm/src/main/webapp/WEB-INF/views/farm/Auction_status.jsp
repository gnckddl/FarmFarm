<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->  

  <!-- 경매 진행내역 시작 -->
   <div class="content-panel" style="margin-bottom:100px; margin-top:100px;">
      <table class="table table-hover">
         <h4>
            <i class="fa fa-angle-right"></i> 경매 진행내역 (${newCnt}건)
         </h4>
         <hr>
         <thead>
            <tr>
               <th style="width: 15%">상품 이미지</th>
               <th style="width: 15%">경매 제목</th>
               <th style="width: 10%">경매 시작가</th>
               <th style="width: 10%">현재 경매가</th>
               <th style="width: 10%">작성일</th>
               <th style="width: 10%">경매 기간</th>
               <th style="width: 5%">상태</th>
            </tr>
         </thead>
         <tbody>
         <!-- 게시글이 있으면 -->
            <%-- <c:if test="${cnt>0}"> --%> 
            <c:if test="${auc_status != 0}">
         <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
            <c:forEach var="dto" items="${newDtos}">
            <c:if test="${dto.auc_status ==1 || dto.auc_status==2 }">
            <tr>
                  <c:set var="number" value="${number-1}"/>   
                    <td><img src="../farmfarm/resources/images/farmer/${dto.stock_image}" width="100px"></td>
                    <td>${dto.auc_title}</td>
                    <td>${dto.auc_startPrice}</td>
                    
                    <td>${dto.auc_nowPrice}</td>
                   
                    <td> <fmt:formatDate value="${dto.auc_regDate}" pattern="yyyy-MM-dd"/></td>
                    <td> <fmt:formatDate value="${dto.auc_term}" pattern="yyyy-MM-dd"/></td>
                    <td>      
                    
                     <c:if test="${dto.auc_status ==1}">
                        <button type="button" class="btn btn-round btn-warning" onclick="#">
                           <i class="fa fa-cog"> 미등록</i>
                        </button>
                        <button type="button" class="btn btn-theme04" onclick="window.location='aucOk.ad?auc_no=${dto.auc_no}&auc_status=${auc_status}&pageNum=${pageNum}'">
                           <i class="fa fa-times"> 중지함</i>
                        </button>
                   </c:if>
                   
                   <c:if test="${dto.auc_status ==2}">
                        <button type="button" class="btn btn-round btn-warning" onclick="#">
                           <i class="fa fa-cog"> 진행중</i>
                        </button>
                        <button type="button" class="btn btn-theme04" onclick="window.location='aucOk.ad?auc_no=${dto.auc_no}&auc_status=${auc_status}&pageNum=${pageNum}'">
                           <i class="fa fa-times"> 중지함</i>
                        </button>
                   </c:if>
                   
                   
                   </td>
            </tr>
            </c:if>
            </c:forEach>
            </c:if>
        <%--     </c:if> --%>
            <!-- 게시글이 없으면 -->
            <c:if test="${newCnt==0}">
               <tr>
                  <td colspan="6" align="center">
                        경매진행건이 없습니다.!!
                  </td>
               </tr>
            </c:if>
         </tbody>
      </table>
   </div>
   <!-- 경매 진행내역 끝 -->
   
   <!-- 페이지 컨트롤 시작 -->
   <c:if test="${cnt>0 }">
      <div class="clearfix"></div>
      <ul class="pagination pull-right">
      <c:if test="${startPage > pageBlock}">
         <li class="disabled"><a href="AucList_ing.ad?${startPage - pageBlock}">
         <span class="glyphicon glyphicon-chevron-left"></span></a></li>
      </c:if>
               
         <c:forEach var ="i" begin="${startPage}" end="${endPage}">
            <c:if test="${i == currentPage}">
               <li class="active"><a href="AucList_ing.ad?pageNum=${i}">${i}</a></li>
            </c:if>
            
            <c:if test="${i != currentPage}">
               <li><a href="AucList_ing.ad?pageNum=${i}">${i}</a></li>
            </c:if>
         </c:forEach>
         
         <c:if test="${pageCount > endPage}">
         <li><a href="AucList_ing.ad?pageNum=${startPage + pageBlock}"><span
               class="glyphicon glyphicon-chevron-right"></span></a></li>
         </c:if>
      </ul>
   </c:if>
   <!-- 페이지 컨트롤 종료 -->
   
   <!-- 경매 완료내역 시작 -->
   <div class="content-panel" style="margin-bottom:100px; margin-top:100px;">
      <table class="table table-hover">
         <h4>
            <i class="fa fa-angle-right"></i> 경매 완료내역  (${oldCnt}건)
         </h4>
         <hr>
         <thead>
            <tr>
               <th style="width: 15%">상품 이미지</th>
               <th style="width: 15%">경매 제목</th>
               <th style="width: 10%">경매 시작가</th>
               <th style="width: 10%">경매 낙찰가</th>
               <!-- <th style="width: 10%">참여인원</th> -->
               <th style="width: 10%">작성일</th>
               <th style="width: 10%">경매 기간</th>
               <th style="width: 5%">상태</th>
            </tr>
         </thead>
         <tbody>
         <!-- 게시글이 있으면 -->
            <%-- <c:if test="${cnt>0}"> --%> 
            <c:if test="${auc_status != 0}">
         <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
            <c:forEach var="dto" items="${oldDtos}">
            <c:if test="${dto.auc_status ==1 || dto.auc_status==2 }">
            <tr>
                  <c:set var="number" value="${number-1}"/>   
                    <td><img src="../farmfarm/resources/images/farmer/${dto.stock_image}" width="100px"></td>
                    <td>${dto.auc_title}</td>
                    <td>${dto.auc_startPrice}</td>
                    
                    <td>${dto.auc_nowPrice}</td>
                   
                    <td> <fmt:formatDate value="${dto.auc_regDate}" pattern="yyyy-MM-dd"/></td>
                    <td> <fmt:formatDate value="${dto.auc_term}" pattern="yyyy-MM-dd"/></td>
                    <td>      
                    
                     <c:if test="${dto.auc_status ==3}">
                        <button type="button" class="btn btn-round btn-warning" onclick="#">
                           <i class="fa fa-cog"> 유찰</i>
                        </button>
                        <button type="button" class="btn btn-theme04" onclick="window.location='aucOk.ad?auc_no=${dto.auc_no}&auc_status=${auc_status}&pageNum=${pageNum}'">
                           <i class="fa fa-times"> 중지함</i>
                        </button>
                   </c:if>
                   
                   <c:if test="${dto.auc_status ==4}">
                        <button type="button" class="btn btn-round btn-warning" onclick="#">
                           <i class="fa fa-cog"> 낙찰</i>
                        </button>
                        <button type="button" class="btn btn-theme04" onclick="window.location='aucOk.ad?auc_no=${dto.auc_no}&auc_status=${auc_status}&pageNum=${pageNum}'">
                           <i class="fa fa-times"> 중지함</i>
                        </button>
                   </c:if>
                   </td>
	            </tr>
	            </c:if>
            </c:forEach>
            </c:if>
		        	<%--     </c:if> --%>
		            <!-- 게시글이 없으면 -->
		            <c:if test="${oldCnt==0}">
		               <tr>
		                  <td colspan="6" align="center">
		                        경매진행건이 없습니다.!!
                  </td>
               </tr>
            </c:if>
         </tbody>
      </table>
   </div>
   <!-- 경매 진행내역 끝 -->
  

   <!-- 페이지 컨트롤 시작 -->
   <c:if test="${cnt1>0 }">
      <div class="clearfix"></div>
      <ul class="pagination pull-right">
      <c:if test="${startPage1 > pageBlock1}">
         <li class="disabled"><a href="AucList_end.ad?${startPage1 - pageBlock1}">
         <span class="glyphicon glyphicon-chevron-left"></span></a></li>
      </c:if>
               
         <c:forEach var ="i" begin="${startPage1}" end="${endPage1}">
            <c:if test="${i == currentPage1}">
               <li class="active"><a href="AucList_end.ad?pageNum=${i}">${i}</a></li>
            </c:if>
            
            <c:if test="${i != currentPage1}">
               <li><a href="AucList_end.ad?pageNum=${i}">${i}</a></li>
            </c:if>
         </c:forEach>
         
         <c:if test="${pageCount1 > endPage1}">
         <li><a href="AucList_end.ad?pageNum=${startPage1 + pageBlock1}"><span
               class="glyphicon glyphicon-chevron-right"></span></a></li>
         </c:if>
      </ul>
   </c:if>
   <!-- 페이지 컨트롤 종료 -->
   
   

 

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