<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="../include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<jsp:include page="../include/barra.jsp"/>
	<div class="container mt-5">	
	
		
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="customerNumber mt-3" class="form-label">Numero de cliente</label>
					<input type="text" class="form-control" id="customerNumber" name="customerNumber" required >
					
					<label for="customerName" class="form-label mt-3">Nombre de cliente</label>
    				<input type="text" class="form-control" id="customerName" name="customerName" required >
    					
    				<label for="paymentDate" class="form-label mt-3">Nombre de la persona de contacto</label>
    				<input type="text" class="form-control" id="ContactName" name="ContactName" required>
    				
    				<label for="amount" class="form-label mt-3">Apellido de la persona de contacto</label>
    				<input type="text" class="form-control" id="ContactLastName" name="ContactLastName" required>
    				
    				<label for="amount" class="form-label mt-3">Telefono</label>
    				<input type="text" class="form-control" id="phone" name="phone" required>
    				
    				<label for="amount" class="form-label mt-3">Direccion 1</label>
    				<input type="text" class="form-control" id="address1" name="address1" required>
    				
    				<label for="amount" class="form-label mt-3">Direccion 2</label>
    				<input type="text" class="form-control" id="address2" name="address2" required>
    				
    				<label for="amount" class="form-label mt-3">Ciudad</label>
    				<input type="text" class="form-control" id="city" name="city" required>
    				
    				<label for="amount" class="form-label mt-3">Estado </label>
    				<input type="text" class="form-control" id="State" name="State" required>
    				
    				<label for="amount" class="form-label mt-3">CP</label>
    				<input type="text" class="form-control" id="cp" name="cp" required>
    				
    				<label for="amount" class="form-label mt-3">Pais</label>
    				<input type="text" class="form-control" id="country" name="country" required>
    				
    				<label for="amount" class="form-label mt-3">Empleado</label>
    				<select class="form-select" id="employee" name="employee">
						<c:forEach  items="${empleados}" var="e">
							<option value="${e.employeeNumber}"> ${e.firstName}</option>
						</c:forEach>					
					</select>
    				<label for="amount" class="form-label mt-3">Limite de credito</label>
    				<input type="int" class="form-control" id="credito" name="credito" required>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="AÑADIR CLIENTE" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>