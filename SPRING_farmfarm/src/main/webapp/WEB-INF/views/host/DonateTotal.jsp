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
	<%@ include file="../Header.jsp" %>
 	
 	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp" %>
 	
 	<section id="container">
		<section id="main-content">
			<section class="wrapper">
			<!-- 제목 -->
			<h3>
				<i class="fa fa-angle-right"></i> [기부 현황]
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
							<!-- 업체별 차트 시작 -->
							<div class="col-lg-6">
								<div class="content-panel">
									<h4>
										<i class="fa fa-angle-right"></i> 업체별
									</h4>
									<div class="panel-body text-center">
										<canvas id="bar" height="300" width="400"></canvas>
									</div>
								</div>
							</div>
							<!-- 업체별 차트 종료 -->
		
							<!-- 방법별 차트 시작 -->
							<div class="col-lg-6">
								<div class="content-panel">
									<h4>
										<i class="fa fa-angle-right"></i> 방법별
									</h4>
									<div class="panel-body text-center">
										<canvas id="doughnut" height="300" width="400"></canvas>
									</div>
								</div>
							</div>
							<!-- 방법별 차트 종료 -->
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