<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить район</title>
</head>
<body>
<c:if test="${addDistrictSuccess}">
    <div> Район успешно сохранен : ${savedDistrict.id}</div>
</c:if>

<c:url var="add_district_url" value="/districts/addDistrict"/>
<form:form action="${add_district_url}" method="post" modelAttribute="district">
    <form:label path="districtName">Название района: </form:label> <form:input type="text" path="districtName"/>
    <form:label path="districtDescription">Описание: </form:label> <form:input path="districtDescription"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
