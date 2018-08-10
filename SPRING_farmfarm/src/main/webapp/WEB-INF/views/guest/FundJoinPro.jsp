<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>


         <c:if test="${updateCnt==0}">
            <script type="text/javascript">
               alert("에러발생2");
               window.history.back();
            </script>
         </c:if>
         
         <c:if test="${updateCnt!=0}">
            <script type="text/javascript">
               alert("펀드참여완료");
               opener.window.location="FundProducts?fund_no=${fund_no}";
               self.close();
            </script>
         </c:if>


</body>
</html>