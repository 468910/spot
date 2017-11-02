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
                <input type="submit" name="submitList" value="submit" onclick="toggle_visibility(['addPlaylist']);">
            </div>
        </form>
    </div>

    <form action="${pageContext.request.contextPath}/playlist" method="post">
    <table>
        <tr>
            <th> Name</th>
            <th> Owner</th>
            <th> Select</th>
            <th> Availability</th>
        </tr>
        <c:forEach var ="item" items="${list}" varStatus="status">
        <tr>
            <td>${item.name} </td>
            <td>${item.owner}</td>
            <td>
                List id: ${item.id} <input class="radio" type="radio" name="listID" value="${item.id}">
                <input type="submit" name="editThisList" value="edit this">
            </td>
            <td>${item.availability}</td>
        </tr>
        </c:forEach>
    </table>
    <br>
    </form>

    <input type="button" name="editMode" value="Add tracks or change playlist name" onclick="toggle_visibility(['searchTrack']);"/>
    <br/><br/>

    <div id="searchTrack">
        <form action="${pageContext.request.contextPath}/playlist" method="post">
            Playlist name: <input type='text' value="${myBean}" name="newTrackName">
            <input type="submit" value="Kies deze naam" name="changeListName" onclick="toggle_visibility(['searchTrack']);"><br/>
        </form>
        <form action="${pageContext.request.contextPath}/addtrack" method="get">
            <input type="submit" name="searchTrack" value="Add tracks">
            <input type="hidden" value="${playlistID}" name="playlistID">
        </form>
    </div>
</div>
</body>
</html>
