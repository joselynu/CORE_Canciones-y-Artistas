<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle del Artista</title>
</head>
<body>
    <h1>Detalle del Artista</h1>

    <p>Nombre: ${artista.nombre}</p>
    <p>Apellido: ${artista.apellido}</p>
    <p>Biografía: ${artista.biografia}</p>
    <p>Fecha de Creación: ${artista.fechaCreacion}</p>
    <p>Fecha de Actualizacion: ${artista.fechaActualizacion}</p>

    <h3>Lista de Canciones</h3>
    <ul>
        <c:forEach var="cancion" items="${artista.canciones}">
        <li>${cancion.titulo}</li>
        </c:forEach>
    </ul>

    <br>
    <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>
