<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align="center">


	<!-- For displaying the errors at the top of the page -->
	<spring:hasBindErrors name="productz">
		<c:forEach var="error" items="${errors.allErrors}">
			<b><spring:message message="${error}" /></b>
			<br />
		</c:forEach>
	</spring:hasBindErrors>

	<c:choose>
		<c:when test="${edit==true }">
			<b><h1>Edit Product</h1></b>
		</c:when>
		<c:otherwise>
			<b><h1>Add Product</h1></b>
		</c:otherwise>
	</c:choose>

	<form:form action="${contextRoot}/saveproducts" method="post"
		modelAttribute="productz">
		<table>
			<tr>
				<form:hidden path="id" />
				<td>Product Name:</td>
				<td><form:input path="name" /></td>
				<%--for displaying error next to field <td><form:errors path="name" /></td> --%>
			</tr>
			<tr>
				<td>Product Description:</td>
				<td><form:input path="description" /></td>
				<%-- <td><form:errors path="description" /></td> --%>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save"></td>
			</tr>
		</table>
	</form:form>

</div>