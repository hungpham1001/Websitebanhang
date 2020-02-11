<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>
	<div class="carousel-inner">
		<div class="item active">
			<img alt="" src="/static/picture/curosel/39-392424_adidas-new-model-shoes..jpg">
		</div>
		<div class="item">
			<img alt="" src="/static/picture/curosel/adidas-Mens-Grand.jpg">
		</div>
		<div class="item">
			<img src="/static/picture/curosel/best-high-top-sneakers.jpg">
		</div>
		<div class="item">
			<img alt=""
				src="/static/picture/curosel/images.jpg">
		</div>
	</div>
	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a> <a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>
<div class="products container">
	<h3>New items</h3>
		<c:forEach var="p" items="${productImage}">
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="frameImage">
					<div class="frameImage-body">
						<img alt="" src="/static/picture/${p.image}">
					</div>
					<div class="frameImage-footer">
						<a class="btn btn-info" href="/product/${p.id}">Detail</a>
					</div>
				</div>
			</div>
		</c:forEach>
</div>

</html>