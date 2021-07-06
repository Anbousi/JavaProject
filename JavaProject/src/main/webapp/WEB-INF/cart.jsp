<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='/css/style3.css' type='text/css' media='all'/>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
	
<div class="container">
	<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carts}" var="cart">
							<tr>
								<td data-th="Product">
									<div class="row">
										<div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
										<div class="col-sm-10">
											<h4 class="nomargin">${cart.getPainting().getTitle()}</h4>
											<p>${cart.getPainting().getDescreption()}</p>
										</div>
									</div>
								</td>
								<td data-th="Price">${cart.getPainting().getPrice()}</td>
								<td class="actions" data-th="">
									<a href="/cart/delete/${cart.getId()}"><button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button></a>							
								</td>
							</tr>
						</c:forEach>
						
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total <c:out value="${total}"/></strong></td>
						</tr>
						<tr>
							<td><a href="../" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total <c:out value="${total}"/></strong></td>


							<c:choose>
         
                                <c:when test = "${carts.size() > 0}">
                                    <td><a href="/cart/checkout" class="btn btn-success btn-block">Checkout<i class="fa fa-angle-right"></i></a></td>
                                </c:when>
                                                                                     
                                <c:otherwise>
									<td><button href="/cart/checkout" class="btn btn-success btn-block" disabled>Checkout<i class="fa fa-angle-right"></i></button></td>                                </c:otherwise>
                             </c:choose>

							
						</tr>
					</tfoot>
				</table>
</div>
</body>

</html>