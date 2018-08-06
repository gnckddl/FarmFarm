<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<!-- IoT 점검현황 시작 -->
	<div class="content-panel">
		<table class="table table-hover">
			<h4>
				<i class="fa fa-angle-right"></i> IOT 점검현황
			</h4>
			<hr>
			<thead>
				<tr>
					<th style="width: 5%">번호</th>
					<th style="width: 15%">농장명</th>
					<th style="width: 15%">온도센서 연결여부</th>
					<th style="width: 15%">토양 습도센서 연결여부</th>
					<th style="width: 15%">카메라 연결여부</th>
					<th style="width: 15%">농장주 연락처</th>
					<th style="width: 5%">버튼</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>푸른농장</td>
					<td>o</td>
					<td>o</td>
					<td>x</td>
					<td>010-7777-7111</td>
					<td>
						<button type="button" class="btn btn-round btn-primary">점검요청</button>
					</td>
				</tr>
				<tr>
					<td>2</td>
					<td>촉촉농장</td>
					<td>o</td>
					<td>o</td>
					<td>o</td>
					<td>010-3333-7111</td>
					<td>
						<button type="button" class="btn btn-round btn-default">점검완료</button>
					</td>
				</tr>
				<tr>
					<td>3</td>
					<td>넓은농장</td>
					<td>o</td>
					<td>o</td>
					<td>o</td>
					<td>010-4444-7111</td>
					<td>
						<button type="button" class="btn btn-round btn-primary">점검요청</button>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!--/content-panel -->
	<!-- IoT 점검현황 끝 -->
</body>
</html>