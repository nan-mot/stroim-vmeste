<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Изменить район</title>
</head>
<body>
<c:if test="${updateUserSuccess}">
    <div> Пользоваель успешно сохранен под номером : ${updatedUser.id}</div>
</c:if>

<c:url var="update_user_url" value="/users/updateUser"/>
<form:form action="${update_user_url}" method="post" modelAttribute="user">

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
    <form:label path="id" style="visibility:hidden;"> </form:label> <form:input type="text" path="id" style="visibility:hidden;"/>
    <br/>
    <br/>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
