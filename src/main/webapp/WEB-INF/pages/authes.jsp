<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Authes Page</title>

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
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Auth List</h1>



<c:if test="${!empty listAuthes}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Username</th>
            <th width="120">Password</th>
            <th width="120">Email</th>
            <th width="120">User role</th>
            <th width="120">Is active</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listAuthes}" var="auth">
            <tr>
                <td>${auth.id}</td>
                <td><a href="/authdata/${auth.id}" target="_blank">${auth.username}</a></td>
                <td>${auth.password}</td>
                <td>${auth.email}</td>
                <td>${auth.role}</td>
                <td>${auth.active ? "Active" : "Not active"}</td>
                <td><a href="<c:url value='/authes/edit/${auth.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/authes/remove/${auth.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Auth</h1>

<c:url var="addAction" value="/authes/add"/>
<form:form action="${addAction}" commandName="auth">
    <table>
        <c:if test="${!empty auth.username}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="username">
                    <spring:message text="Username"/>
                </form:label>
            </td>
            <td>
                <form:input path="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <form:input path="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="role">
                    <spring:message text="User role"/>
                </form:label>
            </td>
            <td>
                <form:select path="role">
                    <form:option value="DOCTOR">doctor</form:option>
                    <form:option value="NURSE">nurse</form:option>
                    <form:option value="ADMIN">administrator</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="active">
                    <spring:message text="User active"/>
                </form:label>
            </td>
            <td>
                <form:select path="active">
                    <form:option value="true">Active</form:option>
                    <form:option value="false">Not active</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty auth.username}">
                    <input type="submit"
                           value="<spring:message text="Edit Auth"/>"/>
                </c:if>
                <c:if test="${empty auth.username}">
                    <input type="submit"
                           value="<spring:message text="Add Auth"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
