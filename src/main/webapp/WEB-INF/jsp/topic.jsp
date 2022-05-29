<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${topic.topicName}</title>
</head>
<body>
<div>${topic.topicName}</div>
<br/>
<div>${topic.topicDescription}</div>
<br/>
<table>
    <thead>
    <tr>
        <th>Пользователь</th>
        <th>Сообщение</th>
        <th>Удалить</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${topic.topicMessagesDto}" var="message">
        <tr>
            <td>${message.userName}</td>
            <td>${message.messageText}</td>
            <td><a href='<c:url value="/projects/topics/${topic.id}/deleteMessage/${message.id}"/>'> Удалить </a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<a href='<c:url value="/projects/topics/addMessage"/>' > Добавить сообщение </a>
</body>
</html>