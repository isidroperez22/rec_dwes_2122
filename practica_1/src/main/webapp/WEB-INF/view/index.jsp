<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp"/>
<title>Inicio</title>
</head>
<body>

	<%if (session.isNew()){ %>
	
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
			<h1>CENTRAL DE VIAJES</h1>
				<form method="post">
					<label for="usuario" class="form-label mt-3">Usuario</label>
    				<input type="text" class="form-control" id="usuario" name="usuario" required >	
    				<label for="password" class="form-label mt-3">Password</label>
    				<input type="password" class="form-control" id="password" name="password" required>
    				<label for="confirmar" class="form-label mt-3">Confirmar Password</label>
    				<input type="password" class="form-control" id="confirmar" name="confirmar" required>
    				<label for="email" class="form-label mt-3">Email</label>
    				<input type="email" class="form-control" id="email" name="email" required >
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="REGISTRARSE" />
				</form>
			</div>
		</div>
	</div>
	<% }else {%>
	<jsp:include page="include/barra.jsp"/>
		<img src="img/portada.jpg">
	<% } %>
</body>
</html>