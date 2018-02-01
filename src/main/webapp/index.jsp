<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Hospital application</title>    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>

    </head>
    <body>
    <%@include file="/pageFragments/header.html"%>
        <h1>Hospital application by Viarzilin Mikalai</h1>
        <br/>
        <a href="<c:url value="/doctor/prescriptions"/>" target="_blank">Prescriptions list</a>
        <br/>
        <a href="<c:url value="/general/patients"/>" target="_blank">Patients list</a>
        <br/>
        <a href="<c:url value="/general/doctorslist"/>" target="_blank">Doctors list</a>
        <br/>
        <a href="<c:url value="/authes"/>" target="_blank">Authes list</a>
        <br/>
        <a href="<c:url value="/admin/users"/>" target="_blank">Users list</a>
        <br/>
        <a href="<c:url value="/receptions"/>" target="_blank">Receptions list</a>
        <br/>
        <a href="<c:url value="/rprescriptions"/>" target="_blank">Patient prescriptions</a>
        <br/>
        <a href="<c:url value="/nurse/hospitalized-receptions"/>" target="_blank">Hospitalized receptions list</a>
        <%@include file="/pageFragments/footer.html"%>
    </body>
</html>
