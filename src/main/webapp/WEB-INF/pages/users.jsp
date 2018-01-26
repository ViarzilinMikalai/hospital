<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Users Page</title>

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

<h1>User List</h1>



<c:if test="${!empty listUsers}">
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
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listUsers}" var="user">
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


                <td><a href="<c:url value='/users/edit/${user.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/users/remove/${user.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a User</h1>

<c:url var="addAction" value="/users/add"/>
<form:form action="${addAction}" modelAttribute="user">
    <table>
        <c:if test="${!empty user.lastName}">
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
                <form:label path="lastName">
                    <spring:message text="Lastname"/>
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message text="Firstname"/>
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surName">
                    <spring:message text="SurName"/>
                </form:label>
            </td>
            <td>
                <form:input path="surName"/>
            </td>
        </tr>




        <tr hidden="hidden">
            <td>
                <form:label path="auth.id">
                    <spring:message text="Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="auth.id"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="auth.username">
                    <spring:message text="Username"/>
                </form:label>
            </td>
            <td>
                <form:input path="auth.username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="auth.password">
                    <spring:message text="Password"/>
                </form:label>
            </td>
            <td>
                <form:input path="auth.password"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="auth.email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="auth.email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="auth.role">
                    <spring:message text="User role"/>
                </form:label>
            </td>
            <td>
                <form:select path="auth.role">
                    <form:option value="ROLE_DOCTOR">doctor</form:option>
                    <form:option value="ROLE_NURSE">nurse</form:option>
                    <form:option value="ROLE_ADMIN">administrator</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="auth.active">
                    <spring:message text="User active"/>
                </form:label>
            </td>
            <td>
                <form:select path="auth.active">
                    <form:option value="true">Active</form:option>
                    <form:option value="false">Not active</form:option>
                </form:select>
            </td>
        </tr>



        <tr>
            <td colspan="2">
                <c:if test="${!empty user.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit User"/>"/>
                </c:if>
                <c:if test="${empty user.lastName}">
                    <input type="submit"
                           value="<spring:message text="Add User"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
