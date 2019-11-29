<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link rel="stylesheet" href="WEB-INF/fontawesome/css/all.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	.header{
		width: 100%;
		position: relative;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
	}
	.header>div{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: flex-start;
		width: auto;
		margin-top: 10px;
	}
	.header .logan{
		display: block;
		text-align: center;
	}
	.header .contact{
		position: absolute;
		left: 20px;
		top: 10px;
		width: 220px;
	}
	.header .user{
		position: absolute;
		right: 20px;
		top: 10px;
		width: 55px;
	}
	.navbar-default, .navbar {
		border:0px;
		margin: 0px;
		padding: 0px;
		width:100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.navbar-nav, .nav{
	display: flex;
	justify-content: center;
	align-items: center;
	}
	.navbar-nav>li{
		padding: 0px 10px;
	}
	.navbar-nav>li>div{
		border-radius: 5px;
		width: 100px;
		box-shadow: 0px 0px 10px 2px lightgrey;
		display: none;
	}
	.navbar-nav>li>div>a{
		color: grey;
		text-decoration: none;
		display: block;
		padding: 5px 5px;
	}
	.navbar-nav>li>div>a:hover{
		color: cyan;
	}
	.navbar-nav>li:hover div {
		display: block;
		position: absolute;
	}
</style>
</head>
<body>
	<header><tiles:insertAttribute name="header"/> </header>
	<main><tiles:insertAttribute name="menu"/></main>
	<footer></footer>
</body>
</html>