<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Пользователи</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>Никнейм</th>
                    <th>Район</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td style="visibility:hidden;">${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.userDistrict}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>