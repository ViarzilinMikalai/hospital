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
        <%--<th width="60">Edit</th>--%>
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
        <%--<td><a href="<c:url value='/receptions/edit/${reception.id}'/>">Edit</a></td>--%>
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
                    <a href="<c:url value='/doctor/receptiondata/${reception.id}/execute/${rprescription.id}'/>">
                            Execute</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<c:if test="${!reception.discharge}">
<h2>Add a prescription ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
    ${reception.patient.surName}</h2>

<c:url var="addAction" value="/doctor/receptiondata/${reception.id}/addprescription"/>
<form:form action="${addAction}" modelAttribute="rprescription">
    <table>
        <tr hidden="hidden">
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
        <tr hidden="hidden">
            <td>
                <form:label path="receptions.id">
                    <spring:message text="Patient"/>
                </form:label>
            </td>
            <td>
                <form:input path="receptions.id" value="${id}"/>

            </td>
        </tr>

        <tr>
            <td>
                <form:label path="prescription.id">
                    <spring:message text="Prescription"/>
                </form:label>
            </td>
            <td>
                <form:select path="prescription.id">
                    <c:forEach items="${listPrescriptions}" var="prescription">
                        <form:option value="${prescription.id}">
                            ${prescription.namePrescription}&nbsp;${prescription.typePrescription}
                        </form:option>
                    </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr hidden="hidden">
            <td>
                <form:label path="executed">
                    <spring:message text="Prescription executed"/>
                </form:label>
            </td>
            <td>
                <form:select path="executed">
                    <form:option value="true">Execute</form:option>
                    <form:option value="false">Not execute</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">

                    <input type="submit"
                           value="<spring:message text="Add Patien prescription"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</c:if>

<%--Patient discharge form--%>

<c:if test="${!reception.discharge}">
<h2>Discharge ${reception.patient.lastName}&nbsp;${reception.patient.firstName}&nbsp;
    ${reception.patient.surName}</h2>
<c:url var="addAction" value="/doctor/receptiondata/${reception.id}/discharge"/>
<form:form action="${addAction}" modelAttribute="reception">
    <table>
        <tr  hidden="hidden">
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
        <tr  hidden="hidden">
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
                <form:input path="finalDiagnosis"  required="required"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">

                    <input type="submit" value="<spring:message text="Discharge patient"/>"/>
            </td>
        </tr>
    </table>
</form:form>
</c:if>
<%@include file="/pageFragments/footer.html"%>
</body>
</html>