<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기부업체 현황</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<section id="main-content">
		<section class="wrapper">
		<h3>
			<i class="fa fa-angle-right"></i> 기부업체 현황
		</h3>
		<div class="row">
			<!-- 기부업체 현황 시작 -->
			<div class="col-md-12 mt">
				<div class="content-panel">
					<table class="table table-hover">
						<h4>
							<i class="fa fa-angle-right"></i> 기부업체 현황 (${cnt}건)
						</h4>
						
						<thead>
							<tr>
								<td colspan="7"></td>
								<td>
									<button type="button" class="btn btn-theme04" onclick="window.location='DonateWriteForm.ad?pageNum=${pageNum}'">
                                        	<i class="fa fa-heart"></i> 기부단체 등록
                           			</button>
								</td>
							</tr>
							<tr>
								<th style="width: 1%"><input type="checkbox" id="checkall"></th>
								<th style="width: 5%">번호</th>
								<th style="width: 5%">로고</th>
								<th style="width: 15%">이름</th>
								<th style="width: 10%">담당자</th>
								<th style="width: 10%">등록일</th>
								<th style="width: 10%">총 기부 금액</th>
								<th style="width: 3%">관리</th>
							</tr>
						</thead>
						<tbody>
						 <!-- 게시글이 있으면 -->
                           <c:if test="${cnt>0}"> 
                           <c:if test="${d_state != 0}">
                           <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
                              <c:forEach var="dto" items="${dtos}">
                                  <tr>
                                 	 <td><input type="checkbox" class="checkthis"></td>
                                     <td>${number}
										<c:set var="number" value="${number-1}"/>	
                                     </td>
                                     <td><img src="${hostImage}/${dto.doOrg_image}" width="100px"></td>
                    				 <td>${dto.doOrg_name}</td>
                                     <td>${dto.doOrg_person}</td>
                                     <td>${dto.doOrg_regDate}</td>
                                     <td>${dto.doOrg_account}</td>
                                     <td>                     
                                        <button type="button" class="btn btn-primary" onclick="window.location='donateModifyView.ad?pageNum=${pageNum}&doForm_id=${dto.doForm_id}'">
                                        	<i class="fa fa-cog"> 수정</i>
                                        </button>
                             			<button type="button" class="btn btn-default" onclick="window.location='donateDeletePro.ad?pageNum=${pageNum}&doForm_id=${dto.doForm_id}'">
                                        	<i class="fa fa-times"></i> 삭제
                           				</button>
                             		</td>
                                 </tr>
                               </c:forEach>
                            </c:if>
                            </c:if>
                            <!-- 게시글이 없으면 -->
                           <c:if test="${cnt==0}">
                              <tr>
                                 <td colspan="6" align="center">
                                   	 기부 단체가 없습니다.!!
                                 </td>
                              </tr>
                           </c:if>
						</tbody>
					</table>
				</div>
				<!--/content-panel -->
			</div>
			<!-- /col-md-12 -->
			<!-- 기부업체 현황 끝 -->
		</div>
		<!-- row -->
	
		<!-- 페이지 컨트롤 시작 -->
		<c:if test="${cnt>0 }">
			<div class="clearfix"></div>
			<ul class="pagination pull-right">
			<c:if test="${startPage > pageBlock}">
				<li class="disabled"><a href="DonateConList.ad?${startPage - pageBlock}">
				<span class="glyphicon glyphicon-chevron-left"></span></a></li>
			</c:if>
						
				<c:forEach var ="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == currentPage}">
						<li class="active"><a href="DonateConList.ad?pageNum=${i}">${i}</a></li>
					</c:if>
					
					<c:if test="${i != currentPage}">
						<li><a href="DonateConList.ad?pageNum=${i}">${i}</a></li>
					</c:if>
				</c:forEach>
				
				<c:if test="${pageCount > endPage}">
				<li><a href="DonateConList.ad?pageNum=${startPage + pageBlock}"><span
						class="glyphicon glyphicon-chevron-right"></span></a></li>
				</c:if>
			</ul>
		</c:if>
		<!-- 페이지 컨트롤 종료 -->
		</section>
	</section>

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>

</body>
</html>