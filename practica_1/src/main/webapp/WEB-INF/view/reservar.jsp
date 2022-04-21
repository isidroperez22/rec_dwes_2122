<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp"/>
<title>Reservar</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container">
		<div class="row justify-content-center mt-5">
			<div class="col-6">
				<h1>DATOS DE LA RESERVA</h1>
				<form method="post">
					<label for="inicio" class="form-label mt-3">Fecha inicio</label>
    				<input type="date" class="form-control" id="inicio" name="inicio" required >	
    				<label for="fin" class="form-label mt-3">Fecha fin</label>
    				<input type="date" class="form-control" id="fin" name="fin" required>
    				<label for="personas" class="form-label mt-3">Numero de personas</label>
    				<input type="number" class="form-control" id="personas" name="personas" required>
    				<h3>SERVICIOS</h3>
    				<input type="checkbox" class="form-check-input" id="wifi" name="checkbox" value = "Wifi">  
    				<label class="form-check-label" for="wifi">Wifi</label>
    				<input type="checkbox" class="form-check-input" id="toallas" name="checkbox" value = "Toallas">
    				<label class="form-check-label" for="wifi">Toallas</label>
    				<input type="checkbox" class="form-check-input" id="limpieza" name="checkbox" value = "Limpieza">
    				<label class="form-check-label" for="wifi">Limpieza</label>
    				<input type="checkbox" class="form-check-input" id="ruta" name="checkbox" value = "Ruta guiada">
    				<label class="form-check-label" for="wifi">Ruta guiada</label>
    				<input type="checkbox" class="form-check-input" id="desayuno" name="checkbox" value = "Desayuno">
    				<label class="form-check-label" for="wifi">Desayuno</label>
    				<input type="checkbox" class="form-check-input" id="sauna" name="checkbox" value = "Sauna">
    				<label class="form-check-label" for="wifi">Sauna</label>
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="RESERVAR" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>