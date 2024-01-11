<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dongmin
  Date: 24. 1. 8.
  Time: 오후 4:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Register</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--&lt;%&ndash;<form method="post" action="/student/register">&ndash;%&gt;--%>
<%--&lt;%&ndash;    ID : <input type="text" name="id"/> <br/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    이름 : <input type="text" name="userName"/><br/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    성별  : <input type="radio" name="gender" value="M"/>남&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="radio" name="gender" value="F"/>여&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    <label>성별</label>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;    <c:forEach var="gender" items="${Gender.values()}">&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;&lt;%&ndash;        <input type="radio" name="gender" value="${gender}">${gender}&ndash;%&gt;&ndash;%&gt;--%>

<%--&lt;%&ndash;&lt;%&ndash;    </c:forEach>&ndash;%&gt;&ndash;%&gt;--%>

<%--&lt;%&ndash;    <br/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    나이  : <input type="text" name="age"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;    <input type="submit" value="가입"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>

<%--<form method="post" action="${action}">--%>
<%--    <table>--%>
<%--        <tbody>--%>
<%--        <tr>--%>
<%--            <th>ID</th>--%>
<%--            <td><input type="text" name="id" value="${student.id}" required /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>이름</th>--%>
<%--            <td><input type="text" name="name" value="${empty student ? '' : student.name}" required /></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>성별</th>--%>
<%--            <td>--%>
<%--                <input type="radio" name="gender" value="M" ${empty student || student.gender == 'M' ? 'checked' : ''}/>남--%>
<%--                <input type="radio" name="gender" value="F" ${!empty student && student.gender == 'F' ? 'checked' : ''}/>여--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <th>나이</th>--%>
<%--            <td><input type="text" name="age" value="${empty student ? '' : student.age}" required /></td>--%>
<%--        </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <p>--%>
<%--        <button type="submit">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${empty student}">--%>
<%--                    등록--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    수정--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--        </button>--%>
<%--    </p>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

<html>
<head>
    <title>학생-등록</title>
    <link rel="stylesheet" href="/style.css" />
    <meta charset="UTF-8" />
</head>

<body>
<!-- todo /register -> /register.do 변경  -->
<!-- todo /update -> /update.do 변경  -->
<c:choose>
    <c:when test="${empty student}">
        <c:set var="action" value="/student/register.do" />
    </c:when>
    <c:otherwise>
        <c:set var="action" value="/student/update.do" />
    </c:otherwise>
</c:choose>

<form method="post" action="${action}">
    <table>
        <tbody>
        <tr>
            <th>ID</th>
            <td><input type="text" name="id" value="${student.id}" required /></td>
        </tr>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name" value="${student.name}" required /></td>
        </tr>
        <tr>
            <th>성별</th>
            <td>
                <input type="radio" name="gender" value="M" ${student.gender eq 'M' ? 'checked' : '' } />남
                <input type="radio" name="gender" value="F" ${student.gender eq 'F' ? 'checked' : '' } />여
            </td>
        </tr>
        <tr>
            <th>나이</th>
            <td><input type="number" name="age" value="${student.age}" required /></td>
        </tr>
        </tbody>
    </table>
    <p>
        <button type="submit">
            <c:choose>
                <c:when test="${empty student}">
                    등록
                </c:when>
                <c:otherwise>
                    수정
                </c:otherwise>
            </c:choose>
        </button>
    </p>
</form>
</body>
</html>