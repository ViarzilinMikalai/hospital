<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>UserData</title>
    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>
<h1>User Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Lastname</th>
        <th width="120">Firstname</th>
        <th width="120">Surname</th>
        <th width="120">Create date</th>
        <th width="120">Update date</th>
        <th width="120">Username</th>
        <th width="120">Password</th>
        <th width="120">Email</th>
        <th width="120">Role</th>
        <th width="120">IsActive</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.lastName}</td>
        <td>${user.firstName}</td>
        <td>${user.surName}</td>
        <td>${user.createDate}</td>
        <td>${user.updateDate}</td>
        <td>${user.auth.username}</td>
        <td>${user.auth.password}</td>
        <td>${user.auth.email}</td>
        <td>${user.auth.role}</td>
        <td>${user.auth.active ? "Active" : "Not active"}</td>
    </tr>
</table>
<%@include file="/pageFragments/footer.html"%>
</body>
</html>