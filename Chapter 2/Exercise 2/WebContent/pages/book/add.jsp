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
						    Add Book
						  </div>
						  <div class="card-body">
							<form action="${pageContext.request.contextPath}/book/add/submit" method="post">
							<div class="row g-3 mb-3">
							  <div class="col">
							    <input type="text" class="form-control" name="name" placeholder="Book Name *" required autofocus="autofocus">
							  </div>
							  <div class="col">
							    <input type="text" class="form-control"  name="edition" placeholder="Edition *" required>
							  </div>
							</div>
							<div class="row g-3 mb-3">
							  <div class="col">
							    <input type="text" class="form-control"  name="publisher" placeholder="Publisher *" required>
							  </div>
							  <div class="col">
							    <input type="number" class="form-control"  name="publishingYear" placeholder="Publishing Year *" required>
							  </div>
							</div>
							
 							<div class="row g-3 mb-3">
							  <div class="col">
							  	<select class="form-select" name="category" aria-label="Select Book Category" required>
								  <option selected disabled value="">-- Select Book Category --</option>
								  <option value="technical">Technical</option>
								  <option value="novel">Novel</option>
								  <option value="history">History</option>
								  <option value="science">Science</option>
								</select>
							  </div>
							    <div class="col">
							    	<input type="text" class="form-control"  name="author_name" placeholder="Author Name *" required>
							  	</div>
							</div>
							
							<div class="row g-3 mb-3">
							  <div class="col">
							    <input type="number" class="form-control"  name="price" placeholder="Price *" required>
							  </div>
							  <div class="col">
							    <input type="number" class="form-control"  name="quantity" placeholder="Quantity *" required>
							  </div>
							</div>

							  <button type="submit" class="btn btn-primary">Add</button>
							  <a href="${pageContext.request.contextPath}" class="btn btn-light">Cancel</a>
							</form>
						  </div>
						</div>
						
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>