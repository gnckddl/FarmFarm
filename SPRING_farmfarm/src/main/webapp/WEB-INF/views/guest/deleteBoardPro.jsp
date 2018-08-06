<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>글 삭제</h2>
	<c:if test="${deleteCnt !=1 }">
		<script type="text/javascript">
			alert("글삭제 실패했습니다.")
		</script>
	</c:if>
	
	<c:if test="${deleteCnt == 1 }">
		<script type="text/javascript">
			alert("글이 삭제되었습니다")
			window.location='RequestBoard?pageNum=${pageNum}&boa_id=${boa_id}&number=${number}&boa_category=${boa_category}';
			
		</script>
	</c:if>
</body>
</html>