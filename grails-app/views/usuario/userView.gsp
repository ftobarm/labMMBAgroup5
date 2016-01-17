<%@ page import="labmmba.Study; labmmba.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Bienvenido ${usuarioInstance.nombre} ${usuarioInstance.apellido}</h1>
    <ul><g:link controller="usuario" action="edit" id="${usuarioInstance.id}">editar</g:link></ul>
    <ul><g:link controller="tesis" action="index" id="${usuarioInstance.id}">Tesis</g:link></ul>
    <ul><g:link controller="project" action="index" id="${usuarioInstance.id}">Proyectos</g:link></ul>
    <ul><g:link controller="book" action="index" id="${usuarioInstance.id}">Publicaciones</g:link></ul>
    <ul><g:link controller="congress" action="index" id="${usuarioInstance.id}">Asistencias a congresos</g:link></ul>
    <ul><g:link controller="multimedia" action="index" id="${usuarioInstance.id}">Archivos Multimedia</g:link></ul>
    <ul><g:link controller="logout">Salir</g:link></ul>

</br>
<strong>Nombre: </strong>  ${usuarioInstance.nombre}
</br>
<strong>Apellido:</strong> ${usuarioInstance.apellido}
</br>
<strong>Email: </strong>${usuarioInstance.email}
</br>
<strong>Area de Investigacion:</strong> ${usuarioInstance.area.name}
</br>
<strong>Cargo:</strong> ${usuarioInstance.charge.name}
</br>
<strong>Estudios:</strong>
</br>
<g:each in="${studies}" var="study">
    -${study.grade} en ${study.name} en  ${study.university.name} de ${study.country.name}
    </br>
</g:each>
</div>

</body>
</html>