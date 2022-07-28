<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Employees</title>
</head>
<br>
<body>

<table>
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
    </tr>
    <c:forEach var="emp" items="${allEmps}">
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Add" onclick="window.location.href = '/spring_mvc_hibernate/add-new-employee/'"/>

<br><br>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
