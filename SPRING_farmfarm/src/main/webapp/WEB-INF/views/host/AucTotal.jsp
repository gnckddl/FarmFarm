<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>경매 현황</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<section id="container"> 
		<section id="main-content">
			<section class="wrapper">
			<!-- 제목 -->
			<h3>
				<i class="fa fa-angle-right"></i> [경매 현황]
			</h3>
			<div class="row">
				<div class="tab-pane" id="chartjs">
					<div class="row mt">
						<!-- 차트 시작 -->
						<div class="tab-pane" id="chartjs">
							<div class="row mt">
								<!-- 월별 차트 시작 -->
								<div class="col-lg-6">
									<div class="content-panel">
										<h4>
											<i class="fa fa-angle-right"></i> 월별
										</h4>
										<div class="panel-body text-center">
											<canvas id="bar" height="300" width="400"></canvas>
										</div>
									</div>
								</div>
								<!-- 월별 차트 종료 -->
		
								<!-- 년별 차트 시작 -->
								<div class="col-lg-6">
									<div class="content-panel">
										<h4>
											<i class="fa fa-angle-right"></i> 년별
										</h4>
										<div class="panel-body text-center">
											<canvas id="doughnut" height="300" width="400"></canvas>
										</div>
									</div>
								</div>
								<!-- 년별 차트 종료 -->
							</div>
						</div>
		
						<hr>
		
						<div class="row mt">
							<!-- 금액별 차트 시작 -->
							<div class="col-lg-6">
								<div class="content-panel">
									<h4>
										<i class="fa fa-angle-right"></i> 금액별
									</h4>
									<div class="panel-body text-center">
										<canvas id="bar" height="300" width="400"></canvas>
									</div>
								</div>
							</div>
							<!-- 금액별 차트 종료 -->
		
							<!-- 달성률 차트 시작 -->
							<div class="col-lg-6">
								<div class="content-panel">
									<h4>
										<i class="fa fa-angle-right"></i> 달성률
									</h4>
									<div class="panel-body text-center">
										<canvas id="doughnut" height="300" width="400"></canvas>
									</div>
								</div>
							</div>
							<!-- 달성률 차트 종료 -->
						</div>
						<!-- /row -->
		
						<hr>
		
						<div class="row mt">
							<!-- 진행도 시작 -->
							<div class="col-lg-12">
			      				<div class="showback">
			      					<h4><i class="fa fa-angle-right"></i> 진행도</h4>
				      				<div class="progress progress-striped active">
									  <div class="progress-bar"  role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
									    <span class="sr-only">45% Complete</span>
									  </div>
									</div>
			      				</div>
							</div>
							<!-- 진행도 종료 -->
						</div>
						<!-- /row -->
					</div>
				</div>
			</div>
			<!-- 차트 시작 -->
			</section><!--/wrapper -->
		</section><!-- /MAIN CONTENT --> <!--main content end-->
	</section>

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>

</body>
</html>