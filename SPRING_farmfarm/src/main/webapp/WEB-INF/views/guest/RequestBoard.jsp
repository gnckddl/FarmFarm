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
        <div class="table-responsive">

                
    <table id="mytable" class="table table-bordred table-striped">
         
        <tr align="center">
         <td style="width:10%"><b>글번호</b></td>
          <td style="width:10%"><b>아이디</b></td>
           <td style="width:10%"><b>요청상품</b></td>
           <td style="width:20%"><b>요청내용</b></td>
           <td style="width:10%"><b>요청날짜</b></td>
           <td style="width:10%"><b>조회수</b></td>
           <td style="width:10%"><b>좋아요</b></td>
           <!--  <th>글쓰기</th>
             <th>삭제</th> -->
          </tr>   
    <tbody>
 <tr> 
 
 <!--게시글이 있으면  -->
 <c:if test="${cnt > 0}">
 	<c:forEach var="dto" items="${dtos}">
 		<tr>
		 	<td align="center">
				${dto.boa_id}
			</td>
			
			<td align="center">
				${dto.mem_id}
			</td>
			
			<td align="center">
				${dto.boa_subject}
			</td>
			
			<td align="center">
				${dto.boa_content}
			</td>
			
			<td align="center">
				${dto.boa_regDate}
			</td>
			
			 <td align="center">
				${dto.boa_readCnt}
			</td>  
			<!--hot 이미지  -->
		  <%-- 	<c:if test="${dto.readCnt > 10}">
				<img src="resources/images/hot.gif" border="0" width="20" height="15">
			</c:if> --%>  
			<!--추가 END  -->
			<td align="center">
				<a href="#"><img src="resources/images/ddabong.png" border="0" width="30" height="30"></a>
			</td>
			
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
				게시글이 없습니다. 글을 작성해 주세요.!!
				</td>
			</tr>
		</c:if>
	</table>
		<!--페이지 컨트롤  -->
	<table id="table2" style="width:1000px" align="center">
		<tr>
			<td align="center">
				<c:if test="${cnt>0}">
					<!--[◀◀]처음 /이전블록[◀]  -->
					<c:if test="${startPage > pageBlock}">
						<a href="boardList">[◀◀]</a>
						<a href="boardList?pageNum=${startPage - pageBlock}">[◀]</a>
					</c:if>
					
					<c:forEach var ="i" begin="${startPage}" end="${endPage}">
						<c:if test="${i == currentPage}">
							<span><b>[${i }]</b></span>
						</c:if>
						
						<c:if test="${i != currentPage}">
							<a href="boardList?pageNum=${i}">[${i}]</a>
						</c:if>
					</c:forEach>
					
					<!--다음블로[▶▶] / 끝[▶]  -->
					<c:if test="${pageCount > endPage}">
						<a href="boardList?pageNum=${startPage + pageBlock}">[▶]</a>
						<a href="boardList?pageNum=${pageCount}">[▶▶]</a>
					</c:if>
				</c:if>	
			</td>	
		</tr>
	</table>

<div class="clearfix"></div>
<ul class="pagination pull-right">
  <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
  <li class="active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
</ul>
                
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