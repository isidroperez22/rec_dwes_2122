<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<title>Registro</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<form method="post">
					<label for="usaurio" class="form-label">Usuario</label> 
					<input type="text" class="form-control" id="usuario" name="usaurio"
							required> 
					<label for="first" class="form-label">First Name</label> 
					<input type="text" class="form-control" id="first" name="first"
							required> 
					<label for="last" class="form-label">Last Name</label> 
					<input type="text" class="form-control" id="last" name="last"
							required> 
					<label for="password" class="form-label mt-3">Password</label>
					<input type="password" class="form-control" id="password" name="password" 
							required>
					<label for="confirm" class="form-label mt-3">Confirmar Password</label>
					<input type="password" class="form-control" id="confirm" name="confirm" 
							required>
					<label for="email" class="form-label">Email</label> 
					<input type="text" class="form-control" id="email" name="email"
							required> 
					<input type="submit" class="btn btn-primary w-100 mt-3"
							value="REGISTRARSE" />
				</form>
			</div>
		</div>
	</div>	
</body>
</html>