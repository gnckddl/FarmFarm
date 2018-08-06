<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<c:if test="${insertCnt==0}">
	<script type="text/javascript">
		alert("에러발생");
		window.history.back();
	</script>
</c:if>

<c:if test="${judge==false}">
	<script type="text/javascript">
		alert("입찰금액을 현재가보다 적게 입력하셨습니다");
		window.history.back();
	</script>
</c:if>

	<c:if test="${judge==true}">
		<c:if test="${insertCnt!=0}">
			<c:if test="${updateCnt==0}">
				<script type="text/javascript">
					alert("에러발생");
					window.history.back();
				</script>
			</c:if>
			
			<c:if test="${updateCnt!=0}">
				<script type="text/javascript">
					alert("입찰완료");
					opener.window.location="AuctionItemContent?auc_no=${auc_no}";
					self.close();
				</script>
			</c:if>
		</c:if>
	</c:if>


</body>
</html>