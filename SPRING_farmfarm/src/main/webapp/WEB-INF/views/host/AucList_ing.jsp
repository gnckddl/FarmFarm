<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
   <!-- 경매 진행내역 시작 -->
   <div class="content-panel">
      <table class="table table-hover">
         <h4>
            <i class="fa fa-angle-right"></i> 경매 진행내역 (${cnt}건)
         </h4>
         <hr>
         <thead>
            <tr>
               <th style="width: 1%"><input type="checkbox" id="checkall"></th>
               <th style="width: 5%">번호</th>
               <th style="width: 5%">코드</th>
               <th style="width: 5%">상태</th>
               <th style="width: 15%">상품 이미지</th>
               <th style="width: 15%">경매 제목</th>
               <th style="width: 10%">경매 시작가</th>
               <th style="width: 10%">현재 경매가</th>
               <th style="width: 10%">참여인원</th>
               <th style="width: 10%">경매 등록일</th>
               <th style="width: 10%">경매 종료일</th>
               <th style="width: 5%">상태</th>
            </tr>
         </thead>
         <tbody>
         <!-- 게시글이 있으면 -->
            <c:if test="${cnt>0}"> 
            <c:if test="${dto.auc_status != 0}">
         <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
            <c:forEach var="dto" items="${dtos}">
            <c:if test="${dto.auc_status ==2}">
            <tr>
           		<td><input type="checkbox" class="checkthis"></td>
              		<td>${number}
					<c:set var="number" value="${number-1}"/>	
                   </td>
                   <td>${dto.auc_no}</td>
                   <td>${dto.auc_status}</td>
                   <td><img src="${hostImage}/${dto.stock_image}" width="100px"></td>
                   <td>${dto.auc_title}</td>
                   <td>${dto.auc_startPrice}</td>
                   <td>${dto.auc_nowPrice}</td>
                   <td>${dto.auc_join} 명</td>
                   <td>${dto.auc_regDate}</td>
                   <td>${dto.auc_endDate}</td>
                   <td>      
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
            </c:if>
            <!-- 게시글이 없으면 -->
            <c:if test="${cnt==0}">
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

</body>
</html>