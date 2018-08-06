<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<!--스크립트 공통부분  -->
  <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
<!--스크립트 공통부분  -->

<head>

<body>
	<header>
		<%@include file="../Header.jsp"%>
	</header>


	<div class="container">
		<div class="row">


			<div class="col-md-12">
				<h2 align="center">농부 점수 : ${sumPoint}</h2>
				<br><br>
				<div class="table-responsive">
					<table id="mytable" class="table table-bordred table-striped">
						<thead>
							<tr>
								<td align="center"><b>번호</b></td>
								<td align="center"><b>아이디</b></td>
								<td align="center"><b>변경 사유</b></td>
								<td align="center"><b>점수</b></td>
								<td align="center"><b>날짜</b></td>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="dto" items="${dtos}">
								<tr>
									<td align="center">${dto.rNum}</td>
									<td align="center">${dto.mem_id}</td>
									<td align="center"><c:if test="${dto.adv_reason==1}">펀드참여</c:if>
										<c:if test="${dto.adv_reason==2}">펀드취소</c:if> <c:if
											test="${dto.adv_reason==3}">경매참여</c:if> <c:if
											test="${dto.adv_reason==4}">경매취소</c:if> <c:if
											test="${dto.adv_reason==5}">이벤트</c:if></td>
									<td align="center">${dto.adv_point}</td>
									<td align="center">${dto.adv_regDate}</td>
								</tr>
								<c:set var="total" value="">
								</c:set>
							</c:forEach>

						</tbody>

					</table>
					
					
					<!-- 페이지 컨트롤 -->
					<c:if test="${cnt>0 }">
						<div class="clearfix"></div>
						<ul class="pagination pull-right">
						<c:if test="${startPage > pageBlock}">
							<li class="disabled"><a href="gusetAdv?${startPage - pageBlock}">
							<span class="glyphicon 	glyphicon-chevron-left"></span></a></li>
						</c:if>
									
							<c:forEach var ="i" begin="${startPage}" end="${endPage}">
								<c:if test="${i == currentPage}">
									<li class="active"><a href="#">${i }</a></li>
								</c:if>
								
								<c:if test="${i != currentPage}">
									<li><a href="gusetAdv?pageNum=${i}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pageCount > endPage}">
							<li><a href="guestAdv?pageNum=${startPage + pageBlock}"><span
									class="glyphicon glyphicon-chevron-right"></span></a></li>
							</c:if>
						</ul>
					</c:if>

				</div>

			</div>
		</div>
	</div>
	
	<footer>
		<%@include file="../Footer.jsp"%>
	</footer>

</body>
</html>