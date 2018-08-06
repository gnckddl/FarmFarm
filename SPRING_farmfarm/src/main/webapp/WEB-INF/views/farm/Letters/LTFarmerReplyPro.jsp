<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<h2 align="center">글쓰기 - 처리페이지</h2>
	
	<!--글쓰기 실패  -->
	<c:if test="${insertCnt==0}">
		<script type="text/javascript">
			errorAlert("글작성 실패");
		</script>
	</c:if>
	
	<!--글쓰기 성공  -->
	<c:if test="${insertCnt!=0}">
		<c:redirect url="LTFarmerLetters"/>
	</c:if>
</body>
</body>
</html>