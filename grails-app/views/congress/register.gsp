<%@ page import="labmmba.Usuario; labmmba.Country;labmmba.Congress" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<h1>Agregar asistencia a congresos</h1>
<div class="nav" role="navigation">
    <g:form controller="congress" action="upload" enctype="multipart/form-data" useToken="true">
        <br class="button">
            <input hidden name="id" value="${usuarioInstance.id}"/>
            Nombre Congreso<input type="text" placeholder="Congreso1" name="name">
            </br>
            Fecha de Inicio<input type="text" placeholder="AAAA/MM/DD  " name="startDate">
            </br>
            Fecha de Termino<input type="text" placeholder="AAAA/MM/DD"  name="endDate">
            </br>
            Ciudad<input type="text" placeholder="Ciudad" name="city" list="Cities">
                <datalist id="Cities">
                    <g:each in="${labmmba.Congress.getAll()}" var="congress">
                        <option value="${congress.city}"/>
                    </g:each>
                </datalist>
            </br>
            Pais<input type="text" placeholder="Pais" name="country" list="Countries"/>
            <datalist id="Countries">
                <g:each in="${labmmba.Country.getAll()}" var="country">
                    <option value="${country.name}"/>
                </g:each>
            </datalist>
            </br>
            Nombre archivo<input type="text" placeholder="Poster/Paper/Presentacion" name="paper"/>
            </br>
            <input type="file" name="filecsv"/>
            <input type="submit" class="upload" value="upload"/>
        </span>
    </g:form>
    <button><g:link controller="congress" action="index" id="${usuarioInstance.id}">volver</g:link></button>
</div>

</body>
</html>
