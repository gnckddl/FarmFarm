
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<link rel="stylesheet" href="resources/css/assets/bootstrap.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>

<body class="board-body">
<!-- 헤더시작 -->
<header>
	<%@include file="../Header.jsp" %>
</header>
<!-- 헤더끝 --> 

<!------ Include the above in your HEAD tag ---------->

<div class="container">
	<div class="row">
        <div class="col-md-12">
        <h4 align="center" style="margin-bottom:30px; color:#00A58A;"><b>요청게시판</b></h4>
        <button onclick="window.location='RequestBoardWrite?pageNum=${pageNum}&boa_category=${ boa_category}'" style="margin-left:1050px; margin-bottom:10px; color:#00A58A;"><b>글쓰기</b></button>
        <div class="table-responsive">
    <table id="mytable" class="table table-bordred table-striped">
         
        <tr align="center">
         <td style="width:10%"><b>번호</b></td>
          <td style="width:10%"><b>아이디</b></td>
           <td style="width:10%"><b>요청상품</b></td>
           <td style="width:20%"><b>요청내용</b></td>
           <td style="width:15%"><b>요청날짜</b></td>
           <td style="width:10%"><b>조회수</b></td>
           <td style="width:10%"><b>인기</b></td>
           <!--  <th>글쓰기</th>
             <th>삭제</th> -->
          </tr>   
    <tbody>
 <tr> 
 
 <!--게시글이 있으면  -->
 <c:if test="${cnt > 0}">
 	<c:forEach var="dto" items="${dtos}">
 		<tr>
 		<!-- 2.번호 -->
           <td align="center">
              ${number}
              <c:set var="number" value="${number -1}"/>
           </td>
           
			<td align="center">
				${dto.mem_id}
			</td>
			
			<td align="center">
				${dto.boa_subject}
			</td>
			
			<td align="center">
				<a href="RequestBoardContent?boa_id=${dto.boa_id}&pageNum=${pageNum}&number=${number+1}&mem_id=${sessionScope.userId}&cm_cnt=${dto.cm_cnt}&boa_category=${boa_category}">${dto.boa_content}<span style="color: red;">[${dto.cm_cnt}]</span></a>
			</td>
			
			<td align="center">
				${dto.boa_regDate}
			</td>
			
			 <td align="center">
				${dto.boa_readCnt}
			</td>  
			<!--hot 이미지  -->
			<td align="center">
			   	<c:if test="${dto.boa_readCnt > 20}">
					<img src="resources/images/hithit.png" border="0" width="50" height="50">
				</c:if> 
			</td>
			<!--hot 이미지  -->
			
 		</tr>
 	</c:forEach>
 </c:if>
 </tr>
    </tbody>
        
</table>
		<!--게시글이 없으면  -->
	<table>
		<c:if test="${cnt==0}">
			<tr align="center">
				<td colspan="6" align="center">
				<span style="margin-left: 400px;">게시글이 없습니다. 글을 작성해 주세요.!!</span>
				</td>
			</tr>
		</c:if>
	</table>
			<!-- 페이지 컨트롤 -->
					<c:if test="${cnt>0 }">
						<div class="clearfix"></div>
						<ul class="pagination pull-right">
						<c:if test="${startPage > pageBlock}">
							<li class="disabled"><a href="RequestBoard?${startPage - pageBlock}&boa_category=${boa_category}">
							<span class="glyphicon 	glyphicon-chevron-left"></span></a></li>
						</c:if>
									
							<c:forEach var ="i" begin="${startPage}" end="${endPage}">
								<c:if test="${i == currentPage}">
									<li class="active"><a href="#">${i}</a></li>
								</c:if>
								
								<c:if test="${i != currentPage}">
									<li><a href="RequestBoard?pageNum=${i}&boa_category=${boa_category}">${i}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pageCount > endPage}">
							<li><a href="RequestBoard?pageNum=${startPage + pageBlock}&boa_category=${boa_category}">
							<span>class="glyphicon glyphicon-chevron-right"></span></a></li>
							</c:if>
						</ul>
					</c:if>
            </div>
            
        </div>
	</div>
</div>


<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
      <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Edit Your Detail</h4>
      </div>
          <div class="modal-body">
          <div class="form-group">
        <input class="form-control " type="text" placeholder="Mohsin">
        </div>
        <div class="form-group">
        
        <input class="form-control " type="text" placeholder="Irshad">
        </div>
        <div class="form-group">
        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>
    
        
        </div>
      </div>
          <div class="modal-footer ">
        <button type="button" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
    
    
    
    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
      <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
      </div>
          <div class="modal-body">
       
       <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
       
      </div>
        <div class="modal-footer ">
        <button type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>

 <!-- 4.푸터 -->
    <footer >
	<%@include file="../Footer.jsp" %>
    </footer>
   <!--푸터 끝  -->  
    
 	<!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>
</body>
</html>