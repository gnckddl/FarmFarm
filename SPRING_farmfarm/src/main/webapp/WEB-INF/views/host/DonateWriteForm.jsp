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
		     <form class="form-horizontal" role="form" method="post" action="donateWritePro.ad" enctype="multipart/form-data">
		       <fieldset>
		
		         <!-- Form Name -->
		        <legend style=" color:#00A58A;"> <h2>기부 단체 등록</h2></legend>
		
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
		             <input type="text" placeholder="단체명" name="doOrg_name" class="form-control">
		           </div>
		         </div>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">주소</label>
		           <div class="col-sm-10">
		             <input type="text" placeholder="주소" name="doOrg_address" class="form-control">
		           </div>
		         </div>
		
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">담당자</label>
		           <div class="col-sm-4">
		             <input type="text" placeholder="담당자" name="doOrg_person" class="form-control">
		           </div>
		
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">연락처</label>
		           <div class="col-sm-4">
		             <input type="text" placeholder="연락처 '-' 없이 입력" name="doOrg_hp" class="form-control">
		           </div>
		         </div>
		      
		         <!-- Text input-->
		         <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">신청제목</label>
		           <div class="col-sm-10">
		             <input type="text" placeholder="신청제목" name="doOrg_title" class="form-control">
		           </div>
		         </div>
		        
		          <div class="form-group">
		           <label class="col-sm-2 control-label" for="textinput" style=" color:#00A58A;">신청내용</label>
		           <div class="col-sm-10">
		             <textarea placeholder="신청내용" name="doOrg_content" class="form-control"></textarea>
		           </div>
		         </div>
		         
		         <div class="form-group">
		           <div class="col-sm-offset-2 col-sm-10">
		             <div class="pull-right">
		               <button type="reset" class="btn btn-default">취소</button>
		               <button type="submit" class="btn btn-primary">기부단체 등록</button>
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