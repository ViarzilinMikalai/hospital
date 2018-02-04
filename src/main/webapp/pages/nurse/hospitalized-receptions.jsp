<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Hospitalized patients</title>
    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>
<%@include file="/pageFragments/nurse-nav.html"%>
<div class="content">
    <h1>Hospitalized patients list</h1>

    <c:if test="${!empty listHospitalizedReceptions}">
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
            <c:forEach items="${listHospitalizedReceptions}" var="reception">
                <tr>
                    <td>${reception.id}</td>
                    <td><a href="/nurse/receptiondata-for-nurse/${reception.id}" target="_blank">
                            ${reception.patient.lastName}<br>${reception.patient.firstName}<br>
                            ${reception.patient.surName}</a></td>
                    <td>${reception.user.lastName}<br>${reception.user.firstName}<br>${reception.user.surName}</td>
                    <td>${reception.preliminaryDiagnosis}</td>
                    <td>${reception.receptionDate}</td>
                    <td>${reception.discharge}</td>
                    <td>${reception.finalDiagnosis}</td>
                    <td>${reception.dischargeDate}</td>
                    <%--<td><a href="<c:url value='/receptions/edit/${reception.id}'/>">Edit</a></td>--%>
                    <%--<td><a href="<c:url value='/receptions/remove/${reception.id}'/>">Delete</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</div>
<%@include file="/pageFragments/footer.html"%>
</body>
</html>
