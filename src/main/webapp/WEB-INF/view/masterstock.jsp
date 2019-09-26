<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>MASTER STOCK</title>
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
<h1> MASTER STOCK RECORD </H1> 
<table border="2">

 <th>binID</th>
 
    <th>Product name</th> 
    <th>Quantity </th> 
        <th>Status </th> 


    <c:forEach var="var" items="${list}">
      <tr>
        <td>${var.getBinID()}</td>
    
        <td>${var.getProductName()}</td>
                <td>${var.getQuantity()}</td> 
       <td>${var.getStatus()}</td> 
     
      </tr>
    </c:forEach>
  </table>
  </form>
   
</body>
</html>
