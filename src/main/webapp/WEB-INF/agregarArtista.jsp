<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Artista</title>
</head>
<body>
    <h1>Agregar Artista</h1>
    <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
        Nombre:
        <form:input path="nombre"/>
        <form:errors path="nombre" cssClass="error"/>
        <br><br>


        Apellido:
        <form:input path="apellido"/>
        <form:errors path="apellido" cssClass="error"/>
        <br><br>


        Biografía:
        <form:input path="biografia"/>
        <form:errors path="biografia" cssClass="error"/>
        <br><br>
        <button type="submit"> Guardar</button>

    </form:form>
    <br><br>
    <a href="/artistas">Volver a la lista de artistas</a>


</body>
</html>