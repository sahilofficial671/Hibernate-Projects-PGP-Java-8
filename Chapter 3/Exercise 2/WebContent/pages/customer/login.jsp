<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
					<div class="col-sm-12">
						<div style="width: 100%;max-width: 330px;margin: 0 auto;">
							<jsp:include page="/components/alert.jsp" />
							<div class="card">
							  <div class="card-header">
							    Login
							  </div>
							  <div class="card-body">
								<form action="${pageContext.request.contextPath}/customer/login/submit" method="post">
								  <div class="mb-3">
								    <label for="userName" class="form-label">Username</label>
								    <input type="text" class="form-control" id="userName" name="userName">
								  </div>
								  <div class="mb-3">
								    <label for="password" class="form-label">Password</label>
								    <input type="password" class="form-control" id="password" name="password">
								  </div>
								  <button type="submit" class="btn btn-primary">Submit</button>
								   <a href="${pageContext.request.contextPath}" class="btn btn-light">Cancel</a>
								</form>
								<div class="text mt-3">No Account? <a href="${pageContext.request.contextPath}/customer/register" class="link">Click to register.</a></div>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>