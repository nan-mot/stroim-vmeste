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
                    <th>ID</th>
                    <th>Район</th>
                    <th>Описание</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${districts}" var="district">
                    <tr>
                        <td>${district.id}</td>
                        <td>${district.districtName}</td>
                        <td>${district.districtDescription}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>