<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="from"%>
<html>
	<div class="container">
	<h3 class="alert alert-success">Registration</h3>
		<from:form action="/account/registration" modelAttribute="user" enctype="multipart/form-data">
			<div class="form-group">
				<div style="color: red; margin-left: 5px">${userExist}</div>
				<label>User</label><from:input path="id" cssClass="form-control"/>
			</div>
			<div class="form-group"><label>Password</label><from:password path="password" cssClass="form-control"/></div>
			<div class="form-group"><label>Confirm Password</label><input class="form-control" type="password" name="confirmPass"/></div>
			<div class="form-group"><label>Full Name</label><from:input path="fullname" cssClass="form-control"/></div>
			<div class="form-group"><label>Email</label><from:input path="email" cssClass="form-control"/></div>
			<div class="form-group"><label>Phone Number</label><from:input path="phoneNumber" cssClass="form-control"/></div>
			<div class="form-group"><label>Address</label><from:textarea cols="5" rows="3" path="address" cssClass="form-control"/></div>
			<div class="form-group" hidden="true"><label>admin<from:checkbox value="false"  path="admin" cssClass="form-control"/></label></div>
			<div class="form-group" hidden="true"><label>active<from:checkbox value="false" path="activated" cssClass="form-control"/></label></div>
			<div class="form-group"><label>upload image</label><input class="form-control" type="file" name="attach">
				<from:hidden path="photo"/>
			</div>
			<button type="submit" class="btn btn-info">Register</button>
		</from:form>
	</div>
</html>