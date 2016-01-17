<%@ page import="labmmba.Country; labmmba.University;labmmba.Study" %>

<html>

<head>
    <meta name='layout' content='main'/>
    <title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>



<s2ui:form width='650' height='300' elementId='loginFormContainer'
           titleCode='Añadir proyecto' center='true'>
    <p style="color: #cd0a0a">${flash.message}</p>
    <g:form controller="project" action='save' name='registerForm'>

        <g:if test='${emailSent}'>
            <br/>
            <g:message code='spring.security.ui.register.sent'/>
        </g:if>
        <g:else>

            <br/>
            <table>
                <tbody>
                Nombre proyecto <input type="text" placeholder="proyecto 1" name="name" />
                <br/>
                Años de ejecucion<input type="text" placeholder="2013-2015" name="age" />
                <br/>
                Cargo en el proyecto <input type="text" placeholder="Cargo" name="charge" />
                <br/>
                Otros <input type="text" placeholder="fondef, proyecto de tesis" name="other"/>
                <br/>
                <input hidden name="id" value="${usuarioInstance.id}"/>
            </table>

            <button>Agregar</button>
            <br/>
            <button><g:link controller="project" action="index" id="${usuarioInstance.id}">volver</g:link></button>

        </g:else>

    </g:form>

</s2ui:form>

