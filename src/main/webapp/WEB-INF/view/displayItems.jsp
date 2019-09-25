<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
    <title>Display products</title>
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

<%-- <form action="/cancelOrder" method="post">
 <input type="hidden" name="myField" id="myField" value="" /> --%>
<table border="2">

    <th>Item name</th>
    <th>Item type</th>
    <th>Item quantity</th>
    

    <c:forEach var="products" items="${list}">
      <tr>
        <td>${products.getItem_name()}</td>
        <td>${products.getItem_type()}</td>
        <td>${products. getItem_quantity()}</td>
       
        <%-- <td><a href="/cancelOrder"> <button type="submit" class="button" value="${emp.getOrder_id()}" onclick="senddata(this)" name="confirm"> Cancel Order </button></a> </td> --%>
      </tr>
    </c:forEach>
  </table>
  </form>
   <%-- <script>
          function senddata(e){
              
             document.getElementById('myField').value= e.value; 
              
              
          }
          
          
          
          
          </script> --%>
</body>
</html>
