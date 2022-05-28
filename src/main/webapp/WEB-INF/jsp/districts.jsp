<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>All districts</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Район</th>
                    <th>Описание</th>
                    <th>Изменить район</th>
                    <th>Удалить район</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${districts}" var="district">
                    <tr>
                        <td>${district.districtName}</td>
                        <td>${district.districtDescription}</td>
                        <td><a href='<c:url value="/districts/updateDistrict/${district.id}"/>' > Изменить </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>