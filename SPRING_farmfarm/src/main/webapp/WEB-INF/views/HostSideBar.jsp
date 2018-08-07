<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- Bootstrap core CSS -->
<link href="${hostcss}/css/bootstrap.css" rel="stylesheet">

<!--external css-->
<link href="${hostcss}/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="${hostcss}/css/zabuto_calendar.css">
<link rel="stylesheet" type="text/css"
	href="${hostcss}/js/gritter/css/jquery.gritter.css" />
<link rel="stylesheet" type="text/css"
	href="${hostcss}/lineicons/style.css">

<!-- Custom styles for this template -->
<link href="${hostcss}/css/style.css" rel="stylesheet">
<link href="${hostcss}/css/style-responsive.css" rel="stylesheet">

<script src="${hostcss}/js/chart-master/Chart.js"></script>

<body>
	<!--header start-->
	<header class="header">
	<div class="sidebar-toggle-box">
		<div class="fa fa-bars tooltips" data-placement="right"
			data-original-title="Toggle Navigation"></div>
	</div>
	<div class="nav notify-row" id="top_menu">
		<!--  notification start -->
		<ul class="nav top-menu">
			<!-- settings start -->
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="index.html#"> <i
					class="fa fa-tasks"></i> <!-- 오늘의 업데이트 알림 --> <!-- 확인 안했을 때 몇 건인지 보여준다. -->
					<span class="badge bg-theme">4</span>
			</a>
				<ul class="dropdown-menu extended tasks-bar">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">오늘의 업데이트</p>
					</li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">경매 낙찰 건수</div>
								<div class="percent">4건</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-success"
									role="progressbar" aria-valuenow="40" aria-valuemin="0"
									aria-valuemax="100" style="width: 40%">
									<span class="sr-only">40% Complete (success)</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">펀드 완료 건수</div>
								<div class="percent">6건</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-warning"
									role="progressbar" aria-valuenow="60" aria-valuemin="0"
									aria-valuemax="100" style="width: 60%">
									<span class="sr-only">60% Complete (warning)</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">이번달 기부 모금액</div>
								<div class="percent">600,000원</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-info" role="progressbar"
									aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"
									style="width: 20%">
									<span class="sr-only">20% Complete</span>
								</div>
							</div>
					</a></li>
					<li><a href="index.html#">
							<div class="task-info">
								<div class="desc">이번달 거래금</div>
								<div class="percent">800,000원</div>
							</div>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-danger" role="progressbar"
									aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
									style="width: 60%">
									<span class="sr-only">60% Complete (Important)</span>
								</div>
							</div>
					</a></li>
					<li class="external"><a href="#">모두 확인했습니다.</a></li>
				</ul></li>
			<!-- settings end -->

			<!-- inbox dropdown start-->
			<li id="header_inbox_bar" class="dropdown"><a
				data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
					<i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
			</a>
				<ul class="dropdown-menu extended inbox">
					<div class="notify-arrow notify-arrow-green"></div>
					<li>
						<p class="green">5건의 기부신청단체가 있습니다.</p>
					</li>
					<li><a href="index.html#"> <span class="photo"><img
								src="${hostImage}/donate1.jpg"></span> <span class="subject">
								<span class="from">국내아동지원</span> <span class="time">지금 막</span>
						</span> <span class="message"> 어린이 도움재단 입니다. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								src="${hostImage}/donate2.jpg"></span> <span class="subject">
								<span class="from">해외아동지원</span> <span class="time">40 분전</span>
						</span> <span class="message"> 아프리카 어린이모금단체 입니다. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								src="${hostImage}/donate3.png"></span> <span class="subject">
								<span class="from">북한아동지원</span> <span class="time">2 시간
									전</span>
						</span> <span class="message"> 꿈나무 어린이 보육원 입니다. </span>
					</a></li>
					<li><a href="index.html#"> <span class="photo"><img
								src="${hostImage}/donate4.jpg"></span> <span class="subject">
								<span class="from">나눔 SOS</span> <span class="time">4 시간
									전</span>
						</span> <span class="message"> 교회단체 입니다. </span>
					</a></li>
					<li><a href="#">모두 확인 했습니다.</a></li>
				</ul></li>
			<!-- inbox dropdown end -->

		</ul>
		<!--  notification end -->
	</div>
	</header>
	<!--header end-->
	<!--sidebar start-->
	<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<p class="centered">
				<a href="HostMain.ad"> <img src="${hostImage}/farmHost.png"
					width="60"></a>
			</p>
			<h5 class="centered">관리자</h5>
			<!-- <li class="mt">
                <a class="active" href="#">
                    <i class="fa fa-dashboard"></i>
                    <span>기본</span>
                </a>
                <ul class="sub">
                    <li><a href="general.html">General</a></li>
                    <li><a href="buttons.html">Buttons</a></li>
                    <li><a href="panels.html">Panels</a></li>
                </ul> 
            </li> -->

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-desktop"></i> <span>펀드 관리</span>
			</a>
				<ul class="sub">
					<li><a href="NoFundList.ad">미등록 펀드내역</a></li>
					<li><a href="FundList.ad">펀드 진행내역</a></li>
					<li><a href="FundList_end.ad">펀드 완료내역</a></li>
				</ul></li>

			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-cogs"></i> <span>경매 관리</span>
			</a>
				<ul class="sub">
					<li><a href="NoAucList.ad">미등록 경매내역</a></li>
					<li><a href="AucList.ad">경매 진행내역</a></li>
					<li><a href="AucList_end.ad">경매 완료내역</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-book"></i> <span>회원 관리</span>
			</a>
				<ul class="sub">
					<li><a href="GuestManage.ad">일반회원 관리</a></li>
					<li><a href="PartnerManage.ad">파트너 관리</a></li>
				</ul></li>
				
			<li class="sub-menu"><a href="GuestManage.ad"> <i class="fa fa-th"></i> 
			<span>결제 관리</span>
			</a></li>
			
			<li class="sub-menu"><a href="GuestManage.ad"> <i class="fa fa-th"></i> 
			<span>배송 관리</span>
			</a></li>
		
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-th"></i> <span>정산</span>
			</a>
				<ul class="sub">
					<li><a href="FundTotal.ad">펀드</a></li>
					<li><a href="AucTotal.ad">경매</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class=" fa fa-bar-chart-o"></i> <span>게시판 관리</span>
			</a>
				<ul class="sub">
					<li><a href="Notice">공지사항</a></li>
					<li><a href="#">문의 게시판[파트너]</a></li>
					<li><a href="#">문의 게시판[회원]</a></li>
					<li><a href="#">소식 게시판</a></li>
					<li><a href="#">요청 게시판</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class=" fa fa-bar-chart-o"></i> <span>기부</span>
			</a>
				<ul class="sub">
					<li><a href="DonateList.ad">기부 내역</a></li>
					<li><a href="DonateConList.ad">기부 업체현황</a></li>
					<li><a href="DonateTotal.ad">기부 현황</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class=" fa fa-bar-chart-o"></i> <span>주말농장</span>
			</a>
				<ul class="sub">
					<li><a href="WeekFarmManage.ad">주말농장 관리</a></li>
					<li><a href="IOTManage.ad">IoT</a></li>
				</ul></li>
			<li><a href="logout"> <i class="fa fa-dashboard"></i> <span>로그아웃</span>
			</a></li>

		</ul>
		<!-- sidebar menu end-->
	</div>
	</aside>
	<!--sidebar end-->

</body>
</html>