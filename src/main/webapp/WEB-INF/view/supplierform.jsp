<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>Supplier form</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
  <jsp:include page="navigationBar.jsp"/>
   <div class="layout">
            <div class="main">
   <form:form method="PUT"
          action="/updateItem" modelAttribute="mastermodel">
             <table>
               <tr>
               <td><form:label path = "productName">Select product name</form:label></td>
               <td>
                  <form:select path = "productName">
                     <form:option value = "NONE" label = "Select"/>
                     <form:options items = "${productList}" />
                  </form:select>     	
               </td>
            </tr>   	  
              <tr>
                    <td><form:label path="suppplierName">  Supplier name  </form:label></td>
                    <td><form:input path="suppplierName"/></td>
                </tr>
                <tr>
                    <td><form:label path="quantity">Quantity </form:label></td>
                    <td><form:input path="quantity"/></td>
                </tr>
                 <tr>
                    <td><form:label path="quanlity">  Quality </form:label></td>
                    <td><form:input path="quanlity"/></td>
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