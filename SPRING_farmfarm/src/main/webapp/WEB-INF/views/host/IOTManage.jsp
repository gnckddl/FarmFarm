<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IOT 상태확인</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<section id="main-content">
		<section class="wrapper">
			<h3>
				<i class="fa fa-angle-right"></i> IOT 상태확인
			</h3>
			
			<div class="row mt">
				<!-- IoT 연결 시작 -->
				<div class="col-md-12 mt">
					<%@ include file="IOTConnect.jsp" %>
				</div>
				<!-- IoT 연결 끝 -->
			</div>
		
			<hr>
		
			<div class="row mt">
				<!-- IoT 점검현황 시작 -->
				<%@ include file="IOTStatus.jsp" %>
				<!-- IoT 점검현황 끝-->
			</div>
			
			<div class="clearfix"></div>
			<ul class="pagination pull-right">
				<li class="disabled"><a href="#"><span
						class="glyphicon glyphicon-chevron-left"></span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#"><span
						class="glyphicon glyphicon-chevron-right"></span></a></li>
			</ul>
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