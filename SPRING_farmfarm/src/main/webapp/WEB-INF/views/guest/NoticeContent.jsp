<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 상세페이지</title>
</head>
<body>
   <!-- 헤더시작 -->
   <header> <%@include file="../Header.jsp"%>
   </header>
   <!-- 헤더끝 -->

   <!-- 관리자일 경우, 관리자 사이드바 추가 -->
   <c:if test="${sessionScope.grade == 3}">
      <%@ include file="../HostSideBar.jsp"%>
   </c:if>

   <!-- 관리자일 경우, section id="main-content" 적용 -->
   <c:if test="${sessionScope.grade == 3}">
      <section id="main-content">
   </c:if>
   <!-- 관리자가 아닐 경우, div class="wrap" 적용 -->
   <c:if test="${sessionScope.grade != 3}">
      <div class="wrap">
   </c:if>

   <!-- 하단영역 -->
   <div class="section section-bg-white layout-md section-itemview-bottom"
      style="padding-top: 0px !important;">
      <div class="container">
         <div class="col-lg-10 col-lg-offset-1 col-xs-12">
            <div class="ibox">
               <!-- 공지사항 상세페이지 시작 -->
               <div class="ibox-content">
                  <!-- 오른쪽 맨 위 div 시작 -->
                  <div class="pull-right"></div>
                  <!-- 오른쪽 맨 위 div 끝 -->
                  <div class="text-center article-title">
                     <span class="text-muted"> <i class="fa fa-clock-o"></i>
                        ${dto.boa_regDate2}
                     </span>
                     <h1> ■ ${dto.boa_subject} ■ </h1>
                  </div>
                  <!-- 공지사항 내용 시작 -->
                  <div class="text-center article-title" style="margin-top: 50px;">
                     <h3>${dto.boa_content}</h3>
                  </div>
                  <!-- 공지사항 내용 끝 -->
                  <br />
                  <!-- 댓글 달기 시작 -->
                  <div class="row">
                     <div class="col-lg-12">
                        <h2> 댓글 : </h2>
                        <div class="media-body writerinput">
                           <form method="POST" action="CommentWrite?boa_id=${dto.boa_id}&pageNum=${pageNum}">
                              <textarea placeholder="댓글을 남겨주세요." class="form-control"
                                 style="height: 4em" id="cm_content" name="cm_content" cols="50" rows="10"></textarea>
                              <input class="btn btn-default btn-block" type="submit"
                                 value="댓글달기" onclick="return commentWriteCheck();">
                           </form>
                        </div>
                     </div>
                  </div>
                  <!-- 댓글 달기 끝 -->
                  
                  <!-- 댓글 조회 시작 -->
                  <div class="row">
                     <div class="col-lg-12">
                        <c:forEach var="dtos" items="${dtos}">
                        <table>
                           <tr>
                              <td><h3>${dtos.mem_id}</h3></td>
                           </tr>
                           <tr>
                              <td><h4>${dtos.cm_content}</h4></td>
                              <td>
                                 <!-- 댓글 수정 -->
                                 <button class="btn btn-warning btn-xs" onclick="commentModifyCheck('${sessionScope.userId}', '${dtos.mem_id}', '${sessionScope.grade}', ${dtos.cm_no}, ${dto.boa_id}, ${pageNum}, '${dtos.cm_content}');">
                                    <i class="fa fa-pencil"></i>
                                 </button>
                                 
                                 <!-- 댓글 삭제 -->
                                 <button class="btn btn-danger btn-xs" onclick="return commentDeleteCheck('${sessionScope.userId}', '${dtos.mem_id}', '${sessionScope.grade}', ${dtos.cm_no}, ${dto.boa_id}, ${pageNum});">
                                    <i class="fa fa-trash-o "></i>
                                 </button>
                              </td>
                           </tr>
                           <tr>
                              <td><h5>${dtos.cm_regDate}</h5></td>
                           </tr>
                        </table>
                        </c:forEach>
                     </div>
                  </div>
                  <!-- 댓글 조회 끝 -->
               </div>
               <!-- 공지사항 상세페이지 끝 -->
            </div>
         </div>
      </div>
      <!-- /.container -->
   </div>
   <!-- /.content-wrapper -->

   <!-- 관리자일 경우, section id="main-content" 적용 -->
   <c:if test="${sessionScope.grade == 3}">
      </section>
   </c:if>
   <!-- 관리자가 아닐 경우, div class="wrap" 적용 -->
   <c:if test="${sessionScope.grade != 3}">
   </div>
   </c:if>

   <c:if test="${sessionScope.grade == 3}">
      <!-- 관리자일 경우, 관리자 푸터 적용 -->
      <footer> <%@ include file="../HostFooter.jsp"%>
      </footer>
   </c:if>

   <!-- 4.푸터 -->
   <footer> <%@include file="../Footer.jsp"%>
   </footer>
   <!--푸터 끝  -->

   <!-- 관리자가 아닐 경우, 스크립트 공통부분 적용 -->
   <c:if test="${sessionScope.grade != 3}">
      <!--스크립트 공통부분  -->
      <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
      <script src="resources/js/bootstrap.js"></script>
   </c:if>
</body>
</html>