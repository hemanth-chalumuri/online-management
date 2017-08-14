<div align="center">
	<h1>PRODUCTS</h1>

	<table border="1">

		<th>Name</th>
		<th>Description</th>
		<th>Edit</th>
		<th>Delete</th>

		<c:forEach var="product" items="${products}">
			<tr>

				<td>${product.name}</td>
				<td>${product.description}</td>
				<td><a href="${contextRoot}/addproducts/${product.id}">Edit</a></td>
				<td><a href="${contextRoot}/deleteproduct/${product.id}">Delete</a></td>

			</tr>

		</c:forEach>
		<tr>
			<a href="${contextRoot}/addproducts">Add New Product</a>
		</tr>
	</table>
</div>