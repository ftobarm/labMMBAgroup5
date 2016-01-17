<%@ page import="labmmba.Usuario; labmmba.Country; labmmba.University" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<h1>Agregar Tesis</h1>
<div class="nav" role="navigation">
    <g:form controller="tesis" action="upload" enctype="multipart/form-data" useToken="true">
        <br class="button">
            <input hidden name="id" value="${usuarioInstance.id}"/>
            <input type="text" placeholder="Nombre Tesis" name="tesis">
            </br>
            *Tutor: <select name="tutor">
                <g:each in="${labmmba.Usuario.getAll()}" var="tutor">
                    <option value="${tutor.id}" >${tutor.nombre}$ ${tutor.apellido}$  </option>
                </g:each>
            </select>
            </br>
            Cotutor <select name="cotutor">
                <g:each in="${labmmba.Usuario.getAll()}" var="cotutor">
                    <option value="${cotutor.id}" >${cotutor.nombre}$ ${cotutor.apellido}$  </option>
                 </g:each>
                <option selected="Sin Cotutor" >Sin Cotutor  </option>

            </select>
            </br>
                <input type="text" placeholder="*Universidad" name="university" list="universities"/>
            <datalist id="universities">
                <g:each in="${labmmba.University.getAll()}" var="university">
                    <option value="${university.name}"/>
                </g:each>
            </datalist>
            <br/>
            <input type="text" placeholder="*Pais" name="country" list="Countries"/>
            <datalist id="Countries">
                <g:each in="${labmmba.Country.getAll()}" var="country">
                    <option value="${country.name}"/>
                </g:each>
            </datalist>
            </br>
            <input type="file" name="filecsv"/>
            <input type="submit" class="upload" value="upload"/>
        </span>
    </g:form>
    <button><g:link controller="tesis" action="index" id="${usuarioInstance.id}">volver</g:link></button>
</div>

</body>
</html>
