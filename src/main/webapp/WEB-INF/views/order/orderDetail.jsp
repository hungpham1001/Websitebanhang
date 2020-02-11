<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<link rel="stylesheet" href="/static/css/basket.css">
</head>
	<div class="container">
		<div id="main" style="">
			<h3 class="alert alert-info">Ordered List</h3>
			<table class="table table-condensed table-hover">
				<thead>
					<tr class="row">
						<th>Order Date</th>
						<th>Price</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody class="basketDetail">
					<c:forEach var="p" items="${orderList}">
						<tr class="row">
								<td>${p.orderDate}</td>
								<td id="priceItem">${p.amount}</td>
								<td>
									<a href="/order/order-detail/${p.id}" class="btn btn-info">Detail</a> 
								</td>
								<td>
									<a href="#" class="btn btn-info">Order Again</a> 
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
</html>