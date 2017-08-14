<div align="center">
	<h1>PRODUCTS</h1>
	<h3>
		<a href="${contextRoot}/addproducts">New Product</a>
	</h3>
	<table border="1">

		<th>Name</th>
		<th>Description</th>

		  <c:forEach var="product" items="${products}">
			<tr>

				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>
					<a href="editproduct?id=${product.id}">Edit</a> 
					<a href="deleteproduct?id=${product.id}">Delete</a>
				</td>

			</tr>
		</c:forEach>  
	</table>
</div>