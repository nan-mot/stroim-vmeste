<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить тему</title>
</head>
<body>
<c:if test="${addTopicSuccess}">
    <div> Topic успешно сохранен : ${savedTopic.id}</div>
</c:if>

<c:url var="add_topic_url" value="/projects/topics/addTopic"/>
<form:form action="${add_topic_url}" method="post" modelAttribute="topic">
    <form:label path="topicName">Название темы: </form:label> <form:input type="text" path="topicName"/>
    <br/>
    <br/>
    <form:label path="topicDescription">Описание: </form:label> <form:input path="topicDescription"/>
    <br/>
    <br/>
    <form:label path="project">Проект: </form:label>
    <form:select path="project">
        <form:options items="${projects}" itemValue="id" itemLabel="projectName" />
    </form:select>
    <br/>
    <br/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
