<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %> 
<html>
<link rel="stylesheet" href="resources/css/assets/bootstrap.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<body class="board-body">
<!-- 헤더시작 -->
<header>
	<%@include file="Header.jsp" %>
</header>
<!-- 헤더끝 -->

<!------ Include the above in your HEAD tag ---------->

<div class="container" style="height: 900px;">
	<div class="row">
		
        
        <div class="col-md-12">
        <h4 align="center" style="margin-bottom:30px; color:#00A58A;"><b>검색 내용</b></h4>
        <div class="table-responsive">

                
    <table id="mytable" class="table table-bordred table-striped">
         
        <tr align="center">
         <td style="width:10%"><b>거래 종류</b></td>
          <td style="width:20%"><b>이미지</b></td>
           <td style="width:7%"><b>상품명</b></td>
           <td style="width:18%"><b>거래 상품명</b></td>
           <td style="width:10%"><b>가격</b></td>
           <td style="width:8%"><b>상품 종류</b></td>
           <td style="width:10%"><b>상품 상태</b></td>
           <td style="width:10%"><b>종료 날짜</b></td>
           <!--  <th>글쓰기</th>
             <th>삭제</th> -->
          </tr>   
    <tbody>
 <tr> 
 
 <!--게시글이 있으면  -->
 <c:if test="${cnt > 0}">
 	<c:forEach var="dto" items="${dtos}">
 		<c:if test="${dto.fund_no!=null }">
	 		<tr>
			 	<td align="center">
					펀드
				</td>
				
				<td align="center">
					<a href="#"><img src="${image}main/${dto.stock_image}"></a>
				</td>
				
				<td align="center">
					${dto.stock_name}
				</td>
				
				<td align="center">
					${dto.fund_title}
				</td>
				
				<td align="center">
					${dto.fund_price}<br>
					(펀드 목표액)
				</td>
				
				<td align="center">
					<c:choose>
						<c:when test="${dto.stock_kind==1}">이벤트</c:when>
						<c:when test="${dto.stock_kind==2}">농산</c:when>
						<c:when test="${dto.stock_kind==3}">축산</c:when>
						<c:when test="${dto.stock_kind==4}">수산</c:when>
						<c:when test="${dto.stock_kind==5}">건강/유기농</c:when>
						<c:when test="${dto.stock_kind==6}">버섯</c:when>
						<c:when test="${dto.stock_kind==7}">주류</c:when>
						<c:when test="${dto.stock_kind==8}">기타</c:when>
					</c:choose>
				</td>
				
				<td align="center">
					<c:choose>
						<c:when test="${dto.fund_status==1}">미등록</c:when>
						<c:when test="${dto.fund_status==2}">진행중</c:when>
						<c:when test="${dto.fund_status==3}">종료</c:when>
					</c:choose>
				</td>
				
				<td align="center">
					${dto.fund_endDate}
				</td>
				
	 		</tr>
	 	</c:if>
	 	<c:if test="${dto.auc_no!=null }">
	 		<tr>
			 	<td align="center">
					경매
				</td>
				
				<td align="center">
					<a href="AuctionItemContent?auc_no=${dto.auc_no}"><img style="width:200px;" src="${images}main/${dto.stock_image}"></a>
				</td>
				
				<td align="center">
					${dto.stock_name}
				</td>
				
				<td align="center">
					${dto.auc_title}
				</td>
				
				<td align="center">
					${dto.auc_nowPrice}<br>
					(현재경매가)
				</td>
				
				<td align="center">
					<c:choose>
						<c:when test="${dto.stock_kind==1}">이벤트</c:when>
						<c:when test="${dto.stock_kind==2}">농산</c:when>
						<c:when test="${dto.stock_kind==3}">축산</c:when>
						<c:when test="${dto.stock_kind==4}">수산</c:when>
						<c:when test="${dto.stock_kind==5}">건강/유기농</c:when>
						<c:when test="${dto.stock_kind==6}">버섯</c:when>
						<c:when test="${dto.stock_kind==7}">주류</c:when>
						<c:when test="${dto.stock_kind==8}">기타</c:when>
					</c:choose>
				</td>
				
				<td align="center">
					<c:choose>
						<c:when test="${dto.auc_status==1}">미등록</c:when>
						<c:when test="${dto.auc_status==2}">진행중</c:when>
						<c:when test="${dto.auc_status==3}">유찰</c:when>
						<c:when test="${dto.auc_status==4}">낙찰</c:when>
					</c:choose>
				</td>
				
				<td align="center">
					<%-- <!-- 등록일+경매기간해서 종료날짜계산  -->
					<!-- string>date형변환 -->
					<fmt:parseDate var="startDate" value="${dto.auc_regDate }" pattern="yyyy-MM-dd HH:mm" />
					<fmt:parseDate var="addDate" value="${dto.auc_term}" pattern="yyyy-MM-dd HH:mm" />
					<!-- date>number형변환 -->
					<fmt:parseNumber var="endDate" value="${(startDate.time+addDate.time)/(1000*60*60*24)}" integerOnly="true"/>
					<!-- 남은날짜 계산후 출력(남았는지,넘었는지 체크) --> --%>
					${dto.auc_endDate}
				</td>
				
	 		</tr>
	 	</c:if>
	 	
 	</c:forEach>
 </c:if>
 </tr>
    </tbody>
        
</table>


<!--게시글이 없으면  -->
<c:if test="${cnt==0}">
	<tr>
		<td colspan="6" align="center">
			검색 내용이 존재하지 않습니다.
		</td>
	</tr>
</c:if>
		
		
	<!-- 페이지 컨트롤 -->
	<c:if test="${cnt>0 }">
		<div class="clearfix"></div>
		<ul class="pagination pull-right">
		<c:if test="${startPage > pageBlock}">
			<li class="disabled"><a href="searching?${startPage - pageBlock}&keyword=${keyword}">
			<span class="glyphicon 	glyphicon-chevron-left"></span></a></li>
		</c:if>
					
			<c:forEach var ="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == currentPage}">
					<li class="active"><a href="#">${i }</a></li>
				</c:if>
				
				<c:if test="${i != currentPage}">
					<li><a href="searching?pageNum=${i}&keyword=${keyword}">${i}</a></li>
				</c:if>
			</c:forEach>
			<c:if test="${pageCount > endPage}">
			<li><a href="searching?pageNum=${startPage + pageBlock}&keyword=${keyword}"><span
					class="glyphicon glyphicon-chevron-right"></span></a></li>
			</c:if>
		</ul>
	</c:if>

                
            </div>
            
        </div>
	</div>
</div>



 <!-- 4.푸터 -->
    <footer >
	<%@include file="Footer.jsp" %>
    </footer>
   <!--푸터 끝  -->  
    
</body>
</html>