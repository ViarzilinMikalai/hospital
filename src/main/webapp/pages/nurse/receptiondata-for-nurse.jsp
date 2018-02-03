<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>

<html>
<head>
    <title>Patient ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
        ${reception.patient.surName}</title>
    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>

</head>
<body>
<%--<%@include file="/pageFragments/header.html"%>--%>
<br>
<h1>Patient ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
    ${reception.patient.surName}</h1>

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
                <%--<th width="60">Delete</th>--%>
    </tr>
    <tr>
        <td>${reception.id}</td>
        <td>${reception.patient.lastName}<br>${reception.patient.firstName}<br>${reception.patient.surName}</td>
        <td>${reception.user.lastName}<br>${reception.user.firstName}<br>${reception.user.surName}</td>
        <td>${reception.preliminaryDiagnosis}</td>
        <td>${reception.receptionDate}</td>
        <td>${reception.discharge ? "Discharged" : ""}</td>
        <td>${reception.finalDiagnosis}</td>
        <td>${reception.dischargeDate}</td>
                <%--<td><a href="<c:url value='/receptions/remove/${reception.id}'/>">Delete</a></td>--%>
    </tr>
</table>



<h2>Prescriptions of ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
    ${reception.patient.surName}</h2>

<c:if test="${!empty prescriptionsByReceptionId}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Prescription name</th>
            <th width="120">Prescription date</th>
            <th width="120">Date executed</th>
            <th width="120">Executed</th>
            <th width="60">Execute</th>
        </tr>
        <c:forEach items="${prescriptionsByReceptionId}" var="rprescription">
            <tr>
                <td>${rprescription.id}</td>
                <td>${rprescription.prescription.namePrescription}<br>
                        ${rprescription.prescription.typePrescription}</td>
                <td>${rprescription.rprescriptionDate}</td>
                <td>${rprescription.executionDate}</td>
                <td>${rprescription.executed ? "Executed" : ""}</td>
                <td>
                  <c:if test="${!rprescription.executed}">
                   <c:if test="${rprescription.prescription.typePrescription!='OPERATION'}">
                    <a href="<c:url value='/nurse/receptiondata-for-nurse/${reception.id}/execute/${rprescription.id}'/>">
                        Execute</a>
                   </c:if>
                  </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<%@include file="/pageFragments/footer.html"%>
</body>
</html>