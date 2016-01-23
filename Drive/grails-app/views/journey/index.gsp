
<%@ page import="drive.Journey" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'journey.label', default: 'Journey')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-journey" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-journey" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="endTime" title="${message(code: 'journey.endTime.label', default: 'End Time')}" />
					
						<g:sortableColumn property="heavyAccelerationCount" title="${message(code: 'journey.heavyAccelerationCount.label', default: 'Heavy Acceleration Count')}" />
					
						<g:sortableColumn property="heavyBrakingCount" title="${message(code: 'journey.heavyBrakingCount.label', default: 'Heavy Braking Count')}" />
					
						<g:sortableColumn property="startTime" title="${message(code: 'journey.startTime.label', default: 'Start Time')}" />
					
						<th><g:message code="journey.vehicle.label" default="Vehicle" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${journeyInstanceList}" status="i" var="journeyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${journeyInstance.id}">${fieldValue(bean: journeyInstance, field: "endTime")}</g:link></td>
					
						<td>${fieldValue(bean: journeyInstance, field: "heavyAccelerationCount")}</td>
					
						<td>${fieldValue(bean: journeyInstance, field: "heavyBrakingCount")}</td>
					
						<td><g:formatDate date="${journeyInstance.startTime}" /></td>
					
						<td>${fieldValue(bean: journeyInstance, field: "vehicle")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${journeyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
