<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
   <!-- 주말농장 요청현황 -->
   <div class="content-panel">
      <table class="table table-hover">
         <h4>
            <i class="fa fa-angle-right"></i> 주말농장 요청현황 (${cnt}건)
         </h4>
         <hr>
         <thead>
            <tr>
               <th style="width: 1%"><input type="checkbox" id="checkall" /></th>
               <th style="width: 5%">번호</th>
               <th style="width: 10%">아이디</th>
               <th style="width: 10%">주말농장 이름</th>
               <th style="width: 10%">신청일</th>
               <th style="width: 10%">평당 가격</th>
               <th style="width: 5%">관리</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="dto" items="${dtos}">
            <tr>
               <td><input type="checkbox" class="checkthis"></td>
               <td>${number}<c:set var="number" value="${number-1}" /></td>
               <td>${dto.mem_id}</td>
               <td>${dto.wfarmInfo_title}</td>
               <td>${dto.wfarmInfo_regDate}</td>
               <td>${dto.wfarmInfo_price}</td>
               <td>
                  <button class="btn btn-theme04 " onclick="return weekFarmReqPermit('${dto.wfarm_key}', '${dto.wfarmInfo_title}', '${pageNum}', '${pageNum1}')">
                     <i class="fa fa-heart">승인</i>
                  </button>
                  <button class="btn btn-default " onclick="return weekFarmDelete('${dto.wfarm_key}', '${dto.wfarmInfo_title}', '${pageNum}', '${pageNum1}')">
                     <i class="fa fa-trash-o ">삭제</i>
                  </button>
               </td>
            </tr>
            </c:forEach>
            <!-- <tr>
               <td colspan="6"></td>
               <td>
                  <button class="btn btn-theme04 ">
                     <i class="fa fa-heart">전체 승인</i>
                  </button>
                  <button class="btn btn-default ">
                     <i class="fa fa-times ">전체 삭제</i>
                  </button>
               </td>
            </tr> -->
         </tbody>
      </table>
   </div>
   <!-- 주말농장 요청현황 끝 -->

   <!-- 페이지 컨트롤 시작 -->
   <c:if test="${cnt>0 }">
      <div class="clearfix"></div>
      <ul class="pagination pull-right">
      <c:if test="${startPage > pageBlock}">
         <li class="disabled"><a href="WeekFarmManage.ad?${startPage - pageBlock}">
         <span class="glyphicon glyphicon-chevron-left"></span></a></li>
      </c:if>
               
         <c:forEach var ="i" begin="${startPage}" end="${endPage}">
            <c:if test="${i == currentPage}">
               <li class="active"><a href="WeekFarmManage.ad?pageNum=${i}">${i}</a></li>
            </c:if>
            
            <c:if test="${i != currentPage}">
               <li><a href="WeekFarmManage.ad?pageNum=${i}">${i}</a></li>
            </c:if>
         </c:forEach>
         
         <c:if test="${pageCount > endPage}">
         <li><a href="WeekFarmManage.ad?pageNum=${startPage + pageBlock}"><span
               class="glyphicon glyphicon-chevron-right"></span></a></li>
         </c:if>
      </ul>
   </c:if>
   <!-- 페이지 컨트롤 종료 -->
   </body>
</html>