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
<!-- 토글을 위한 부트스트랩 버튼 -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>


<!--스크립트 공통부분  -->
  <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
  <script src="resources/js/bootstrap.js"></script>
<!--스크립트 공통부분  -->



<!-- 페이지 내 자체 CSS -->
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
	P { 
		font-family: 'Nanum Pen Script', cursive; 
		}
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */
#insert{
width: 140px;
}
#delete{
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

<script type="text/javascript">
	//1. 전체 선택 구현을 위한 자바스크립트
function allChk(obj){
    var chkObj = document.getElementsByName("RowCheck");
    var rowCnt = chkObj.length - 1;
    var check = obj.checked;
    if (check) {﻿
        for (var i=0; i<=rowCnt; i++){
         if(chkObj[i].type == "checkbox")
             chkObj[i].checked = true; 
        }
    } else {
        for (var i=0; i<=rowCnt; i++) {
         if(chkObj[i].type == "checkbox"){
             chkObj[i].checked = false; 
         }
        }
    }
} 

﻿ ﻿ 

	//﻿2. 체크박스 선택된 것 삭제 처리 (N개) 
	function fn_userDel() {
		var boa_id = null;
		var result = "";

		boa_id = document.getElementsByName("RowCheck");
		for (var i = 0; i < boa_id.length; i++) {
			if (boa_id[i].checked == true) {
				result += boa_id[i].value + ",";
			}
		}
		window.location = 'LTDeletePro?result=' + result;
	}
	
</script>


</head>
<title>토지임대 신청 현황</title>
<body>
<!-- 헤더시작 -->
	<%@include file="../../Header.jsp" %>
<!-- 헤더끝 -->



<br><br><br><br>
<!-- 리스트 출력 시작 -->
<div class="container">
    <table class="table table-board">
    	<h1><p>&nbsp;&nbsp;주말농장 신청현황</p></h1>
	    <tr align="center">
			<td style="width:7%;"><input id="allCheck" type="checkbox" onclick="allChk(this);"/></td>
			<td style="width:10%;"><b>번호</b></td>
			<td style="width:15%;"><b>농장 닉네임</b></td>
			<td style="width:15%;"><b>신청인</b></td>
			<td style="width:15%;"><b>임대금액</b></td>
			<td style="width:15%;"><b>결과확인</b></td>
		</tr>
		<!-- 농부로부터의 쪽지가 있을 경우 -->
		<c:if test="${cnt > 0}">
			<c:forEach var="dto" items="${dtos}"><!--큰바구니에서 작은 바구니를 꺼내서 아래서 출력 , 건수만큼 반복해라-->
				<tr>
					<!-- 1.체크박스 -->
					<td align="center">
						<input id="allCheck" type="checkbox" name="RowCheck" value="${dto.wfarm_key}"/>
					</td>
					
					<!-- 2.번호 -->
					<td align="center">
						${number}
						<c:set var="number" value="${number -1}"/>
					</td>
					<!-- 3.농장 닉네임-->
					<td align="center">
						${dto.wfarminfo_title}
					</td>
					<!-- 4.신청인 -->
					<td align="center">
						${dto.mem_id}
					</td>
					
					<!-- 5.임대금액 -->
					<td align="center">
						${dto.wfarmInfo_price}
					</td>
					
					
					<!-- 6.임대결과 -->
					 <c:if test="${dto.wfarm_status == 1}">
					<td align="center">
					<button type="button" class="btn btn-primary" data-toggle="button" .active aria-pressed="true" autocomplete="off">
					승인대기</button>
					</td>
					</c:if>
					
					<c:if test="${dto.wfarm_status == 2}">
					<td align="center">
					<button type="button" class="btn btn-primary" data-toggle="button" .active aria-pressed="true" autocomplete="off">
					승인</button>
					</td> 
					</c:if> 
					</tr>
			</c:forEach>
		</c:if>
			<!-- 쪽지함이 비었을 때  -->
		<c:if test="${cnt==0}">
			<tr>
				<td colspan="6" align="center">
					EMPTY WEEKFARM!
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
						<a href="ConfirmWeekFarm">[◀◀]</a>
						<a href="ConfirmWeekFarm?pageNum=${startPage - pageBlock}">[◀]</a>
					</c:if>
					
					<c:forEach var ="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
							<span><b>[${i}]</b></span>
						</c:if>
						
						<c:if test="${i != currentPage}">
							<a href="ConfirmWeekFarm?pageNum=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<!--다음블로[▶▶] / 끝[▶]  -->
					<c:if test="${pageCount > endPage}">
						<a href="ConfirmWeekFarm?pageNum=${startPage + pageBlock}">[▶]</a>
						<a href="ConfirmWeekFarm?pageNum=${pageCount}">[▶▶]</a>
					</c:if>
				</c:if>	
			</td>	
		</tr>
	</table>
	</div>

 <!-- 4.푸터 -->
    <footer>
	<%@include file="../../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 
</body>
</html>