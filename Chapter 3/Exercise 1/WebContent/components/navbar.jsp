<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark navbar-expand-lg">
    <div class="container-fluid">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">New tech Book Store</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbar-menu" aria-controls="#navbar-menu" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      
      <div class="collapse navbar-collapse" id="navbar-menu">
      
      </div>
      <div class="d-flex right">
	        <% if(request.getSession().getAttribute("logged") != null) { %>
	       		<ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item dropdown">
				        <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<c:out value="${sessionScope.customer.getFirstName()}"/>
			          	</a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/customer/profile">Edit Profile</a></li>
			            <li><hr class="dropdown-divider"></li>
				  		<li><a href="${pageContext.request.contextPath}/customer/logout" class="dropdown-item">Logout</a></li>
			          </ul>
		        	</li>
	     		</ul>
		  	<% }else{ %>
		        <a href="${pageContext.request.contextPath}/customer/login" class="btn btn-light me-2">Login</a>
				<a href="${pageContext.request.contextPath}/customer/register" class="btn btn-outline-light">Sign Up</a>
	     	<% } %>
        </div>
      </div>
</nav>