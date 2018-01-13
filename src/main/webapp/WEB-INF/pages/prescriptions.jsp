<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: vernik
  Date: 12.01.2018
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Prescriptions Page</title>

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

<h1>Prescriptions List</h1>

<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Prescription name</th>
            <th width="120">Prescription type</th>
            <th width="120">Description</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <td>${prescription.idPrescription}</td>
                <td><a href="/prescriptiondata/${prescription.idPrescription}" target="_blank">
                        ${prescription.namePrescription}</a></td>
                <td>${prescription.typePrescription}</td>
                <td>${prescription.description}</td>
                <td><a href="<c:url value='/edit/${prescription.idPrescription}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${prescription.idPrescription}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Prescriptions</h1>

<c:url var="addAction" value="/prescriptions/add">

    <%--@elvariable id="prescriptions" type=""--%>
    <form:form action="${addAction}" commandName="prescriptions">
        <table>
            <c:if test="${!empty prescription.namePrescription}">
                <tr>
                    <td>
                        <form:label path="idPrescription">
                            <spring:message text="ID"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="idPrescription" readonly="true" size="8" disabled="true"/>
                        <form:hidden path="idPrescription"/>
                    </td>
                </tr>
            </c:if>
            <tr>
                <td>
                    <form:label path="namePrescription">
                        <spring:message text="Prescription name"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="namePrescription"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="typePrescription">
                        <spring:message text="Prescription type"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="typePrescription"/>
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
                               value="<spring:message text="Edit Presc"/>"/>
                    </c:if>
                    <c:if test="${empty prescription.namePrescription}">
                        <input type="submit"
                               value="<spring:message text="Add Presc"/>"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
    </body>
    </html>
