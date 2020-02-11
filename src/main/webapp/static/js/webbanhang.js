$(document).ready(function(){
	$("button[name=btn-add-to-favo]").click(function(){
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url:"/add-favo/"+id,
			type:"POST",
			success: function(response){
				alert(response)
			}
		})
	})
	$("button[name=btn-add-to-cart]").click(function(){
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url:"/add-to-cart/"+id,
			type:'POST',
			success: function(response){
				$(".basket .label-as-badge").html(response);
			}
		})
	})
	$(".user").click(function(){
		$("#user-detail").toggle();
	})
	$("button[name=deleteItemBasket]").click(function(){
		var id = $(this).closest("tr").attr("data-id");
 		$.ajax({
			url:"/delete-item-basket/"+id,
			TYPE:"POST",
			success: function(response){
				$("#cartIcon").html(response[0]);
				$("#total").html(response[1]);
			}
 		})
 		$(this).closest("tr").remove();
	})
	$("button[name=minusQuantity]").click(function(){
		var id = $(this).closest("tr").attr("data-id");
		var quantity = $(this).closest("div").children("input").val();
		if(quantity>1){
			$.ajax({
				url:"/minus-item-basket/"+id,
				TYPE:"POST",
				success: function(response){
					$("#cartIcon").text(response[0]);
					$("#total").text(response[1])
				}
	 		})
	 		quantity--;
	 		$(this).closest("div").children("input").val(quantity);
		}
	})
	$("button[name=plusQuantity]").click(function(){
		var id = $(this).closest("tr").attr("data-id");
		var quantity = $(this).closest("div").children("input").val();
		if(quantity<99){
			$.ajax({
				url:"/plus-item-basket/"+id,
				TYPE:"POST",
				success: function(response){
					$("#cartIcon").text(response[0]);
					$("#total").text(response[1])
				}
	 		})
	 		quantity++;
	 		$(this).closest("div").children("input").val(quantity);
		}
	})
	$("button[name=checkout]").click(function(){
		console.log($("#amount").val());
		if($("#amount").val()!=0){
			$("#main").css({"margin-left":"320px","transition":"0.5s"});
			$("#sideNav").css("width","320px")
		} else {
			alert("Please add items into basket!")
		}
	})
	$(".close").click(function(){
		$("#sideNav").css({width:"0px"});
		$("#main").css("margin-left","0px")
	})
	$("button[name=orderDetail]").click(function(){
		var id = $(this).closest("tr").attr("data-id");
		$.ajax({
			url:"/order/order-detail/"+id
		})
	})
})