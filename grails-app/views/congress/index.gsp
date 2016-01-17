<%@ page import="labmmba.Study; labmmba.Usuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Congresos</h1>
<ul><g:link controller="congress" action="register" id="${usuarioInstance.id}">Añadir Asistencia</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${congress}" var="congress1">
    <strong>-Nombre del Congreso:</strong>  ${congress1.congress.name}
    <strong>Locacion:</strong> ${congress1.congress.city},${congress1.congress.country.name}
    <strong>Fechas</strong> ${congress1.congress.startDate}-${congress1.congress.endDate}
    <strong>Paper:</strong> ${congress1.url}
    </br>
</g:each>
</body>
</html>


