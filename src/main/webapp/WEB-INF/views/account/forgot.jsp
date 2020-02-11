<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container">
		<div class="alert alert-success"><h3>Login</h3></div>
		<h4 style="color: red"><i>${message}</i></h4>
		<form action="/account/forgot" method="post">
			<div class="form-group">
				<label>Email</label><input class="form-control" name="email" type="text">
			</div>
			<button type="submit" class="btn btn-warning">Retrieve Link</button>
		</form>
	</div>
</html>