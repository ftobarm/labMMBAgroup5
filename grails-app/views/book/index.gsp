<%@ page import="labmmba.Usuario;labmmba.UserBook" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<br>
<div class="nav" role="navigation">
    <h1>Publicaciones</h1>
<ul><g:link controller="book" action="register" id="${usuarioInstance.id}">Añadir publicacion</g:link></ul>
<ul><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></ul>
</div>
</br>
</br>
<g:each in="${books}" var="book">
    <strong>-Nombre de publicacion:</strong>  ${book.book.title}
    <strong>Año:</strong> ${book.book.year} <strong>Autores:</strong>
    <g:each in="${labmmba.UserBook.findAllByBook(book.book)}" var="autor">
        ${autor.user.nombre} ${autor.user.apellido},
    </g:each>
    <strong>Editorial:</strong> ${book.book.editorial}
    <strong>ISBN:</strong> ${book.book.isbn}
    <br>
    <strong>Url:</strong> ${book.book.url}
    </br>
</g:each>
</body>
</html>


