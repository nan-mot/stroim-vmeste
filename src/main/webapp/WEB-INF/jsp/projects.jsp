<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Проекты</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th></th>
        <th>Название проекта</th>
        <th>Район</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${projects}" var="project">
        <tr>
            <td style="visibility:hidden;">${project.id}</td>
            <td>${project.projectName}</td>
            <td>${project.projectDistrictName}</td>
            <td><a href='<c:url value="/projects/updateProject/${project.id}"/>' > Изменить </a> </td>
            <td><a href='<c:url value="/projects/deleteProject/${project.id}"/>' > Удалить </a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href='<c:url value="/projects/addProject"/>' > Добавить район </a>
</body>
</html>
