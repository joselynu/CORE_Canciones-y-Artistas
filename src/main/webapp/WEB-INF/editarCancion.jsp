<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Canciones</title>
</head>
<body>
    <h1>Editar Canciones</h1>

    <form:form method="POST" modelAttribute="cancion"
        action="/canciones/procesa/editar/${cancion.id}">

        <p>
            Título:
            <form:input path="titulo"/>
            <form:errors path="titulo" cssClass="errors"/>
        </p>

        <p>
            Artista:
            <form:input path="artista"/>
            <form:errors path="artista" cssClass="errors"/>
        </p>
        <p>

            Álbum:
            <form:input path="album"/>
            <form:errors path="album" cssClass="errors"/>
        </p>

        <p>
            Género:
            <form:input path="genero"/>
            <form:errors path="genero" cssClass="errors"/>
        </p>

        <p>
            Idioma:
            <form:input path="idioma"/>
            <form:errors path="idioma" cssClass="errors"/>
        </p>

        <button type="submit"> Actualizar canción</button>
    </form:form>

    <p>
        <a href="/canciones">Volver a la lista de canciones</a>
    </p>
</body>
</html>