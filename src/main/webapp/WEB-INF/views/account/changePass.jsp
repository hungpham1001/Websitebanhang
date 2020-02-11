<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
	<div class="container">
		<div class="alert alert-success"><h3>Change Password</h3></div>
		<h4 style="color: red"><i>${message}</i></h4>
		<form action="/account/forgot/userId" method="post">
			<div class="form-group">
				<label>Pass </label><input class="form-control" name="pass" type="password">
			</div>
			<div class="form-group">
				<label>Confirm Password </label><input class="form-control" name="confirm" type="password">
			</div>
				<button class="btn btn-info" type="submit" >Confirm</button>
		</form>
		<div style="color: blue; font-size: 25px; margin-top: 15px"><a href="/home">Home Page</a></div>
	</div>
</html>