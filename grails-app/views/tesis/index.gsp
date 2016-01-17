<%@ page import="labmmba.Study; labmmba.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Tesis</h1>
<ul><g:link controller="tesis" action="register" id="${usuarioInstance.id}">Añadir tesis</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${tesis}" var="tesis1">
    <strong>Nombre de Tesis:</strong>  ${tesis1.tesis.name}
    <strong>Universidad:</strong> ${tesis1.tesis.university.name} de ${tesis1.tesis.country.name}
    <strong>Cargo:</strong>${tesis1.charge} <strong>Url:</strong>${tesis1.tesis.url}
    </br>
</g:each>
</body>
</html>


