<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

	<%@include file="/include/head.jsp"%>
	<body>
	<%@include file="/include/menu.jsp"%> 

	<div class="row">
	
		<div class="container">
			<h3 class="text-center">List Product</h3>
			<hr>
			<div class="container text-left">
					<a href="<%=request.getContextPath()%>/Ajout" class="btn btn-success">Ajouter nouveau Article</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Prix</th>
						<th>Quantité</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${listProduct}">
						<tr>
							<td><c:out value="${product.idProduct}" /></td>
							<td><c:out value="${product.titleProduct}" /></td>
							<td><c:out value="${product.priceProduct}"/> </td>
							<td><c:out value="${product.quantite}" /></td>
							<td>
								<a href="edit?idProduct=<c:out value='${product.idProduct}' />">Modifier</a>
							 	<a href="delete?idProduct=<c:out value='${product.idProduct}' />">Supprimer</a>
							</td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</body>
</html>