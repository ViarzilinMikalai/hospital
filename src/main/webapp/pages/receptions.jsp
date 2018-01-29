<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Receptions Page</title>

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
<a href="../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1>Reception List</h1>



<c:if test="${!empty listReceptions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Preliminary diagnosis</th>
            <th width="120">Reception date</th>
            <th width="120">IsDischarge</th>
            <th width="120">Final diagnosis</th>
            <th width="120">Discharge date</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listReceptions}" var="reception">
            <tr>
                <td>${reception.id}</td>
                <td><a href="/receptiondata/${reception.id}" target="_blank">${reception.preliminaryDiagnosis}</a></td>
                <td>${reception.receptionDate}</td>
                <td>${reception.discharge}</td>
                <td>${reception.finalDiagnosis}</td>
                <td>${reception.dischargeDate}</td>
                <td><a href="<c:url value='/receptions/edit/${reception.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/receptions/remove/${reception.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Reception</h1>

<c:url var="addAction" value="/receptions/add"/>
<form:form action="${addAction}" modelAttribute="reception">
    <table>
        <c:if test="${!empty reception.preliminaryDiagnosis}">
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
                <form:label path="preliminaryDiagnosis">
                    <spring:message text="PreliminaryDiagnosis"/>
                </form:label>
            </td>
            <td>
                <form:input path="preliminaryDiagnosis"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="discharge">
                    <spring:message text="Patient discharge"/>
                </form:label>
            </td>
            <td>
                <form:select path="discharge">
                    <form:option value="true">Discharge</form:option>
                    <form:option value="false">Not discharge</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="finalDiagnosis">
                    <spring:message text="FinalDiagnosis"/>
                </form:label>
            </td>
            <td>
                <form:input path="finalDiagnosis"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty reception.preliminaryDiagnosis}">
                    <input type="submit"
                           value="<spring:message text="Edit Reception"/>"/>
                </c:if>
                <c:if test="${empty reception.preliminaryDiagnosis}">
                    <input type="submit"
                           value="<spring:message text="Add Reception"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
