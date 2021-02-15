<%@include file="/include/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="en">

	<%@include file="/include/head.jsp"%>

  <body>
    <form class="form-signin" method="post" action="Inscription" var="user" items="${Inscription}">
      <div class="text-center mb-4">
      <img class="mb-4 logo"  alt="logo" width="72" height="72" src="images/lgoSBahia.png" >
       				
        <h1 class="h3 mb-3 font-weight-normal">SBahía</h1>
        <p>Une plateforme de gestion simple et performante, vous permet de gérer votre produits.</p>
      </div>
     <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">Nom</label>
                <input type="text" class="form-control"  placeholder="" value="<c:out value='${user.lastnameUser}' />" name="lastnameUser" required autofocus>
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Prénom</label>
                <input type="text" class="form-control"  placeholder="" value="<c:out value='${user.nameUser}' />" name="nameUser" required>
                <div class="invalid-feedback">
                  Valid last name is required.
                </div>
              </div>
            </div>
      <div class="form-label-group">
      <label for="inputEmail">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address"  name="emailUser" value="<c:out value='${user.emailUser}' />" required >
        
      </div>

      <div class="form-label-group">
      <label for="inputPassword">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password"  name="passwordUser" value="<c:out value='${user.passwordUser}' />" required>
      </div>

      <button class="btn btn-lg btn-primary btn-block btnLogin btninscr" type="submit">Inscrit</button>
       <button class="btn btn-lg btn-primary btn-block btnLogin btninscr cancel" type="submit"  onclick="location.href='<%=request.getContextPath()%>/login';" >Annuler</button>
      
      <p class="mt-5 mb-3 text-muted text-center">&copy; 2021</p>
    </form>
  </body>
</html>