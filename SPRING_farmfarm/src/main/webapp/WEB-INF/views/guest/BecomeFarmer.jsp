<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
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
    
    <form method="POST" action="BecomeFarmerPro" accept-charset="UTF-8"><input name="_token" type="hidden" value="5l6e8Kp9DSRw212mIuZVs0m5OydkGly5LillPdLH">
    <div class="section section-bg-white layout-sm">
      <div class="container faq-content" >
        <div class="faqtitle_app">농장명</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예)남산골농원</li>
          <li class="a_app"><input class="app_ip" type="text" name="fPlan_title" value="" ></li>
        </ul>
        
        <div class="faqtitle_app">농사펀드를 통해 하시고자 하는 일</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예)<br>
          전통방식 그대로 메주를 만들려고 합니다.<br>
          우리가 먹는 장류도 인스턴트화 되고 있습니다. 모든 먹거리가 인스턴트로 대체되더라도 외할머니의 된장찌게 맛 만큼은 지키고 싶었습니다.<br>
          현실적인 문제로 계속해서 효율성이 좋은 방법으로만 진화하다 보면 옛 선조들의 방법이 모두 사라져 버릴지도 모릅니다. 시간이 걸리고 지금 보기에 비효율적인 일들도 지켜나갈 값어치가 있다고 생각합니다.직접 재배한 콩을 가마솥으로 불리고 삶아 친환경 볏짚을 활용해 메주를 만들려고 합니다.<br>
          손이 많이 가는 일이지만 이런 메주와 된장을 필요로 하는 사람이 있을거라고 생각합니다. 농사펀드를 통해 사전에 그런 분들을 만나고 싶습니다.
          </li>
          <li class="a_app"><textarea name="fPlan_plan" class="materialize-textarea_app"></textarea></li><!--  style="height: 300.2px" -->
        </ul>
        
        <div class="faqtitle_app">필요자금</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예) 총 필요금액 - 350만원</li>
          <li class="a_app"><input type="text" name="fPlan_capital" value=""></li>
        </ul>
        
        <div class="faqtitle_app">쓰임새</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예)<br>
          - 발효를 위한 친환경(유기농) 볏짚마련 <br>
          - 비닐하우스 재정비 <br>
          - 항아리 구입 <br>
          - 콩농사를 위한 종자비용과 농부의 인건비 <br>
          - 배송비
          </li>
          <li class="a_app"><textarea name="fPlan_use" class="materialize-textarea_app"></textarea></li>
        </ul>
        <div class="faqtitle_app">상품의 특징</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예) <br>
          저염으로 만들어 맛이 자극적이지 않습니다. <br>
          콩은 마을 부녀회에서 무농약으로 기른 콩을 이용하고 있습니다. <br>
          3대째 내려우는 무쇠솥을 이용해 콩을 삶고 있습니다.
          </li>
          <li class="a_app"><textarea name="fPlan_detail" class="materialize-textarea_app"></textarea></li>
        </ul>
       
        <div class="faqtitle_app">농장주소</div>
        <ul class="faqlist2_app" style="list-style : none;">
          <li class="q_app">예) 충남 부여군 장암면 정암리 304</li>
          <li class="a_app"><input type="text" name="fPlan_address" value=""></li>
        </ul>
        
         
        <button class="btn btn-primary btn-lg btn-block" type="submit" style="height:70px;" onclick="return confirm('농부신청을 완료하시겠습니까?');">펀드 신청하기</button>
      </div>
    </div>
    </form>
</div>
</div>



<!-- 4.푸터 -->
    <footer>
   <%@include file="../Footer.jsp" %>
    </footer>
<!--푸터 끝  --> 
    
    <!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>
</body>
</html>