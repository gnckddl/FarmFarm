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

	<section id="main-content"> <section class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> [IOT 상태확인]
	</h3>
	<div class="row">
		<!-- 경매 진행내역 시작 -->
		<div class="col-md-12 mt">
			<div class="content-panel">
				<table class="table table-hover">
					<h4>
						<i class="fa fa-angle-right"></i> IOT 연결
					</h4>
					<hr>
					<thead>
						<tr>
							<th style="width: 5%">번호</th>
							<th style="width: 15%">농장명</th>
							<th style="width: 15%">온도센서 연결여부</th>
							<th style="width: 15%">토양 습도센서 연결여부</th>
							<th style="width: 15%">카메라 연결여부</th>
							<th style="width: 15%">농장주 연락처</th>
							<th style="width: 5%">버튼</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>푸른농장</td>
							<td>o</td>
							<td>o</td>
							<td>x</td>
							<td>010-7777-7111</td>
							<td>
								<!-- 내려오는 버튼--> <!-- Single button -->
								<div class="btn-group">
									<button type="button" class="btn btn-theme04 dropdown-toggle"
										data-toggle="dropdown">
										점검요청 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">IOT 상태보기</a></li>
										<li class="divider"></li>
										<li><a href="#">온도센서</a></li>
										<li><a href="#">토양습도센서</a></li>
										<li><a href="#">카메라</a></li>
									</ul>
								</div> <!-- /내려오는 버튼 -->
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>촉촉농장</td>
							<td>o</td>
							<td>o</td>
							<td>o</td>
							<td>010-3333-7111</td>
							<td>
								<!-- 내려오는 버튼--> <!-- Single button -->
								<div class="btn-group">
									<button type="button" class="btn btn-theme04 dropdown-toggle"
										data-toggle="dropdown">
										점검요청 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">IOT 상태보기</a></li>
										<li class="divider"></li>
										<li><a href="#">온도센서</a></li>
										<li><a href="#">토양습도센서</a></li>
										<li><a href="#">카메라</a></li>
									</ul>
								</div> <!-- /내려오는 버튼 -->
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>넓은농장</td>
							<td>o</td>
							<td>o</td>
							<td>o</td>
							<td>010-4444-7111</td>
							<td>
								<!-- 내려오는 버튼--> <!-- Single button -->
								<div class="btn-group">
									<button type="button" class="btn btn-theme04 dropdown-toggle"
										data-toggle="dropdown">
										점검요청 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="#">IOT 상태보기</a></li>
										<li class="divider"></li>
										<li><a href="#">온도센서</a></li>
										<li><a href="#">토양습도센서</a></li>
										<li><a href="#">카메라</a></li>
									</ul>
								</div> <!-- /내려오는 버튼 -->
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--/content-panel -->
		</div>
		<!-- /col-md-12 -->
		<!-- 경매 진행내역 끝 -->
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



	<div class="row">
		<!-- 경매 진행내역 시작 -->
		<div class="col-md-12 mt">
			<div class="content-panel">
				<table class="table table-hover">
					<h4>
						<i class="fa fa-angle-right"></i> IOT 점검현황
					</h4>
					<hr>
					<thead>
						<tr>
							<th style="width: 5%">번호</th>
							<th style="width: 15%">농장명</th>
							<th style="width: 15%">온도센서 연결여부</th>
							<th style="width: 15%">토양 습도센서 연결여부</th>
							<th style="width: 15%">카메라 연결여부</th>
							<th style="width: 15%">농장주 연락처</th>
							<th style="width: 5%">버튼</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>푸른농장</td>
							<td>o</td>
							<td>o</td>
							<td>x</td>
							<td>010-7777-7111</td>
							<td>
								<button type="button" class="btn btn-round btn-primary">점검요청</button>
							</td>
						</tr>
						<tr>
							<td>2</td>
							<td>촉촉농장</td>
							<td>o</td>
							<td>o</td>
							<td>o</td>
							<td>010-3333-7111</td>
							<td>
								<button type="button" class="btn btn-round btn-default">점검완료</button>
							</td>
						</tr>
						<tr>
							<td>3</td>
							<td>넓은농장</td>
							<td>o</td>
							<td>o</td>
							<td>o</td>
							<td>010-4444-7111</td>
							<td>
								<button type="button" class="btn btn-round btn-primary">점검요청</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<!--/content-panel -->
		</div>
		<!-- /col-md-12 -->
		<!-- 경매 진행내역 끝 -->
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