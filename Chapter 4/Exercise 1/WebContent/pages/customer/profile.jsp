<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
				<div class="row">
					<div class="col-sm-12">
						<div style="width: 100%;max-width: 330px;margin: 0 auto;">
							<jsp:include page="/components/alert.jsp" />
							<div class="card">
							  <div class="card-header">
							    Profile
							  </div>
							  <div class="card-body">
							  	<c:if test="${ sessionScope.logged != null && sessionScope.customer != null}">
							  		<div class="mb-3">
							  			${ sessionScope.customer.getFirstName()} ${sessionScope.customer.getLastName()}
							  			<span class="badge bg-primary">${sessionScope.customer.getGender()}</span>
							  		</div>
							  		<div class="mb-3">
							  			Username: ${sessionScope.customer.getUserName()}<br />
							  			Email: ${sessionScope.customer.getEmail()}<br />
							  			DOB: ${sessionScope.customer.getDob()}<br />
							  			<hr />
							  			Address:<br />
							  			Line 1: ${sessionScope.customer.getAddress().getLine_1()}
							  			Phone: ${sessionScope.customer.getPhone()}<br />
							  		</div>
							  	</c:if>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</jsp:attribute>
</t:app>