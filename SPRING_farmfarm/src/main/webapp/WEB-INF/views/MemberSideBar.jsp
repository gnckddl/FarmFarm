<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Bootstrap core CSS -->
    <link href="resources/css/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="resources/css/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="resources/css/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="resources/css/assets/js/gritter/css/jquery.gritter.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/assets/lineicons/style.css">    
    
    <!-- Custom styles for this template -->
    <link href="resources/css/assets/css/style.css" rel="stylesheet">
    <link href="resources/css/assets/css/style-responsive.css" rel="stylesheet">

    <script src="resources/css/assets/js/chart-master/Chart.js"></script>
<body>


<!--header start-->
      <header class="header">
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
              <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-tasks"></i>
                            <span class="badge bg-theme">4</span>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">오늘의 4 업데이트</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">경매 낙찰 건수</div>
                                        <div class="percent">4건</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">펀드 완료 건수</div>
                                        <div class="percent">6건</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">이번달 기부 모금액</div>
                                        <div class="percent">600,000원</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <div class="task-info">
                                        <div class="desc">이번달 거래금</div>
                                        <div class="percent">800,000원</div>
                                    </div>
                                    <div class="progress progress-striped">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (Important)</span>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="external">
                                <a href="#">모두 확인했습니다.</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">5건의 기부신청단체가 있습니다.</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img src="resources/css/assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">장어린</span>
                                    <span class="time">지금 막</span>
                                    </span>
                                    <span class="message">
                                          어린이 도움재단 입니다.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img src="resources/css/assets/img/ui-divya.jpg"></span>
                                    <span class="subject">
                                    <span class="from">메리양</span>
                                    <span class="time">40 분전</span>
                                    </span>
                                    <span class="message">
                                        아프리카 어린이모금단체 입니다.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img src="resources/css/assets/img/ui-danro.jpg"></span>
                                    <span class="subject">
                                    <span class="from">김드림</span>
                                    <span class="time">2 시간 전</span>
                                    </span>
                                    <span class="message">
                                           꿈나무 어린이 보육원 입니다.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt src="resources/css/assets/img/ui-sherman.jpg"></span>
                                    <span class="subject">
                                    <span class="from">마리아</span>
                                    <span class="time">4 시간 전</span>
                                    </span>
                                    <span class="message">
                                           교회단체 입니다.
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">모두 확인 했습니다.</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
      </header>
      <!--header end-->
<!--sidebar start-->
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
                <p class="centered"><a href="HostMain.ad"><img src="resources/images/host/farmHost.png" width="60"></a></p>
                <h5 class="centered" style="color:black">일반회원</h5>
            <!-- <li class="mt">
                <a class="active" href="#">
                    <i class="fa fa-dashboard"></i>
                    <span>기본</span>
                </a>
                <ul class="sub">
                    <li><a href="general.html">General</a></li>
                    <li><a href="buttons.html">Buttons</a></li>
                    <li><a href="panels.html">Panels</a></li>
                </ul> 
            </li> -->

            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class="fa fa-desktop"></i>
                    <span>정보수정</span>
                </a>
                <ul class="sub">
                    <li><a href="updateInfoPage">회원정보 수정</a></li>
                    <li><a href="deleteMember">회원탈퇴</a></li>
                </ul>
            </li>

             <li>
                 <a href="gusetAdv">
                     <i class="fa fa-dashboard"></i>
                     <span>회원점수</span>
                 </a>
             </li>
            <li>
                 <a href="#">
                     <i class="fa fa-dashboard"></i>
                     <span>경매</span>
                 </a>
             </li>
             <li>
                 <a href="#">
                     <i class="fa fa-dashboard"></i>
                     <span>펀드</span>
                 </a>
             </li>
             <li class="sub-menu"><a href="javascript:;"> <i
               class=" fa fa-bar-chart-o"></i> <span>쪽지</span>
            </a>
               <ul class="sub">
                  <li><a href="LetterList">보낸쪽지함</a></li>
                  <li><a href="LetterGetList">받은쪽지함</a></li>
               </ul></li>
            <li><a href="logout"> <i class="fa fa-dashboard"></i> <span>로그아웃</span>
            </a>
         </li>
             <li>
                 <a href="#">
                     <i class="fa fa-dashboard"></i>
                     <span>관심상품 목록</span>
                 </a>
             </li>
             <li>
                 <a href="guestDonateLists">
                     <i class="fa fa-dashboard"></i>
                     <span>내 기부내역</span>
                 </a>
             </li>           
            <li class="sub-menu">
                <a href="javascript:;" >
                    <i class=" fa fa-bar-chart-o"></i>
                    <span>주말 농장</span>
                </a>
                <ul class="sub">
                   <li><a  href="CustomerWeeklyFarmlist">주말농장 관리</a></li>
                  <li><a  href="#">IoT</a></li>
                </ul>
            </li>
            
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->

<!-- js placed at the end of the document so the pages load faster -->
<script src="resources/css/assets/js/jquery.js"></script>
<script src="resources/css/assets/js/jquery-1.8.3.min.js"></script>
<script src="resources/css/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="resources/css/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="resources/css/assets/js/jquery.scrollTo.min.js"></script>
<script src="resources/css/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="resources/css/assets/js/jquery.sparkline.js"></script>


<!--common script for all pages-->
<script src="resources/css/assets/js/common-scripts.js"></script>

<script type="text/javascript" src="resources/css/assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="resources/css/assets/js/gritter-conf.js"></script>

<!--script for this page-->
   <script src="resources/css/assets/js/sparkline-chart.js"></script>    
<script src="resources/css/assets/js/zabuto_calendar.js"></script>   



<script type="application/javascript">
    $(document).ready(function () {
        $("#date-popover").popover({html: true, trigger: "manual"});
        $("#date-popover").hide();
        $("#date-popover").click(function (e) {
            $(this).hide();
        });
    
        $("#my-calendar").zabuto_calendar({
            action: function () {
                return myDateFunction(this.id, false);
            },
            action_nav: function () {
                return myNavFunction(this.id);
            },
            ajax: {
                url: "show_data.php?action=1",
                modal: true
            },
            legend: [
                {type: "text", label: "Special event", badge: "00"},
                {type: "block", label: "Regular event", }
            ]
        });
    });
    
    
    function myNavFunction(id) {
        $("#date-popover").hide();
        var nav = $("#" + id).data("navigation");
        var to = $("#" + id).data("to");
        console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
</script>

</body>
</html>