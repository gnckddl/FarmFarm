
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!-- 페이지 내 자체 CSS -->
<html>
<head>

<script type="text/javascript">
function reset(){
	document.joinForm.add1.value="";
	document.joinForm.add2.value="";
	document.joinForm.address.value="";
}

function setting(){
	document.joinForm.add1.value="${orderDto.addr[0]}";
	document.joinForm.add2.value="${orderDto.addr[1]}";
	document.joinForm.address.value="${orderDto.addr[2]}";
}
</script>



<!-- 주소 찾기 API를 위한 스크립트  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('sample6_address').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('sample6_address2').focus();
					}
				}).open();
	}
</script>

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
<body onload="setting();">

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="well well-sm">
					<form class="form-horizontal" action="AuctionJoinPro" method="post" name="joinForm">
						<fieldset>
							<legend class="text-center">
								<h2>
									<P>경매 입찰</P>
								</h2>
							</legend>

							<!-- 글번호 input-->
							<div class="form-group">
								<div class="col-md-9"></div>
							</div>

							<!-- 작성자 input-->
							<legend style="font-size: 15px">
								<div class="form-group">
									<label class="col-md-3 control-label" for="email" name="mem_id">상품명</label>
									<div class="col-md-9">
										<input class="form-control" type="text" name="nowPrice"
											id="nowPrice" disabled="disabled" value="${dto.stock_name}"
											style="font-size: 20px; margin-left: 20%; width: 65%">
										<!-- submit hidden값 -->
										<input type="hidden" name="auc_no" value="${dto.auc_no}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="nowPrice">입찰
										금액 *</label>
									<div class="col-md-9">
										<input class="form-control" type="number" name="nowPrice"
											id="nowPrice" step="1000" min="0"
											style="font-size: 20px; margin-left: 20%; width: 65%">
									</div>
								</div>
							</legend>
							

							<!-- Form actions -->
							<div class="form-group">
								<div class="col-md-12 text-right">
									<input type="submit" class="btn btn-primary btn-lg" value="입찰" />
									<input class="btn btn-primary btn-lg" type="button" value="닫기"
										onclick="self.close();">
								</div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>