<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<html>
<body>
<c:if test="${updateCnt==0}">
	<script type="text/javascript">
		errorAlert(updateError);
		window.location='updateInfoView';
	</script>
</c:if>
<c:if test="${updateCnt==1}">
	<script type="text/javascript">
		alert("회원정보수정 성공");
		window.location='FarmFarm';
	</script>
</c:if>
</body>
</html>