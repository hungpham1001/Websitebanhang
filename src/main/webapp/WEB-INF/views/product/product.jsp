<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container">
		<div class="row product-detail ">
			<h2>Product Detail:</h2>
			<div class="col-sm-4">
				<img alt="" src="https://i.ibb.co/${product.image}">
			</div>
			<div class="col-sm-8">
				<p>Giá: <f:formatNumber value="${product.unitPrice}" pattern="$#.###" /></p>
				<p>Giảm giá: <f:formatNumber value="${product.discount}" type="percent" /></p>
				 <p>Mô tả: ${product.description}</p>
				 <div class="col-sm-12 col-md-4" data-id="${product.id}">
					 <button class="btn btn-success" name="btn-add-to-cart">
						 <i class="glyphicon glyphicon-shopping-cart"></i>Thêm vào giỏ hàng</button>
					  <button class="btn btn-success" name="btn-add-to-favo">
					  	<i class="glyphicon glyphicon-star"></i>Thêm vào mục ưa thích</button>
				  </div>
			</div>
		</div>
		<div class="row theSameProduct">
			<h2>Sản phẩm cùng loại:</h2>
			<div class="img">
				<c:forEach var="p" items="${list}">
						<a href="/product/${p.id}"><img  alt="" src="https://i.ibb.co/${p.image}"></a>
				</c:forEach>
			</div>
		</div>
	</div>
</html>