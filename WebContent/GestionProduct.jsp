<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/include/head.jsp"%>
<body>
	<%@include file="/include/menu.jsp"%>



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


			<c:forEach var="product" items="${listProduct}" varStatus="status">


				<div class="col-md-3">
					<div class="product-wrapper mb-45 text-center">
						<div class="product-img">
							<a> <img
								src="data:image/jpeg;base64,${ images[status.index] }" alt=""
								width="100%" height="410">
							</a> <span><i class="fa fa-rupee"></i>55</span>
							<div class="product-action">
								<div class="product-action-style">
								
									<a href="#"> <i><img alt="" src="images/edit.png"></i></a>
									<a href="#"> <i><img alt="" src="images/delete.png"></i></a>

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