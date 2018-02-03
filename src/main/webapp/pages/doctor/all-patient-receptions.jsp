<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Receptions Page</title>

    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%--<%@include file="/pageFragments/header.html"%>--%>
<br>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<h1>Reception List</h1>

<c:if test="${!empty listReceptions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Patient lastname<br>firstname<br>surname</th>
            <th width="120">Doctor lastname<br>firstname<br>surname</th>
            <th width="120">Preliminary diagnosis</th>
            <th width="120">Reception date</th>
            <th width="120">IsDischarge</th>
            <th width="120">Final diagnosis</th>
            <th width="120">Discharge date</th>
            <th width="60">Edit</th>
            <%--<th width="60">Delete</th>--%>
        </tr>
        <c:forEach items="${listReceptions}" var="reception">
            <tr>
                <td>${reception.id}</td>
                <td><a href="/doctor/receptiondata/${reception.id}" target="_blank">${reception.patient.lastName}
                    <br>${reception.patient.firstName}<br>${reception.patient.surName}</a></td>
                <td>${reception.user.lastName}<br>${reception.user.firstName}<br>${reception.user.surName}</td>
                <td>${reception.preliminaryDiagnosis}</td>
                <td>${reception.receptionDate}</td>
                <td>${reception.discharge ? "Discharged" : ""}</td>
                <td>${reception.finalDiagnosis}</td>
                <td>${reception.dischargeDate}</td>
                <td><a href="<c:url value='/doctor/all-patient-receptions/edit/${reception.id}'/>">Edit</a></td>
                <%--<td><a href="<c:url value='/doctor/all-patient-receptions/remove/${reception.id}'/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Reception</h1>

<c:url var="addAction" value="/doctor/all-patient-receptions/add"/>
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
                <form:label path="patient.id">
                    <spring:message text="Patient"/>
                </form:label>
            </td>
            <td>
                <form:select path="patient.id">
                    <c:forEach items="${listPatients}" var="patient">
                        <form:option value="${patient.id}">
                            ${patient.lastName}&nbsp;${patient.firstName}&nbsp;${patient.surName}
                        </form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="user.id">
                    <spring:message text="Doctor"/>
                </form:label>
            </td>
            <td>
                <form:select path="user.id">
                    <c:forEach items="${listUsersByRoleDoctor}" var="user">
                        <form:option value="${user.id}">
                            ${user.lastName}&nbsp;${user.firstName}&nbsp;${user.surName}
                        </form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
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
        <tr hidden="hidden">
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
        <tr hidden="hidden">
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

<%@include file="/pageFragments/footer.html"%>
</body>
</html>
