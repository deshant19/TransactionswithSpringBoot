<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th></tr>  
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.id}</td>  
   <td>${emp.name}</td>  
   <td>${emp.salary}</td>
    <td><a href="/editemp/${emp.id}">Edit</a></td>  
   <td><a href="/deleteemp/${emp.id}">Delete</a></td>    
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/viewemp/1">1</a>   
   <a href="/viewemp/2">2</a>   
   <a href="/viewemp/3">3</a>  
   <a href="/viewemp/4">4</a>
   
   <br/><a href="/empform">Add New Employee</a>  