<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>경매 진행내역</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<section id="main-content">
		<section class="wrapper">
		<h3>
			<i class="fa fa-angle-right"></i> 경매 진행내역
		</h3>
		<div class="row">
			<!-- 경매 진행내역 시작 -->
			<div class="col-md-12 mt">
				<%@ include file="AucList_ing.jsp"%>
			</div>
			<!-- 경매 진행내역 끝 -->
	
			<!-- 경매 완료내역 시작 -->
			<div class="col-md-12 mt">
				<%@ include file="AucList_end.jsp"%>
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
			</div>
			<!-- 경매 완료내역 끝 -->
		</div><!-- row -->
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