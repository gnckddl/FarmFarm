
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="resources/css/boardcontent.css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script type="text/javascript">

function modifyForm(){
   
   
   window.location ='modifyFormBoard?boa_subject=${dto.boa_subject}&boa_content=${dto.boa_content}&mem_id=${dto.mem_id}&pageNum=${pageNum}&boa_id=${boa_id}&number=${number}&boa_category=${boa_category}';
   
}

function commentModifyPop(num){
    window.open('commentModifyPop?cm_no='+num+'&pageNum=${pageNum}&number=${number}&boa_id=${boa_id}&boa_category=${boa_category}', 'contentpopup','top=100px, left=100px, height=500px, width=500px');
    
   
}

function deleteBoardPro(){
   window.location = 'deleteBoardPro?boa_id=${dto.boa_id}&pageNum=${pageNum}&number=${number}&boa_category=${boa_category}'
   
}

function commentDeletePro(num){
   window.location = 'commentDeletePro?cm_no='+num+'&pageNum=${pageNum}&number=${number}&boa_id=${dto.boa_id}&boa_category=${boa_category}'
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
							type="button" value="글수정" onclick="modifyForm()"> <input
							class="inputButton" type="button" value="글삭제"
							onclick="deleteBoardPro()">
						</a>
					</c:if>
				</section>


				<section id="bo_v_atc" class="col-md-10 col-md-offset-1">
					<h2 id="bo_v_atc_title">본문</h2>

					<div id="bo_v_img"></div>

					<!-- 본문 내용 시작 { -->

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
						<h2>댓글목록</h2>
						<c:if test="${cnt>0}">
							<c:forEach var="dtos" items="${dtos}">
								<div class="tab-pane" id="tab_3" style="display: block;">

									<div class="social-feed-box">


										<div class="social-footer">
											<div class="social-comment">

												<br>
												<hr style="border-color: LightGray;">
												<img alt="image" src="${images}board/comment.jpg"
													style="width: 80px; height: 70px;" class="pull-left">
												<div class="media-body">
													<c:if test="${dtos.mem_id==sessionScope.userId}">
														<a href="#" onclick="commentDeletePro(${dtos.cm_no});"
															style="float: right; color: #00A58A; margin-left: 10px;">글삭제</a>
														<a href="#" onclick="commentModifyPop(${dtos.cm_no});"
															style="float: right; margin-left: 10px; color: #00A58A;">글수정</a>
													</c:if>
													<a href="#"><br> ${dtos.mem_id} : </a>
													${dtos.cm_content} <br> <small class="text-muted">${dtos.cm_regDate}</small>

												</div>
											</div>
										</div>
									</div>

								</div>
							</c:forEach>
						</c:if>
					</div>


				</section>
				<!-- } 댓글 끝 -->
				<c:if test="${cnt==0}">
					<tr align="center">
						<td colspan="6" align="center"><span
							style="margin-left: 40%;">댓글이 없습니다.</span></td>
					</tr>
				</c:if>
			</div>
			<!-- 댓글 쓰기 시작 { -->
			<aside id="bo_vc_w">
				<h2>댓글쓰기</h2>
				<form class="form-horizontal" name="fviewcomment"
					action="commentBoardWritePro?boa_category=${boa_category}"
					method="post" autocomplete="off">

					<input type="hidden" name="number" value="${number}"> <input
						type="hidden" name="pageNum" value="${pageNum}"> <input
						type="hidden" name="boa_id" value="${boa_id}">

					<div class="form-group">
						<label for="wr_name" class="col-sm-2 control-label">아이디:<strong
							class="sound_only">${sessionScope.userId}</strong></label>

					</div>

					<div class="form-group">
						<div class="col-sm-offset-1 col-sm-10">
							<textarea id="wr_content" name="cm_content" maxlength="10000"
								required="" class="required form-control" rows="3" title="내용"></textarea>
							<script>
              $(document).on( "keyup change", "textarea#wr_content[maxlength]", function(){
                  var str = $(this).val()
                  var mx = parseInt($(this).attr("maxlength"))
                  if (str.length > mx) {
                      $(this).val(str.substr(0, mx));
                      return false;
                  }
              });
              </script>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button type="submit" id="btn_submit"
								class="btn btn-primary btn-block" value="댓글등록">댓글등록</button>
						</div>
					</div>
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


			<script>
var save_before = '';
var save_html = document.getElementById('bo_vc_w').innerHTML;

function good_and_write()
{
    var f = document.fviewcomment;
    if (fviewcomment_submit(f)) {
        f.is_good.value = 1;
        f.submit();
    } else {
        f.is_good.value = 0;
    }
}

function fviewcomment_submit(f)
{
    var pattern = /(^\s*)|(\s*$)/g; // \s 공백 문자

    f.is_good.value = 0;

    var subject = "";
    var content = "";
    $.ajax({
        url: g5_bbs_url+"/ajax.filter.php",
        type: "POST",
        data: {
            "subject": "",
            "content": f.wr_content.value
        },
        dataType: "json",
        async: false,
        cache: false,
        success: function(data, textStatus) {
            subject = data.subject;
            content = data.content;
        }
    });

    if (content) {
        alert("내용에 금지단어('"+content+"')가 포함되어있습니다");
        f.wr_content.focus();
        return false;
    }

    // 양쪽 공백 없애기
    var pattern = /(^\s*)|(\s*$)/g; // \s 공백 문자
    document.getElementById('wr_content').value = document.getElementById('wr_content').value.replace(pattern, "");
    if (char_min > 0 || char_max > 0)
    {
        check_byte('wr_content', 'char_count');
        var cnt = parseInt(document.getElementById('char_count').innerHTML);
        if (char_min > 0 && char_min > cnt)
        {
            alert("댓글은 "+char_min+"글자 이상 쓰셔야 합니다.");
            return false;
        } else if (char_max > 0 && char_max < cnt)
        {
            alert("댓글은 "+char_max+"글자 이하로 쓰셔야 합니다.");
            return false;
        }
    }
    else if (!document.getElementById('wr_content').value)
    {
        alert("댓글을 입력하여 주십시오.");
        return false;
    }

    if (typeof(f.wr_name) != 'undefined')
    {
        f.wr_name.value = f.wr_name.value.replace(pattern, "");
        if (f.wr_name.value == '')
        {
            alert('이름이 입력되지 않았습니다.');
            f.wr_name.focus();
            return false;
        }
    }

    if (typeof(f.wr_password) != 'undefined')
    {
        f.wr_password.value = f.wr_password.value.replace(pattern, "");
        if (f.wr_password.value == '')
        {
            alert('비밀번호가 입력되지 않았습니다.');
            f.wr_password.focus();
            return false;
        }
    }

    if (!chk_captcha()) return false;

    set_comment_token(f);

    document.getElementById("btn_submit").disabled = "disabled";

    return true;
}

function comment_box(comment_id, work)
{
    var el_id;
    // 댓글 아이디가 넘어오면 답변, 수정
    if (comment_id)
    {
        if (work == 'c')
            el_id = 'reply_' + comment_id;
        else
            el_id = 'edit_' + comment_id;
    }
    else
        el_id = 'bo_vc_w';

    if (save_before != el_id)
    {
        if (save_before)
        {
            document.getElementById(save_before).style.display = 'none';
            document.getElementById(save_before).innerHTML = '';
        }

        document.getElementById(el_id).style.display = '';
        document.getElementById(el_id).innerHTML = save_html;
        // 댓글 수정
        if (work == 'cu')
        {
            document.getElementById('wr_content').value = document.getElementById('save_comment_' + comment_id).value;
            if (typeof char_count != 'undefined')
                check_byte('wr_content', 'char_count');
            if (document.getElementById('secret_comment_'+comment_id).value)
                document.getElementById('wr_secret').checked = true;
            else
                document.getElementById('wr_secret').checked = false;
        }

        document.getElementById('comment_id').value = comment_id;
        document.getElementById('w').value = work;

        if(save_before)
            $("#captcha_reload").trigger("click");

        save_before = el_id;
    }
}

function comment_delete()
{
    return confirm("이 댓글을 삭제하시겠습니까?");
}

comment_box('', 'c'); // 댓글 입력폼이 보이도록 처리하기위해서 추가 (root님)

</script>
			<!-- } 댓글 쓰기 끝 -->
			<script src="http://gb5-health1.dothome.co.kr/js/md5.js"></script>

			<!-- 링크 버튼 시작 { -->

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
