<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- 테이블 아래 이동키  -->
<link
   href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
   src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
<!-- 테이블 아래 이동키 끝  -->

<!-- 헤더 -->
<%@ include file="../Header.jsp"%>

<!-- 관리자 사이드 바 -->
<%@ include file="../HostSideBar.jsp"%>
<head>
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

<title>파트너 관리</title>
<body>

   <section id="container"> <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
   <!--main content start-->
   <section id="main-content">
   <section class="wrapper">
   <h3>
      <i class="fa fa-angle-right"></i> 파트너 관리
   </h3>
   <div class="row">
      <!-- 차트 시작 -->
      <div class="tab-pane" id="chartjs">
         <div class="row mt">
                        <!-- 분야별 펀드 현황 차트 시작 -->
            <div class="col-lg-6">
               <div class="content-panel">
                  <h4>
                     <i class="fa fa-angle-right"></i> 분야별 펀드 현황
                  </h4>
                  <div class="panel-body text-center">
                  <!-- 차트에 입력할 값 c:set 작업 -->
                   <c:set var="event" value="${map['event']}"></c:set>
                   <c:set var="farm" value="${map['farm']}"></c:set>
                   <c:set var="animal" value="${map['animal']}"></c:set>
                   <c:set var="fish" value="${map['fish']}"></c:set>
                    <c:set var="health" value="${map['health']}"></c:set>
                   <c:set var="mushroom" value="${map['mushroom']}"></c:set>
                   <c:set var="alcohol" value="${map['alcohol']}"></c:set>
                   <c:set var="etc" value="${map['etc']}"></c:set>
                  
                      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                      <script type="text/javascript">
                        google.charts.load('current', {'packages':['bar']});
                        google.charts.setOnLoadCallback(drawChart);
                  
                        function drawChart() {
                          var data = google.visualization.arrayToDataTable([
                            ['', '총 금액'],
                            ['이벤트', ${event}],
                            ['농산', ${farm}],
                            ['축산', ${animal}],
                            ['수산', ${fish}],
                            ['건강·유기농', ${health}],
                            ['버섯', ${mushroom}],
                            ['주류', ${alcohol}],
                            ['기타', ${etc}]
                          ]);
                  
                          var options = {
                            chart: {
                              title: '',
                              subtitle: '',
                            },
                            bars: 'horizontal' // Required for Material Bar Charts.
                          };
                  
                          var chart = new google.charts.Bar(document.getElementById('partnerFund'));
                  
                          chart.draw(data, google.charts.Bar.convertOptions(options));
                        }
                      </script>
                      <div id="partnerFund" style="width: 400px; height: 400px;"></div>
                  </div>
               </div>
            </div>
            <!-- 분야별 펀드 현황 차트 끝 -->

            <!-- 분야별 경매 현황 차트 시작 -->
            <div class="col-lg-6">
               <div class="content-panel">
                  <h4>
                     <i class="fa fa-angle-right"></i> 분야별 경매 현황 차트
                  </h4>
                  <div class="panel-body text-center">
                     <!-- 차트에 입력할 값 c:set 작업 -->
                   <c:set var="event" value="${map1['event']}"></c:set>
                   <c:set var="farm" value="${map1['farm']}"></c:set>
                   <c:set var="animal" value="${map1['animal']}"></c:set>
                   <c:set var="fish" value="${map1['fish']}"></c:set>
                    <c:set var="health" value="${map1['health']}"></c:set>
                   <c:set var="mushroom" value="${map1['mushroom']}"></c:set>
                   <c:set var="alcohol" value="${map1['alcohol']}"></c:set>
                   <c:set var="etc" value="${map1['etc']}"></c:set>
                  
                      <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                      <script type="text/javascript">
                        google.charts.load('current', {'packages':['bar']});
                        google.charts.setOnLoadCallback(drawChart);
                  
                        function drawChart() {
                          var data = google.visualization.arrayToDataTable([
                            ['', '총 금액'],
                            ['이벤트', ${event}],
                            ['농산', ${farm}],
                            ['축산', ${animal}],
                            ['수산', ${fish}],
                            ['건강·유기농', ${health}],
                            ['버섯', ${mushroom}],
                            ['주류', ${alcohol}],
                            ['기타', ${etc}]
                          ]);
                  
                          var options = {
                            chart: {
                              title: '',
                              subtitle: '',
                            },
                            bars: 'horizontal' // Required for Material Bar Charts.
                          };
                  
                          var chart = new google.charts.Bar(document.getElementById('partnerAuc'));
                  
                          chart.draw(data, google.charts.Bar.convertOptions(options));
                        }
                      </script>
                      <div id="partnerAuc" style="width: 400px; height: 400px;"></div>
                  </div>
               </div>
            </div>
            <!-- 분야별 경매 현황 차트 끝 -->
         </div>
      </div>
      <!-- 차트 끝 -->

      <hr width="0%">

      <div class="row mt">
         <div class="col-md-12">
            <div class="content-panel">
               <!-- 파트너 관리 테이블 시작 -->
               <h4>
                  <i class="fa fa-angle-right"></i> 파트너 관리
               </h4>
               <table class="table table-striped table-advance table-hover">
                  <hr>
                  <thead>
                     <tr>
                        <th style="width: 1%"><input type="checkbox" id="checkall" /></th>
                        <th style="width: 5%"><i class="fa fa-bullhorn"></i> 번호</th>
                        <th style="width: 5%"><i class="fa fa-heart"></i> 아이디</th>
                        <th style="width: 5%"><i class="fa fa-eye"></i>   이름</th>
                        <th style="width: 10%"><i class="fa fa-phone-square"></i> 연락처</th>
                        <th style="width: 10%"><i class=" fa fa-bookmark"></i> 등록/승인일</th>
                        <th style="width: 5%"><i class="fa fa-star"></i> 상태</th>
                        <th style="width: 5%"><i class="fa fa-plus-square"></i>점수</th>
                        <th style="width: 10%"><i class=" fa fa-smile-o"></i> 어드벤티지</th>
                        <th style="width: 15%"><i class=" fa fa-edit"></i> 파트너 관리</th>
                     </tr>
                  </thead>
                  <tbody>
                     <!-- 회원 목록이 있으면  -->
                     <c:if test="${cnt>0}">
                        <!-- 큰바구니에서 작은바구니로 한건을꺼냄 건수만큼 반복하라-->
                        <c:forEach var="dto" items="${dtos}">
                           <tr>
                              <td><input type="checkbox" class="checkthis"></td>
                              <td>${number}<c:set var="number" value="${number-1}" /></td>
                              <td><a href="#">${dto.mem_id}</a></td>
                              <td>${dto.mem_name}</td>
                              <td>${dto.mem_hp}</td>
                              <td>${dto.farm_regDate}</td>
                              <c:if test="${dto.farm_status == 1}">
                              <c:set var="mem_grade" value="${dto.mem_grade}"/>
                                 <td><span class="badge bg-warning">신청 대기</span></td>
                              </c:if>
                              <c:if test="${dto.farm_status == 2}">
                              <c:set var="mem_grade" value="${dto.mem_grade +1}"/>
                                 <td><span class="badge bg-info">파트너</span></td>
                              </c:if>
                              <td>${dto.farm_adv}</td>
                              <td>
                                 <!-- 파트너 어드밴티지 가산점 -->
                                
                                 <div class="btn-group">
                                   <button type="button" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
                                     <i class="fa fa-plus"></i>
                                   </button>
                                   
                                   <ul class="dropdown-menu" role="menu">
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=1&advStatue=1&pageNum=${pageNum}&mem_grade=${mem_grade}">1점</a></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=5&advStatue=1&pageNum=${pageNum}&mem_grade=${mem_grade}">5점</a></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=10&advStatue=1&pageNum=${pageNum}&mem_grade=${mem_grade}">10점</a></li>
                                     <li class="divider"></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=50&advStatue=1&pageNum=${pageNum}&mem_grade=${mem_grade}">50점</a></li>
                                   </ul>
                                 </div>
                                   <!-- 파트너 어드밴티지 가산점 -->
                                   <!-- 파트너 어드밴티지 감점 -->
                                 <div class="btn-group">
                                   <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
                                     <i class="fa fa-minus"></i>
                                   </button>
                                   <ul class="dropdown-menu" role="menu">
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=1&advStatue=2&pageNum=${pageNum}&mem_grade=${mem_grade}">-1점</a></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=5&advStatue=2&pageNum=${pageNum}&mem_grade=${mem_grade}">-5점</a></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=10&advStatue=2&pageNum=${pageNum}&mem_grade=${mem_grade}">-10점</a></li>
                                     <li class="divider"></li>
                                     <li><a href="PartnerAdvManage.ad?mem_id=${dto.mem_id}&mem_adv=50&advStatue=2&pageNum=${pageNum}&mem_grade=${mem_grade}">-50점</a></li>
                                   </ul>
                                 </div>
                                   </div>
                                   <!-- 파트너 어드밴티지 감점 -->
                  
                              </td>
                              <!-- 파트너 관리 버튼 -->
                              <td>
                                 <c:if test="${dto.farm_status == 1}">
                                    <button class="btn btn-success btn-xs" onclick="return farmUp('${dto.mem_id}');">
                                       <i class="fa fa-check"></i>
                                    </button>
                                 </c:if>
                                 <button class="btn btn-danger btn-xs" onclick="return farmDown('${dto.mem_id}')">
                                    <i class="fa fa-trash-o "></i>
                                 </button>
                              </td>
                              <!-- 파트너 관리 버튼 -->
                           </tr>
                        </c:forEach>
                        <tr align="center">
                           <td colspan="9"></td>
                           <td>
                              <button class="btn btn-success btn-xs">
                                 <i class="fa fa-check"></i>
                              </button>
                              <button class="btn btn-danger btn-xs">
                                 <i class="fa fa-trash-o "></i>
                              </button>
                           </td>
                        </tr>
                     </c:if>
                     <!-- 회원 목록이 있으면 끝 -->

                     <!-- 게시글이 없으면 -->
                     <c:if test="${cnt==0}">
                        <tr>
                           <td colspan="9" align="center">파트너 회원이 없습니다.!!</td>
                        </tr>
                     </c:if>
                  </tbody>
               </table>
               <!-- 파트너 관리 테이블 종료 -->

               <!-- 페이지 컨트롤 시작 -->
               <c:if test="${cnt>0 }">
                  <div class="clearfix"></div>
                  <ul class="pagination pull-right">
                     <c:if test="${startPage > pageBlock}">
                        <li class="disabled"><a   href="PartnerManage.ad?${startPage - pageBlock}">
                        <span class="glyphicon glyphicon-chevron-left"></span></a></li>
                     </c:if>

                     <c:forEach var="i" begin="${startPage}" end="${endPage}">
                        <c:if test="${i == currentPage}">
                           <li class="active"><a href="PartnerManage.ad?pageNum=${i}">${i}</a></li>
                        </c:if>

                        <c:if test="${i != currentPage}">
                           <li><a href="PartnerManage.ad?pageNum=${i}">${i}</a></li>
                        </c:if>
                     </c:forEach>

                     <c:if test="${pageCount > endPage}">
                        <li><a href="PartnerManage.ad?pageNum=${startPage + pageBlock}">
                        <span class="glyphicon glyphicon-chevron-right"></span></a></li>
                     </c:if>
                  </ul>
               </c:if>
               <!-- 페이지 컨트롤 종료 -->

            </div>
            <!-- /content-panel -->
         </div>
         <!-- /col-md-12 -->
      </div>
      <!-- /row -->
   </section><!--/wrapper -->
   </section><!-- /MAIN CONTENT --> <!--main content end-->
   </section>

   <!-- 관리자 푸터 -->
   <footer> <%@ include file="../HostFooter.jsp"%>
   </footer>

   <!-- 푸터 -->
   <footer> <%@ include file="../Footer.jsp"%>
   </footer>
</body>
</html>