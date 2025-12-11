<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle Cancion</title>
</head>
<body>
    <h1>${cancion.titulo}</h1>
    <p>Artista: ${cancion.artista.nombre} ${cancion.artista.apellido}</p>
    <p>Album: ${cancion.album}</p>
    <p>Genero: ${cancion.genero}</p>
    <p>Idioma: ${cancion.idioma}</p>

    <a href="/canciones/formulario/editar/${cancion.id}">
        <button>Editar Canción</button>
    </a>
    <br><br>
    <a href="/canciones/eliminar/${cancion.id}">
        <button>Eliminar Canción</button>
    </a>
    <br><br>
    <a href="/canciones">Volver a la lista de  canciones</a>
</body>
</html>




