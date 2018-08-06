<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>내 주말농장 신청 현황</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
</head>
<body>


<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->

<!-- 사이드메뉴 시작 -->
	<%@include file="../MemberSideBar.jsp" %>
<!-- 사이드 메뉴 끝 -->

	<div class="container">
		<div class="row">
			<p></p>
			<h1 align="center">내 주말농장 신청 현황</h1>
			<p align="center">고객님이 신청하신 주말농장 신청 현황입니다.</p>


			<div class="col-md-10 col-md-offset-1">

				<div class="panel panel-default panel-table">
					<div class="panel-heading">
						<div class="row">
							<div class="col col-xs-6">
								<h4 class="panel-title">목차</h4>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<table class="table table-striped table-bordered table-list">
							<thead>
								<tr>
									<th style="width: 7%";>번호</em></th>
									<th style="width: 29%";>신청 농장명</th>
									<th style="width: 9%";>농장주</th>
									<th style="width: 9%";>임대금액</th>
									<th style="width: 31%">주소(추후 주소API필요)</th>
									<th style="width: 9%">결과확인</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${cnt > 0}">
									<c:forEach var="dto" items="${dtos}">
										<tr>
											<!-- 1.번호 -->
											<td align="left">${number}
											<c:set var="number" value="${number-1}"/></td>
											<!-- 2.신청 농장명 -->
											<td class="hidden-xs">${dto.wfarminfo_title}</td>
											<!-- 3.농장주 -->
											<td>${dto.mem_id}</td>
											<!-- 4.임대금액 -->
											<td>${dto.wfarminfo_price}</td>
											<!-- 5. 주소 -->
											<td>${dto.wfarminfo_add}</td>
											<!-- 6.임대결과 -->
											<c:if test="${dto.wfarm_status == 1}">
												<td align="center">
													<button type="button" class="btn btn-primary"
														data-toggle="button" .active aria-pressed="true"
														autocomplete="off">승인대기</button>
												</td>
											</c:if>

											<c:if test="${dto.wfarm_status == 2}">
												<td align="center">
													<button type="button" class="btn btn-primary"
														data-toggle="button" .active aria-pressed="true"
														autocomplete="off">승인</button>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</c:if>
								<!-- 쪽지함이 비었을 때  -->
								<c:if test="${cnt==0}">
									<tr>
										<td colspan="6" align="center">신청하신 주말농장이 존재하지 않습니다!</td>
									</tr>
								</c:if>

							</tbody>
						</table>

						<!-- 페이지 컨트롤 -->
						<table style="width: 1000px" align="center">
							<tr>
								<td align="center"><c:if test="${cnt>0}">
										<!--[◀◀]처음 /이전블록[◀]  -->
										<c:if test="${startPage > pageBlock}">
											<a href="CustomerWeeklyFarmlist">[◀◀]</a>
											<a
												href="CustomerWeeklyFarmlist?pageNum=${startPage - pageBlock}">[◀]</a>
										</c:if>

										<c:forEach var="i" begin="${startPage}" end="${endPage}">
											<c:if test="${i == currentPage}">
												<span><b><a href="CustomerWeeklyFarmlist?pageNum=${i}">[${i}]</a></b></span>
											</c:if>

											<c:if test="${i != currentPage}">
												<a href="CustomerWeeklyFarmlist?pageNum=${i}">[${i}]</a>
											</c:if>
										</c:forEach>

										<!--다음블로[▶▶] / 끝[▶]  -->
										<c:if test="${pageCount > endPage}">
											<a
												href="CustomerWeeklyFarmlist?pageNum=${startPage + pageBlock}">[▶]</a>
											<a href="CustomerWeeklyFarmlist?pageNum=${pageCount}">[▶▶]</a>
										</c:if>
									</c:if></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>
	<!-- 4.푸터 -->
    <footer>
	<%@include file="../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 

</body>
</html>