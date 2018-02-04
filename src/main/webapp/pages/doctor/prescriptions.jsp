<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Prescriptions Page</title>

    <style type="text/css">
        <%@include file="/css/style.css"%>
    </style>
</head>
<body>
<%@include file="/pageFragments/header.html"%>
<h1>Prescription List</h1>
<c:if test="${!empty listPrescriptions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">NamePrescription</th>
            <th width="120">TypePrescription</th>
            <th width="120">Description</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listPrescriptions}" var="prescription">
            <tr>
                <td>${prescription.id}</td>
                <td>${prescription.namePrescription}</td>
                <td>${prescription.typePrescription}</td>
                <td>${prescription.description}</td>
                <td><a href="<c:url value='/doctor/prescriptions/edit/${prescription.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/doctor/prescriptions/remove/${prescription.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Prescription</h1>

<c:url var="addAction" value="/doctor/prescriptions/add"/>
<form:form action="${addAction}" modelAttribute="prescription">
    <table>
        <c:if test="${!empty prescription.namePrescription}">
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
                <form:label path="namePrescription">
                    <spring:message text="NamePrescription"/>
                </form:label>
            </td>
            <td>
                <form:input path="namePrescription" required="required"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="typePrescription">
                    <spring:message text="TypePrescription"/>
                </form:label>
            </td>
            <td>
                <form:select path="typePrescription">
                    <form:option value="MEDICAMENT">medicament</form:option>
                    <form:option value="PROCEDURE">procedure</form:option>
                    <form:option value="OPERATION">operation</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Description"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty prescription.namePrescription}">
                    <input type="submit"
                           value="<spring:message text="Edit Prescription"/>"/>
                </c:if>
                <c:if test="${empty prescription.namePrescription}">
                    <input type="submit"
                           value="<spring:message text="Add Prescription"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<%@include file="/pageFragments/footer.html"%>
</body>
</html>
