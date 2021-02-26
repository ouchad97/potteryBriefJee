<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/include/head.jsp"%>

<body>

	<form class="form-signin" 
		action="<%=request.getContextPath()%>/login" method="post">
		<div class="text-center mb-4">
			<img class="mb-4 logo" src="images/lgoSBahia.png" alt="logo"
				width="72" height="72">

			<h1 class="h3 mb-3 font-weight-normal">SBahía</h1>
			<p>Une plateforme de gestion simple et performante, vous permet
				de gérer votre produits.</p>
		</div>

		<div class="form-label-group">
			<input type="email" id="inputEmail" class="form-control"
				name="emailUser" placeholder="Email address" required autofocus>

		</div>

		<div class="form-label-group">
			<input type="password" id="inputPassword" class="form-control"
				name="passwordUser" placeholder="Password" required>

		</div>

		<div class="checkbox mb-3">
			<label><a class="linkInsc"
				href="<%=request.getContextPath()%>/Inscription">Inscription</a></label>
		</div>
		<button class="btn btn-lg btn-primary btn-block btnLogin"
			type="submit">Connexion</button>
		<p class="mt-5 mb-3 text-muted text-center">&copy; 2021</p>
	</form>
</body>
</html>