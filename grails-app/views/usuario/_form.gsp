<%@ page import="labmmba.Charge; labmmba.InvestigationArea; labmmba.Usuario" %>



<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="usuario.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${usuarioInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'nombre', 'error')} required">
	<label for="nombre">
		<g:message code="usuario.nombre.label" default="nombre" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nombre" required="" value="${usuarioInstance?.nombre}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'apellido', 'error')} required">
	<label for="apellido">
		<g:message code="usuario.apellido.label" default="apellido" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="apellido" required="" value="${usuarioInstance?.apellido}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'area', 'error')} required">
	<label for="area">
		<g:message code="usuario.apellido.label" default="area" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="area"
			  from="${InvestigationArea.list()}"
			  value="${usuarioInstance?.area}"
			  optionValue="name"
			  noSelection='["${usuarioInstance.area.id}":"${usuarioInstance.area.name}(actual)"]'
			  optionKey="id"
	/>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'charge', 'error')} required">
	<label for="charge">
		<g:message code="usuario.apellido.label" default="charge" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="charge"
			  from="${labmmba.Charge.list()}"
			  value="${usuarioInstance?.charge}"
			  optionValue="name"
			  noSelection='["${usuarioInstance.charge.id}" :"${usuarioInstance.charge.name}(actual)"]'
			  optionKey="id"
	/>
</div>
<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'password', 'error')} required">
	<g:hiddenField name="password" value="${usuarioInstance?.password}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountExpired', 'error')} ">

	<g:hiddenField name="accountExpired" value="${false}" />

</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'enabled', 'error')} ">
	<g:hiddenField name="enabled" value="${true}" />
</div>
<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'passwordExpired', 'error')} ">
	<g:hiddenField name='passwordExpired' value="${false}" />
</div>

<div class="fieldcontain ${hasErrors(bean: usuarioInstance, field: 'accountLocked', 'error')} ">
	<g:hiddenField name='accountLocked' value="${false}" />

</div>