<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<table>
	<thead>
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
         <c:forEach var="expense" items="${expenses}">
         	<tr>
<%--          		<td><c:out value="${burger.id}"/></td>
 --%>         	<td><c:out value="${expense.name}"/></td>
         		<td><c:out value="${expense.vendor}"/></td>
         		<td><c:out value="${expense.amount}"/></td>
         		<td><c:out value="${expense.description}"/></td>
         		<td><a href="/edit/${expense.id}">edit</a></td>
         		<td>
         			<form action="/expense/${expense.id}" method="post">
	         			<input type="hidden" name="_method" value="delete"/>
	         			<input type="submit" value="Delete"/>
	         		</form>
	         		
	         	</td>
         	</tr>
         	
         </c:forEach>
    </tbody>
</table>
	
	<form:form action="/addExpense" method="post" modelAttribute="expense">
		<div class="form-group">
			<label>Expense Name</label>
			<form:input type="text" path="name" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Vendor</label>
			<form:input type="text" path="vendor" class="form-control"/>
		</div>
		<div class="form-group">
			<label>Amount</label>
			<form:input type="number" path="amount" class="form-contol"/>
		</div>
		<div class="form-group">
			<label>Description</label>
			<form:input type="text" path="description" class="form-contol"/>
		</div>
		<input type="submit" value="Submit" class="btn btn-primary"/>
	
	</form:form>

</body>
</html>