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
    <title>Playlist</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/style.css" />" />

<script type="text/javascript">
    function toggle_visibility(id) {
        var e;
        for(var i = 0; i < id.length; i++){
            e = document.getElementById(id[i]);
               if(e.style.display == 'block')
                  e.style.display = 'none';
               else
                  e.style.display = 'block';
        }
    }
</script>

</head>


<body>

<div id="header">
    <h1> Playlist </h1>
</div>
<%@include file="nav.html"%>
<div id="wrapper">
    <div id="createList">
        <input type="submit" name="createList" value="Create new playlist" onclick="toggle_visibility(['addPlaylist']);"/>
        <form action='${pageContext.request.contextPath}/playlist' method="post">
            <div id="addPlaylist"><br/>
                Choose name of playlist:
                <input type="text" name="newPlaylistName"><br/>
                <input type="submit" name="submitTrack" value="submit" onclick="toggle_visibility(['addPlaylist']);">
            </div>
        </form>
    </div>

    <form action="${pageContext.request.contextPath}/playlist" method="post">
    <table>
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
            <td>
                <input type="radio" name="radioButton" value="${item.name}">
                <input type="submit" name="editThisList" value="edit this">
            </td>
        </tr>
        </c:forEach>
    </table>
    <br>
    </form>

    <input type="button" name="editMode" value="Edit" onclick="toggle_visibility(['searchTrack']);"/>
    <div id="searchTrack">
        <form action="${pageContext.request.contextPath}/playlist" method="post">
            Title: <input type='text' value="${myBean}" name="newTrackName">
            <input type="submit" value="kiez deze naam" name="changeListName" onclick="toggle_visibility(['searchTrack']);"><br/>
            Choose at least 1 track before you can submit "search for file".<br/>
            add track:
        </form>
        <form action="${pageContext.request.contextPath}/addtrack" method="get">
            <input type="submit" name="searchTrack" value="${myBean}">
        </form>
    </div>
</div>
</body>
</html>
