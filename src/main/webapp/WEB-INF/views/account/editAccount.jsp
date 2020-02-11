<%@page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="from"%>
<html>
	<div class="container">
	<h3 class="alert alert-success">Edit Account</h3>
	<h4 class="alert alert-warning">${userEdit}</h4>
		<from:form action="/account/edit" modelAttribute="user" enctype="multipart/form-data">
			<div class="form-group"><label>User</label><from:input readonly="true" path="id" cssClass="form-control"/><i style="color: red; margin-left: 5px"></i></div>
			<from:hidden path="password" />
			<div class="form-group"><label>Full Name</label><from:input readonly="true" path="fullname" cssClass="form-control"/></div>
			<div class="form-group"><label>Email</label><from:input path="email" cssClass="form-control"/></div>
			<div class="form-group"><label>Phone Number</label><from:input path="phoneNumber" cssClass="form-control"/></div>
			<div class="form-group"><label>Address</label><from:textarea cols="5" rows="3" path="address" cssClass="form-control"/></div>
			<from:hidden path="admin" cssClass="form-control"/>
			<from:hidden path="activated" cssClass="form-control"/>
			<div class="form-group"><label>upload image</label><input class="form-control" type="file" name="attach">
			<from:hidden path="photo"/>
			</div>
			<button type="submit" class="btn btn-info">Update</button>
		</from:form>
	</div>
</html>