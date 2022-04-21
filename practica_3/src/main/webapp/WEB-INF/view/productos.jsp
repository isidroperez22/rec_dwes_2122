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
			<h1>Productos de la categoria ${pro.toUpperCase()}</h1>
				<table class="table table-striped">	
					<thead>
						<tr>
							<th>Numero</th>
							<th>Apellidos</th>
							<th>Nombre</th>
							<th>Puesto</th>
							<th>Oficina</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<td>${p.productName}</td>
								<td>${p.productDescription}</td>
								<td>${p.productVendor}</td>
								<td>${p.buyPrice}</td>
								<td>${p.quantityInStock}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
</body>
</html>