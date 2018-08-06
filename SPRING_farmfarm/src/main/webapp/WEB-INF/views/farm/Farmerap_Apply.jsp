<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body class="fundbd">
<!-- 헤더시작 -->
	<%@include file="../Header.jsp" %>
<!-- 헤더끝 -->  
	<div class="wrap">
<div class="section section-bg-gray layout-md section-itemview-top">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-12 section-header-sm section-itemview-top-title">
                <h1 class="section-title center">펀드 신청서 작성하기 </h1>
                <!-- <h3 class="center"><a href="/농부선정기준.pdf" target="_blank" class="btn btn-primary">농부선정기준</a></h3> -->
                <h3 class="section-subtitle center">농사펀드와 함께하고 싶습니다.</h3>
            </div>
        </div>
    </div>
    <form method="POST" action="https://farmingfund.co.kr/farmer/join" accept-charset="UTF-8"><input name="_token" type="hidden" value="5l6e8Kp9DSRw212mIuZVs0m5OydkGly5LillPdLH">
    <div class="section section-bg-white layout-sm">
      <div class="container faq-content">
        <div class="faqtitle_app">신청자 이름과 농장명</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) 조관희 / 남산골농원</li>
          <li class="a_app"><input class="app_ip" type="text" name="q1" value=""></li>
        </ul>
        <div class="faqtitle_app">통화 가능한 연락처</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) 010-1234-5678</li>
          <li class="a_app"><input class="app_ip" type="text" name="q2" value=""></li>
        </ul>
        <div class="faqtitle_app">농사펀드를 통해 하시고자 하는 일</div>
        <ul class="faqlist2_app">
          <li class="q_app">예)<br>
          전통방식 그대로 메주를 만들려고 합니다.<br>
          우리가 먹는 장류도 인스턴트화 되고 있습니다. 모든 먹거리가 인스턴트로 대체되더라도 외할머니의 된장찌게 맛 만큼은 지키고 싶었습니다.<br>
          현실적인 문제로 계속해서 효율성이 좋은 방법으로만 진화하다 보면 옛 선조들의 방법이 모두 사라져 버릴지도 모릅니다. 시간이 걸리고 지금 보기에 비효율적인 일들도 지켜나갈 값어치가 있다고 생각합니다.직접 재배한 콩을 가마솥으로 불리고 삶아 친환경 볏짚을 활용해 메주를 만들려고 합니다.<br>
          손이 많이 가는 일이지만 이런 메주와 된장을 필요로 하는 사람이 있을거라고 생각합니다. 농사펀드를 통해 사전에 그런 분들을 만나고 싶습니다.
          </li>
          <li class="a_app"><textarea name="q3" class="materialize-textarea_app" style="height: 300.2px"></textarea></li>
        </ul>
        <div class="faqtitle_app">필요자금과 쓰임새</div>
        <ul class="faqlist2_app">
          <li class="q_app">예)<br>
          총 필요금액 - 350만원 <br>
          - 발효를 위한 친환경(유기농) 볏짚마련 <br>
          - 비닐하우스 재정비 <br>
          - 항아리 구입 <br>
          - 콩농사를 위한 종자비용과 농부의 인건비 <br>
          - 배송비
          </li>
          <li class="a_app"><textarea name="q4" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">상품의 특징</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) <br>
          저염으로 만들어 맛이 자극적이지 않습니다. <br>
          콩은 마을 부녀회에서 무농약으로 기른 콩을 이용하고 있습니다. <br>
          3대째 내려우는 무쇠솥을 이용해 콩을 삶고 있습니다.
          </li>
          <li class="a_app"><textarea name="q5" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">농부(농장) 이야기</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) <br>
          박가네 농장 박종범 농부 입니다.<br>
          박가네 농장 가족은 저와 제 아내, 그리고 예쁜 5살 딸 지호 이렇게 3명입니다. <br>
          저희는 10년 전 강원도 춘천 산골짜기 마을로 귀농했습니다. <br>
          저는 좋은 환경에서 아이를 키우고 싶었고, 무엇보다 안전한 먹거리를 먹이고 싶었습니다.<br><br>
          전통 방식 그대로 만든 메주와 3년 숙성 된장을 만들게 된 이유 입니다. <br>
          아내인 박미진은 저를 도와 된장을 만듭니다. <br>
          그리고 된장을 이용한 다양한 음식을 만드는 재주꾼 입니다. 기회가 되면 투자자분들을 농장에 초대해 팜파티를 하고 싶습니다.
          </li>
          <li class="a_app"><textarea name="q6" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">투자 상환계획(보상계획)</div>
        <ul class="faqlist2_app">
          <li class="q_app">예)<br>
            메주와 청국장, 된장을 드리려고 합니다.<br>
            - 3만원 - 청국장 400g + 3년 숙성 된장 1kg - (시중가 대비 3,000원 이익)<br>
            - 6만원 - 청국장 400g + 3년 숙성 된장 1kg + 막장 1kg (시중가 대비 7,000원 이익)<br>
            - 10만원 - 청국장400g + 메주 10kg (시중가 대비 15,000원 이익)
          </li>
          <li class="a_app"><textarea name="q7" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">자주하는 질문과 답, 투자자가 궁금해 할 내용</div>
        <ul class="faqlist2_app">
          <li class="q_app">예)<br>
          Q. 메주를 만드는데 친환경 볏짚을 이용하는 이유는 무fvv  엇인가요?<br><br>
          A. 좋은 메주를 만들기 위해서는 발효를 일으키는 균이 필요합니다. <br>
          이 건강한 균들은 공기중과 친환경 볏집에 많이 있습니다. 좋은 메주가 되라고 쓰고 있습니다.
          </li>
          <li class="a_app"><textarea name="q8" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">이메일 주소</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) abcd@ffd.co.kr</li>
          <li class="a_app"><input type="text" name="q9" value=""></li>
        </ul>
        <div class="faqtitle_app">농장주소</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) 충남 부여군 장암면 정암리 304</li>
          <li class="a_app"><input type="text" name="q10" value=""></li>
        </ul>
        <div class="faqtitle_app">주요작물과 생산량</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) 쌀, 2,000kg</li>
          <li class="a_app"><input type="text" name="q11" value=""></li>
        </ul>
        <div class="faqtitle_app">홈페이지 or 블로그 주소</div>
        <ul class="faqlist2_app">
          <li class="q_app">예) 쌀, 2,000kg</li>
          <li class="a_app"><input type="text" name="q12" value=""></li>
        </ul>
        <button class="btn btn-primary btn-lg btn-block" type="submit" style="height:70px;" onclick="return confirm('농부신청을 완료하시겠습니까?');">펀드 신청하기</button>
      </div>
    </div>
    </form>
</div>
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