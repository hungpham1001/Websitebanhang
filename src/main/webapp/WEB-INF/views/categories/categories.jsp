<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container products">
		<h3>Products: ${cate.name}</h3>
		<c:forEach var="p" items="${listProducts}">
			<div class="col-md-3 col-xs-12">
				<div class="frameImage">
					<div class="frameImage-body">
						<img alt="" src="https://i.ibb.co/${p.image}">
					</div>
					<div class="frameImage-footer">
						<a class="btn btn-info" href="/product/${p.id}">Details</a>
					</div>
				</div>
			</div>
		</c:forEach>
		<input id="size" hidden="true" value="${size}">
		<ul class="pagination">
			 <li><a href="#">1</a></li>
			 <li><a href="#">2</a></li>
			 <li><a href="#">3</a></li>
			 <li><a href="#">4</a></li>
			 <li><a href="#">5</a></li>
		</ul>
	</div>
	<script>
		$(function(){
			var size = $("#size").val();
			var i = 0;
			if(size<5){
				for(i;i<5;i++){
					
				}
			}
			
			$(".pagination a:eq(0)").text();
		})
	</script>
</html>