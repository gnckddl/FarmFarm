<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>    
<html>
</head>
<body>
<%-- <c:if test="${insertCnt==0}">
	<script type="text/javascript">
		errorAlert(insertError);
		window.location="registerForm";
	</script>
</c:if>
<c:if test="${insertCnt==1}">
	<script type="text/javascript">
		alert("회원가입 성공");
		window.location="FarmFarm";
	</script>
</c:if> --%>

<c:if test="${cnt == 0}"> 
		<script type="text/javascript">
	
		alert("상품 등록에 실패하였습니다.");
		</script>
	</c:if>
	
	<c:if test="${cnt != 0}">
		
		<script type="text/javascript">
		alert("상품 등록 완료되었습니다.");
		window.location="Auction_Apply";
						
		</script>
	</c:if>


</body>
</html>