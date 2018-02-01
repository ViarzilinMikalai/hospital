<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctors list</title>
    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>

<h1>Doctors List</h1>
<c:if test="${!empty listUsersByRoleDoctor}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Lastname</th>
            <th width="120">Firstname</th>
            <th width="120">Surname</th>
            <th width="120">Role</th>
        </tr>
        <c:forEach items="${listUsersByRoleDoctor}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.lastName}</td>
                <td>${user.firstName}</td>
                <td>${user.surName}</td>
                <td>${user.auth.role}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<%@include file="/pageFragments/footer.html"%>
</body>
</html>
