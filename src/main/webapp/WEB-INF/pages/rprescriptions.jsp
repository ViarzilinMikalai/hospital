<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Prescription of Patient Page</title>

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

<h1>Reception List</h1>



<c:if test="${!empty listRprescriptions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Prescription date</th>
            <th width="120">Cancelled</th>
            <th width="120">Test</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listRprescriptions}" var="rprescription">
            <tr>
                <td>${rprescription.id}</td>
                <td><a href="/rprescriptiondata/${rprescription.id}" target="_blank">${rprescription.rprescriptionDate}</a></td>
                <td>${rprescription.cancell}</td>
                <td>${rprescription.test}</td>
                <td><a href="<c:url value='/rprescriptions/edit/${rprescription.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/rprescriptions/remove/${rprescription.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Reception</h1>

<c:url var="addAction" value="/rprescriptions/add"/>
<form:form action="${addAction}" modelAttribute="rprescription">
    <table>
        <c:if test="${!empty rprescription.test}">
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
                <form:label path="cancell">
                    <spring:message text="Prescription cancelled"/>
                </form:label>
            </td>
            <td>
                <form:select path="cancell">
                    <form:option value="true">Not cancell</form:option>
                    <form:option value="false">Cancell</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="test">
                    <spring:message text="Test"/>
                </form:label>
            </td>
            <td>
                <form:input path="test"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty rprescription.test}">
                    <input type="submit"
                           value="<spring:message text="Edit Patien prescription"/>"/>
                </c:if>
                <c:if test="${empty rprescription.rprescriptionDate}">
                    <input type="submit"
                           value="<spring:message text="Add Patien prescription"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
