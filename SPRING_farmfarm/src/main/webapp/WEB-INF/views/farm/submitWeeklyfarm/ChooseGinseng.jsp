<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신청서 작성</title>
</head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ 1.농장 전경 사진 아이프레임 삽입을 위한 부트스트랩 ---------->

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<!------ 2.농장신청 작성 폼 부트스트랩 ---------->

<style type="text/css">
@import url(https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css);
@import url(https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.3/css/mdb.min.css);

.hm-gradient {
    background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%);
}
.darken-grey-text {
    color: #2E2E2E;
}
</style>

<!-- 땅 1평당 금액계산을 위한 자바스크립트 코드 -->
<body onload="init();">
<script language="JavaScript">
var sum;
var amount;

function init () {
	sum = document.ChooseFarm.sum.value;
	amount = document.ChooseFarm.amount.value;
	document.ChooseFarm.wfarminfo_price.value = sum;
	change();
}

function add () {
	hm = document.ChooseFarm.amount;
	wfarminfo_price = document.ChooseFarm.wfarminfo_price;
	hm.value ++ ;

	wfarminfo_price.value = parseInt(hm.value) * sum;
}

function del () {
	hm = document.ChooseFarm.amount;
	wfarminfo_price = document.ChooseFarm.wfarminfo_price;
		if (hm.value > 1) {
			hm.value -- ;
			wfarminfo_price.value = parseInt(hm.value) * sum;
		}
}

function change () {
	hm = document.ChooseFarm.amount;
	wfarminfo_price = document.ChooseFarm.wfarminfo_price;

		if (hm.value < 0) {
			hm.value = 0;
		}
		wfarminfo_price.value = parseInt(hm.value) * sum;
}  
</script>

<!-- 주소 API 적용 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('add1').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('add2').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('wfarmInfo_add').focus();
            }
        }).open();
    }
</script>

<body class="hm-gradient" onload="init();">
<form action="ChooseFarmPro" method="post" name="ChooseFarm">
<input type="hidden" name="wfarm_status" value="1">
	<!-- 요청상태코드 1번 요청완료 -->
	
	<main> <!--MDB -->
	<div class="container mt-4">
		<div class="card p-3 mb-4">
			<div class="card-block">
				<!--Title-->
				<h3 class="text-center font-up font-bold pink-text pb-2">
					<strong>농장 신청하기</strong>
				</h3>
				<div class="embed-responsive embed-responsive-16by9">
					<img class="embed-responsive-item"
						src="resources/images/farmer/farmview07.PNG" />
				</div>
			</div>
		</div>
		<hr class="my-4">
		<div class="text-center darken-grey-text mb-4">
			<h3 class="font-bold mb-3">인삼재배 주말농장 신청서 작성하기</h3>
		</div>
	</div>
	<!--MDB --> </main>
	<!-- Form Name -->
	<legend>상세 작성</legend>
	<!-- Text input-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput">Partner
			ID</label>
		<div class="col-sm-10">
			<input type="text" name="mem_id" autocomplete="off"
				placeholder="팜팜 파트너 ID을 입력하세요" class="form-control"
				style="font-size: 20px;" value="${sessionScope.userId}">
		</div>
	</div>

	<!-- Text input-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput">개설 농장
			닉네임</label>
		<div class="col-sm-10">
			<input type="text" name="wfarminfo_title" placeholder="위 예시를 참조해 임대하실 텃밭의 개인 이름을 지어주세요"
				style="font-size: 20px;" class="form-control">
		</div>
	</div>
	
	
	<!-- 농장주소-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput">농장주소</label>
		<div class="col-sm-10">
		<input type="text" id="add1" name="add1" placeholder="우편번호"style="font-size: 20px;" class="form-control">
		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br><br>
		<input type="text" id="add2" name="add2" placeholder="주소"style="font-size: 20px;" class="form-control">
			<input type="text" name="wfarminfo_add" placeholder="상세주소 입력"
				style="font-size: 20px;" class="form-control">
		</div>
	</div>
	
	
		<!-- Text input-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput">임대평수</label>
		<div class="col-sm-4">
		<input type="hidden" name = "sum" value="300000" 
			style="font-size: 20px;" class="form-control">
		<input type="text" name="amount" value="1" size="3" onchange="change();">
		<input type="button" value=" + " onclick="add();"><input type="button" value=" - " onclick="del();"><br>
		</div>
		
	<!-- Text input-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput">총 금액(평당계산)</label>
		<div class="col-sm-4">
			<input type="text" name="wfarminfo_price" size="11" readonly class="form-control" 
			style="font-size: 20px;padding-top: 1px;padding-bottom: 1px;margin-bottom: 9px;margin-top: 1px;height: 19px;">
		</div>
	</div>
		
	</div>

     <!-- Text input-->
	<div class="form-group">
		<label class="col-sm-2 control-label" for="textinput"></label>
		<div class="col-sm-10" align="center" style="left: 150px;">
			<input type="submit" class="btn btn-danger"
			target="_blank" style="font-size: 20px;" value="신청서 제출">
		</div>
	</div>
	</form>
</body>
</html>