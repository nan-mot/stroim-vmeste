<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Районы</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th></th>
                    <th>Район</th>
                    <th>Описание</th>
                    <th>Изменить район</th>
                    <th>Удалить район</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${districts}" var="district">
                    <tr>
                        <td style="visibility:hidden;">${district.id}</td>
                        <td>${district.districtName}</td>
                        <td>${district.districtDescription}</td>
                        <td><a href='<c:url value="/districts/updateDistrict/${district.id}"/>' > Изменить </a> </td>
                        <td><a href='<c:url value="/districts/deleteDistrict/${district.id}"/>' > Удалить </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br/>
        <a href='<c:url value="/districts/addDistrict"/>' > Добавить район </a>
    </body>
</html>