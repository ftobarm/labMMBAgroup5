<%@ page import="labmmba.Usuario;labmmba.UserBook" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Revistas</h1>
<ul><g:link controller="magazine" action="register" id="${usuarioInstance.id}">Añadir revista</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${magazines}" var="magazine">
    <strong>-Nombre de revista:</strong>  ${magazine.magazine.magazineName}
    <strong>Año:</strong> ${magazine.magazine.year}
    <strong>articulo:</strong> ${magazine.magazine.paper}
    <strong>Area:</strong> ${magazine.magazine.area.name}
    <strong>Autores:</strong>
    <g:each in="${labmmba.UserMagazine.findAllByMagazine(magazine.magazine)}" var="autor">
        ${autor.user.nombre} ${autor.user.apellido},
    </g:each>
    <strong>keyword:</strong>
    <g:each in="${labmmba.KeywordMagazine.findAllByMagazine(magazine.magazine)}" var="keyword">
        ${keyword.keyword.name},
    </g:each>
    </br>
    </br>
</g:each>
</body>
</html>


