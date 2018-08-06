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
   <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container" style="margin-bottom:120px; margin-top:100px;">
    <div class="row">
        <div class="col-sm-30 col-md-20 col-md-offset0">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th style="padding-left: 100px;">기부단체명</th>
                        <!-- <th>Quantity</th> -->
                        <th>기부단체 담담장</th>
                        <th>기부단체 주소</th>
                        <th>기부단체 연락처</th>
                        <th>기부 금액</th>
                        <th>기부 날짜</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                   <c:set var="total" value="0"/>
                    <c:forEach var="dto" items="${dtos}">
                    <c:set var="total" value="${total+dto.dona_price}"/>
                    <tr>
                        <td class="col-sm-3 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="../farmfarm/resources/images/give/${dto.doOrg_image}" style="width: 72px; height: 72px;"> </a>
                             <div class="media-body">
                                <h4 class="media-heading">${dto.doOrg_name}</h4>
                                
                                <%-- <h5 class="media-heading">${dto.doOrg_hp}</h5> --%>
                                <%-- <span>${dto.doOrg_person} </span><span class="text-success"><strong>In Stock</strong></span> --%>
                            </div> 
                        </div></td>
                        <!-- <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="3">
                        </td> -->
                        <td class="col-sm-2 col-md-1 text-center"><strong>${dto.doOrg_person}</strong></td>
                        <td class="col-sm-2 col-md-1 text-center"><strong>${dto.doOrg_address}</strong></td> 
                        <td class="col-sm-2 col-md-1 text-center"><strong>${dto.doOrg_hp}</strong></td>
                        <td class="col-sm-2 col-md-1 text-center"><strong>${dto.dona_price}</strong></td>
                        <td class="col-sm-2 col-md-1 text-center"><strong>${dto.dona_date}</strong></td>
                        <td></td>
                        <!-- <td class="col-sm-1 col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></td> -->
                    </tr>
                    </c:forEach>
                   <!--  <tr>
                        <td class="col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="media-object" src="http://icons.iconarchive.com/icons/custom-icon-design/flatastic-2/72/product-icon.png" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading"><a href="#">Product name</a></h4>
                                <h5 class="media-heading"> by <a href="#">Brand name</a></h5>
                                <span>Status: </span><span class="text-warning"><strong>Leaves warehouse in 2 - 3 weeks</strong></span>
                            </div>
                        </div></td>
                        <td class="col-md-1" style="text-align: center">
                        <input type="email" class="form-control" id="exampleInputEmail1" value="2">
                        </td>
                        <td class="col-md-1 text-center"><strong>$4.99</strong></td>
                        <td class="col-md-1 text-center"><strong>$9.98</strong></td>
                        <td class="col-md-1">
                        <button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></td>
                    </tr> -->
                   
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td> </td>
                        <td></td>
                        <td><h3>Total</h3></td>
                        <td class="text-right"><h3><strong>${total}</strong></h3></td>
                    </tr>
                    <!-- <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></td>
                        <td>
                        <button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></td>
                    </tr> -->
                </tbody>
            </table>
        </div>
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