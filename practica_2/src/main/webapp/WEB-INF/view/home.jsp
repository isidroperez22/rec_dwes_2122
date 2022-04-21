<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Home</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
			<div class="row justify-content-center mt-5">
			<c:if test="${sessionScope.role eq 'usuario'}">
				<img src="https://img.remediosdigitales.com/79cb08/1967-ford-shelby-gt500-super-snake-continuation-0-2878/1366_2000.jpeg">
			</c:if>
			<c:if test="${sessionScope.role eq 'admin'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Categoria</th>
							<th>Stock</th>
							<th>Precio</th>
							<th>Accion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<td>${p.productCode}</td>
								<td>${p.productName}</td>
								<td>${p.productLine}</td>
								<td>${p.quantityInStock}</td>
								<td>${p.buyPrice}</td>
								<td><a href="Admin/EditarProduct?id=${p.productCode}"><i class="bi bi-people-fill"></i></a>						
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			</div>
		</div>
</body>
</html>