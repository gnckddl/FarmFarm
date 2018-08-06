<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<!-- 페이지 내 자체 CSS -->
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
<body>
  
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
<title>내가 보낸 쪽지</title>
<body>
<!-- 헤더시작 -->
	<%@include file="../../Header.jsp" %>
<!-- 헤더끝 -->


<!-- 사이드메뉴 -->
<div style="float:left; ">
	<%@include file="../../MemberSideBar.jsp" %>		
</div>
<!-- 사이드 메뉴 끝 -->


<br><br><br><br>
<!-- 리스트 출력 시작 -->
<div class="container">
    <table class="table table-board">
    	<h1><p>&nbsp;&nbsp;농부님께 보낸 쪽지함</p></h1>
	    <tr align="center">
			<td style="width:7%;"><input id="allCheck" type="checkbox" onclick="allChk(this);"/></td>
			<td style="width:10%;"><b>번호</b></td>
			<td style="width:15%;"><b>제목</b></td>
			<td style="width:15%;"><b>작성자</b></td>
			<td style="width:15%;"><b>수신농부</b></td>
			<td style="width:15%;"><b>작성일</b></td>
		</tr>
		<!-- 농부로부터의 쪽지가 있을 경우 -->
		<c:if test="${cnt > 0}">
			<c:forEach var="dto" items="${dtos}"><!--큰바구니에서 작은 바구니를 꺼내서 아래서 출력 , 건수만큼 반복해라-->
				<tr>
					<!-- 1.체크박스 -->
					<td align="center">
						<input id="allCheck" type="checkbox" name="RowCheck" value="${dto.boa_id}"/>
					</td>
					
					<!-- 2.번호 -->
					<td align="center">
						${number}
						<c:set var="number" value="${number -1}"/>
					</td>
					<!-- 3.제목 클릭시 (상세 메시지 보기로 연결)-->
					<td align="center">
						<a href="LTContentsForm?boa_id=${dto.boa_id}&pageNum=${pageNum}"onclick="window.open(this.href, '_blank','width=600,height=700,toolbars=no,scrollbars=no'); return false;">${dto.boa_subject}</a>
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
		<c:if test="${cnt==0}">
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
						<a href="LetterList">[◀◀]</a>
						<a href="LetterList?pageNum=${startPage - pageBlock}">[◀]</a>
					</c:if>
					
					<c:forEach var ="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
							<span><b>[${i}]</b></span>
						</c:if>
						
						<c:if test="${i != currentPage}">
							<a href="LetterList?pageNum=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<!--다음블로[▶▶] / 끝[▶]  -->
					<c:if test="${pageCount > endPage}">
						<a href="LetterList?pageNum=${startPage + pageBlock}">[▶]</a>
						<a href="LetterList?pageNum=${pageCount}">[▶▶]</a>
					</c:if>
				</c:if>	
			</td>	
		</tr>
	</table>
    
    <div class="huge-top">
    	<div style="margin-left:800px; margin-bottom: 10px;">
    		<tr>
    			<td>
        			<button class="form-control btn btn-login" id="insert" onclick="window.open('LTWriteForm', 'write','top=100px, left=100px, height=500px, width=500px')">쪽지보내기</button>
        		</td>
        		<td>
        			<button class="form-control btn btn-login" id="delete" onclick="javascript:fn_userDel();"style="margin-right: 20px">쪽지 삭제</button>
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