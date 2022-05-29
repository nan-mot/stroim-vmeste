<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Изменить тему</title>
</head>
<body>
<c:if test="${updateTopicSuccess}">
    <div> ема успешно сохранен : ${updatedTopic.id}</div>
</c:if>

<c:url var="update_topic_url" value="/projects/topics/updateTopic"/>
<form:form action="${update_topic_url}" method="post" modelAttribute="topic">

    <form:label path="topicName">Название темы: </form:label> <form:input type="text" path="topicName"/>
    <br/>
    <br/>
    <form:label path="topicDescription">Описание: </form:label> <form:input path="topicDescription"/>
    <br/>
    <br/>
    <form:label path="topicProject">Проект: </form:label>
    <form:select path="topicProject">
        <form:options items="${projects}" itemValue="id" itemLabel="projectName" />
    </form:select>
    <form:label path="id" style="visibility:hidden;"> </form:label> <form:input type="text" path="id" style="visibility:hidden;"/>
    <br/>
    <br/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
