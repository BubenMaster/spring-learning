<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit employee</title>
</head>
<br>
<body>
<form:form action="${pageContext.request.contextPath}/save-employee/"
           modelAttribute="addedEmployee" >

    <form:hidden path="id"/>

    Name: <form:input type="text" path="name"  />
    <br>
    Surname:  <form:input type="text" path="surname"  />
    <br>
    Salary: <form:input type="number" path="salary" />
    <br>
    Department: <form:select path="department">
                    <form:options items="${departments}"/>
                </form:select>

    <br>
    <input type="submit" value = "Ok">

</form:form>

<br><br>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
