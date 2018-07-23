<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">
</head>
<title>고객 쪽지 테이블</title>
<script type="text/javascript">
//체크박스 동작을 위한 자바스크립트
  function allcheck(obj){
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

//﻿2. 체크박스 선택된 것 삭제 처리 (N개) 
   function fn_userDel(){
	var chkFirList = document.getElementByName("RowCheck");
	var arrFir = new Array();
	var cnt = 0;
	for(var idx=chkFirList.length - 1; 0 <= idx; idx--){
		if(chkFirList[idx].checked){
			arrF
		}
	}
  
  } 
</script>﻿
<body>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->


<!-- 사이드메뉴 -->
<div style="float:left; ">
	<%@include file="../MemberSideBar.jsp" %>		
</div>
<!-- 사이드 메뉴 끝 -->


<br><br><br><br>
<!-- 리스트 출력 시작 -->
<div class="container">
    <table class="table table-board">
    	<h1><p>&nbsp;&nbsp;농부님께 보낸 쪽지</p></h1>
	    <tr align="center">
			<td style="width:7%;"><input type="checkbox" name="RowCheck" id="allcheck" onclick="allcheck(this)" value="${dto.letternum}"></td>
			<td style="width:10%;"><b>번호</b></td>
			<td style="width:15%;"><b>제목</b></td>
			<td style="width:15%;"><b>작성자</b></td>
			<td style="width:15%;"><b>작성일</b></td>
		</tr>
		<!-- 농부로부터의 쪽지가 있을 경우 -->
		<c:if test="${cnt > 0}">
			<c:forEach var="dto" items="${dtos}"><!--큰바구니에서 작은 바구니를 꺼내서 아래서 출력 , 건수만큼 반복해라-->
				<tr>
					<!-- 1.체크박스 -->
					<td align="center">
						<input type="checkbox" name="RowCheck" id="allcheck" onclick="allChk(this)" value="${dto.letternum}">
					</td>
					
					<!-- 2.번호 -->
					<td align="center">
						${dto.letternum}
					</td>
					<!-- 3.제목 클릭시 (상세 메시지 보기로 연결)-->
					<td align="center">
						<a href="LTContentsForm?letternum=${dto.letternum}&pageNum=${pageNum}">${dto.lettersubject}</a> 
					</td>
					
					<!-- 4.작성자 -->
					<td align="center">
						${dto.letterwritter}
					</td>
					<td align="center">
						<fmt:formatDate type="both" pattern="yyyy-MM-dd HH:mm" value="${dto.letterreg_date}"/>					
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
	<%@include file="../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 
</body>
</html>