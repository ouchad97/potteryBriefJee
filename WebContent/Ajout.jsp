<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

	<%@include file="/include/head.jsp"%>
	<body>
	<%@include file="/include/menu.jsp"%> 

<body>
    <form class="form-signin" method="post" action="Ajout" var="product" items="${AjoutProduct}">
      <script language="JavaScript">
			function showPreview(ele) {
				$("#imgAvatar").attr("src", ele.value); // for IE
				if (ele.files && ele.files[0]) {
					var reader = new FileReader();
					reader.onload = function(e) {
						$("#imgAvatar").attr("src", e.target.result);
					}
					reader.readAsDataURL(ele.files[0]);
				}
			}
		</script>
      <div class="text-center mb-4">
       				
        <h1 class="h3 mb-3 font-weight-normal">SBahía</h1>
        <p>Une plateforme de gestion simple et performante, vous permet de gérer votre produits.</p>
      </div>
      <div class="container">
				<input type="file" name="image" accept="image/*"
					OnChange="showPreview(this)" required>
				<hr>
				<img id="imgAvatar" class="rounded mx-auto d-block" style="width: 400px; height: 300px; margin-bottom: 30px;">
			</div>
      <div class="form-label-group"> 
        <input type="text" class="form-control" placeholder=""  name="titleProduct" value="<c:out value='${product.titleProduct}' />"  required autofocus>
        
      </div>
      <div class="form-label-group"> 
        <input type="text" class="form-control" placeholder=""  name="priceProduct" value="<c:out value='${product.priceProduct}' />"  required >
        
      </div>

      <div class="form-label-group"> 
        <input type="text"   class="form-control" placeholder=""  name="Quantite" value="<c:out value='${product.Quantite}' />"  required>
      </div>

      <button class="btn btn-lg btn-primary btn-block btnLogin btninscr" type="submit">Ajouter</button>
       <button class="btn btn-lg btn-primary btn-block btnLogin btninscr cancel" type="submit"  onclick="location.href='<%=request.getContextPath()%>/Gestion';" >Annuler</button>
      
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2021</p>
    </form>
  </body>

</html>