<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить район</title>
</head>
<body>
<c:if test="${updateDistrictSuccess}">
    <div> Район успешно сохранен под номером : ${updatedDistrict.id}</div>
</c:if>

<c:url var="update_district_url" value="/districts/updateDistrict"/>
<form:form action="${update_district_url}" method="post" modelAttribute="district">
    <form:label path="districtName">Название района: </form:label> <form:input type="text" path="districtName"/>
    <form:label path="districtDescription">Описание: </form:label> <form:input path="districtDescription"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
