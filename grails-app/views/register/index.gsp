<html>

<head>
	<meta name='layout' content='main'/>
	<title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>



<s2ui:form width='650' height='300' elementId='loginFormContainer'
           titleCode='spring.security.ui.register.description' center='true'>
<p style="color: #cd0a0a">${flash.message}</p>
<g:form controller="register" action='register' name='registerForm'>

	<g:if test='${emailSent}'>
	<br/>
	<g:message code='spring.security.ui.register.sent'/>
	</g:if>
	<g:else>

	<br/>

	<table>
	<tbody>

		<s2ui:textFieldRow name='email' bean="${command}" value="${command.email}"
		                   size='40' labelCode='user.email.label' labelCodeDefault='E-mail'/>

		<s2ui:textFieldRow name='nombre' bean="${command}" value="${command.nombre}"
		size='40' labelCode='user.nombre.label' labelCodeDefault='Nombre'/>

		<s2ui:textFieldRow name='apellido' bean="${command}" value="${command.apellido}"
						   size='40' labelCode='user.apellido.label' labelCodeDefault='apellido'/>

		<s2ui:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"
                             size='40' labelCodeDefault='Password' value="${command.password}"/>

		<s2ui:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"
                             size='40' labelCodeDefault='Password (again)' value="${command.password2}"/>
	</tbody>
	</table>

	<button>Registrarse</button>
		<br/>
		<button><g:link controller="inicio" action="index">volver</g:link></button>

	</g:else>

</g:form>

</s2ui:form>


<script>
$(document).ready(function() {
	$('#username').focus();
});
</script>
</body>
</html>
