<%@ page import="labmmba.Usuario; labmmba.Country; labmmba.University" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<h1>Archivos Multimedia </h1>
<div class="nav" role="navigation">
    <g:form controller="multimedia  " action="upload" enctype="multipart/form-data" useToken="true">
        <br class="button">
        <input hidden name="id" value="${usuarioInstance.id}"/>
        Tipo <input type="text" placeholder="Foto/video/etc" name="type">
        </br>
        <input type="file" name="filecsv"/>
        <input type="submit" class="upload" value="upload"/>
        </span>
    </g:form>
    <button><g:link controller="tesis" action="index" id="${usuarioInstance.id}">volver</g:link></button>
</div>
<g:each in="${multis}" var="multi">
    <strong>${multi.type}:</strong> ${multi.url}
    </br>
</g:each>
</div>
</body>
</html>


