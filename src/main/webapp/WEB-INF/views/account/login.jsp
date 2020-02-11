<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container">
		<div class="alert alert-success"><h3>Login</h3></div>
		<h4 style="color: red"><i>${sessionScope['errorMessageLogin']}</i></h4>
		<form action="/account/login" method="post">
			<div class="form-group">
				<label>User: </label><input class="form-control" name="user" type="text">
			</div>
			<div class="form-group">
				<label>Password: </label><input class="form-control" name="pw" type="password">
			</div>
			<div class="checkbox">
				<label><input type="checkbox" name="rmb">remember me?</label>
			</div>
			<button class="btn btn-info" type="submit" >Login</button>
		</form>
		<div style="margin-top: 20px">
			<a style="text-decoration: none" href="/account/registration">Registration</a>
			<a style="text-decoration: none; margin-left: 50px" href="/account/forgot">Forgot Password</a>
		</div>
	</div>
</html>