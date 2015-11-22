<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 29/10/15
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/style.css" />" />
</head>
<body>

<div id="header">
    <h1> Tracks </h1>
</div>

<%@include file="nav.html"%>
<div id="wrapper">
<table border="1">
  <tr>
    <th> Performer</th>
    <th> Title</th>
    <th> Url</th>
    <th> Duration</th>
  </tr>
  <c:forEach var ="item" items="${list}">
    <tr>
      <td>${item.performer} </td>
      <td>${item.title}</td>
      <td>${item.url}</td>
      <td>${item.duration}</td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
