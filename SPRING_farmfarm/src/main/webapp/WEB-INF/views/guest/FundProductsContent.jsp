<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="../setting.jsp"%>
<html>

<script type="text/javascript">
function FundProductsPop(fund_no){
   if(${sessionScope.userId== null}){
      alert("로그인후 이용해주세요!");
      window.location='loginForm';
      return false;
   }else{
    
      window.open('FundProductsPop?fund_no='+fund_no+'&stock_price=${dto.stock_price}&fund_title=${dto.fund_title}', 'auction_popup','top=100px, left=100px, height=600px, width=500px');
   }
}
</script>
<head>
<!-- <link type="text/css" rel="stylesheet" href="//farmingfund.co.kr/css/vendor.css">
<link type="text/css" rel="stylesheet" href="//farmingfund.co.kr/css/user.css"> -->
<body class="auc_content" >
   <!-- 헤더시작 -->
   <%@include file="../Header.jsp"%>
   <!-- 헤더끝 -->

   <!-- 본문영역 -->
   <form action="#" name="auctionForm">
   <div class="wrap">
      <!-- 상단영역 -->
      <div class="section section-bg-gray layout-md section-itemview-top">
         <div class="container">

            <!-- 펀드제목 -->
            <div class="row">
               <!-- 타이틀 -->
               <div
                  class="col-xs-12 col-sm-12 section-header-sm section-itemview-top-title">
                  <h1 class="section-title center">[팜팜펀드]  ${dto.fund_title}</h1>
                  <h3 class="section-subtitle center">${dto.mem_id } 농부의 상품</h3>
               </div>
            </div>
            <!-- 펀드제목 -->
            <!-- 펀드정보 요약 -->
            <section class="ff-summary"> <!-- 왼쪽 -->
            <div class="row layout-column">
               <div class="col-md-8 col-xs-12 layout-column-left">

                  <!-- 이미지롤링배너-->
                  <div class="row">
                     <div class="col-xs-12 itemview-carousel">
                        <div class="ibox">
                           <div class="carousel">
                              <div>
                                 <div class="ibox-content">
                                    <img style="width: 700px; height: 600px;" src="${images}fund/${dto.stock_image}" />
                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
                  <!-- 이미지롤링배너 -->

                  <div class="rewardline" style="margin-top: 30px">
                      ${dto.fund_content}
                  </div>

               </div>
               <!-- 왼쪽 -->

               <!-- 오른쪽 -->
               <div class="col-md-4 col-xs-12 pull-right layout-column-right">

                  <ul class="status">
                     <li>
                        <div class="number" style="margin-bottom: 20px">
                          <span style="font-size: 30px;">상품명 :  ${dto.fund_title}</span>
                        </div>
                        <div class="number">
                           <span style="font-size: 30px;">펀드 가격 :<fmt:formatNumber value="${dto.stock_price}" pattern="#,###,###"/>원</span>
                           
                        </div>
                        <br>
                        
                        <div class="number">
                           <span style="font-size: 30px;">참여인원 : ${dto.fund_join}</span>
                        </div>
                         <br>
                        <div class="number">
                           <span style="font-size: 30px;">남은일수 : ${calDateDays}</span>
                        </div>
                       </li>
                     <li class="funding-go row">
                        <div class="col-xs-12 col-sm-12">
                          <a href="#" onclick="FundProductsPop(${dto.fund_no})"
                              class="btn-go btn-primary" oncontextmenu="return false"
                              ondragstart="return false" onselectstart="return false">
                              <div class="big">펀드 참여하기</div>
                           </a>
                        </div>
                     </li>

                  </ul>
                    <!-- 농부정보 -->
                  <div class="farmer">
                     <ul class="collapsible farmer-card" data-collapsible="accordion" style="margin-top: 50px;">
                        <li>
                           <div class="collapsible-header">
                              <img src="${images}main/p_logo.png" class="pic" /> <i
                                 class="icon ion-android-more-vertical icon-more"></i>
                              <div class="header-set">
                                 <h4 class="farmername">${dto.mem_id }  농부</h4>
                              </div>
                           </div>
                           <div class="collapsible-body">
                              <div class="farmerabout">한줄소개</div>
                              <div class="row no-gutter">
                                 <div class="col-xs-4 cell1">
                                    <small>펀드 개설 건수</small>
                                    <h5>${dto2.fundCnt} 건</h5>
                                 </div>
                                 <div class="col-xs-4 cell2">
                                    <small>경매 개설 건수</small>
                                    <h5>${dto2.auctionCnt} 건</h5>
                                 </div>
                                 <div class="col-xs-4 cell3">
                                    <small>투자자수</small>
                                    <h5>${dto2.fund_join}</h5>
                                 </div>
                              </div>
                           </div>
                        </li>
                     </ul>

                  </div>
                  <!-- 농부정보 -->
               </div>
               <!-- 오른쪽 -->
            </div>
            </section>
            <!-- 펀드정보 요약 -->

         </div>
      </div>
      <!-- 상단영역 -->

      <!-- 하단영역 -->
      <div
         class="section section-bg-white layout-md section-itemview-bottom">
         <div class="container">

            <div class="row layout-column">
               <div class="col-md-12 col-xs-12 layout-column-left">
                  <!-- 탭메뉴 본문영역 -->
                  <div class="nav-tabs-custom">
                     <div class="tab-content">

                        <!-- 펀드소개본문 -->
                        <div class="tab-pane active" id="tab_1">
                           <p>
                              <img
                                 src="${images}main/auctionBanner.png"
                                 style="width: 100%;" />
                           </p>

                           <p>&nbsp;</p>

                           <p>
                              <img alt="" src="/filemanager/userfiles/contents/2831/011.JPG"
                                 style="width: 100%;" />
                           </p>

                           <section class="ff-episode">
                           <div class="episode-title">
                              <p>1. 상품의 특징</p>
                           </div>

                           <div class="episode-article">
                              <div class="p">
                                 <p>
                                    <span style="color: #DAA520;">먹은 듯 안 먹은 듯</span>
                                 </p>

                                 <p>오전 11시, 오후 4시 반만 되면 배고픔에 사무치나요? 무심히 과자 반 봉지를 해치우고 나면
                                    입안에 남는 자극적인 뒷맛에 후회가 되지요. 이 상태로 점심, 저녁을 먹으러 가면 마치 이 닦고 밥 먹는
                                    느낌이에요. 여기, 편안한 맛으로 여러분을 사로잡을 달칩이 있습니다. 단순한 재료와 깔끔한 맛으로 언제
                                    먹어도 부담스럽지 않을 거예요. 나초치즈나 과카몰레,&nbsp;토마토 살사, 크림치즈, 바질페스토 등 다양한
                                    딥핑소스와 곁들여보세요! 쉽게 눅눅해지지 않아, 특별한 안주로 변신합니다.</p>

                                 <p>
                                    <img alt=""
                                       src="/filemanager/userfiles/contents/2831/005.JPG"
                                       style="width: 100%;" /><br /> │달칩 110g, 한 통 분량. 25~30개의
                                    넉넉한 양.
                                 </p>

                                 <p>&nbsp;</p>

                                 <p>
                                    <img alt=""
                                       src="/filemanager/userfiles/contents/2831/006.JPG"
                                       style="width: 100%;" />
                                 </p>

                                 <p>&nbsp;</p>

                                 <p>
                                    <span style="color: #DAA520;">유기농 백미/현미 99.6%, 소금,
                                       스테비아. 끝.</span>
                                 </p>
                           </section>

                           <div class="row faq-content">
                              <div class="faqtitle">배송비 안내</div>
                              <b>
                              <ul style="color: #777;">
                                 <li><i class="fa fa-dot-circle-o"></i> 기본 배송비는 투자옵션 가격에
                                    포함되어 있습니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 도서산간지역은 택배사 규정에
                                    따라 추가 배송료가 발생할 수 있습니다. 고객센터로 문의해주세요.<br> <i
                                    class="fa fa-asterisk" style="margin-left: 10px;"></i> 고객센터
                                    문의(1600-3418) / <a href="http://plus.kakao.com/home/@농사펀드">카카오톡(ID:팜팜펀드)</a>
                                    / 이메일(farmfarm@ffd.co.kr)를 이용해주세요.</li>
                              </ul>
                              </b>
                              <div class="faqtitle">교환환불 안내</div>
                              <b>
                              <ul style="color: #777;">
                                 <li><i class="fa fa-dot-circle-o"></i> 단순변심에 의한 취소는 펀드종료
                                    전, 정기발송 상품의 경우 발송 전 까지 가능합니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 받아 보신 제품 중 일부에
                                    이상이 있을 경우 문제가 생긴 만큼 적립금으로 환불해 드립니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 받아 보신 제품 전체에 이상이
                                    있을 경우 100% 적립금으로 환불 혹은 재발송을 해드립니다.</li>
                              </ul>
                              </b>
                              <div class="faqtitle">교환환불 요청</div>
                              <b>
                              <ul style="color: #777;">
                                 <li><i class="fa fa-dot-circle-o"></i> 받아 보신 제품에 이상이 있을
                                    경우 수령 후 2일 이내 사진을 찍어 해당 상품 “이용문의” 코너 or 농사펀드 옐로아이디로 접수해주세요.</li>
                                 <li><i class="fa fa-asterisk" style="margin-left: 10px;"></i>
                                    이용문의 코너 : 마이페이지 > 이용 리스트 > 해당상품 클릭 > 하단 문의하기에 등록</li>
                                 <li><i class="fa fa-asterisk" style="margin-left: 10px;"></i>
                                    농사펀드 옐로아이디 : 카카오톡 > 친구찾기 > ‘농사펀드’로 검색 > 친구추가</li>
                                 <li><i class="fa fa-asterisk" style="margin-left: 10px;"></i>
                                    이메일로 요청 : farmfarm@ffd.co.kr</li>
                              </ul>
                              </b>
                              <div class="faqtitle">교환환불이 불가능한 경우</div>
                              <b>
                              <ul style="color: #777;">
                                 <li><i class="fa fa-dot-circle-o"></i> 신선식품의 경우 제품을 받아
                                    보신 후 단순변심에 의한 교환 및 환불은 불가능합니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 투자자의 책임 있는 사유로 상품
                                    등이 손실 또는 훼손된 경우 교환 및 환불이 불가능합니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 시간의 경과에 의해 재판매가
                                    곤란할 정도로 제품 등의 가치가 현저히 감소한 경우 교환 및 환불이 불가능합니다.</li>
                                 <li><i class="fa fa-dot-circle-o"></i> 신선식품의 경우 배송 중 통화가
                                    안되어 수령을 하지 못했을 경우 폐기처분을 해야 합니다. 회원 정보 및 주문 시 기재하는 연락처의 오기
                                    등으로 연락이 되지 않을 경우 교환 및 환불이 어려울 수 있으니 개인정보를 꼭 확인해주세요.</li>
                              </ul>
                              </b>
                           </div>
                           <div class="fb-comments"
                              data-href="https://farmingfund.co.kr/products/direct/show/2831"
                              data-width="100%" data-numposts="10"></div>
                        </div>
                        <!-- /.tab-pane -->


                     </div>
                     <!-- /.tab-content -->
                  </div>
                  <!-- nav-tabs-custom -->
               </div>
               <!-- 왼쪽 -->


            </div>
            <!-- row -->
            <div
               style="position: fixed; bottom: 20px; font-size: 50px; color: #00A58A; cursor: pointer; width: 50px; bottom: 10px; right: 10px;">
               <i class="fa fa-arrow-circle-up" onclick="window.scrollTo(0,0)"></i>
            </div>
         </div>
         <!-- /.container -->
      </div>
      <!-- /.content-wrapper -->
   </div>
   <div style="margin-left: 1500px;">
      <ul class="bo_v_com">
      <li><a
         href="FundProducts"
         class="btn btn-sm btn-success">목록</a></li>
   </ul>
   </div>
   </form>
   <!--스크립트 공통부분  -->
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="resources/js/bootstrap.js"></script>
   <!-- 4.푸터 -->

   <footer> <%@include file="../Footer.jsp"%>
   </footer>
   <!--푸터 끝  -->
</body>
</html>