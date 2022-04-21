<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
			<div class="row justify-content-center mt-5">
				<div class="row justify-content-end">
					<div class="col-3">
						<a class="btn btn-primary w-100" href="AddEmpleado">AÑADIR CUSTOMER</a>
					</div>
				</div>
				<table class="table table-striped">	
					<thead>
						<tr>
							<th>Numero</th>
							<th>Apellidos</th>
							<th>Nombre</th>
							<th>Puesto</th>
							<th>Oficina</th>
							<th>Jefe</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${employees}" var="e">
						<tr></tr>
							<td>${e.employeeNumber}</td>
							<td>${e.lastName}</td>
							<td>${e.firstName}</td>
							<td>${e.jobTitle}</td>
							<td>${e.officeCode}</td>
							<td>
								<c:forEach items="${employees}" var="emp">
									<c:if test="${e.reportsTo == emp.employeeNumber}">
										${emp.firstName} ${emp.lastName}
									</c:if>
								</c:forEach>
							</td>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>
</html>