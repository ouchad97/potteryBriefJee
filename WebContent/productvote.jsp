<%@include file="/include/taglibs.jsp"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang="en">

<%@include file="/include/head.jsp"%>

<link
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>

<script
	src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script
	src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
<body>

	<%@include file="/include/menu.jsp"%>
	<%
		//In case, if Editor session is not set, redirect to Login page
	if ((request.getSession(false).getAttribute("Client") == null)) {
	%>
	<jsp:forward page="login"></jsp:forward>
	<%
		}
	%>

		
	<div class="container d-flex justify-content-center mt-100 imagesVote">

		<div class="row ">

			<c:forEach var="product" items="${listProduct}" varStatus="display">


					<div class="col-md-3">
						<div class="product-wrapper mb-45 text-center">
							<div class="product-img">
								<a> <img
									src="data:image/jpeg;base64,${ images[display.index] }" alt=""
									width="100%" height="410">
								</a> <span><i class="fa fa-rupee"></i>55</span>
								<div class="product-action">
									<div class="product-action-style"> 
									
			            <form action="vote" method="post">
		                	<input type="text" name="idUser" value="<c:out value='${CURRENT_USER.idUser}'/>"  />
		                	<input type="text" name="idUser" value="<c:out value='${product.idProduct}'/>"/>   
		                	<a> 
		                		<i> 
		                			<input type="image" src="images/like.png" alt="Like" >
								</i>
							</a>
						</form>
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