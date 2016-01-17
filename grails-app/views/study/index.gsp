<%@ page import="labmmba.Country; labmmba.University;labmmba.Study" %>

<html>

<head>
    <meta name='layout' content='main'/>
    <title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>



<s2ui:form width='650' height='300' elementId='loginFormContainer'
           titleCode='Agregar estudios' center='true'>
    <p style="color: #cd0a0a">${flash.message}</p>
    <g:form controller="study" action='register' name='registerForm'>

        <g:if test='${emailSent}'>
            <br/>
            <g:message code='spring.security.ui.register.sent'/>
        </g:if>
        <g:else>

            <br/>
            <table>
                <tbody>
                <input type="text" placeholder="Carrera" name="carrera" list="carreras"/>
                <datalist id="carreras">
                    <g:each in="${labmmba.Study.getAll()}" var="study">
                        <option value="${study.name}"/>
                    </g:each>
                </datalist>
                <br/>
                <input type="text" placeholder="Universidad" name="university" list="universities"/>
                <datalist id="universities">
                    <g:each in="${labmmba.University.getAll()}" var="university">
                        <option value="${university.name}"/>
                    </g:each>
                </datalist>
                <br/>
                <input type="text" placeholder="pais" name="country" list="Countries"/>
                <datalist id="Countries">
                    <g:each in="${labmmba.Country.getAll()}" var="country">
                        <option value="${country.name}"/>
                    </g:each>
                </datalist>
                <br/>
                <input type="text" placeholder="grado" name="grade" list="grades"/>
                <datalist id="grades">
                    <option value="pregrado"/>
                    <option value="Magister"/>
                    <option value="Doctorado    "/>
                </datalist>
                <input hidden name="id" value="${usuarioInstance.id}"/>
            </table>

            <button>Agregar</button>
            <br/>
            <button><g:link controller="usuario" action="userView" id="${usuarioInstance.id}">volver</g:link></button>

        </g:else>

    </g:form>

</s2ui:form>

