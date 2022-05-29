<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить проект</title>
</head>
<body>
<c:if test="${addProjectSuccess}">
    <div> Проект успешно сохранен : ${savedProject.id}</div>
</c:if>

<c:url var="add_project_url" value="/projects/addProject"/>
<form:form action="${add_project_url}" method="post" modelAttribute="project">
    <form:label path="projectName">Название проекта: </form:label> <form:input type="text" path="projectName"/>
    <br/>
    <br/>
    <form:label path="projectDescription">Описание: </form:label> <form:input path="projectDescription"/>
    <br/>
    <br/>
    <form:label path="district">Район: </form:label>
    <form:select path="district">
        <form:options items="${districts}" itemValue="id" itemLabel="districtName" />
    </form:select>
    <br/>
    <br/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
