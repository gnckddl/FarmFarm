<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>

<html>
<!-- 부트스트랩 js -->
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<body>
	<header>
		<%@include file="../Header.jsp"%>
	</header>
	<div style="float: left;">
		<%@include file="../MemberSideBar.jsp"%>
	</div>


	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<h1 align="center">펀드 랭킹</h1>
				<br><br>
				<div class="table-responsive">
					<table id="mytable" class="table table-bordred table-striped">
						<thead>
							<tr>
								<td align="center"><b>순위</b></td>
								<td align="center"><b>펀드개설 농부</b></td>
								<td align="center"><b>펀드명</b></td>
								<td align="center"><b>펀드 상품</b></td>
								<td align="center"><b>목표 금액 / 참여 금액</b></td>
								<td align="center"><b>참여 인원</b></td>
								<td align="center"><b>종료 날짜</b></td>
							</tr>
						</thead>

						<tbody>
							<c:set var="i" value="1"/>
							<c:forEach var="dto" items="${dtos}">
								
								<tr>
									<td align="center">${i}</td>
									<td align="center">${dto.farmer_id}</td>
									<td align="center">${dto.fund_title}</td>
									<td align="center">${dto.stock_name}</td>									
									<td align="center">${dto.fund_price} / ${dto.stock_price * dto.fund_join} </td>
									<td align="center">${dto.fund_join} 명</td>
									<td align="center">${dto.fund_endDate}</td>
								</tr>								
								<c:set var="i" value="${i+1}"/>
							</c:forEach>

						</tbody>

					</table>
					

				</div>

			</div>
		</div>
	</div>
	
	<footer>
		<%@include file="../Footer.jsp"%>
	</footer>

</body>
</html>