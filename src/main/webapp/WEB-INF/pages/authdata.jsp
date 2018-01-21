<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Authentication Data</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>

</head>
<body>
<h1>Prescription Details</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Login</th>
        <th width="120">Password</th>
        <th width="120">Email</th>
        <th width="120">Is active</th>
        <th width="120">User role</th>
    </tr>
    <tr>
        <td>${auth.id}</td>
        <td>${auth.login}</td>
        <td>${auth.password}</td>
        <td>${auth.email}</td>
        <td>${auth.active ? "Active" : "Not active"}</td>
        <td>${auth.role}</td>
        <td><a href="<c:url value='/edit/${auth.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/remove/${auth.id}'/>">Delete</a></td>
    </tr>
</table>
</body>
</html>