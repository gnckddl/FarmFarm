<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<h2 align="center">글쓰기 - 처리페이지</h2>
	
	<!--글쓰기 실패  -->
	<c:if test="${insertCnt==0}">
		<script type="text/javascript">
			alert("글내용을 작성해주세요");
		</script>
	</c:if>
	
	<!--글쓰기 성공  -->
	<c:if test="${insertCnt!=0}">
		<c:if test="${boa_category==2}">
		<c:redirect url="memberQuestionBoard?boa_category=${boa_category}&pageNum=${pageNum}"/>			
		</c:if>
		
		<c:if test="${boa_category==3}">
		<c:redirect url="farmerQuestionBoard?boa_category=${boa_category}&pageNum=${pageNum}"/>			
		</c:if>
		
		<c:if test="${boa_category==5}">
		<c:redirect url="RequestBoard?boa_category=${boa_category}&pageNum=${pageNum}"/>			
		</c:if>
	</c:if>
	
</body>
</html>