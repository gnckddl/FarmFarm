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

<title>일반회원 관리</title>
<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">
	<h3>
		<i class="fa fa-angle-right"></i> 일반회원 관리
	</h3>
	<div class="row">
		<!-- 차트 시작 -->
		<div class="tab-pane" id="chartjs">
			<div class="row mt">
				<!-- 분야별 구매 차트 시작 -->
				<div class="col-lg-6">
					<div class="content-panel">
						<h4>
							<i class="fa fa-angle-right"></i> 분야별 구매
						</h4>
						<div class="panel-body text-center">
							<canvas id="bar" height="300" width="400"></canvas>
						</div>
					</div>
				</div>
				<!-- 분야별 구매 차트 끝 -->

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
					<table class="table table-striped table-advance table-hover">
						<h4>
							<i class="fa fa-angle-right"></i> 회원 관리
						</h4>
						<hr>
						<thead>
							<tr>
								<th><input type="checkbox" id="checkall" /></th>
								<th><i class="fa fa-bullhorn"></i> 번호</th>
								<th class="hidden-phone"><i class="fa fa-question-circle"></i>
									아이디</th>
								<th><i class=" fa fa-edit"></i> 이름</th>
								<th><i class="fa fa-bookmark"></i> 연락처</th>
								<th><i class=" fa fa-edit"></i> 펀드 및 경매 참여금액</th>
								<th><i class="fa fa-bookmark"></i> 등급</th>
								<th><i class=" fa fa-edit"></i> 어드벤티지</th>
								<th><i class=" fa fa-edit"></i> 삭제</th>

							</tr>
						</thead>
						<tbody>
							<!-- 회원 목록이 있으면  -->
							<c:if test="${cnt>0}">
								<!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
								<c:forEach var="dto" items="${dtos}">
									<tr>
										<td><input type="checkbox" class="checkthis"></td>
										<td>${number-1}<!-- 보여지기용도  num뿌리면 안됨.-->
											<c:set var="number" value="${number-1}" />
										</td>
										<td><a href="#">${dto.mem_id}</a></td>
										<td>${dto.mem_name}</td>
										<td class="hidden-phone">${dto.mem_hp}</td>
										<td>참여금액</td>
										<td><span class="label label-info label-mini">소작농</span>
										</td>
										<td>
											<button class="btn btn-success btn-xs">+</button>
											<button class="btn btn-danger btn-xs">-</button>
										</td>
										<td>
											<button class="btn btn-danger btn-xs">
												<i class="fa fa-trash-o "></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</c:if>
							<!-- 회원 목록이 있으면 끝 -->
							<!-- 게시글이 없으면 -->
							<c:if test="${cnt==0}">
								<tr>
									<td colspan="6" align="center">회원이 없습니다.!!</td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<!-- 페이지 컨트롤 -->
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
					<!-- 페이지 컨트롤 끝-->

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