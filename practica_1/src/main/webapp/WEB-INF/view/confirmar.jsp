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
			
				<jsp:useBean id="reserva" class="org.iesalixar.servidor.model.Reserva"/>
					<h1>RESERVA CONFIRMADA</h1>
					<p>FECHA DE INICIO: <jsp:getProperty name="reserva" property="inicio"/></p>
				<p>FECHA DE FINALIZACION: <%= session.getAttribute("fin") %></p>
				
				<p>NUMERO DE PERSONAS: <%= session.getAttribute("personas") %></p>
				
				<p>SERVCIOS RESERVADOS</p>
				
				
				
			</div>
		</div>
	</div>
</body>
</html>