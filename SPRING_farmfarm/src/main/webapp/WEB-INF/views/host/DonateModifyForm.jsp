<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기부 현황</title>
</head>
<body>

	<!-- 헤더 -->
	<%@ include file="../Header.jsp"%>

	<!-- 관리자 사이드 바 -->
	<%@ include file="../HostSideBar.jsp"%>

	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
		<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
		<!------ Include the above in your HEAD tag ---------->
		
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
		<!------ Include the above in your HEAD tag ---------->
		<script src="http://momentjs.com/downloads/moment-with-locales.js"></script>
		<script src="http://momentjs.com/downloads/moment-timezone-with-data.js"></script>
		
		  <div class="row">
		    <div class="col-md-5 col-md-offset-4" style="margin-bottom:170px; margin-top:150px;">
		     <form class="form-horizontal" role="form" method="post" action="donateModifyPro.ad" enctype="multipart/form-data">
		       <input type="hidden" name="doForm_id" value="${doForm_id}">
				<input type="hidden" name="pageNum" value="${pageNum}">
				
		       <fieldset>
		
		         <!-- Form Name -->
		        <legend style=" color:#00A58A;"> <h2>기부 단체 수정페이지</h2></legend>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">단체 로고</label>
		           <div class="col-sm-6">
		             <input type="file" name="doOrg_image" class="form-control">
		           </div>
		         </div>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">단체명</label>
		           <div class="col-sm-10">
		             ${dto.doOrg_name}
		           </div>
		         </div>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">주소</label>
		           <div class="col-sm-10">
		             <input type="text" placeholder="${dto.doOrg_address}" name="doOrg_address" class="form-control">
		           </div>
		         </div>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">담당자</label>
		           <div class="col-sm-4">
		             <input type="text" placeholder="${dto.doOrg_person}" name="doOrg_person" class="form-control">
		           </div>
		
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">연락처</label>
		           <div class="col-sm-4">
		             <input type="text" placeholder="${dto.doOrg_hp}" name="doOrg_hp" class="form-control">
		           </div>
		         </div>
		      
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">신청제목</label>
		           <div class="col-sm-10">
		             <input type="text" placeholder="${dto.doOrg_title}" name="doOrg_title" class="form-control">
		           </div>
		         </div>
		        
		          <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">신청내용</label>
		           <div class="col-sm-10">
		             <textarea placeholder="${dto.doOrg_content}" name="doOrg_content" class="form-control"></textarea>
		           </div>
		         </div>
		         
		         <div class="form-group">
		           <div class="col-sm-offset-2 col-sm-10">
		             <div class="pull-right">
		               <button type="submit" class="btn btn-primary">수정</button>
		               <button type="reset" class="btn btn-default">수정 취소</button>
		               <button class="btn btn-default" onclick="window.location='DonateConList.ad?pageNum=${pageNum}'">
						목록</button>
		             </div>
		           </div>
		         </div>
		
		       </fieldset>
		     </form>
		   </div><!-- /.col-lg-12 -->
		</div><!-- /.row -->

	<!-- 관리자 푸터 -->
	<footer> <%@ include file="../HostFooter.jsp"%>
	</footer>

	<!-- 푸터 -->
	<footer> <%@ include file="../Footer.jsp"%>
	</footer>

</body>
</html>