<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<html>
<script type="text/javascript">
function setId(id) {
	opener.document.registerForm.userId.value = id;
	self.close();
}
//중복확인 창에서 id입력체크
function confirmIdCheck() {
	if (!document.confirmForm.userId.value) {
		alert(msg_id);
		document.confirmForm.userId.focus();
		return false;
	}
}

</script>
<body>
<form action="confirmId" method="post" name="confirmForm"
		onsubmit="return confirmIdCheck();">
	
		<c:if test="${selectCnt==1}">
		<table>
			<tr>
				<th colspan="2">
					<span>${id}</span>사용할 수 없음
				</th>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input class="input" type="text" name="userId" maxlength="20"
					style="width:100px"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
					<input class="inputButton" type="submit" value="확인">
					<input class="inputButton" type="reset" value="취소" onclick="self.close();">				
				</th>
			</tr>
		</table>
		</c:if>
		<c:if test="${selectCnt!=1}">
			<table>
				<tr>
					<td align="center"><span>${id }</span>는 사용할 수 있음</td>
				</tr>
				<tr>
					<th>
						<!-- 부모로 넘길 id set -->
						<input class="inputButton" type="button" value="확인" onclick="setId('${id}');">
					</th>
				</tr>
			</table>	
		</c:if>
	</form>	
</body>
</html>