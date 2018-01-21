<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hospital application</title>
</head>

<h1>Hospital application by Viarzilin Mikalai</h1>
<br/>
<a href="<c:url value="/prescriptions"/>" target="_blank">Prescriptions list</a>
<br/>
<a href="<c:url value="/patients"/>" target="_blank">Patients list</a>
<br/>
<a href="<c:url value="/authes"/>" target="_blank">Authes list</a>
</body>
</html>
