<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>펀드 현황</title>
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
				<i class="fa fa-angle-right"></i> 펀드 현황
			</h3>
			<div class="row">
				<!-- 차트 시작 -->
				<div class="tab-pane" id="chartjs">
					<div class="row mt">
						<div class="tab-pane" id="chartjs">
               <div class="row mt">
                  <!-- 1. 이번 달 펀드(상품 종류별) 차트 시작 -->
                  <div class="col-lg-6">
                     <div class="content-panel">
                        <h4>
                           <i class="fa fa-angle-right"></i> 이번달 펀드 (상품 종류별)
                        </h4>
                        <div class="panel-body text-center">
                           <!-- 차트에 입력할 값 c:set 작업 -->
                            <c:set var="event" value="${map1['event']}"></c:set>
                            <c:set var="farm" value="${map1['farm']}"></c:set>
                            <c:set var="animal" value="${map1['animal']}"></c:set>
                            <c:set var="fish" value="${map1['fish']}"></c:set>
                             <c:set var="health" value="${map1['health']}"></c:set>
                            <c:set var="mushroom" value="${map1['mushroom']}"></c:set>
                            <c:set var="alcohol" value="${map1['alcohol']}"></c:set>
                            <c:set var="etc" value="${map1['etc']}"></c:set>
                         
                           <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                            <script type="text/javascript">
                              google.charts.load("current", {packages:["corechart"]});
                              google.charts.setOnLoadCallback(drawChart);
                              function drawChart() {
                                var data = google.visualization.arrayToDataTable([
                                  ['상품 종류', '종류별 총 펀드액'],
                                  ['이벤트', ${event}],
                                  ['농산', ${farm}],
                                  ['축산', ${animal}],
                                  ['수산', ${fish}],
                                  ['건강,유기농', ${health}],
                                  ['버섯', ${mushroom}],
                                  ['주류', ${alcohol}],
                                  ['기타', ${etc}]
                                ]);
                        
                                var options = {
                                  title: '',
                                  is3D: true,
                                };
                        
                                var chart = new google.visualization.PieChart(document.getElementById('thisMonthFundKind'));
                                chart.draw(data, options);
                              }
                            </script>
                            <div id="thisMonthFundKind" style="width: 750px; height: 500px;"></div>
                        </div>
                     </div>
                  </div>
                  <!-- 1. 이번 달 펀드(상품 종류별) 차트 종료 -->
      
                  <!-- 2. 월별 펀드 총액 차트 시작 -->
                  <div class="col-lg-6">
                     <div class="content-panel">
                        <h4>
                           <i class="fa fa-angle-right"></i> 월별 펀드 총액
                        </h4>
                        <div class="panel-body text-center">
                           <!-- 차트에 입력할 값 c:set 작업 -->
                            <c:set var="fundTotal_1" value="${map2['fundTotal_1']}"></c:set>
                            <c:set var="fundTotal_2" value="${map2['fundTotal_2']}"></c:set>
                            <c:set var="fundTotal_3" value="${map2['fundTotal_3']}"></c:set>
                            <c:set var="fundTotal_4" value="${map2['fundTotal_4']}"></c:set>
                             <c:set var="fundTotal_5" value="${map2['fundTotal_5']}"></c:set>
                            <c:set var="fundTotal_6" value="${map2['fundTotal_6']}"></c:set>
                            <c:set var="fundTotal_7" value="${map2['fundTotal_7']}"></c:set>
                            <c:set var="fundTotal_8" value="${map2['fundTotal_8']}"></c:set>
                            <c:set var="fundTotal_9" value="${map2['fundTotal_9']}"></c:set>
                            <c:set var="fundTotal_10" value="${map2['fundTotal_10']}"></c:set>
                            <c:set var="fundTotal_11" value="${map2['fundTotal_11']}"></c:set>
                            <c:set var="fundTotal_12" value="${map2['fundTotal_12']}"></c:set>
                         
                           <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                            <script type="text/javascript">
                              google.charts.load("current", {packages:["corechart"]});
                              google.charts.setOnLoadCallback(drawChart);
                              function drawChart() {
                                var data = google.visualization.arrayToDataTable([
                                  ['월별', '펀드 총액'],
                                  ['1월', ${fundTotal_1}], ['2월', ${fundTotal_2}], ['3월', ${fundTotal_3}],
                                  ['4월', ${fundTotal_4}], ['5월', ${fundTotal_5}], ['6월', ${fundTotal_6}],
                                  ['7월', ${fundTotal_7}], ['8월', ${fundTotal_8}], ['9월', ${fundTotal_9}],
                                  ['10월', ${fundTotal_10}], ['11월', ${fundTotal_11}], ['12월', ${fundTotal_12}]
                                ]);
                        
                                var options = {
                                  title: '',
                                  legend: '',
                                  pieSliceText: 'label',
                                  slices: { 1: {offset: 0.3},
                                  },
                                };
                        
                                var chart = new google.visualization.PieChart(document.getElementById('monthFundTotal'));
                                chart.draw(data, options);
                              }
                            </script>
                            <div id="monthFundTotal" style="width: 750px; height: 500px;"></div>
                        </div>
                     </div>
                  </div>
                  <!-- 2. 월별 펀드 총액 차트 종료 -->
               </div>
            </div>
					</div>
				</div>
		
				<hr>
		
				<div class="row mt">
					<!-- 금액별 차트 시작 -->
							<div class="col-lg-6">
								<div class="content-panel">
									<h4>
										<i class="fa fa-angle-right"></i> 년별 펀드 (총 액수)
									</h4>
									<div class="panel-body text-center">
									<!-- 차트에 입력할 값 c:set 작업 -->
			                         <c:set var="a" value="${map3['2013']}"></c:set>
			                         <c:set var="b" value="${map3['2014']}"></c:set>
			                         <c:set var="c" value="${map3['2015']}"></c:set>
			                         <c:set var="d" value="${map3['2016']}"></c:set>
			                         <c:set var="e" value="${map3['2017']}"></c:set>
			                         <c:set var="f" value="${map3['2018']}"></c:set>
			                         <c:set var="ToCnt" value="${ToCnt}"></c:set>
			                         <c:set var="Average" value="${(a+b+c+d+e+f)/ToCnt}"></c:set>
			                         
			                         
										 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
									     <script type="text/javascript">
									      google.charts.load('current', {'packages':['corechart']});
									      google.charts.setOnLoadCallback(drawVisualization);
									
									      function drawVisualization() {
									        // Some raw data (not necessarily accurate)
									        var data = google.visualization.arrayToDataTable([
									         ['달 별', '펀드', '평균'],
									         ['2013',  ${a}, ${Average}],
									         ['2014',  ${b}, ${Average}],
									         ['2015',  ${c}, ${Average}],
									         ['2016',  ${d}, ${Average}],
									         ['2017',  ${e}, ${Average}],
									         ['2018',  ${f}, ${Average}]
									      ]);
									
									    var options = {
									      title : '6 개년 총 펀드 판매량',
									      vAxis: {title: '금액'},
									      hAxis: {title: '6 개년 총 펀드 판매량'},
									      seriesType: 'bars',
									      series: {1: {type: 'line'}}
									    };
									
									    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
									    chart.draw(data, options);
									  }
									    </script>
									    <div id="chart_div" style="width: 850px; height: 500px;"></div>
									</div>
								</div>
							</div>
							<!-- 금액별 차트 종료 -->
		
					<!-- 달성률 차트 시작 -->
					<div class="col-lg-6">
						<div class="content-panel">
							<h4>
								<i class="fa fa-angle-right"></i>년별 펀드(상품 종류별)
							</h4>
							<!-- 차트에 입력할 값 c:set 작업 -->
			                         <c:set var="A1" value="${map4['2018_1']}"></c:set>
			                         <c:set var="A2" value="${map4['2018_2']}"></c:set>
			                         <c:set var="A3" value="${map4['2018_3']}"></c:set>
			                         <c:set var="A4" value="${map4['2018_4']}"></c:set>
			                         <c:set var="A5" value="${map4['2018_5']}"></c:set>
			                         <c:set var="A6" value="${map4['2018_6']}"></c:set>
			                         <c:set var="A7" value="${map4['2018_7']}"></c:set>
			                         <c:set var="A8" value="${map4['2018_8']}"></c:set>
			                         
			                         <c:set var="B1" value="${map4['2017_1']}"></c:set>
			                         <c:set var="B2" value="${map4['2017_2']}"></c:set>
			                         <c:set var="B3" value="${map4['2017_3']}"></c:set>
			                         <c:set var="B4" value="${map4['2017_4']}"></c:set>
			                         <c:set var="B5" value="${map4['2017_5']}"></c:set>
			                         <c:set var="B6" value="${map4['2017_6']}"></c:set>
			                         <c:set var="B7" value="${map4['2017_7']}"></c:set>
			                         <c:set var="B8" value="${map4['2017_8']}"></c:set>
			                         
			                         <c:set var="C1" value="${map4['2016_1']}"></c:set>
			                         <c:set var="C2" value="${map4['2016_2']}"></c:set>
			                         <c:set var="C3" value="${map4['2016_3']}"></c:set>
			                         <c:set var="C4" value="${map4['2016_4']}"></c:set>
			                         <c:set var="C5" value="${map4['2016_5']}"></c:set>
			                         <c:set var="C6" value="${map4['2016_6']}"></c:set>
			                         <c:set var="C7" value="${map4['2016_7']}"></c:set>
			                         <c:set var="C8" value="${map4['2016_8']}"></c:set>
			                         
							 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
						    <script type="text/javascript">
						      google.charts.load('current', {'packages':['corechart']});
						      google.charts.setOnLoadCallback(drawChart);
						//상품 종류(1: 이벤트, 2: 농산, 3: 축산, 4: 수산, 5: 건강·유기농, 6: 버섯, 7: 주류, 8: 기타)
						      function drawChart() {
						        var data = google.visualization.arrayToDataTable([
						          ['Year', '이벤트', '농산' ,'축산','수산','건강·유기농','버섯','주류','기타'],
						          ['2016',  ${C1},   ${C2},   ${C3},  ${C4},  ${C5},  ${C6},  ${C7},   ${C8}],
						          ['2017',  ${B1},   ${B2},   ${B3},  ${B4},  ${B5},  ${B6},  ${B7},   ${B8}],
						          ['2018',  ${A1},   ${A2},   ${A3},  ${A4},  ${A5},  ${A6},  ${A7},   ${A8}]
						        ]);
						
						        var options = {
						          curveType: 'function',
						          legend: { position: 'bottom' }
						        };
						
						        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
						
						        chart.draw(data, options);
						      }
						    </script>
						    <div id="curve_chart" style="width: 900px; height: 530px"></div>
						</div>
					</div>
					<!-- 달성률 차트 종료 -->
				</div>
				<!-- /row -->
		
				<hr>
		
				<!-- /row -->
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