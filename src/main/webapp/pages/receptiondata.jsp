<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<html>
<head>
    <title>ReceptionData</title>

    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>

</head>
<body>
<%--<%@include file="/pageFragments/header.html"%>--%>
<br>
<h1>Reception Details</h1>

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
        <th width="60">Delete</th>
    </tr>
    <tr>
        <td>${reception.id}</td>
        <td>${reception.patient.lastName}<br>${reception.patient.firstName}<br>${reception.patient.surName}</td>
        <td>${reception.user.lastName}<br>${reception.user.firstName}<br>${reception.user.surName}</td>
        <td>${reception.preliminaryDiagnosis}</td>
        <td>${reception.receptionDate}</td>
        <td>${reception.discharge}</td>
        <td>${reception.finalDiagnosis}</td>
        <td>${reception.dischargeDate}</td>
        <td><a href="<c:url value='/receptions/edit/${reception.id}'/>">Edit</a></td>
        <td><a href="<c:url value='/receptions/remove/${reception.id}'/>">Delete</a></td>
    </tr>
</table>



<c:if test="${!empty listRprescriptions}">
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Patient lastname<br>firstname<br>surname</th>
        <th width="120">Doctor lastname<br>firstname<br>surname</th>
        <th width="120">Prescription name</th>
        <th width="120">Prescription date</th>
        <th width="120">Cancelled</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listRprescriptions}" var="rprescription">
        <tr>
            <td>${rprescription.id}</td>
            <td><a href="/rprescriptiondata/${rprescription.id}" target="_blank">${rprescription.receptions.patient.lastName}<br>
                    ${rprescription.receptions.patient.firstName}<br>
                    ${rprescription.receptions.patient.surName}</a></td>
            <td>${rprescription.user.lastName}<br>
                    ${rprescription.user.firstName}<br>
                    ${rprescription.user.surName}<br>
                    ${rprescription.user.auth.role}</td>
            <td>${rprescription.prescription.namePrescription}</td>
            <td>${rprescription.rprescriptionDate}</td>
            <td>${rprescription.cancell}</td>
            <td><a href="<c:url value='/rprescriptions/edit/${rprescription.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/rprescriptions/remove/${rprescription.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>

<h2>Discharge patient</h2>
<c:url var="addAction" value="/receptions/discharge"/>
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

        <tr hidden="hidden">
            <td>
                <form:label path="patient.id">
                    <spring:message text="Patient id"/>
                </form:label>
            </td>
            <td>
                <form:input path="patient.id"/>
            </td>
        </tr>
        <tr hidden="hidden">
            <td>
                <form:label path="user.id">
                    <spring:message text="User id"/>
                </form:label>
            </td>
            <td>
                <form:input path="user.id"/>
            </td>
        </tr>
        <tr hidden="hidden">
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
                <%--<c:if test="${!empty reception.finalDiagnosis}">--%>
                    <input type="submit"
                           value="<spring:message text="Discharge patient"/>"/>
                <%--</c:if>--%>

            </td>
        </tr>
    </table>
</form:form>
<%@include file="/pageFragments/footer.html"%>
</body>
</html>