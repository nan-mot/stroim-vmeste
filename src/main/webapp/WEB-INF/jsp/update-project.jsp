<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Изменить проект</title>
</head>
<body>
<c:if test="${updateProjectSuccess}">
    <div> Проект успешно сохранен : ${updatedProject.id}</div>
</c:if>

<c:url var="update_project_url" value="/projects/updateProject"/>
<form:form action="${update_project_url}" method="post" modelAttribute="project">

    <form:label path="projectName">Название проекта: </form:label> <form:input type="text" path="projectName"/>
    <br/>
    <br/>
    <form:label path="projectDescription">Описание: </form:label> <form:input path="projectDescription"/>
    <br/>
    <br/>
    <form:label path="id" style="visibility:hidden;"> </form:label> <form:input type="text" path="id" style="visibility:hidden;"/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
