<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>UserData</title>

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
        <td><a href="/userdata/${user.id}" target="_blank">${user.lastName}</a></td>
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
</body>
</html>