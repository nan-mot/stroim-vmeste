<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<div>Выбор пользователей из одного района</div>
<br/>
<form:label path="district">Район: </form:label>
<form:select path="district">
    <form:options items="${districts}" itemValue="id" itemLabel="districtName"/>
</form:select>
<br/>
<table>
    <thead>
    <tr>
        <th>Никнейм</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${project.projectTopics}" var="topic">
        <tr>
            <td>${user.userName}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
</body>
</html>