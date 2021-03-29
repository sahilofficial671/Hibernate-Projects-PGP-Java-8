<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
					<div class="col-sm-6 offset-sm-3">
						<jsp:include page="/components/alert.jsp" />
						<div class="card">
						  <div class="card-header">
						    View Book Information
						  </div>
						  <div class="card-body">
						  
			  				<div class="row">
								<div class="col-sm-4">Select for which you are looking for:</div>
								<div class="col-sm-8">
								  	<c:if test="${requestScope.books != null}">
								  		<select class="form-select" name="bookId" aria-label="Select Book" required>
								  			<option selected disabled value="">-- Select Book --</option>
										  	<c:forEach items="${books}" var="book">
												  <option value="${book.getId()}">${book.getName()} (Author: ${book.getAuthor().getName()})</option>
										  	</c:forEach>
									  	</select>
								  	</c:if>
								</div>
							</div>
							
							<div class="row d-none mt-3" id="book_details">
							<hr>
								<div class="col-sm-12">
									<div>Name: <span id="name"></span></div>
									<div>Edition: <span id="edition"></span></div>
									<div>Category: <span id="category"></span></div>
									<div>Author: <span id="author_name"></span></div>
									<div>Publisher: <span id="publisher"></span></div>
									<div>Publishing Year: <span id="publishingYear"></span></div>
									<div>Price: <span id="price"></span></div>
									<div>Quantity Available: <span id="quantity"></span></div>
								</div>
							</div>
							
						  </div>
						</div>
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>