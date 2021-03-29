<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:app>
	<jsp:attribute name="body">
		<div class="container mt-5 mb-5">
			<div class="row menu-tab">
				<div class="col-sm-12">
					
				</div>
			</div>
			<div class="row menu-tab">				
				<div class="col-sm-6 offset-sm-3">
				<jsp:include page="../components/alert.jsp" />
					<div class="card">
						<div class="card-header">
							New Tech Book Store
						</div>
						<div class="card-body">
							On Stop Shop for Books!
						</div>
					</div>
				</div>
					
			</div>
		</div>
	</jsp:attribute>
</t:app>