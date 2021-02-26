<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/include/head.jsp"%> 
	<%@include file="/include/menu.jsp"%>
	<%
		//In case, if Editor session is not set, redirect to Login page
	if ((request.getSession(false).getAttribute("Administrateur") == null)) {
	%>
	<jsp:forward page="login"></jsp:forward>
	<%
		}
	%>
<body>


	<form class="form-signin" method="post" action="update" 
		enctype='multipart/form-data'>

		<br /> <br />
		<script language="JavaScript">
			function showPreview(ele) {
				$("#imgAvatar").attr("src", ele.value);
				if (ele.files && ele.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$("#imgAvatar").attr("src", e.target.result);
					}
					reader.readAsDataURL(ele.files[0]);
				}
			}
		</script>

		<br />

		<div class="container">
			<input type="file" name="image" accept="image/*"
				OnChange="showPreview(this)" required>
			<hr>
			<img id="imgAvatar" class="rounded mx-auto d-block"
				style="width: 300px; height: 150px; margin-bottom: 30px;">
		</div>

		<c:if test="${product == null}">
			<p>c'est null</p>
		</c:if>
		<c:if test="${product != null}">
			<p>bieen  </p>
		</c:if>
		
		
		<div class="form-label-group">
			<p>
				ID Produit :
				<c:out value='${product.idProduct}' />
			</p>
		</div>

		<div class="form-label-group">
			<input type="text" class="form-control" placeholder=""
				name="titleProduct"
				value="<c:out value='${product.titleProduct}' />" required autofocus>
		</div>


		<div class="form-label-group">
			<input type="text" class="form-control" placeholder=""
				name="priceProduct" value="<c:out value='${product.priceProduct}'/>"
				required>
		</div>

		<div class="form-label-group">
			<input type="text" class="form-control" placeholder=""
				name="Quantite" value="<c:out value='${product.quantite}' />"
				required>
		</div>

		<button class="btn btn-lg btn-primary btn-block btnLogin btninscr"
			type="submit">Modifier</button>

		<button
			class="btn btn-lg btn-primary btn-block btnLogin btninscr cancel"
			type="submit"
			onclick="location.href='<%=request.getContextPath()%>/Gestion';">Annuler</button>

		<p class="mt-5 mb-3 text-muted text-center">&copy; 2021</p>
	</form>
</body>

</html>