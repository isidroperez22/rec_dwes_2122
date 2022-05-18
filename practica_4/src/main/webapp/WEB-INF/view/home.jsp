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
					<c:if test="${sessionScope.role eq 'admin'}">
						<div class="col-3">
							<a class="btn btn-primary w-100" href="AddCustomer">AÑADIR CUSTOMER</a>
						</div>
					</c:if>
				</div>
				<table class="table table-striped">	
					<thead>
						<tr>
							<th>Numero de cliente</th>
							<th>Nombre de cliente</th>
							<th>Nombre del contacto</th>
							<th>Apellidos del contacto</th>
							<th>Telefono</th>
							<th>Opciones</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${customer}" var="c">
						<tr></tr>
							<td>${c.customerNumber}</td>
							<td>${c.customerName}</td>
							<td>${c.contactFirstName}</td>
							<td>${c.contactLastName}</td>
							<td>${c.phone}</td>
							<td>
								<c:if test="${sessionScope.role eq 'usuario'}">
									<a href="${pageContext.request.contextPath}/ChangeAssigment?cust=${c.customerNumber}"><i class="bi bi-eye-fill"></i></a>
								</c:if>
								<c:if test="${sessionScope.role eq 'admin'}">
									<a href="${pageContext.request.contextPath}/Admin/ChangeAssigment?cust=${c.customerNumber}"><i class="bi bi-people-fill"></i></a>
								</c:if>
							</td>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>