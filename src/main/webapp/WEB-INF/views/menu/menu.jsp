<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<nav class="navbar navbar-default" data-spy="affix" data-offset-top="155">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="men">Men</a>
				<div>
				<c:forEach var="list" items="${categoryList}">
						<a href="#">${list.nameVN}</a>
				</c:forEach>

				</div>
			</li>
			<li><a href="women">Women</a>
				<div>
					<a href="#">Giày</a>
					<a href="#">Sandal</a>
					<a href="#">Túi Xách</a>
					<a href="#">Phụ kiện</a>
				</div>
			</li>
			<li><a href="about">About</a></li>
			<li><a href="contact">Contact</a></li>
		</ul>
	</nav>
</html>