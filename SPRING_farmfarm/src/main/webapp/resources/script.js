var msg_id = "(!)아이디를 입력하세요";
var msg_pwd = "(!)암호를 입력하세요";
var msg_repwd = "(!)암호확인을 입력하세요";
var msg_pwdChk = "(!)암호와 암호확인을 같게 입력하세요";
var msg_name = "(!)이름을 입력하세요";
var msg_jumin = "(!)주민을 입력하세요";
var msg_email = "(!)이메일을 입력하세요";
var msg_emailChk = "(!)이메일을 형식에 맞게 입력하세요";
var msg_confirmId = "(!)아이디를 중복체크 하세요";
var msg_login = "(!)로그인을 먼저 하세요";
var insertError = "(!)회원가입에 실패했습니다";
var updateError = "(!)회원정보수정에 실패했습니다";
var deleteError = "(!)회원탈퇴에 실패했습니다";
var pwdError = "(!)암호가 틀렸습니다";
var bookInsertError ="(!)재고추가에 실패했습니다";
var bookUpdateError ="(!)재고수정에 실패했습니다";
var bookDeleteError = "(!)재고삭제에 실패했습니다";
var bookCartError = "(!)추가에 실패했습니다";
var bookCartDelError= "(!)삭제에 실패했습니다";
var bookCartUpdError= "(!)수정에 실패했습니다";
var bookBuyError="(!)구매에 실패했습니다";
var bookOrderError="(!)주문 승인에 실패하였습니다";
var bookRefundError="(!)환불 처리에 실패하였습니다";

function errorAlert(errorMsg) {
	alert(errorMsg);
	window.history.back();
}



function registerCheck() {
	if (!document.registerForm.id.value) {
		alert("아이디 입력하세요");
		document.registerForm.id.focus();
		return false;
	} else if (!document.registerForm.pwd.value) {
		alert("암호 입력하세요");
		document.registerForm.pwd.focus();
		return false;
	} else if (!document.registerForm.rePwd.value) {
		alert("암호확인 입력하세요");
		document.registerForm.rePwd.focus();
		return false;
	} else if (document.registerForm.pwd.value != document.registerForm.rePwd.value) {
		alert("암호확인 동일하게 입력하세요");
		document.registerForm.rePwd.focus();
		document.registerForm.rePwd.value = null;
		return false;
	}

	else if (!document.registerForm.name.value) {
		alert("이름을 입력하세요");
		document.registerForm.name.focus();
		return false;
	} else if (!document.registerForm.addr1.value) {
		alert("주소를 입력하세요");
		document.registerForm.addr1.focus();
		return false;
	} else if (!document.registerForm.addr2.value) {
		alert("주소를 입력하세요");
		document.registerForm.addr2.focus();
		return false;
	} else if (!document.registerForm.jumin1.value
			|| !document.registerForm.jumin2.value) {
		alert("주민등록번호를 입력하세요");
		document.registerForm.jumin1.focus();
		return false;
	}

	else if (!document.registerForm.hp.value) {
		alert("휴대폰번호 입력하세요");
		document.registerForm.hp.focus();
		return false;
	} else if (!document.registerForm.email.value) {
		alert("이메일 입력하세요");
		document.registerForm.email.focus();
		return false;
	} else if (!document.registerForm.rulecheck.checked) {
		alert("이용약관을 확인하세요");
		document.registerForm.rulecheck.focus();
		return false;
	}
}

// 중복확인 버튼클릭시 중복확인창 id포커스
function confirmIdFocus() {
	document.confirmForm.id.focus();
}






// 로그인창체크
function loginCheck() {
	if (!document.inputForm.id.value) {
		alert("아이디 입력하세요");
		document.inputForm.id.focus();
		return false;
	}
	if (!document.inputForm.pwd.value) {
		alert("암호 입력하세요");
		document.inputForm.pwd.focus();
		return false;
	}
}

function deleteCheck() {
	if (!document.dropForm.pwd.value) {
		alert("암호 입력하세요");
		document.dropForm.pwd.focus();
		return false;
	}
}

// 회원정보수정
function passwdFocus() {
	document.passwdForm.pwd.focus();
}
function passwdCheck() {
	if (!document.passwdForm.pwd.value) {
		alert(msg_pwd);
		document.passwdForm.pwd.focus();
		return false;
	}
}

// QnA부분
function pwdFocus() {
	document.pwdform.pwd.focus();
}

function pwdCheck() {
	if (!document.pwdform.pwd.value) {
		alert(msg_pwd);
		document.pwdform.pwd.focus();
		return false;
	}
}

//체크박스가 체크 안되어있으면
function checkboxChk(){
	var checkboxs=document.getElementsByName("bookNo");
	var judge=false;
	
	for(var i=0;i<checkboxs.length;i++){
		if(checkboxs[i].checked==true){
			judge=true;
		}			
	}	
	if(judge==false){
		alert("체크 후 눌러주세요");
		return false;
	}
}