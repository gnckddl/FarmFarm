<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">

<!--스크립트 공통부분  -->
  <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
<!--스크립트 공통부분  -->

<script type="text/javascript">
function fn_toggle() {
	window.location = 'LTFarmerLetters';
}
</script>


<!-- 페이지 자체 자바스크립트 끝 -->
<!-- 페이지 내 자체 CSS -->
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	P { 
		font-family: 'Nanum Pen Script', cursive; 
		}
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */

#insertUserletter{
   width: 140px;
   margin-left: 200px;
}
#replyletters{
margin-right: 20px;margin-left: 30px;
width: 140px;
}
.btn-login {
background-color: #59B2E0;
outline: none;
color: #fff;
font-size: 14px;
height: auto;
font-weight: normal;
padding: 14px 0;
text-transform: uppercase;
border-color: #59B2E6;
	}
	
.btn-login:hover,
.btn-login:focus {
color: #fff;
background-color: #1CA347;
border-color: #1CA347;
}

#reset{
width: 102px;
height: 31px;
padding-bottom: 5px;
padding-top: 5px;
}

#button{
width: 102px;
height: 31px;
padding-top: 5px;
padding-bottom: 5px;
}

</style>
<!-- 페이지 내 자체 CSS END-->

</head>
<title>답변완료 쪽지함</title>
</head>
<body>
<!-- 헤더시작 -->
<header>
	<%@include file="../../Header.jsp" %>
</header>
<!-- 헤더끝 -->

<br><br><br><br>
<!-- 리스트 출력 시작 -->
<div class="container">
	<input type="hidden" name="mem_id" value="${mem_id}">
    <table class="table table-board">
    	<h1><p>&nbsp;&nbsp;답변 완료 쪽지함</p></h1>
    	
	    <tr align="center">
			<td style="width:10%;"><b>번호</b></td>
			<td style="width:15%;"><b>제목</b></td>
			<td style="width:15%;"><b>회원ID</b></td>
			<td style="width:15%;"><b>담당농부</b></td>
			<td style="width:15%;"><b>작성일</b></td>
		</tr>
		<!-- 농부로부터의 쪽지가 있을 경우 -->
		<c:if test="${cnt > 0}">
			<c:forEach var="dto" items="${dtos}"><!--큰바구니에서 작은 바구니를 꺼내서 아래서 출력 , 건수만큼 반복해라-->
				<tr>
					<!-- 2.번호 -->
					<td align="center">
						${number}
					<c:set var="number" value="${number -1}"/>
					</td>
					<!-- 3.제목 클릭시 (상세 메시지 보기로 연결)-->
					<td align="center">
						<a href="LTFarmerContentsForm?boa_id=${dto.boa_id}&pageNum=${pageNum}"onclick="window.open(this.href, '_blank','width=600,height=700,toolbars=no,scrollbars=no'); return false;">${dto.boa_subject}</a>
					</td>
					<!-- 4.작성자 -->
					<td align="center">
						${dto.mem_id}
					</td>
					
					<!-- 5.수신자 -->
					<td align="center">
						${dto.letter_id}
					</td>
					<!-- 6.작성일/시간 -->
					<td align="center">
						${dto.boa_regDate}
					</td>
				</tr>
			</c:forEach>
		</c:if>
			<!-- 쪽지함이 비었을 때  -->
		<c:if test="${cnt == 0}">
			<tr>
				<td colspan="6" align="center">
					EMPTY LETTERS!
				</td>
			</tr>
		</c:if>
    </table>
    <!-- 페이지 컨트롤 -->
    <table style="width:1000px" align="center">
		<tr>
			<td align="center">
				<c:if test="${cnt>0}">
					<!--[◀◀]처음 /이전블록[◀]  -->
					<c:if test="${startPage > pageBlock}">
						<a href="LTFarmerLetters">[◀◀]</a>
						<a href="LTFarmerLetters?pageNum=${startPage - pageBlock}">[◀]</a>
					</c:if>
					
					<c:forEach var ="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
							<span><b>[${i}]</b></span>
						</c:if>
						
						<c:if test="${i != currentPage}">
							<a href="LTFarmerLetters?pageNum=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<!--다음블로[▶▶] / 끝[▶]  -->
					<c:if test="${pageCount > endPage}">
						<a href="LTFarmerLetters?pageNum=${startPage + pageBlock}">[▶]</a>
						<a href="LTFarmerLetters?pageNum=${pageCount}">[▶▶]</a>
					</c:if>
				</c:if>	
			</td>	
		</tr>
	</table>
    
    <div class="huge-top">
    	<div style="margin-left:800px; margin-bottom: 10px;">
    		<tr>
    			<td>
        			<button class="form-control btn btn-login" id="insertUserletter" onclick="javascript:fn_toggle();">회원문의 쪽지함</button>
        		</td>
    		</tr>    
    	</div>
	</div>
	</div>








 <!-- 4.푸터 -->
    <footer>
	<%@include file="../../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 
</body>
</html>