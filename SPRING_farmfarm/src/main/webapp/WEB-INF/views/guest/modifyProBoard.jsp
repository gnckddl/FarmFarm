<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>글 수정</h2>
	<c:if test="${updateCnt !=1 }">
		<script type="text/javascript">
			alert("글수정 실패했습니다.")
		</script>
	</c:if>
	
	<c:if test="${updateCnt == 1 }">
		<script type="text/javascript">
			alert("글이 수정되었습니다")
			window.location='RequestBoardContent?pageNum=${pageNum}&boa_id=${boa_id}&number=${number}&boa_category=${boa_category}';
			
		</script>
	</c:if>
</body>
</html>