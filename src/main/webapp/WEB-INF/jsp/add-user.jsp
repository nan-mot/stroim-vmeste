<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить пользователя</title>
</head>
<body>
<c:if test="${addUserSuccess}">
    <div> Район успешно сохранен под номером : ${savedUser.id}</div>
</c:if>

<c:url var="add_user_url" value="/users/addUser"/>
<form:form action="${add_user_url}" method="post" modelAttribute="user">
    <form:label path="firstName">Имя: </form:label> <form:input type="text" path="firstName"/>
    <br/>
    <br/>
    <form:label path="lastName">Фамилия: </form:label> <form:input path="lastName"/>
    <br/>
    <br/>
    <form:label path="userName">Никнейм: </form:label> <form:input path="userName"/>
    <br/>
    <br/>
    <form:label path="email">Е-mail: </form:label> <form:input path="email"/>
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
