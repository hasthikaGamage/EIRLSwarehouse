<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Display delivery notes</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
     <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
   margin-top:100px 
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>



<body>
<jsp:include page="navigationBar.jsp"/>



<table border="2">

     
    <th>Product Name</th>
    <th>Product Quantity</th> 
    <th>Description</th>
    <th>Return Location</th>
    <th>Return Date</th>
        <th>orderitem id</th>

   
    

    <c:forEach var="var" items="${list}">
      <tr> 
        <td>${var.getProduct_name()}</td>
       <td>${var.getProduct_quantity()}</td> 
       <td>${var.getDescription()}</td> 
        <td>${var.getReturn_location()}</td> 
        <td>${var.getReturn_date()}</td> 
         <td>${var.getOrder_id()}</td> 

     				

      </tr>
    </c:forEach>
  </table>
 
   
   	 
<script src="js/bootstrap.min.js"></script> 
</body>
</html>
