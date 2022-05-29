<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${project.projectName}</title>
</head>
<body>
<div>${project.projectName}</div>
<br/>
<div>${project.projectDescription}</div>
<br/>
<div>${project.district}</div>
<br/>
<table>
    <thead>
    <tr>
        <th>Темы</th>
        <th>Форум</th>
        <th>Изменить</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${project.projectTopics}" var="topic">
        <tr>
            <td>${topic.topicName}</td>
            <td><a href='<c:url value="/projects/${project.id}/${topic.id}"/>'> Форум </a></td>
            <td><a href='<c:url value="/projects/${project.id}/updateTopic${topic.id}"/>'> Изменить </a></td>
            <td><a href='<c:url value="/projects/${project.id}/deleteTopic/${topic.id}"/>'> Удалить </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href='<c:url value="/projects/addProject"/>' > Добавить проект </a>
</body>
</html>