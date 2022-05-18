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
<title>Add Products</title>
</head>
<body>
<jsp:include page="include/barra.jsp"/>
	<div class="container mt-5">	
	
		
		<div class="row justify-content-center mt-3">
			<div class="col-6">
				<form method="post">
					<label for="productCode mt-3" class="form-label">Product Code</label>
					<input type="text" class="form-control" id="productCode" name="productCode" required >
						
					<label for="productName" class="form-label mt-3">Product Name</label>
    				<input type="text" class="form-control" id="productName" name="productName" required >	
    				
    				<label for="productLine" class="form-label mt-3">Product Line</label>
    				<select class="form-select" id="productLine" name="productLine">
						<c:forEach  items="${productLines}" var="p">
							<option value="${p.productLine}"> ${p.productLine}</option>
						</c:forEach>					
					</select>
    				
    				<label for="productScale" class="form-label mt-3">Prodcut Scale</label>
    				<input type="text" class="form-control" id="productScale" name="productScale" required>
    				
    				<label for="productVendor" class="form-label mt-3">Product Vendor</label>
    				<input type="text" class="form-control" id="productVendor" name="productVendor" required>
    				
    				<label for="productDescription" class="form-label mt-3">Product Description</label>
    				<input type="text" class="form-control" id="productDescription" name="productDescription" required>
    				
    				<label for="stock" class="form-label mt-3">Stock</label>
    				<input type="number" class="form-control" id="stock" name="stock" required>
    				
    				<label for="buyPrice" class="form-label mt-3">Buy Price</label>
    				<input type="number" class="form-control" id="buyPrice" name="buyPrice" required>
    				
    				<label for="msrp" class="form-label mt-3">MSRP</label>
    				<input type="number" class="form-control" id="msrp" name="msrp" required>
    				
    				<c:if test="${error!=null}">
							<p class="text-danger text-small mt-3">${error}</p>
					</c:if>
    				
    				<input type="submit" class="btn btn-primary w-100 mt-3" value="CREATE PRODUCT" />					
				</form>
			</div>
		</div>
	</div>
</body>
</html>