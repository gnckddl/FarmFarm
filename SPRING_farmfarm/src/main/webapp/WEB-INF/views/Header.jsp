<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="setting.jsp"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">

<!-- Bootstrap core CSS -->
<link href="resources/css/assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->

<!-- ***추가 끝css  -->
<body>
	<!-- 헤더시작 -->
	<nav class="navbar navbar-default">
		<!-- 가장 기본적인 형태의 네비게이션 바 -->
		<nav class="container-fluid">
			<!-- ****헤더 토글 추가  -->
			<c:if test="${sessionScope.grade!=null }">

			</c:if>
			<!-- ****헤더 토글 추가 끝 -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
					<!--  <span class="icon-bar"></span>
           <span class="icon-bar"></span> -->
				</button>
				<a href="FarmFarm"><img src="resources/images/farm3.PNG"
					style="width: 130px; height: 60px;"></a>&nbsp;&nbsp;
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<!-- 링크작업 -->
				<ul class="nav navbar-nav">
					<!-- active는 소개라는 탭에 글자가 진해지도록 조정하는 기능을 함 -->
					<li><a href="FundProducts">펀드상품보기<span
							class="sr-only"></span></a></li>
					<li><a href="AuctionItem">경매상품보기</a></li>


					<li><a href="IntrFarmFarm">팜팜소개</a></li>
					<li><a href="Donate">기부소개</a></li>
					<li><a href="BecomeFarmer">농부되기</a>
					<li><a href="WeekFarmApply">주말농장</a></li>
					<li class="dropdown">
						<!-- 아래쪽으로 리스트가 추가되어 나온다 -->
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">게시판<span
							class="caret"></span></a>
					<!-- caret : 아래 화살표 클릭시 아이콘이 나오게 함 -->
						<ul class="dropdown-menu">
							<li><a href="memberQuestionBoard?boa_category=2">회원문의게시판</a>
							<li><a href="farmerQuestionBoard?boa_category=3">농부문의게시판</a>
							<li><a href="NewsBoard?boa_category=4">소식게시판</a>
							<li><a href="RequestBoard?boa_category=5">요청게시판</a>
						</ul>
					<li class="dropdown">
						<!-- 아래쪽으로 리스트가 추가되어 나온다 -->
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-haspopup="true" aria-expanded="false">랭킹<span
							class="caret"></span></a>
					<!-- caret : 아래 화살표 클릭시 아이콘이 나오게 함 -->
						<ul class="dropdown-menu">
							<li><a href="FundRanking">펀드랭킹</a></li>
							<li><a href="AuctionRanking">경매랭킹</a></li>
							<li><a href="DonateRanking">기부랭킹</a></li>
						</ul> <!-- <li class="dropdown">
                  아래쪽으로 리스트가 추가되어 나온다<a href="#" class="dropdown-toggle"
                  data-toggle="dropdown" role="button" aria-haspopup="true"
                  aria-expanded="false">임시주말농장(윅팜)<span class="caret"></span></a>caret : 아래 화살표 클릭시 아이콘이 나오게 함
                 <ul class="dropdown-menu">
                   <li><a href="WeekFarmManagement">주말농장관리</a></li>
                   <li><a href="IOT">IOT</a></li>
                 </ul> -->
					<li><a href="Notice">공지사항</a></li>
					<li><a href="Help">도움말</a></li>

				</ul>
				<form class="navbar-form navbar-left" method="post"
					action="searching">
					<div class="form-group">
						<input type="text" class="form-control" name="keyword"
							placeholder="내용을 입력하세요." style="font-size: 15px;">
						<!-- 힌트 -->
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>

				<!-- 네비게이션 바를 오른쪽 정렬을 하겠다. -->
				<ul class="nav navbar-nav navbar-right">
					<!-- 비회원 헤더 -->
					<%-- <c:if test="${sessionScope.userId==null}"> --%>
					<c:if
						test="${sessionScope.grade!=1 and sessionScope.grade != 2 and sessionScope.grade!=3}">
						<li class="dropdown"><a href="#" class="dropdown=toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">접속하기<span class="caret"></span></a> <!-- 
	              		접속하기<span class="caret">
	              		caret은 아래화살표 클릭시 아이콘이 나오도록 하는 기능
	               	 -->
							<ul class="dropdown-menu">
								<li><a href="loginForm">로그인</a></li>
								<li><a href="registerForm">회원가입</a></li>
							</ul>
					</c:if>

					<!-- 일반회원 헤더 -->
					<c:if test="${sessionScope.grade==1}">
						<li class="dropdown"><a href="#" class="dropdown=toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">마이페이지<span class="caret"></span></a> <!-- 
	              		접속하기<span class="caret">
	              		caret은 아래화살표 클릭시 아이콘이 나오도록 하는 기능
	               	 -->
							<ul class="dropdown-menu">
								<li><a href="updateInfoPage">마이 메뉴</a></li>
								<li><a href="logout">로그아웃</a></li>
							</ul>
					</c:if>

					<!-- 농부 헤더 -->
					<c:if test="${sessionScope.grade == 2}">
						<li class="dropdown"><a href="#" class="dropdown=toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"> <img
								src="resources/images/farmer/farmer.jpg" width="50px"
								height="50px"> <span class="caret"></span></a>

							<ul class="dropdown-menu">
	                	<li><a href="Farmer_Apply">신청</a></li>
	                	<li><a href="ChooseWeekFarm">주말농장신청</a></li>
	                	<li><a href= "ConfirmWeekFarm">신청현황보기</a></li>
	                    <li><a href= "FarmerScore">농부점수</a></li>
	                    <li><a href="Fund_status">펀드 현황및 이전내역</a></li>
	                	<li><a href="Auction_status">경매 현황및 이전내역</a></li>
	                    <li><a href="#">이용내역</a></li>
	                    <li><a href="#">프로필</a></li>
	                    <li><a href="#">지불정보</a></li>
	                    <li><a href="LTFarmerLetters">쪽지함</a></li>
	                    <li><a href="logout">로그아웃</a></li>
	                 </ul>
					</c:if>

					<!-- 관리자 헤더 -->
					<c:if test="${sessionScope.grade == 3}">
						<a href="HostMain.ad"> <img
							src="resources/images/host/farmHost.png" class="img-circle"
							width="40">
						</a>
					</c:if>
				</ul>
			</div>
		</nav>
	</nav>
	<!-- 헤더끝 -->
</body>
</html>