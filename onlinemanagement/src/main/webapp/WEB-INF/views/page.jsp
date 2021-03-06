<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Management System - ${title}</title>
<script>
	window.menu = '${title}'
</script>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Theme -->
<link href="${css}/bootstrap-boot-theme.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">
<style>
body {
	padding-top: 70px;
	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}
</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->

		<div class="content">
			<!-- loading home content -->
			<c:if test="${userClickHome==true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- loading only when user clicks About -->
			<c:if test="${userClickAbout==true }">
				<%@include file="about.jsp"%>
			</c:if>
			
			<c:if test="${userClickViewProducts==true }">
				<%@include file="viewproducts.jsp"%>
			</c:if>
			
			<c:if test="${userClickAddProducts==true }">
				<%@include file="addproducts.jsp"%>
			</c:if>
			
		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- jQuery Version 1.11.1 -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>

		<!-- userdefined jquery -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>
