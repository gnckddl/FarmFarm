<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기부 현황</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<section id="main-content"> <section class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> [기부 현황]
	</h3>
	<div class="row">
		<!-- 기부 현황 시작 -->
		<div class="col-md-12 mt">
			<div class="content-panel">
				<table class="table table-hover">
					<h4>
						<i class="fa fa-angle-right"></i> 기부 현황 (3건)
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
						<tr>
							<td>1</td>
							<td><img src="${hostImage}/watermelon.jpg" width="100px"></td>
							<td><img src="${hostImage}/donate1.jpg" width="100px"></td>
							<td>어린이에게 구원의 손길을</td>
							<td>￦10,000</td>
							<td>문재인</td>
							<td>2018-07-22</td>
						</tr>
						<tr>
							<td>2</td>
							<td><img src="${hostImage}/watermelon.jpg" width="100px"></td>
							<td><img src="${hostImage}/donate2.jpg" width="100px"></td>
							<td>아프리카 어린이에게..</td>
							<td>￦20,000</td>
							<td>안철수</td>
							<td>2018-07-22</td>
						</tr>
						<tr>
							<td>3</td>
							<td><img src="${hostImage}/watermelon.jpg" width="100px"></td>
							<td><img src="${hostImage}/donate4.jpg" width="100px"></td>
							<td>지저스</td>
							<td>￦30,000</td>
							<td>홍준표</td>
							<td>2018-07-22</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--/content-panel -->
		</div>
		<!-- /col-md-12 -->
		<!-- 기부 현황 끝 -->
	</div>
	<!-- row -->

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
	</section> </section>

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>

</body>
</html>