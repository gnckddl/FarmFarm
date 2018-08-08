<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>

<table style="margin-left: 27%">
	<c:forEach var="item" items="${dtos }">
	<tr>
		<th>
			<c:if test="${item.mem_id==sessionScope.userId}">
				<b style="color:blue;"><fmt:formatNumber value="${item.join_aucPrice}" pattern="#,###,###"/> / <fmt:formatDate value="${item.join_regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></b>
			</c:if>
			<c:if test="${item.mem_id!=sessionScope.userId}">
				<fmt:formatNumber value="${item.join_aucPrice}" pattern="#,###,###"/> / <fmt:formatDate value="${item.join_regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
			</c:if>
		</th>
	</tr>
	</c:forEach>
</table>