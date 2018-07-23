<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 테이블 아래 이동키  -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<!-- 테이블 아래 이동키 끝  -->

<!-- 헤더 -->
<%@ include file="../Header.jsp"%>

<!-- 관리자 사이드 바 -->
<%@ include file="../HostSideBar.jsp"%>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>파트너 관리</title>
<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> 파트너 관리
	</h3>
	<div class="row">
		<!-- 차트 시작 -->
		<div class="tab-pane" id="chartjs">
			<div class="row mt">
				<!-- 분야별 파트너 수 차트 시작 -->
				<div class="col-lg-6">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 분야별 파트너
						</h4>
						<div class="panel-body text-center">
							<canvas id="bar" height="300" width="400"></canvas>
						</div>
					</div>
				</div>
				<!-- 분야별 파트너 수 차트 끝 -->

				<!-- 파트너 대 회원 차트 시작 -->
				<div class="col-lg-6">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 파트너 대 회원
						</h4>
						<div class="panel-body text-center">
							<canvas id="doughnut" height="300" width="400"></canvas>
						</div>
					</div>
				</div>
				<!-- 파트너 대 회원 차트 끝 -->
			</div>
		</div>
		<!-- 차트 끝 -->

		<div class="row mt">
			<div class="col-md-12">
				<div class="content-panel">
					<!-- 파트너 관리 테이블 시작 -->
					<h4>
						<i class="fa fa-angle-right"></i> 파트너 관리
					</h4>
					<table class="table table-striped table-advance table-hover">
						<hr>
						<thead>
							<tr>
								<th><input type="checkbox" id="checkall" /></th>
								<th><i class="fa fa-bullhorn"></i> 번호</th>
								<th><i class="fa fa-bullhorn"></i> 아이디</th>
								<th><i class="fa fa-question-circle"></i> 파트너 닉네임</th>
								<th><i class="fa fa-question-circle"></i> 이름</th>
								<th><i class=" fa fa-bookmark"></i> 파트너 등록 / 승인일</th>
								<th><i class="fa fa-bookmark"></i> 상태</th>
								<th><i class=" fa fa-edit"></i> 어드벤티지</th>
								<th><i class=" fa fa-edit"></i> 파트너 관리</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="dto" items="${dtos}">
								<tr>
									<td><input type="checkbox" class="checkthis"></td>
									<td>${number-1}<!-- 보여지기용도  num뿌리면 안됨.-->
										<c:set var="number" value="${number-1}" />
									</td>
									<td><a href="basic_table.html#">${dto.mem_id}</a></td>
									<td class="hidden-phone">${dto.farm_nick}</td>
									<td>${dto.mem_name}</td>
									<td>${dto.farm_regDate}</td>
									<c:if test="${dto.farm_status == 1}">
										<td><span class="label label-warning label-mini">파트너
												신청 대기</span></td>
									</c:if>
									<c:if test="${dto.farm_status == 2}">
										<td><span class="badge bg-info">파트너</span></td>
									</c:if>
									<td>
										<button class="btn btn-success btn-xs">+</button>
										<button class="btn btn-danger btn-xs">-</button> <span
										class="badge bg-info">${dto.farm_adv}점</span>
									</td>
									<td>
										<button class="btn btn-success btn-xs">
											<i class="fa fa-check"></i>
										</button>
										<button class="btn btn-warning btn-xs">
											<i class="fa fa-pencil"></i>
										</button>
										<button class="btn btn-danger btn-xs">
											<i class="fa fa-trash-o "></i>
										</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<!-- 파트너 관리 테이블 종료 -->
				</div>
				<!-- /content-panel -->
			</div>
			<!-- /col-md-12 -->
		</div>
		<!-- /row -->
	</section><!--/wrapper --> </section><!-- /MAIN CONTENT --> <!--main content end--> </section>

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>
</body>
</html>