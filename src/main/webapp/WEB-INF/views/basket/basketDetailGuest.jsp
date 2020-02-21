<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@	taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>
<head>
<link rel="stylesheet" href="/static/css/basket.css">
</head>
<div class="basket">
	<div id="sideNav">
		<form:form action="/order/success-guest" modelAttribute="user">
			<h4 class="alert alert-warning">Guest infomation</h4>
			<div class="close">&times;</div>
			<div class="form-group">
				<label>Full Name</label>
				<form:input cssClass="form-control" path="fullname" />
				<form:errors path="fullname" />
			</div>
			<div class="form-group">
				<label>Phone number</label>
				<form:input cssClass="form-control" path="id" />
				<form:errors path="id" />
			</div>
			<div class="form-group">
				<label>Address</label>
				<form:textarea rows="3" cols="4" cssClass="form-control"
					path="address" />
				<form:errors path="address" />
			</div>
			<div class="form-group">
				<label>Description</label>
				<textarea rows="3" cols="4" name="description" class="form-control"></textarea>
			</div>
			<div class="form-group" hidden="true">
				<label>admin<form:checkbox value="false" path="admin"
						cssClass="form-control" /></label>
			</div>
			<div class="form-group" hidden="true">
				<label>active<form:checkbox value="false" path="activated"
						cssClass="form-control" /></label>
			</div>
			<form:button style="margin-top: 10px" type="submit"
				class="btn btn-warning">Purchase</form:button>
		</form:form>
	</div>
	<div id="main" class="container">
		<h3 style="color: red; margin: 20px">${basketMessage}</h3>
		<table class="table table-condensed table-hover">
			<thead>
				<tr class="row">
					<th class="col-xs-2"></th>
					<th class="col-xs-2">Name</th>
					<th class="col-xs-2">Price</th>
					<th class="col-xs-2">Discount</th>
					<th>Quantity</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody class="basketDetail">
				<c:forEach var="p" items="${basketList}">
					<tr data-id="${p.id}" class="row">
						<td class="col-xs-2"><a href="/product/${p.id}"><img
								class="basket-image" alt="" src="https://i.ibb.co/${p.image}"></a></td>
						<td class="col-xs-2">${p.name}</td>
						<td class="col-xs-2" id="priceItem">${p.unitPrice}</td>
						<td class="col-xs-2"><f:formatNumber type="percent"
								value="${p.discount}" /></td>
						<td class="col-xs-2">
							<div id="quantityItem">
								<button name="minusQuantity"
									style="max-height: 30px; max-width: 30px"
									class="btn btn-success glyphicon glyphicon-minus"></button>
								<input name="quantity" type="text" value="${p.quantity}"
									readonly="readonly" style="width: 30px">
								<button name="plusQuantity"
									style="max-height: 30px; max-width: 30px"
									class="btn btn-success glyphicon glyphicon-plus"></button>
							</div>
						</td>
						<td class="col-xs-2">
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
					<td><h4>
							Total: <input id="total" readonly="readonly" type="number"
								style="border: none; color: orange; background-color: transparent;"
								value="${sessionScope['scopedTarget.cartServices'].total}">
						</h4></td>
					<td>
						<button name="checkout" class="btn btn-success">check out</button>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
</html>