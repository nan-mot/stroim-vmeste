<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить сообщение</title>
</head>
<body>
<c:if test="${addMessageSuccess}">
    <div> Сообщение успешно сохранено : ${savedMessage.id}</div>
</c:if>

<c:url var="add_message_url" value="/projects/topics/addMessage"/>
<form:form action="${add_message_url}" method="post" modelAttribute="message">
    <form:label path="user">Оправитель: </form:label>
    <form:select path="user">
        <form:options items="${users}" itemValue="id" itemLabel="userName" />
    </form:select>
    <br/>
    <br/>
    <form:label path="messageText">Сообщение: </form:label> <form:input path="messageText"/>
    <br/>
    <br/>
    <form:label path="topic">Тема: </form:label>
    <form:select path="topic">
        <form:options items="${topics}" itemValue="id" itemLabel="topicName" />
    </form:select>
    <br/>
    <br/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
