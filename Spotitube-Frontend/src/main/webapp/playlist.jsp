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
    <div>
        <div id="search">
            <form action="${pageContext.request.contextPath}/playlist" method="post">
               Search for a playlist:
               <input type="text" name="name">
               <input type="submit" value="Submit"/>
            </form>
        </div>
        <div id="createList">
          <input type="submit" name="createList" value="Create new playlist" onclick="toggle_visibility(['addPlaylist']);"/>
          <input type="button" name="editMode" value="Edit" onclick="toggle_visibility(['editThisList']);"/>
          <form action='${pageContext.request.contextPath}/playlist' method="post">
          <div id="addPlaylist"><br/>
              Choose name of playlist:
              <input type="text" name="newPlaylistName"><br/>
              Choose at least 1 track before you can submit "search for file".<br/>
              <a href="${pageContext.request.contextPath}/addtrack">Search for file</a><br/>
              <!-- if this list is empty, hide submit "search for file".
              Else show submit -->
              <ul>
                <!-- <li>track/vid</li> -->
              </ul>
              <!-- Add this item to the list!!! -->
              <input type="submit" name="submitTrack" value="submit" onclick="toggle_visibility(['addPlaylist']);">
          </div>
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
          <td><input type="radio" name="radioButton" value="${item.name}"></td>
        </tr>
      </c:forEach>
      </table>
      esjkgnksejgn
      <input type="submit" name="editThisList" id="editThisList" value="Edit this Playlist" >
      <br>

    </form>
</div>

<!-- Button Example-->
<form action="${pageContext.request.contextPath}/playlist" method="post">
  <input type="submit" name="button1" value="Button1"/>
</form>
</form>

<form action="${pageContext.request.contextPath}/playlist" method="get">
    <div>
        Title: <input type='text' placeholder="${myBean}"><br/>
        Songs:
        Choose at least 1 track before you can submit "search for file".<br/>
          <input type="submit" value="Search for file"><br/>
          <!-- if this list is empty, hide submit "search for file".
          Else show submit -->
          <ul>
            <!-- <li>track/vid</li> -->
          </ul>
          <!-- Add this item to the list!!! -->
    </div>
</form>
</body>
</html>
