<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container mt-5">	
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="employeeNumber mt-3" class="form-label">Numero de Empleado</label>
					<input type="text" class="form-control" id="employeeNumber" name="employeeNumber" required >
						
					<label for="lastName" class="form-label mt-3">Apellidos</label>
    				<input type="text" class="form-control" id="lastName" name="lastName" required >	
    				
    				<label for="name" class="form-label mt-3">Nombre</label>
    				<input type="text" class="form-control" id="name" name="name" required>
    				
    				<label for="extension" class="form-label mt-3">Extension</label>
    				<input type="text" class="form-control" id="extension" name="extension" required>
    				
    				<label for="email" class="form-label mt-3">Email</label>
    				<input type="text" class="form-control" id="email" name="email" required>
    				
    				<label for="officeCode" class="form-label mt-3">Oficina</label>
    				<select class="form-select" id="officeCode" name="officeCode">
						<c:forEach  items="${oficina}" var="o">
							<option value="${o.officeCode}"> ${o.city}</option>
						</c:forEach>					
					</select>
					
					<label for="reportsTo" class="form-label mt-3">Jefe</label>
    				<select class="form-select" id="reportsTo" name="reportsTo">
						<c:forEach  items="${empleado}" var="e">
							<option value="${e.employeeNumber}"> ${e.firstName} ${e.lastName}</option>
						</c:forEach>					
					</select>
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR EMPLEADO" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>