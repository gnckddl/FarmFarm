<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주말농장 관리페이지</title>
</head>
<body>

   <!-- 헤더 -->
   <%@ include file="../Header.jsp"%>

   <!-- 관리자 사이드 바 -->
   <%@ include file="../HostSideBar.jsp"%>

   <section id="main-content">
      <section class="wrapper">
      <h3>
         <i class="fa fa-angle-right"></i> 주말농장 관리
      </h3>
      
      <div class="row">
         <!-- 주말농장 요청현황 시작 -->
         <div class="col-md-12 mt">
            <%@ include file="WeekFarmRequest.jsp" %>
         </div>   
         <!-- 주말농장 요청현황 끝 -->
      
         <!-- 주말농장 현황 시작 -->
         <div class="col-md-12 mt">
            <%@ include file="WeekFarmStatus.jsp" %>
         </div>
         <!-- 주말농장 현황 끝 -->
      </div>
      </section>
   </section>

   <!-- 관리자 푸터 -->
   <footer> <%@ include file="../HostFooter.jsp"%>
   </footer>

   <!-- 푸터 -->
   <footer> <%@ include file="../Footer.jsp"%>
   </footer>
</body>
</html>