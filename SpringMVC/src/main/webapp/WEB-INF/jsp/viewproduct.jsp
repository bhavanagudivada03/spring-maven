<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Quantity</th><th>Price</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="product" items="${list}">   
   <tr>  
   <td>${product.id}</td>  
   <td>${product.name}</td>  
   <td>${product.quantity}</td>  
   <td>${product.price}</td>  
   <td><a href="editproduct/${product.id}">Edit</a></td>  
   <td><a href="deleteproduct/${product.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="productform">Add New Product</a>  