<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Patients Page</title>

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

<h1>Patient List</h1>



<c:if test="${!empty listPatients}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Lastname</th>
            <th width="120">Firstname</th>
            <th width="120">Surname</th>
            <th width="120">Birth Date</th>
            <th width="120">Adress</th>
            <th width="120">Create date</th>
            <th width="120">Update date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPatients}" var="patient">
            <tr>
                <td>${patient.id}</td>
                <td><a href="/patientdata/${patient.id}" target="_blank">${patient.lastName}</a></td>
                <td>${patient.firstName}</td>
                <td>${patient.surName}</td>
                <td>${patient.birthDate}</td>
                <td>${patient.adress}</td>
                <td>${patient.createDate}</td>
                <td>${patient.updateDate}</td>
                <td><a href="<c:url value='/patients/edit/${patient.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/patients/remove/${patient.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Patient</h1>

<c:url var="addAction" value="/patients/add"/>
<form:form action="${addAction}" modelAttribute="patient">
    <table>
        <c:if test="${!empty patient.lastName}">
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
        <tr>
            <td>
                <form:label path="adress">
                    <spring:message text="Adress"/>
                </form:label>
            </td>
            <td>
                <form:input path="adress"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty patient.lastName}">
                    <input type="submit"
                           value="<spring:message text="Edit Patient"/>"/>
                </c:if>
                <c:if test="${empty patient.lastName}">
                    <input type="submit"
                           value="<spring:message text="Add Patient"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
