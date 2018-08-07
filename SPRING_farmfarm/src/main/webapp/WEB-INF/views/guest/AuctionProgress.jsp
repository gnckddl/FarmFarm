
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- 페이지 내 자체 CSS -->
<html>

<script src="${project}resources/request.js"></script>
<script type="text/javascript">
	var checkFirst = true;	//처음
	var loopSendKeyword = false;  // 작업완료후에 0.5초마다 반복했던 작업을 중단
	var lastKeyword = null; // 마지막 키워드
	
	function startSuggest() {
		if(checkFirst == true) { // 처음 
			loopSendKeyword = true;	// 0.5초마다 반복해라
			setTimeout("getPrice()", 500);
		}
		checkFirst = false;	// 작업 종료
	}
	
	function getPrice() {		
		if(loopSendKeyword == false) return false;
		var auc_no = document.progressForm.auc_no.value;		
		var parms = "auc_no=" + auc_no;
			
		sendRequest(result_callback, "AuctionProgressAjax", "GET", parms);
		//} 
		// 재귀호출.. function안에서 호출하므로 
		setTimeout("getPrice()", 500); // 실시간 제일 중요한 개념
	}
	
	// 콜백함수
	function result_callback() {
		var nowPrice = document.getElementById("nowPrice");
		
		if(httpRequest.readyState == 4) {  // completed : 전 데이터가 취득완료된 상태 
			if(httpRequest.status == 200) { // 정상종료
				
				var nPrice = "";
				var data = httpRequest.responseText; // 결과값..suggest.jsp의 list
				if( data !=null ) {
						nPrice = data;
						checkFirst = true;
					
					nowPrice.innerHTML = nPrice;
					
				} else {
					nowPrice.innerHTML = 0;				
				}				
			} else {
				nowPrice.innerHTML = "에러발생";
			}
		} else {
			nowPrice.innerHTML = "상태 : " + httpRequest.readyState;
		}	
	}

</script>

<head>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);
   P { 
      font-family: 'Nanum Pen Script', cursive; 
      }
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */

body {padding-top:20px;}

</style>
</head>
<body onload="startSuggest();">

<div class="container">
   <div class="row">
      <div class="col-md-6 col-md-offset-3">
        <div class="well well-sm">
          <form class="form-horizontal" name="progressForm" action="AuctionJoinPro" method="post">
          <fieldset>
            <legend class="text-center"><h2><P>경매 진행 내역</P></h2></legend>
          
    
            <!-- 작성자 input-->
        <legend style="font-size: 15px">
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">상품명</label>
              <div class="col-md-9">
              	<!-- 히든 -->
              	<input type="hidden" id="auc_no" name="auc_no" value="${auc_no }">
              	
                <input class="form-control" type="text" disabled="disabled" value="${dto.auc_title}" 
                	style="font-size:20px; margin-left: 20%; width: 65%">
              </div>
            </div>
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">시작가격</label>
              <div class="col-md-9">
                <input class="form-control" type="text"  disabled="disabled" value="<fmt:formatNumber value="${dto.auc_startPrice}" pattern="#,###,###"/>" style="font-size:20px; margin-left: 20%; width: 65%">
              </div>
            </div>
            <div class="form-group">
              <label class="col-md-3 control-label" for="email" name="mem_id">참여가격 / 날짜 <b style="color:blue;">(내 참여내역)</b></label>
              <div class="col-md-9" id="nowPrice">
              
              <%-- 
              	<table style="margin-left: 27%">
              		<c:forEach var="item" items="${dtos }">
              		<tr>
              			<th style="text-align: center;">
	              			<c:if test="${item.mem_id==sessionScope.userId}">
	              				<b style="color:blue;"><fmt:formatNumber value="${item.join_aucPrice}" pattern="#,###,###"/> / <fmt:formatDate value="${item.join_regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></b>
	              			</c:if>
	              			<c:if test="${item.mem_id!=sessionScope.userId}">
		              			<fmt:formatNumber value="${item.join_aucPrice}" pattern="#,###,###"/> / <fmt:formatDate value="${item.join_regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
		              		</c:if>
	              		</th>
	              	</tr>
              		</c:forEach>
              	</table>
              	 --%>
              </div>
            </div>
       	</legend>
       	
       	
        <!-- Form actions -->
            <div class="form-group">
              <div class="col-md-12 text-right">
                <input class="btn btn-primary btn-lg" type="button" value="닫기" onclick="self.close();">
              </div>
            </div>
          </fieldset>
          </form>
        </div>
      </div>
   </div>
</div>

</body>
</html>


