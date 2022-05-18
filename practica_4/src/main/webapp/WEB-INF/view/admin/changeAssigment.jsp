<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="../include/barra.jsp" />
			<div class="row justify-content-center mt-5">
				<h1>CLIENTE:${cust.customerName}</h1>
				<h1>CONTACT EN CLIENTE:${cust.contactFirstName} ${cust.contactLastName} </h1>
			</div>
		</div>
	
</body>
</html>