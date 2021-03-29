<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
				
					<div class="col-sm-6 offset-sm-3">
						<jsp:include page="/components/alert.jsp" />
						<div class="card">
						  <div class="card-header">
						    Add Author
						  </div>
						  <div class="card-body">
							<form action="${pageContext.request.contextPath}/author/add/submit" method="post">
								<div class="form-group">
									<label class="form-label">Details</label>
								</div>
								<div class="row g-3 mb-3">
							  		<div class="col">
								    	<input type="text" class="form-control" name="firstName" placeholder="First name *" required>
								  	</div>
								  	<div class="col">
								    	<input type="text" class="form-control"  name="lastName" placeholder="Last name *" required>
								  	</div>
								</div>
								<div class="row g-3 mb-3">
							  		<div class="col">
							    		<input type="date" class="form-control"  name="dob" placeholder="Date of birth *" required>
							  		</div>
							  		<div class="col">
								    	<input type="email" class="form-control"  name="email" placeholder="Email Email *" required>
							  		</div>
								</div>
	  							<div class="row g-3 mb-3">
							  		<div class="col">
									  	<label class="form-label me-1">Gender *</label>
									  	<div class="form-check form-check-inline">
										  	<input class="form-check-input" type="radio" name="gender" id="Male" value="Male">
			  								<label class="form-check-label" for="Male">Male</label>
									  	</div>
									  	<div class="form-check form-check-inline">
			  								<input class="form-check-input" type="radio" name="gender" id="Female" value="Female">
			  								<label class="form-check-label" for="Female">Female</label>
									  	</div>
							  		</div>
								  	<div class="col">
								    	<input type="number" class="form-control" id="phone" name="phone" placeholder="Phone *" required>
								  	</div>
								</div>
								<hr>
								<div class="form-group">
									<label class="form-label">Address</label>
								</div>
								<div class="row g-3 mb-3">	
							  		<div class="col">
							    		<input type="text" name="line_1" class="form-control" placeholder="Line 1 *" required>
							  		</div>
							  		<div class="col">
								    	<input type="text" name="line_2" class="form-control" placeholder="Line 2">
							  		</div>
								</div>
								<div class="row g-3 mb-3">	
							  		<div class="col">
							    		<input type="number" name="pincode" class="form-control" placeholder="Pincode *" required>
							  		</div>
							  		<div class="col">
							    		<input type="text" name="city" class="form-control" placeholder="City *" required>
							  		</div>
							  		<div class="col">
								    	<input type="text" name="state" class="form-control" placeholder="State *" required>
							  		</div>
							  		<div class="col">
								    	<input type="text" name="country" class="form-control" placeholder="Country *" required>
							  		</div>
								</div>
								<hr>
								<div class="form-group">
							  		<button type="submit" class="btn btn-primary">Register</button>
								</div>
							</form>
						  </div>
						</div>
						
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>