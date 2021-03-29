<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
				
					<div class="col-sm-6 offset-sm-3">
						<jsp:include page="/components/alert.jsp" />
						<div class="card">
						  <div class="card-header">
						    Order Book
						  </div>
						  <div class="card-body">
							<form action="${pageContext.request.contextPath}/book/order/submit" method="post">
							<div class="row mb-3">
								<div class="col-sm-8">
								  	<c:if test="${requestScope.books != null}">
								  		<select class="form-select" name="bookId" aria-label="Select Book" required>
								  			<option selected disabled value="">-- Select Book --</option>
										  	<c:forEach items="${books}" var="book">
												  <option value="${book.getId()}">${book.getName()} (Author: ${book.getAuthor().getName()}, Qty.: ${book.getQuantity()})</option>
										  	</c:forEach>
									  	</select>
								  	</c:if>
								</div>
								<div class="col-sm-4">
									<input type="number" class="form-control"  name="quantity" placeholder="Quantity *" required>
							  	</div>
							</div>
							
							<div class="form-group mb-3">
							    <textarea class="form-control" id="shippingAddress" name="shippingAddress" rows="3" placeholder="Shipping Address *" required></textarea>
							</div>

							  <button type="submit" class="btn btn-primary">Order</button>
							  <a href="${pageContext.request.contextPath}" class="btn btn-light">Cancel</a>
							</form>
						  </div>
						</div>
						
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>