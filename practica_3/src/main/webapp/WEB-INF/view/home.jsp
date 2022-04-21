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
			<div class="row justify-content-center mt-2">
			<div class="col-5">
				<c:if test="${sessionScope.role eq'usuario'}">
					<h1>Categorias disponibles</h1>
					<ul>
						<c:forEach items="${productLine}" var="p">
							<li><a href="${pageContext.request.contextPath}/MostrarProductos?pro=${p.productLine}">${p.productLine}</a></li>
						</c:forEach>
						
					</ul>
				</c:if>
				<c:if test="${sessionScope.role eq'admin'}">
					<h1>Categorias disponibles</h1>
					<ul>
						<li><a href="">Mostrar empleados<a></a></li>
						<li><a href="">Añadir empleados</a></li>				
					</ul>
				</c:if>
				</div>
			</div>
		</div>
</body>
</html>
