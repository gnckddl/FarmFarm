<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../setting.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${insertCnt == 0 }">
		<script type="text/javascript">
			errorAlert("요청하신 페이지를 응답할 수 없습니다.");
		</script>
	</c:if>

	<c:if test="${insertCnt != 0 }">
		<script type="text/javascript">
			alert("주말농장이 정상적으로 신청되셨습니다.");
			window.location = 'ConfirmWeekFarm';
		</script>
	</c:if>
</body>
</html>