<%@ page import="labmmba.Study; labmmba.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Tus Proyectos</h1>
<ul><g:link controller="proyect" action="register" id="${usuarioInstance.id}">Añadir Proyecto</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${proyects}" var="proyect">
    <strong>-Proyecto:</strong>  ${proyect.proyect.name}(${proyect.proyect.age})
    <strong>cargo:</strong> ${proyect.charge} <strong>Otros:</strong> ${proyect.proyect.other}
    </br>
</g:each>
</body>
</html>

