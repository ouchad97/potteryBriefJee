<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/include/head.jsp"%>
<body>


	<%@include file="/include/menu.jsp"%>
	<%
		//In case, if Editor session is not set, redirect to Login page
	if ((request.getSession(false).getAttribute("Administrateur") == null)) {
	%>
	<jsp:forward page="login"></jsp:forward>
	<%
		}
	%>
	<div class="row"
		style="position: absolute; margin-top: -33%; margin-left: 71%">
		<div class="container">
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/Ajout"
					class="btn btn-success">Ajouter nouveau produit</a>
			</div>
		</div>
	</div>
	<br>

	<div class="container d-flex justify-content-center mt-100 imagesVote">
		<div class="row ">


			<c:forEach var="product" items="${listProduct}" varStatus="display">
				<div class="col-md-3">
					<div class="product-wrapper mb-45 text-center">
						<div class="product-img">
							<a> <img
								src="data:image/jpeg;base64,${ images[display.index] }" alt=""
								width="100%" height="410">
							</a> <span><i class="fa fa-rupee"></i>
							<c:out value='${product.priceProduct}' /></span>
							<div class="product-action">
								<div class="product-action-style">

									<a href="edit?idProduct=<c:out value='${product.idProduct}' />">
										<i><img alt="edit" src="images/edit.png"></i>
									</a> <a
										href="delete?idProduct=<c:out value='${product.idProduct}' />">
										<i><img alt="delete" src="images/delete.png"></i>
									</a>

								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>
</body>
</html>