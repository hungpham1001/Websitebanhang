<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container">
		<div class="alert alert-success"><h3>Success</h3></div>
		<h4 style="text-align: center; color: red">${sessionScope['success']}</h4>
	</div>
</html>