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
            <i class="fa fa-angle-right"></i> 기부 현황
         </h3>
         <div class="row">
            <div class="tab-pane" id="chartjs">
               <div class="row mt">
                  <!-- 차트 시작 -->
                  <div class="tab-pane" id="chartjs">
                     <div class="row mt">
                        <!-- 이번 달 기부 (업체별) 차트 시작 -->
                        <div class="col-lg-6">
                           <div class="content-panel">
                              <h4>
                                 <i class="fa fa-angle-right"></i> 이번 달 기부 (업체별)
                              </h4>
                              <div class="panel-body text-center">
                                 <!-- 차트에 입력할 값 c:set 작업 -->
                                  <c:set var="month_6" value="${map1['month_6']}"></c:set>
                                  <c:set var="month_7" value="${map1['month_7']}"></c:set>
                                  
                                 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                                  <script type="text/javascript">
                                    google.charts.load("current", {packages:["corechart"]});
                                    google.charts.setOnLoadCallback(drawChart);
                                    function drawChart() {
                                      var data = google.visualization.arrayToDataTable([
                                        ['업체별', '업체별 기부 모금액'],
                                        ['하나사랑', ${month_6}],
                                        ['유니세프', ${month_7}],
                                      ]);
                              
                                      var options = {
                                        title: '',
                                        is3D: true,
                                      };
                              
                                      var chart = new google.visualization.PieChart(document.getElementById('thisMonthDonate'));
                                      chart.draw(data, options);
                                    }
                                  </script>
                                  <div id="thisMonthDonate" style="width: 700px; height: 500px;"></div>   
                              </div>
                           </div>
                        </div>
                        <!-- 이번 달 기부 (업체별) 차트 종료 -->
      
                        <!-- 올해 기부 모금액 차트 시작 -->
                        <div class="col-lg-6">
                           <div class="content-panel">
                              <h4>
                                 <i class="fa fa-angle-right"></i> 올해 기부 모금액
                              </h4>
                              <div class="panel-body text-center">
                                 <c:set var="donateTotal_1" value="${map2['donateTotal_1']}"></c:set>
                                  <c:set var="donateTotal_2" value="${map2['donateTotal_2']}"></c:set>
                                  <c:set var="donateTotal_3" value="${map2['donateTotal_3']}"></c:set>
                                  <c:set var="donateTotal_4" value="${map2['donateTotal_4']}"></c:set>
                                  <c:set var="donateTotal_5" value="${map2['donateTotal_5']}"></c:set>
                                  <c:set var="donateTotal_6" value="${map2['donateTotal_6']}"></c:set>
                                  <c:set var="donateTotal_7" value="${map2['donateTotal_7']}"></c:set>
                                  <c:set var="donateTotal_8" value="${map2['donateTotal_8']}"></c:set>
                                  <c:set var="donateTotal_9" value="${map2['donateTotal_9']}"></c:set>
                                  <c:set var="donateTotal_10" value="${map2['donateTotal_10']}"></c:set>
                                  <c:set var="donateTotal_11" value="${map2['donateTotal_11']}"></c:set>
                                  <c:set var="donateTotal_12" value="${map2['donateTotal_12']}"></c:set>
                               
                                 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                                  <script type="text/javascript">
                                    google.charts.load('current', {'packages':['bar']});
                                    google.charts.setOnLoadCallback(drawChart);
                              
                                    function drawChart() {
                                      var data = google.visualization.arrayToDataTable([
                                        ['월', '기부금'],
                                        ['1월', ${donateTotal_1}],
                                        ['2월', ${donateTotal_2}],
                                        ['3월', ${donateTotal_3}],
                                        ['4월', ${donateTotal_4}],
                                        ['5월', ${donateTotal_5}],
                                        ['6월', ${donateTotal_6}],
                                        ['7월', ${donateTotal_7}],
                                        ['8월', ${donateTotal_8}],
                                        ['9월', ${donateTotal_9}],
                                        ['10월', ${donateTotal_10}],
                                        ['11월', ${donateTotal_11}],
                                        ['12월', ${donateTotal_12}],
                                      ]);
                              
                                      var options = {
                                        chart: {
                                          title: '',
                                          subtitle: '',
                                        }
                                      };
                              
                                      var chart = new google.charts.Bar(document.getElementById('monthDonate'));
                              
                                      chart.draw(data, google.charts.Bar.convertOptions(options));
                                    }
                                  </script>
                                  <div id="monthDonate" style="width: 600px; height: 500px;"></div>
                              </div>
                           </div>
                        </div>
                        <!-- 올해 기부 모금액 차트 종료 -->
                     </div>
                  </div>
      
                  <hr width="0%">
      
                  <div class="row mt">
                     <div class="col-md-12">
                        <div class="content-panel">
                           <h4>
                              <i class="fa fa-angle-right"></i> 경매 - 펀드 비교
                           </h4>
                              <div class="panel-body text-center">
                              	<!-- 차트에 입력할 값 c:set 작업 -->
			                        <!-- 차트에 입력할 값 c:set 작업 -->
			                         <c:set var="A1" value="${map4['2018_1']}"></c:set>
			                         <c:set var="A2" value="${map4['2018_2']}"></c:set>
			                         <c:set var="A3" value="${map4['2018_3']}"></c:set>
			                         <c:set var="A4" value="${map4['2018_4']}"></c:set>
			                         <c:set var="A5" value="${map4['2018_5']}"></c:set>
			                         <c:set var="A6" value="${map4['2018_6']}"></c:set>
			                         <c:set var="A7" value="${map4['2018_7']}"></c:set>
			                         <c:set var="A8" value="${map4['2018_8']}"></c:set>
			                         <c:set var="ACnt" value="${A1+A2+A3+A4+A5+A6+A7+A8}"></c:set>
			                         
			                         <c:set var="B1" value="${map4['2017_1']}"></c:set>
			                         <c:set var="B2" value="${map4['2017_2']}"></c:set>
			                         <c:set var="B3" value="${map4['2017_3']}"></c:set>
			                         <c:set var="B4" value="${map4['2017_4']}"></c:set>
			                         <c:set var="B5" value="${map4['2017_5']}"></c:set>
			                         <c:set var="B6" value="${map4['2017_6']}"></c:set>
			                         <c:set var="B7" value="${map4['2017_7']}"></c:set>
			                         <c:set var="B8" value="${map4['2017_8']}"></c:set>
			                         <c:set var="BCnt" value="${B1+B2+B3+B4+B5+B6+B7+B8}"></c:set>
			                         
			                         <c:set var="C1" value="${map4['2016_1']}"></c:set>
			                         <c:set var="C2" value="${map4['2016_2']}"></c:set>
			                         <c:set var="C3" value="${map4['2016_3']}"></c:set>
			                         <c:set var="C4" value="${map4['2016_4']}"></c:set>
			                         <c:set var="C5" value="${map4['2016_5']}"></c:set>
			                         <c:set var="C6" value="${map4['2016_6']}"></c:set>
			                         <c:set var="C7" value="${map4['2016_7']}"></c:set>
			                         <c:set var="C8" value="${map4['2016_8']}"></c:set>
			                         <c:set var="CCnt" value="${C1+C2+C3+C4+C5+C6+C7+C8}"></c:set>
			                         
			                         <c:set var="ToCnt" value="${ToCnt}"></c:set>
			                         <c:set var="Average" value="${(ACnt +BCnt +CCnt)/ToCnt}"></c:set>
			                         
                              	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
							    <script type="text/javascript">
							      google.charts.load('current', {'packages':['corechart']});
							      google.charts.setOnLoadCallback(drawVisualization);
							
							      function drawVisualization() {
							        // Some raw data (not necessarily accurate)
							        var data = google.visualization.arrayToDataTable([
							         ['년별',   '하나사랑' ,  '국내아동지원', '해외아동지원', '북한아동지원', '나눔 SOS', '해외아동결연','유니세프','위스타트' ,'평균'],
							         ['2016',  ${C1},   ${C2},   ${C3},  ${C4},  ${C5},  ${C6},  ${C7},   ${C8} ,${Average}],
							         ['2017',  ${B1},   ${B2},   ${B3},  ${B4},  ${B5},  ${B6},  ${B7},   ${B8} ,${Average}],
							         ['2018',  ${A1},   ${A2},   ${A3},  ${A4},  ${A5},  ${A6},  ${A7},   ${A8} ,${Average}]
							        ]);
							
							    var options = {
							      title : 'Monthly Coffee Production by Country',
							      vAxis: {title: 'Cups'},
							      hAxis: {title: 'Month'},
							      seriesType: 'bars',
							      series: {8: {type: 'line'}}
							    };
							
							    var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
							    chart.draw(data, options);
							  }
							    </script>
							    <div id="chart_div" style="width: 1400px; height: 500px;"></div>
                     </div>
                     <!-- /col-md-12 -->
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