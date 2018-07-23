<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- 관리자 푸터에 넣어야 작동되는 js -->
	<!-- js placed at the end of the document so the pages load faster -->
	<script src="${hostcss}/js/jquery.js"></script>
	<script src="${hostcss}/js/jquery-1.8.3.min.js"></script>
	<script src="${hostcss}/js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="${hostcss}/js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="${hostcss}/js/jquery.scrollTo.min.js"></script>
	<script src="${hostcss}/js/jquery.nicescroll.js" type="text/javascript"></script>
	<script src="${hostcss}/js/jquery.sparkline.js"></script>

	<!--common script for all pages-->
	<script src="${hostcss}/js/common-scripts.js"></script>

	<script type="text/javascript"
		src="${hostcss}/js/gritter/js/jquery.gritter.js"></script>
	<script type="text/javascript" src="${hostcss}/js/gritter-conf.js"></script>

	<!--script for this page-->
	<script src="${hostcss}/js/sparkline-chart.js"></script>
	<script src="${hostcss}/js/zabuto_calendar.js"></script>

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

	<!--script for this page-->
	<script src="resources/css/assets/js/chart-master/Chart.js"></script>
	<script src="resources/css/assets/js/chartjs-conf.js"></script>

	<script>
		//custom select box

		$(function() {
			$('select.styled').customSelect();
		});
	</script>

</body>
</html>