<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="include/bootstrap.jsp" />
<fmt:setBundle basename="interface" />
<title>Change Order</title>
</head>
<body>
	<div class="container mt-5">
		<jsp:include page="include/barra.jsp" />
		<div class="row justify-content-center mt-5">
			<h1>Change Product Customer</h1>
			<div class="col-12">		
				<div class="row justify-content-center">
				<h3>Order code: ${ord.orderNumber}</h3>
					<div class="col-10">
					<form method = "post">
						<label>CUSTOMER:</label>
						<select class="form-select" id="cust" name="cust">
						<c:forEach  items="${customer}" var="c">
							<c:if test = "${c.customerNumber == ord.customerNumber}">
								<option selected value="${c.customerNumber}"> ${c.customerName}</option>
							</c:if>
							<option value="${c.customerNumber}"> ${c.customerName}</option>
						</c:forEach>		
					</select>
					<c:if test="${error!=null}">
							<p class="text-danger text-small mt-3">${error}</p>
					</c:if>
					<input type="submit" class="btn btn-primary w-100 mt-3" value="CHANGE CUSTOMER"/>
					</form>
					
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>