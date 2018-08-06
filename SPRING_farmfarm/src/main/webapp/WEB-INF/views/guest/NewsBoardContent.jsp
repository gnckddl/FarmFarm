
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/boardcontent.css">

<script type="text/javascript">


	function NewsDeleteBoardPro() {
		window.location = 'NewsDeleteBoardPro?boa_id=${dto.boa_id}&pageNum=${pageNum}&number=${number}&boa_category=${boa_category}';
	}

	function NewsModifyForm() {
		window.location = "NewsModifyFormBoard?boa_subject=${dto.boa_subject}&boa_content=${dto.boa_content}&mem_id=${dto.mem_id}&pageNum=${pageNum}&boa_id=${boa_id}&number=${number}&boa_category=${boa_category}";

	}
</script>

<!------ Include the above in your HEAD tag ---------->

<!-- 페이지 내 자체 CSS -->
<html>
<head>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

P {
	font-family: 'Nanum Pen Script', cursive;
}
/* 구글 웹 폰트를 페이지 내부에서 사용하겠다고 선언 */
body {
	padding-top: 20px;
}
</style>
</head>
<body>

	<!-- 헤더시작 -->
	<header>
		<%@include file="../Header.jsp"%>
	</header>
	<!-- 헤더끝 -->

	<article id="bo_v" class="container">
		<div class="panel panel-success">
			<header class="panel-heading">
				<h1 id="bo_v_title">글제목 : ${dto.boa_subject}</h1>
			</header>
			<div class="panel-body">
				<section id="bo_v_info">
					<h2>페이지 정보</h2>
					<strong><span class="sv_member">작성자:${dto.mem_id}</span></strong> <span
						class="sound_only"></span><strong>${dto.boa_regDate}</strong> 조회수<strong>${dto.boa_readCnt}</strong>
					<c:if test="${dto.mem_id==sessionScope.userId}">
						<a style="float: right;"> <input class="inputButton"
							type="button" value="글수정" onclick="NewsModifyForm()"> 
							<input
							class="inputButton" type="button" value="글삭제"
							onclick="NewsDeleteBoardPro()">
						</a>
					</c:if>


				</section>


				<section id="bo_v_atc" class="col-md-10 col-md-offset-1">
					<h2 id="bo_v_atc_title">본문</h2>

					<div id="bo_v_img"></div>

					<!-- 본문 내용 시작 { -->
					<img style="width: 100%; height: 100%"
						src="${images}board/${dto.boa_image}">

					<div id="bo_v_con">${dto.boa_content}</div>
					<!-- } 본문 내용 끝 -->


					<!-- 스크랩 추천 비추천 시작 { -->
					<!-- } 스크랩 추천 비추천 끝 -->
				</section>



				<script>
					// 글자수 제한
					var char_min = parseInt(0); // 최소
					var char_max = parseInt(0); // 최대
				</script>

				<!-- 댓글 시작 { -->
				<section id="bo_vc" class="clearfix">
					<div class="col-md-10 col-md-offset-1">
						<c:if test="${cnt>0}">
							<c:forEach var="dtos" items="${dtos}">
								<div class="tab-pane" id="tab_3" style="display: block;">

									<div class="social-feed-box">


										<div class="social-footer">
											<div class="social-comment">

												<br>
												<hr style="border-color: LightGray;">
												<img alt="image" src="resources/images/eeet.jpg"
													style="width: 80px; height: 70px;" class="pull-left">
												<div class="media-body"></div>
											</div>
										</div>
									</div>

								</div>
							</c:forEach>
						</c:if>
					</div>


				</section>

				<!-- 댓글 쓰기 시작 { -->
				<aside id="bo_vc_w">
					<h2>댓글쓰기</h2>
					<form class="form-horizontal" name="fviewcomment"
						action="commentBoardWirtePro?boa_category=${boa_category}"
						method="post" autocomplete="off">

						<input type="hidden" name="number" value="${number}"> <input
							type="hidden" name="pageNum" value="${pageNum}"> <input
							type="hidden" name="boa_id" value="${boa_id}">

					</form>
					<div id="bo_v_bot" style="margin-right: 10px;">
						<c:if test="${boa_category!=0}">
							<c:if test="${boa_category==2}">
								<ul class="bo_v_com">
									<li><a
										href="memberQuestionBoard?pageNum=${pageNum}&boa_category=${boa_category}"
										class="btn btn-sm btn-success">목록</a></li>
								</ul>
							</c:if>

							<c:if test="${boa_category==3}">
								<ul class="bo_v_com">
									<li><a
										href="farmerQuestionBoard?pageNum=${pageNum}&boa_category=${boa_category}"
										class="btn btn-sm btn-success">목록</a></li>
								</ul>
							</c:if>

							<c:if test="${boa_category==4}">
								<ul class="bo_v_com">
									<li><a
										href="NewsBoard?pageNum=${pageNum}&boa_category=${boa_category}"
										class="btn btn-sm btn-success">목록</a></li>
								</ul>
							</c:if>

							<c:if test="${boa_category==5}">
								<ul class="bo_v_com">
									<li><a
										href="RequestBoard?pageNum=${pageNum}&boa_category=${boa_category}"
										class="btn btn-sm btn-success">목록</a></li>
								</ul>
							</c:if>
						</c:if>
					</div>
				</aside>

			</div>
	</article>

	<!-- 4.푸터 -->
	<footer>
		<%@include file="../Footer.jsp"%>
	</footer>
	<!--푸터 끝  -->

	<!--스크립트 공통부분  -->
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>
