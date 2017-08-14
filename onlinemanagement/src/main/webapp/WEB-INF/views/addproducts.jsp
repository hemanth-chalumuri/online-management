<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div align="center">

	<h1>Add/Edit Product</h1>
	<form:form action="${contextRoot}/saveproducts" method="post" modelAttribute="productz">
		<table>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Product Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save"></td>
			</tr>
		</table>
	</form:form>

</div>