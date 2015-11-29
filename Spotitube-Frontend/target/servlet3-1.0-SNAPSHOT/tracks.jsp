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
<h1>Playlist: ${playlistName}</h1>
<h1>ListID: ${playlistID} | tracks In List:</h1>
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
<br/><br/>
Choose tracks to add to this playlist:
<form action="${pageContext.request.contextPath}/addtrack"  method="get">
<table border="1">
  <tr>
    <th> ID</th>
    <th> Performer</th>
    <th> Title</th>
    <th> Url</th>
    <th> Duration</th>
    <th> Add</th>
  </tr>
  <c:forEach var ="item" items="${allTracks}">
    <tr>
      <td>${item.id}</td>
      <td>${item.performer} </td>
      <td>${item.title}</td>
      <td>${item.url}</td>
      <td>${item.duration}</td>
      <td><input type="checkbox" value="${item.id}" name="addToPlaylist"></td>
    </tr>
  </c:forEach>
</table>
<input type="text" value="${playlistID}" name="playlistID">
<input type="submit" name="addItemsToPlaylist">
</form>
</div>
</body>
</html>
