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
		console.log(id);
		var quantity = $(this).closest("div").children("input").val();
		if(quantity<99){
			quantity++;
			$.ajax({
				url:"/plus-item-basket/"+id,
				TYPE:"POST",
				success: function(response){
					$("#cartIcon").text(response[0]);
					$("#total").val(response[1])
				}
	 		})
	 		$(this).closest("div").children("input").val(quantity);
		}
	})
	$("button[name=checkout]").click(function(){
		var html =``;
		if($("#amount").val()!=0){
			$("#main").css({flex:"70%",transition:"0.5s"});
			$("#sideNav").css({display:"block", flex:"30%",transition:"0.5s"})
		} else {
			alert("Please add items into basket!");
			$("h3").prepend("<h4>Please add items into basket!</h4>")
		}
	})
	$(".close").click(function(){
		$("#sideNav").css({display:"none",flex:"0%",transition:"0.5s"});
		$("#main").css({flex:"100%",transition:"0.5s"})
	})
	$("button[name=orderDetail]").click(function(){
		var id = $(this).closest("tr").attr("data-id");
		$.ajax({
			url:"/order/order-detail/"+id
		})
	})
	$(".glyphicon-menu-hamburger").click(function(){
		var display = $(".navbar-nav, .nav").attr("data-status");
		if(display==="false"){
			$(".navbar-nav, .nav").attr("data-status","true");
			$(".navbar-nav, .nav").css("display","flex")
		} else {
			$(".navbar-nav, .nav").attr("data-status","false");
			$(".navbar-nav, .nav").css("display","none")
		}
	})
})