<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
	<nav class="navbar navbar-default" data-spy="affix" data-offset-top="150">
		<div class="collapse-menu">
			<span class="glyphicon glyphicon-menu-hamburger"></span>
			<ul data-status="false" class="nav navbar-nav">
				<li><a href="/home">Home</a></li>
				<li><a href="#">All Product</a>
					<div>
						<a href="#">Best seller</a>
						<a href="#">New items</a>
						<a href="#">Sale items</a>
					</div>
				</li>
				<li><a href="#">Men</a>
					<div>
						<c:forEach var="list" items="${categoryList}">
							<a href="/category/${list.id}">${list.name}</a>
						</c:forEach>
					</div>
				<li><a href="/about">About</a></li>
				<li><a href="/contact">Contact</a></li>
			</ul>
		</div>
		<div class="menu-nav">
			<div class="user">
					<c:choose>
						<c:when test="${empty sessionScope['user']}">
							<a  href="#" style="text-decoration: none" class="glyphicon glyphicon-user"></a>
							<div id="user-detail">
								<a href="/account/login">Log in</a>
								<a href="/account/registration">Registration</a>
							</div>
						</c:when>
						<c:otherwise>
							<img style="margin-right: 20px; border-radius: 50%; max-width: 30px; height: auto" alt="" src="/static/picture/user/${sessionScope['user'].photo}">
							<div id="user-detail">
								<a href="/account/edit">Edit account</a>
								<a href="/account/change-password">Change Password</a>
								<a href="/order/order-detail">Order Detail</a>
								<a href="/account/logout">Log out</a>
							</div>
						</c:otherwise>
					</c:choose>
			</div>
			<div class="basket">
				<c:choose>
					<c:when test="${empty sessionScope['user']}">
						<a href="/basket/basket-detail-guest">
							<c:set var="cart" value="${sessionScope['scopedTarget.cartServices']}"></c:set>
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span id="cartIcon" class="label label-as-badge label-danger">${cart.countOfCart}</span>
						</a>
					</c:when>
					<c:otherwise>
						<a href="/basket/basket-detail-mem">
							<c:set var="cart" value="${sessionScope['scopedTarget.cartServices']}"></c:set>
							<span class="glyphicon glyphicon-shopping-cart"></span>
							<span id="cartIcon" class="label label-as-badge label-danger">${cart.countOfCart}</span>
						</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>