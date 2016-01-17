<%@ page import="labmmba.Study; labmmba.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Tus Proyectos</h1>
<ul><g:link controller="project" action="register" id="${usuarioInstance.id}">Añadir Proyecto</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${projects}" var="project">
    <strong>-Proyecto:</strong>  ${project.project.name}(${project.project.age})
    <strong>cargo:</strong> ${project.charge} <strong>Otros:</strong> ${project.project.other}
    </br>
</g:each>
</body>
</html>

