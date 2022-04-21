<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Oficinas</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-3">
			<div class="col-3">
				<form method ="POST">
					<label for="oficina" class="form-label mt-3">Oficinas</label>
			    	<select class="form-select" id="ofi" name="ofi">
						<c:forEach  items="${offices}" var="o">
							<option value="${o.officeCode}"> ${o.city}</option>
						</c:forEach>					
					</select>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="OBTRENER DATOS" />
				</form>
				
				<p>DATOS DE LA OFICINA DE ${oficinas.city}</p>
				<p>Code: ${oficinas.officeCode}</p>
				<p>Ciudad: ${oficinas.city}</p>
				<p>Telefono: ${oficinas.phone}</p>
				<p>Direccion 1: ${oficinas.addressLine1}</p>
				<p>Direccion 2: ${oficinas.addressLine2}</p>
				<p>Estado: ${oficinas.state}</p>
				<p>Pais: ${oficinas.country}</p>
				<p>Codigo Postal: ${oficinas.postalCode}</p>
				<p>Territorio: ${oficinas.territory}</p>
				
			</div>
		</div>
	</div>
</body>
</html>