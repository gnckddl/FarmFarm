<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>글 삭제</h2>
		<c:if test="${deleteCnt == 0 }">
			<script type="text/javascript">
				errorAlert("서비스 장애 에러");
			</script>
		</c:if>
	
	<c:if test="${deleteCnt != 0 }">
		<script type="text/javascript">
			alert("쪽지가 삭제되었습니다");
			window.location="LetterList";
		</script>
	</c:if>
</body>
</html>