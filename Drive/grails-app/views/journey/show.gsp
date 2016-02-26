
<%@ page import="drive.Journey" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'journey.label', default: 'Journey')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-journey" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-journey" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list journey">
			
				<g:if test="${journeyInstance?.journeyTimeLength}">
				<li class="fieldcontain">
					<span id="journeyTimeLength-label" class="property-label"><g:message code="journey.journeyTimeLength.label" default="Journey Time Length" /></span>
					
						<span class="property-value" aria-labelledby="journeyTimeLength-label"><g:fieldValue bean="${journeyInstance}" field="journeyTimeLength"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.heavyAccelerationCount}">
				<li class="fieldcontain">
					<span id="heavyAccelerationCount-label" class="property-label"><g:message code="journey.heavyAccelerationCount.label" default="Heavy Acceleration Count" /></span>
					
						<span class="property-value" aria-labelledby="heavyAccelerationCount-label"><g:fieldValue bean="${journeyInstance}" field="heavyAccelerationCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.heavyBrakingCount}">
				<li class="fieldcontain">
					<span id="heavyBrakingCount-label" class="property-label"><g:message code="journey.heavyBrakingCount.label" default="Heavy Braking Count" /></span>
					
						<span class="property-value" aria-labelledby="heavyBrakingCount-label"><g:fieldValue bean="${journeyInstance}" field="heavyBrakingCount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.averageSpeed}">
				<li class="fieldcontain">
					<span id="averageSpeed-label" class="property-label"><g:message code="journey.averageSpeed.label" default="Average Speed" /></span>
					
						<span class="property-value" aria-labelledby="averageSpeed-label"><g:fieldValue bean="${journeyInstance}" field="averageSpeed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.averageRPM}">
				<li class="fieldcontain">
					<span id="averageRPM-label" class="property-label"><g:message code="journey.averageRPM.label" default="Average RPM" /></span>
					
						<span class="property-value" aria-labelledby="averageRPM-label"><g:fieldValue bean="${journeyInstance}" field="averageRPM"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.topSpeed}">
				<li class="fieldcontain">
					<span id="topSpeed-label" class="property-label"><g:message code="journey.topSpeed.label" default="Top Speed" /></span>
					
						<span class="property-value" aria-labelledby="topSpeed-label"><g:fieldValue bean="${journeyInstance}" field="topSpeed"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.topRPM}">
				<li class="fieldcontain">
					<span id="topRPM-label" class="property-label"><g:message code="journey.topRPM.label" default="Top RPM" /></span>
					
						<span class="property-value" aria-labelledby="topRPM-label"><g:fieldValue bean="${journeyInstance}" field="topRPM"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.endTime}">
				<li class="fieldcontain">
					<span id="endTime-label" class="property-label"><g:message code="journey.endTime.label" default="End Time" /></span>
					
						<span class="property-value" aria-labelledby="endTime-label"><g:formatDate date="${journeyInstance?.endTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.sensors}">
				<li class="fieldcontain">
					<span id="sensors-label" class="property-label"><g:message code="journey.sensors.label" default="Sensors" /></span>
					
						<g:each in="${journeyInstance.sensors}" var="s">
						<span class="property-value" aria-labelledby="sensors-label"><g:link controller="sensor" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.startTime}">
				<li class="fieldcontain">
					<span id="startTime-label" class="property-label"><g:message code="journey.startTime.label" default="Start Time" /></span>
					
						<span class="property-value" aria-labelledby="startTime-label"><g:formatDate date="${journeyInstance?.startTime}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${journeyInstance?.vehicle}">
				<li class="fieldcontain">
					<span id="vehicle-label" class="property-label"><g:message code="journey.vehicle.label" default="Vehicle" /></span>
					
						<span class="property-value" aria-labelledby="vehicle-label"><g:link controller="vehicle" action="show" id="${journeyInstance?.vehicle?.id}">${journeyInstance?.vehicle?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:journeyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${journeyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
