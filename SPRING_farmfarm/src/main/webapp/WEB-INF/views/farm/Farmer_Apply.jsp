<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body id=apply>
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->  
	
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<div class="container" style="margin-bottom:170px; margin-top:150px;" >
  
    <div class="row" align="center">
        <div class="col-xs-6 col-sm-4 col-md-3" style="left:250px">            
            <div class="thumbnail_apply">
                <div class="caption_apply">
                	<br><br><br>
                    <h4>펀드 신청</h4>
                    <p>short thumbnail description</p>
                    <!-- <p><a href="" class="label label-danger">Zoom</a> -->
                    <a href="Fund_Apply" class="label label-default">신청서 작성</a></p>
                </div>
                <img src="resources/images/farmer/fund.jpg" width="100%" height="100%" alt="...">
            </div>
        </div>
      
        <div class="col-xs-6 col-sm-4 col-md-3" style="left:360px">            
            <div class="thumbnail_apply">
                <div class="caption_apply">
                	<br><br><br>
                    <h4>경매 신청</h4>
                    <p>short thumbnail description</p>                 
                    <a href="Auction_Apply" class="label label-default">신청서 작성</a></p>
                </div>
                <img src="resources/images/farmer/Auction.jpg" width="100%" height="100%" alt="...">
            </div>
        </div>

       <!--  <div class="col-xs-6 col-sm-4 col-md-3">            
            <div class="thumbnail_apply">
                <div class="caption_apply">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="resources/images/farmer/yoou.jpg" width="200px" alt="...">
            </div>
        </div>

        <div class="col-xs-6 col-sm-4 col-md-3">            
            <div class="thumbnail_apply">
                <div class="caption_apply">
                    <h4>Thumbnail Headline</h4>
                    <p>short thumbnail description</p>
                    <p><a href="" class="label label-danger">Zoom</a>
                    <a href="" class="label label-default">Download</a></p>
                </div>
                <img src="resources/images/farmer/yoou.jpg" width="200px" alt="...">
            </div>  
        </div>  -->
    </div>
    
    <!-- <div class="row">
        <div class="col-xs-12 text-center">
            Original <a href="http://bootsnipp.com/snippets/featured/thumbnail-caption-hover-effect">Thumbnail Caption Hover Effect</a> by <a href="http://bootsnipp.com/sevenx.de">sevenx.de</a>
        </div>
    </div> -->
  
</div><!-- /.container -->
	
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