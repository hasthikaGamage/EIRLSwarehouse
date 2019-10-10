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

<form action="/updatedeliverystatus" method="post">
  <input type="hidden" name="myField" id="myField" value="${var.getDelivery_id()}" />

<table border="2">

    <th>Delivery id</th>
    
    <th>Delivery date</th>
    <th>Delivery location</th>
    <th>Delivery status</th>
    <th>Delivery type</th>
    
   
    
  
    <c:forEach var="var" items="${list}">
      <tr>
        <td>${var.getDelivery_id()}</td> 
        <td>${var.getDelivery_date()}</td>
       <td>${var.getDelivery_location()}</td>
       <td>${var.getDelivery_status()}</td>
       <td>${var.getDelivery_type()}</td> 
     				<td><a href="/updatedeliverystatus"> <button type="submit" class="button" value="${var.getDelivery_id()}" onclick="senddata(this)"  name="cancel">Delivered </button></a> </td>

    </tr>
    </c:forEach>
  </table>
  </form>
   
   	
    <script>
          function senddata(e){
              
             document.getElementById('myField').value= e.value; 
              
              
          }
          
          
          
          
          </script>
					<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>

<script src="js/bootstrap.min.js"></script>
</body>
</html>
