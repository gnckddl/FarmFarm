<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="resources/css/bootstrap.css">

<body>
<!-- 헤더시작 -->
<header>
   <%@include file="../Header.jsp" %>
</header>
<!-- 헤더끝 --> 

<div class="container">
<div class="row">
<div class="col-xs-12">
<div class="ibox-content m-b-sm">
<div class="text-center p-lg">
<h2>성실한 농부에게 투자하고 안전한 먹거리로 돌려받는 팜팜펀드</h2>
</div>
</div>
</div>
</div>
</div>
   
<div class="layout-lg section-bg-gray">
<div class="container">
<div class="layout-md">
<div class="container border-bottom">
<div class="row faq-content">
<div class="col-xs-12 col-sm-3 hidden-xs">
<ul class="faqlist">
   <li class="category-title">도움말 목차</li>
   <li><a href="#faq01">팜팜펀드란</a></li>
   <li><a href="#faq02">팜팜펀드 이용과 소개</a></li>
   <!--   <li><a href="#faq03">결제 및 환불</a></li>  -->
   <li><a href="#faq04">리워드(투자상환)</a></li>
   <li><a href="#faq05">내 계정관리</a></li>
   <li><a href="#faq06">기타</a></li>
</ul>
</div>

<div class="col-xs-12 col-sm-9">
<div class="faqtitle" id="faq01">팜팜펀드란</div>

<ul class="faqlist2">
   <li class="q">팜팜펀드가 무엇인가요?</li>
   <li class="a">농부에게 투자하고 보다 나은 먹거리로 돌려받는 크라우드펀딩입니다. 우리가 안전한 먹거리를 먹기 위해서는 농부가 별다른 걱정 없이 농사를 지을 수 있어야 한다고 믿습니다. 그것을 지원하는 우리의 방식은 함께 영농자금을 마련해주고 농사에 대해 관심을 갖는 것입니다. 마련된 자금은 농부와 농사과정에 투자되고, 투자금은 안전한 농산물로 상환합니다. 농사짓는 과정은 모두 투명하게 공개됩니다. 재미있고 간편하게 누구나 그 일에 동참할 수 있는 방법이 바로 `팜팜펀드`입니다.<br>
   <br>
</ul>

<div class="faqtitle" id="faq02">팜팜펀드 이용과 소개</div>

<ul class="faqlist2">
   <li class="q">팜팜펀드는 어떻게 이용하나요?</li>
   <li class="a">팜팜펀드에는 매주 새로운 농부들이 소개 됩니다. 투자자는 농부가 올린 펀드의 내용과 `농사소식` 탭을 통해 농사과정 등을 보고 투자를 결정할 수 있습니다. 투자금액은 각 투자 상품마다 다르며 그에 따라 받게 되는 리워드(농산물 및 서비스)도 다릅니다.</li>
</ul>

<ul class="faqlist2">
   <li class="q">팜팜펀드에 투자하면 농부에게 어떻게 전달되나요?</li>
   <li class="a">여러분의 투자금은 농부에게 2-3단계에 걸쳐 전달됩니다.<br>
   ※ 투자완료 시 50% / 리워드 발송 후 50%(농부의 상황에 따라 중간정산)<br>
   이렇게 전달되는 투자금은 농부가 빚을 지지 않고 자신의 철학, 계획대로 농사지을 수 있는 농사자금이 됩니다.</li>
</ul>


<ul class="faqlist2">
   <li class="q">팜팜펀드에서 투자는 어떻게 이루어지나요?</li>
   <li class="a">팜팜펀드의 펀딩은 총 세 가지 형태가 있습니다.<br>
   [목표달성형] 목표금액 100% 달성 시에만 진행되는 펀드입니다.<br>
   [기간모집형] 모집기간 중 모집 된 금액만큼 진행되는 펀드입니다.<br>
   [즉시구매형] 구매즉시 준비하여 발송하는 펀드입니다.<br>
   펀드상품마다 형태가 다릅니다. 펀드 상세페이지에서 목록에서 확인할 수 있습니다.<br>
   ‘목표달성형’은 목표금액에 미달되면 해당 프로젝트는 진행이 취소되며 투자해주신 분들의 마이페이지 ‘e-머니’로 환불됩니다. 이렇게 환불받는 ‘e-머니’는 사이트에서 현금처럼 사용하실 수 있고, 마이페이지에서 ‘계좌환불 요청’을 통해 입력하신 계좌로 환불받으실 수 있습니다.</li>
</ul>

<div class="faqtitle" id="faq04">리워드(투자상환)</div>

<ul class="faqlist2">
   <li class="q">‘리워드(reward)’ or ‘투자상환’은 무엇인가요?</li>
   <li class="a">펀딩상품 개설자가 펀드를 후원하고 응원하는 투자자들에게 보답하는 의미로 제공하는 실질적인 서비스(농수산품, 생산품, 혜택, 경험 등)를 의미합니다. 리워드는 진행하는 펀드와 관련된 다양한 농산품을 제공하거나, 2차 가공품류(잼, 청, 말랭이 등) 혹은 가치 있는 무형의 것(체험권 및 숙박권 등)이 제공될 수 있습니다. 각 펀드 상품마다 ‘리워드’ 구성이 다르니 확인하고 투자하시면 됩니다.</li>
</ul>

<ul class="faqlist2">
   <li class="q">언제 제공되나요?</li>
   <li class="a">각 상품마다 배송예정일이 표기되어 있습니다. 일반적으로 펀드 종료 후 제공되며 농산물의 특성 상 기후 등의 요인으로 일정이 변경될 수 있습니다. 이럴 경우 농사소식 등을 통해 변경내용을 안내해드립니다. 리워드 발송에 대한 정보는 펀드상품 제안자가 총괄 관리하는 것을 원칙으로 합니다. 하지만 농사펀드에 문의 주시면 적극적으로 도와드리겠습니다.</li>
</ul>

<div class="faqtitle" id="faq05">내 계정관리</div>

<ul class="faqlist2">
   <li class="q">회원가입은 어떻게 하나요?</li>
   <li class="a">농사펀드의 계정은 사이트 상단의 ‘회원가입’ 버튼을 눌러서 간단하게 만드실 수 있습니다. </li>
</ul>

<ul class="faqlist2">
   <li class="q">비밀번호를 잊어버렸습니다.</li>
   <li class="a">펌펌펀드 로그인 화면에서 로그인 버튼 하단 ‘비밀번호찾기’를 클릭하시면 가입하신 이메일로 비밀번호를 재설정하실 수 있는 링크주소를 보내드립니다.</li>
</ul>

<div class="faqtitle" id="faq06">기타</div>

<ul class="faqlist2">
   <li class="q">우리 아버지, 친척도 농부인데 농사펀드에 등록할 수 있나요?</li>
   <li class="a">네, 물론입니다. 여기 ‘<a href="https://farmingfund.co.kr/farmer/join">농사펀드 농부되기</a>’를&nbsp;보시면 됩니다.</li>
</ul>

<ul class="faqlist2">
   <li class="q">팜팜펀드 소식을 만나볼 수 있는 다른 곳도 있나요?</li>
   <li class="a">팜팜펀드 페이스북 : <a href="http://www.fb.com/farmingfund" target="_blank">http://www.fb.com/farmingfund</a><br>
   가끔 ‘농부의 밥상’이라고 하는 오프라인 모임도 하고 있습니다. 오프라인 모임에 참여하셔서 직접 만나볼 수 있습니다.</li>
</ul>
</div>
</div>
</div>
</div>
</div>
</div>
<div>
   <hr width="50%">
</div>

<footer>
<%@include file="../Footer.jsp" %>
</footer>

    
    <!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>

</body>

</html>