
<%@ page import="drive.Vehicle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'vehicle.label', default: 'Vehicle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-vehicle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list vehicle">
			
				<g:if test="${vehicleInstance?.identifier}">
				<li class="fieldcontain">
					<span id="identifier-label" class="property-label"><g:message code="vehicle.identifier.label" default="Identifier" /></span>
					
						<span class="property-value" aria-labelledby="identifier-label"><g:fieldValue bean="${vehicleInstance}" field="identifier"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.driver}">
				<li class="fieldcontain">
					<span id="driver-label" class="property-label"><g:message code="vehicle.driver.label" default="Driver" /></span>
					
						<span class="property-value" aria-labelledby="driver-label"><g:link controller="driver" action="show" id="${vehicleInstance?.driver?.id}">${vehicleInstance?.driver?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.manufacturer}">
				<li class="fieldcontain">
					<span id="manufacturer-label" class="property-label"><g:message code="vehicle.manufacturer.label" default="Manufacturer" /></span>
					
						<span class="property-value" aria-labelledby="manufacturer-label"><g:fieldValue bean="${vehicleInstance}" field="manufacturer"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.model}">
				<li class="fieldcontain">
					<span id="model-label" class="property-label"><g:message code="vehicle.model.label" default="Model" /></span>
					
						<span class="property-value" aria-labelledby="model-label"><g:fieldValue bean="${vehicleInstance}" field="model"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.year}">
				<li class="fieldcontain">
					<span id="year-label" class="property-label"><g:message code="vehicle.year.label" default="Year" /></span>
					
						<span class="property-value" aria-labelledby="year-label"><g:fieldValue bean="${vehicleInstance}" field="year"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.engineSize}">
				<li class="fieldcontain">
					<span id="engineSize-label" class="property-label"><g:message code="vehicle.engineSize.label" default="Engine Size" /></span>
					
						<span class="property-value" aria-labelledby="engineSize-label"><g:fieldValue bean="${vehicleInstance}" field="engineSize"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.fuelType}">
				<li class="fieldcontain">
					<span id="fuelType-label" class="property-label"><g:message code="vehicle.fuelType.label" default="Fuel Type" /></span>
					
						<span class="property-value" aria-labelledby="fuelType-label"><g:fieldValue bean="${vehicleInstance}" field="fuelType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.journeys}">
				<li class="fieldcontain">
					<span id="journeys-label" class="property-label"><g:message code="vehicle.journeys.label" default="Journeys" /></span>
					
						<g:each in="${vehicleInstance.journeys}" var="j">
						<span class="property-value" aria-labelledby="journeys-label"><g:link controller="journey" action="show" id="${j.id}">${j?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:vehicleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${vehicleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
