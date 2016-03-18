
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
					
						<g:sortableColumn property="averageAmbientAirTemperature" title="${message(code: 'journey.averageAmbientAirTemperature.label', default: 'Average Ambient Air Temperature')}" />
					
						<g:sortableColumn property="averageEngineLoad" title="${message(code: 'journey.averageEngineLoad.label', default: 'Average Engine Load')}" />
					
						<g:sortableColumn property="averageGForce" title="${message(code: 'journey.averageGForce.label', default: 'Average GF orce')}" />
					
						<g:sortableColumn property="averageMPG" title="${message(code: 'journey.averageMPG.label', default: 'Average MPG')}" />
					
						<g:sortableColumn property="averagePercentageCoasting" title="${message(code: 'journey.averagePercentageCoasting.label', default: 'Average Percentage Coasting')}" />
					
						<g:sortableColumn property="averagePercentageHighRPM" title="${message(code: 'journey.averagePercentageHighRPM.label', default: 'Average Percentage High RPM')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${journeyInstanceList}" status="i" var="journeyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${journeyInstance.id}">${fieldValue(bean: journeyInstance, field: "averageAmbientAirTemperature")}</g:link></td>
					
						<td>${fieldValue(bean: journeyInstance, field: "averageEngineLoad")}</td>
					
						<td>${fieldValue(bean: journeyInstance, field: "averageGForce")}</td>
					
						<td>${fieldValue(bean: journeyInstance, field: "averageMPG")}</td>
					
						<td>${fieldValue(bean: journeyInstance, field: "averagePercentageCoasting")}</td>
					
						<td>${fieldValue(bean: journeyInstance, field: "averagePercentageHighRPM")}</td>
					
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
