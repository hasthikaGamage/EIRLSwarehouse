<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Main page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
  <jsp:include page="navigationBar.jsp"/>
   <div class="layout">
            <div class="main">
   <form:form method="POST"
          action="/returnformsend" modelAttribute="returnmodel">
             <table>
               <tr>
               <td><form:label path = "product_name">Select product name</form:label></td>
               <td>
                  <form:select path = "product_name">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${productList}" />
                  </form:select>     	
               </td>
            </tr>   	  
              <tr>
                    <td><form:label path="customer_name">Customer Name</form:label></td>
                    <td><form:input path="customer_name"/></td>
                </tr>
                <tr>
                    <td><form:label path="telephone">Telephone</form:label></td>
                    <td><form:input path="telephone"/></td>
                </tr>
                 <tr>
                    <td><form:label path="description">Description</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                 <tr>
                    <td><form:label path="status">Status</form:label></td>
                    <td><form:input path="status"/></td>
                </tr>
                 <tr>
                    <td><form:label path="date">Date</form:label></td>
                    <td><form:input path="date"/></td>
                </tr>
               
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

      </div>
      </div>
</body>
</html>