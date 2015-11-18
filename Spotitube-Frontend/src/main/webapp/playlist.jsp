<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 16/10/15
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>


<form action="${pageContext.request.contextPath}/addtrack">
<table border="1">
  <tr>
    <th> Name</th>
    <th> Owner</th>
    <th> Availability</th>
    <th> Select</th>
  </tr>
  <c:forEach var ="item" items="${list}" varStatus="status">
    <tr>
      <td>${item.name} </td>
      <td>${item.owner}</td>
      <td>${item.availability}</td>
      <td><input type="radio" name="radioButton" value="${status.count}" ></td>
    </tr>
  </c:forEach>
  </table>
  <br>
  <br>
  <input type="submit" name="choosePlaylistButton" value="Choose" >
</form>

<form  action="${pageContext.request.contextPath}/playlist" method="post">
   Name: <br>
  <input type="text" name="name">
  <br>
  <input type="submit" value="Submit"/>
  <br>

</form>


<!-- Button Example -->
<form action="${pageContext.request.contextPath}/playlist" method="post">
  <input type="submit" name="button1" value="Button1"/>
  </form>

</form>
</body>
</html>
