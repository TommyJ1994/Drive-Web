
<%@ page import="drive.Sensor" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'sensor.label', default: 'Sensor')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-sensor" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-sensor" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list sensor">
			
				<g:if test="${sensorInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="sensor.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${sensorInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sensorInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="sensor.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${sensorInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${sensorInstance?.journey}">
				<li class="fieldcontain">
					<span id="journey-label" class="property-label"><g:message code="sensor.journey.label" default="Journey" /></span>
					
						<span class="property-value" aria-labelledby="journey-label"><g:link controller="journey" action="show" id="${sensorInstance?.journey?.id}">${sensorInstance?.journey?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${sensorInstance?.points}">
				<li class="fieldcontain">
					<span id="points-label" class="property-label"><g:message code="sensor.points.label" default="Points" /></span>
					
						<g:each in="${sensorInstance.points}" var="p">
						<span class="property-value" aria-labelledby="points-label"><g:link controller="point" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:sensorInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${sensorInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
