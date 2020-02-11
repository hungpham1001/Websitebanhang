<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
	<link rel="stylesheet" href="/static/css/basket.css">
</head>
		<form action="/order/success-guest" method="post" id="sideNav"> 
			<h4 class="alert alert-warning">Guest infomation</h4>
			<div class="close">&times;</div>
			<div class="form-group">
				<label>Full Name</label>
				<input  class="form-control" type="text" name="fullname">
			</div>
			<div class="form-group">
				<label>Phone number</label>
				<input class="form-control" type="text" name="id">
			</div>
			<div class="form-group">
				<label>Address</label>
				<textarea rows="3" cols="4" class="form-control" name="address"></textarea>
			</div>
			<div  class="form-group">
				<label>Description</label>
				<textarea rows="3" cols="4" class="form-control" name="description"></textarea>
			</div>
			<input hidden="true" name="password" value="guest">
			<input hidden="true" name="activated" value="false">
			<input hidden="true" name="admin" value="false">
			<button style="margin-top: 10px" type="submit" class="btn btn-warning">Purchase</button>
		</form>
		<div class="container">
			<div id="main" style="max-width: 100%">
				<h3 style="color: red; margin: 20px ">${basketMessage}</h3>
				<table class="table table-condensed table-hover">
					<thead>
						<tr class="row">
							<th></th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody class="basketDetail">
						<c:forEach var="p" items="${basketList}">
								<tr data-id="${p.id}" class="row">
									<td><a href="/product/${p.id}"><img alt="" src="/static/picture/${p.image}"></a></td>
									<td>${p.name}</td>
									<td id="priceItem">${p.unitPrice}</td>
									<td>
										<div id="quantityItem"><button name="minusQuantity" style="max-height: 30px;max-width: 30px" class="btn btn-success glyphicon glyphicon-minus"></button>
											<input name="quantity" type="text" value="${p.quantity}" readonly="readonly" style="width: 30px"> 
											<button name="plusQuantity" style="max-height: 30px;max-width: 30px" class="btn btn-success glyphicon glyphicon-plus"></button>
										</div>
									</td>
									<td>
										<button name="deleteItemBasket" class="btn btn-info">delete</button> 
									</td>
								</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr class="row">
							<td></td>
							<td></td>
							<td></td>
							<td><h4>Total: <input id="amount" readonly="readonly" type="number" style="border: none; background-color: transparent;" value="${sessionScope['scopedTarget.cartServices'].total}"></h4></td>
							<td>
								<button name="checkout" class="btn btn-success">check out</button> 
							</td>
						</tr>
					</tfoot>
				</table>
		</div>
	</div>
</html>