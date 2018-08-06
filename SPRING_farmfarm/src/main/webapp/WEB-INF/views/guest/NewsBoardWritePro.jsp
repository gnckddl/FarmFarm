<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<!--글쓰기 실패  -->
	<c:if test="${insertCnt==0}">
		<script type="text/javascript">
			alert("글쓰기실패");
		</script>
	</c:if>
	
	<!--글쓰기 성공  -->
	<c:if test="${insertCnt!=0}">
		<c:redirect url="NewsBoard?pageNum=${pageNum}&boa_category=${boa_category}"/>			
	</c:if>
	
</body>
</html>