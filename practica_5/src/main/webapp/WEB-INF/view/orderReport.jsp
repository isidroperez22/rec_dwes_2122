<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
<title>Order Report</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-12">		
				<div class="row justify-content-center">
				<h3><fmt:message key="ProductCode"/>: ${ord}</h3>
					<div class="col-10">
						<table class="table table-striped table-hover">
							<thead>
							<tr>
								<th><fmt:message key="ProductName"/></th>
								<th><fmt:message key="Quantity"/></th>
								<th><fmt:message key="Price"/></th>
							</tr>
							</thead>
							<tbody>
								<c:forEach items="${od}" var="o">
									<tr>
										<td>${o.product.productName}</td>
										<td>${o.quantityOrdered}</td>
										<td>${o.priceEach}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>			
</body>
</html>