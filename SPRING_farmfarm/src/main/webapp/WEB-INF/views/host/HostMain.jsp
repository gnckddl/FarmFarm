<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 헤더 -->
<%@ include file="../Header.jsp"%>

<!-- 관리자 사이드 바 -->
<%@ include file="../HostSideBar.jsp"%>
<head>
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword"
	content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>관리자 메인</title>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
	<!--header start--> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<!--main content start--> <section id="main-content"> <section
		class="wrapper">

	<div class="row">
		<div class="col-lg-9 main-chart">
			<div class="row mtbox">
				<!-- 메인 - 펀드 승인 대기 -->
				<div class="col-md-2 col-sm-2 col-md-offset-1 box0">
					<div class="box1">
						<span class="li_cloud"></span>
						<h4>펀드[44]</h4>
					</div>
					<p>44건의 펀드가 승인 요청 대기중입니다.</p>
				</div>

				<!-- 메인 - 경매 승인 대기 -->
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_stack"></span>
						<h4>경매[13]</h4>
					</div>
					<p>13건의 경매가 승인 요청 대기중입니다.</p>
				</div>

				<!-- 메인 - 문의 게시판[파트너] -->
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_mail"></span>
						<h4>문의-파트너[7]</h4>
					</div>
					<p>파트너로부터의 문의가 7건 도착했습니다.</p>
				</div>

				<!-- 메인 - 문의 게시판[회원] -->
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_mail"></span>
						<h4>문의-회원[10]</h4>
					</div>
					<p>회원으로부터의 문의가 10건 도착했습니다.</p>
				</div>

				<!-- 메인 - 기부 건수 -->
				<div class="col-md-2 col-sm-2 box0">
					<div class="box1">
						<span class="li_heart"></span>
						<h4>기부[4444]</h4>
					</div>
					<p>올해의 기부 4444건 돌파~</p>
				</div>

			</div>
			<!-- /row mt -->


			<div class="row mt">
				<!-- SERVER STATUS PANELS -->
				<div class="col-md-4 col-sm-4 mb">
					<div class="green-panel pn donut-chart">
						<!-- 1-1. 진행중인 펀드 -->
						<div class="green-header">
							<h5>진행중인 펀드</h5>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-6 goleft">
								<p>
									<i class="fa fa-database"></i> 85%
								</p>
							</div>
						</div>

						<!-- 1-1. 진행중인 펀드 차트 -->
						<canvas id="serverstatus01" height="120" width="120"></canvas>
						<script>
							var doughnutData = [ {
								value : 85,
								color : "#00A58A"
							}, {
								value : 15,
								color : "#fdfdfd"
							} ];
							var myDoughnut = new Chart(document.getElementById(
									"serverstatus01").getContext("2d"))
									.Doughnut(doughnutData);
						</script>
					</div>
				</div>
				<!-- /col-md-4-->

				<div class="col-md-4 col-sm-4 mb">
					<div class="green-panel pn">
						<!-- 1-2. 최고의 상품 -->
						<div class="green-header">
							<h5>최고의 상품</h5>
						</div>
						<div class="row">
							<div class="col-sm-6 col-xs-6 goleft">
								<p>
									<i class="fa fa-heart"></i>444
								</p>
							</div>
							<div class="col-sm-6 col-xs-6"></div>
						</div>
						<!-- 1-2. 최고의 상품 이미지 -->
						<div class="centered">
							<img src="${hostImage}/watermelon.jpg" class="img-circle"
								width="200">
						</div>
					</div>
				</div>
				<!-- /col-md-4 -->

				<div class="col-md-4 mb">
					<div class="green-panel pn">
						<!-- 1-3. 기부왕 -->
						<div class="green-header">
							<h5>기부왕</h5>
						</div>
						<!-- 1-3. 기부왕 사진 -->
						<p>
							<img src="${hostImage}/kim.jpg" class="img-circle" width="80">
						</p>
						<!-- 1-3. 기부왕 이름 -->
						<p>
							<b>김보영</b>
						</p>
						<div class="row">
							<div class="col-md-6">
								<!-- 1-3. 기부왕 가입 날짜 및 파트너 여부 -->
								<p class="small mt">파트너</p>
								<p>2018</p>
							</div>
							<div class="col-md-6">
								<!-- 1-3. 기부왕 기부한 금액 -->
								<p class="small mt">총 기부 금액</p>
								<p>￦20,000,000</p>
							</div>
						</div>
					</div>
				</div>
				<!-- /col-md-4 -->


			</div>
			<!-- /row -->


			<div class="row">
                  <!-- TWITTER PANEL -->
                  <div class="col-md-4 mb">
                            <div class="darkblue-panel pn">
                               <div class="darkblue-header">
                             <h5>낙찰된 경매</h5>
                               </div>
                        <canvas id="serverstatus02" height="120" width="120"></canvas>
                        <script>
                           var doughnutData = [
                                 {
                                    value: 60,
                                    color:"#68dff0"
                                 },
                                 {
                                    value : 40,
                                    color : "#444c57"
                                 }
                              ];
                              var myDoughnut = new Chart(document.getElementById("serverstatus02").getContext("2d")).Doughnut(doughnutData);
                        </script>
                        <p>April 17, 2018</p>
                        <footer>
                           <div class="pull-left">
                              <h5><i class="fa fa-hdd-o"></i> 17 건</h5>
                           </div>
                           <div class="pull-right">
                              <h5>60% Used</h5>
                           </div>
                        </footer>
                            </div><!-- /darkblue panel -->
                  </div><!-- /col-md-4 -->
                  
                  <!-- WEATHER PANEL -->
                         <div class="col-md-4 col-sm-4 mb">
                     <div class="weather pn">
                        <i class="fa fa-cloud fa-4x"></i>
                        <h2>11º C</h2>
                        <h4>오늘 날씨</h4>
                     </div>
                  </div><!-- /col-md-4-->
               <!--    <div class="col-md-4 mb">
                     INSTAGRAM PANEL
                     <div class="instagram-panel pn">
                        <i class="fa fa-instagram fa-4x"></i>
                        <p>@THISISYOU<br/>
                           5 min. ago
                        </p>
                        <p><i class="fa fa-comment"></i> 18 | <i class="fa fa-heart"></i> 49</p>
                     </div>
                  </div>/col-md-4
                   -->
                   
                   <div class="col-md-4 col-sm-4 mb">
                       <div class="stock card">
                          <div class="stock-chart">
                              <div id="chart"></div>
                        </div>
                        <div class="stock current-price">
                           <div class="row">
                                <div class="info col-sm-6 col-xs-6"><abbr>TODAY 거래금</abbr>
                                    <time>Yesterday</time>
                              </div>
                           <div class="changes col-sm-6 col-xs-6">
                              <div class="value up"><i class="fa fa-caret-up hidden-sm hidden-xs"></i> 694.00</div>
                              <div class="change hidden-sm hidden-xs">+4.95 (3.49%)</div>
                           </div>
                           </div>
                        </div>
                        <div class="summary">
                              <strong>180.000 ▲</strong> <span>전날 대비</span>
                        </div>
                       </div>
                  </div><!-- /col-md-4 -->
                  
                  <!-- <div class="col-md-4 col-sm-4 mb">
                     REVENUE PANEL
                     <div class="darkblue-panel pn">
                        <div class="darkblue-header">
                           <h5>오늘의 거래금</h5>
                        </div>
                        <div class="chart mt">
                           <div class="sparkline" data-type="line" data-resize="true" data-height="75" data-width="90%" data-line-width="1" data-line-color="#fff" data-spot-color="#fff" data-fill-color="" data-highlight-line-color="#fff" data-spot-radius="4" data-data="[200,135,667,333,526,996,564,123,890,464,655]"></div>
                        </div>
                        <p class="mt"><b>$ 17,980</b><br/>Month Income</p>
                     </div>
                  </div>/col-md-4 -->
                  
               </div><!-- /row -->

			<div class="row mt">
				<!--CUSTOM CHART START -->
				<div class="border-head">
					<h3>▶ 올해의 거래금</h3>
				</div>
				<div class="custom-bar-chart">
					<ul class="y-axis">
						<li><span>10.000</span></li>
						<li><span>8.000</span></li>
						<li><span>6.000</span></li>
						<li><span>4.000</span></li>
						<li><span>2.000</span></li>
						<li><span>0</span></li>
					</ul>
					<div class="bar">
						<div class="title">JAN</div>
						<div class="value tooltips" data-original-title="8.500"
							data-toggle="tooltip" data-placement="top">85%</div>
					</div>
					<div class="bar ">
						<div class="title">FEB</div>
						<div class="value tooltips" data-original-title="5.000"
							data-toggle="tooltip" data-placement="top">50%</div>
					</div>
					<div class="bar ">
						<div class="title">MAR</div>
						<div class="value tooltips" data-original-title="6.000"
							data-toggle="tooltip" data-placement="top">60%</div>
					</div>
					<div class="bar ">
						<div class="title">APR</div>
						<div class="value tooltips" data-original-title="4.500"
							data-toggle="tooltip" data-placement="top">45%</div>
					</div>
					<div class="bar">
						<div class="title">MAY</div>
						<div class="value tooltips" data-original-title="3.200"
							data-toggle="tooltip" data-placement="top">32%</div>
					</div>
					<div class="bar ">
						<div class="title">JUN</div>
						<div class="value tooltips" data-original-title="6.200"
							data-toggle="tooltip" data-placement="top">62%</div>
					</div>
					<div class="bar">
						<div class="title">JUL</div>
						<div class="value tooltips" data-original-title="7.500"
							data-toggle="tooltip" data-placement="top">75%</div>
					</div>
				</div>
				<!--custom chart end-->
			</div>
			<!-- /row -->

		</div>
		<!-- /col-lg-9 END SECTION MIDDLE -->


		<!-- **********************************************************************************************************************************************************
      RIGHT SIDEBAR CONTENT
      *********************************************************************************************************************************************************** -->

		<div class="col-lg-3 ds">
			<!--COMPLETED ACTIONS DONUTS CHART-->
			<h3>농부 신청서</h3>

			<!-- First Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>2 분전</muted>
						<br /> <a href="#">촌주 님</a> 농부신청서를 보냈습니다.<br />
					</p>
				</div>
			</div>
			<!-- Second Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>3 시간전</muted>
						<br /> <a href="#">농부왕 님</a> 장기농부를 신청했습니다. <br />
					</p>
				</div>
			</div>
			<!-- Third Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>7 시간전</muted>
						<br /> <a href="#">농삼이 님</a> 농부신청서를 보냈습니다.<br />
					</p>
				</div>
			</div>
			<!-- Fourth Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>11 Hours Ago</muted>
						<br /> <a href="#">Mark Twain</a> commented your post.<br />
					</p>
				</div>
			</div>
			<!-- Fifth Action -->
			<div class="desc">
				<div class="thumb">
					<span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
				</div>
				<div class="details">
					<p>
						<muted>18 Hours Ago</muted>
						<br /> <a href="#">Daniel Pratt</a> purchased a wallet in your
						store.<br />
					</p>
				</div>
			</div>

			<!-- USERS ONLINE SECTION -->
			<h3>TEAM MEMBERS</h3>
			<!-- First Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="${hostcss}/img/ui-divya.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DIVYA MANIAN</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Second Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="${hostcss}/img/ui-sherman.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DJ SHERMAN</a><br />
						<muted>I am Busy</muted>
					</p>
				</div>
			</div>
			<!-- Third Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="${hostcss}/img/ui-danro.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">DAN ROGERS</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fourth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="${hostcss}/img/ui-zac.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Zac Sniders</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>
			<!-- Fifth Member -->
			<div class="desc">
				<div class="thumb">
					<img class="img-circle" src="${hostcss}/img/ui-sam.jpg"
						width="35px" height="35px" align="">
				</div>
				<div class="details">
					<p>
						<a href="#">Marcel Newman</a><br />
						<muted>Available</muted>
					</p>
				</div>
			</div>

			<!-- CALENDAR-->
			<div id="calendar" class="mb">
				<div class="panel green-panel no-margin">
					<div class="panel-body">
						<div id="date-popover" class="popover top"
							style="cursor: pointer; disadding: block; margin-left: 33%; margin-top: -50px; width: 175px;">
							<div class="arrow"></div>
							<h3 class="popover-title" style="disadding: none;"></h3>
							<div id="date-popover-content" class="popover-content"></div>
						</div>
						<div id="my-calendar"></div>
					</div>
				</div>
			</div>
			<!-- / calendar -->

		</div>
		<!-- /col-lg-3 -->
	</div>
	<!-- /row --> </section> </section> </section>

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>
</body>

</html>
