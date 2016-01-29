
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
			
				<g:if test="${vehicleInstance?.make}">
				<li class="fieldcontain">
					<span id="make-label" class="property-label"><g:message code="vehicle.make.label" default="Make" /></span>
					
						<span class="property-value" aria-labelledby="make-label"><g:fieldValue bean="${vehicleInstance}" field="make"/></span>
					
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
			
				<g:if test="${vehicleInstance?.engineConfiguration}">
				<li class="fieldcontain">
					<span id="engineConfiguration-label" class="property-label"><g:message code="vehicle.engineConfiguration.label" default="Engine Configuration" /></span>
					
						<span class="property-value" aria-labelledby="engineConfiguration-label"><g:fieldValue bean="${vehicleInstance}" field="engineConfiguration"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.engineDisplacement}">
				<li class="fieldcontain">
					<span id="engineDisplacement-label" class="property-label"><g:message code="vehicle.engineDisplacement.label" default="Engine Displacement" /></span>
					
						<span class="property-value" aria-labelledby="engineDisplacement-label"><g:fieldValue bean="${vehicleInstance}" field="engineDisplacement"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.manufacturerEngineCode}">
				<li class="fieldcontain">
					<span id="manufacturerEngineCode-label" class="property-label"><g:message code="vehicle.manufacturerEngineCode.label" default="Manufacturer Engine Code" /></span>
					
						<span class="property-value" aria-labelledby="manufacturerEngineCode-label"><g:fieldValue bean="${vehicleInstance}" field="manufacturerEngineCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.totalEngineValves}">
				<li class="fieldcontain">
					<span id="totalEngineValves-label" class="property-label"><g:message code="vehicle.totalEngineValves.label" default="Total Engine Valves" /></span>
					
						<span class="property-value" aria-labelledby="totalEngineValves-label"><g:fieldValue bean="${vehicleInstance}" field="totalEngineValves"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.cylinders}">
				<li class="fieldcontain">
					<span id="cylinders-label" class="property-label"><g:message code="vehicle.cylinders.label" default="Cylinders" /></span>
					
						<span class="property-value" aria-labelledby="cylinders-label"><g:fieldValue bean="${vehicleInstance}" field="cylinders"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.compressionRatio}">
				<li class="fieldcontain">
					<span id="compressionRatio-label" class="property-label"><g:message code="vehicle.compressionRatio.label" default="Compression Ratio" /></span>
					
						<span class="property-value" aria-labelledby="compressionRatio-label"><g:fieldValue bean="${vehicleInstance}" field="compressionRatio"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.engineSize}">
				<li class="fieldcontain">
					<span id="engineSize-label" class="property-label"><g:message code="vehicle.engineSize.label" default="Engine Size" /></span>
					
						<span class="property-value" aria-labelledby="engineSize-label"><g:fieldValue bean="${vehicleInstance}" field="engineSize"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.horsepower}">
				<li class="fieldcontain">
					<span id="horsepower-label" class="property-label"><g:message code="vehicle.horsepower.label" default="Horsepower" /></span>
					
						<span class="property-value" aria-labelledby="horsepower-label"><g:fieldValue bean="${vehicleInstance}" field="horsepower"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.torque}">
				<li class="fieldcontain">
					<span id="torque-label" class="property-label"><g:message code="vehicle.torque.label" default="Torque" /></span>
					
						<span class="property-value" aria-labelledby="torque-label"><g:fieldValue bean="${vehicleInstance}" field="torque"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.fuelType}">
				<li class="fieldcontain">
					<span id="fuelType-label" class="property-label"><g:message code="vehicle.fuelType.label" default="Fuel Type" /></span>
					
						<span class="property-value" aria-labelledby="fuelType-label"><g:fieldValue bean="${vehicleInstance}" field="fuelType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.drivenWheels}">
				<li class="fieldcontain">
					<span id="drivenWheels-label" class="property-label"><g:message code="vehicle.drivenWheels.label" default="Driven Wheels" /></span>
					
						<span class="property-value" aria-labelledby="drivenWheels-label"><g:fieldValue bean="${vehicleInstance}" field="drivenWheels"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.transmissionType}">
				<li class="fieldcontain">
					<span id="transmissionType-label" class="property-label"><g:message code="vehicle.transmissionType.label" default="Transmission Type" /></span>
					
						<span class="property-value" aria-labelledby="transmissionType-label"><g:fieldValue bean="${vehicleInstance}" field="transmissionType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.vehicleStyle}">
				<li class="fieldcontain">
					<span id="vehicleStyle-label" class="property-label"><g:message code="vehicle.vehicleStyle.label" default="Vehicle Style" /></span>
					
						<span class="property-value" aria-labelledby="vehicleStyle-label"><g:fieldValue bean="${vehicleInstance}" field="vehicleStyle"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.numberOfSpeeds}">
				<li class="fieldcontain">
					<span id="numberOfSpeeds-label" class="property-label"><g:message code="vehicle.numberOfSpeeds.label" default="Number Of Speeds" /></span>
					
						<span class="property-value" aria-labelledby="numberOfSpeeds-label"><g:fieldValue bean="${vehicleInstance}" field="numberOfSpeeds"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.numOfDoors}">
				<li class="fieldcontain">
					<span id="numOfDoors-label" class="property-label"><g:message code="vehicle.numOfDoors.label" default="Num Of Doors" /></span>
					
						<span class="property-value" aria-labelledby="numOfDoors-label"><g:fieldValue bean="${vehicleInstance}" field="numOfDoors"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.mpgHighway}">
				<li class="fieldcontain">
					<span id="mpgHighway-label" class="property-label"><g:message code="vehicle.mpgHighway.label" default="Mpg Highway" /></span>
					
						<span class="property-value" aria-labelledby="mpgHighway-label"><g:fieldValue bean="${vehicleInstance}" field="mpgHighway"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.mpgCity}">
				<li class="fieldcontain">
					<span id="mpgCity-label" class="property-label"><g:message code="vehicle.mpgCity.label" default="Mpg City" /></span>
					
						<span class="property-value" aria-labelledby="mpgCity-label"><g:fieldValue bean="${vehicleInstance}" field="mpgCity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.newPrice}">
				<li class="fieldcontain">
					<span id="newPrice-label" class="property-label"><g:message code="vehicle.newPrice.label" default="New Price" /></span>
					
						<span class="property-value" aria-labelledby="newPrice-label"><g:fieldValue bean="${vehicleInstance}" field="newPrice"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.usedPrice}">
				<li class="fieldcontain">
					<span id="usedPrice-label" class="property-label"><g:message code="vehicle.usedPrice.label" default="Used Price" /></span>
					
						<span class="property-value" aria-labelledby="usedPrice-label"><g:fieldValue bean="${vehicleInstance}" field="usedPrice"/></span>
					
				</li>
				</g:if>

				<g:if test="${vehicleInstance?.colourNames}">
				<li class="fieldcontain">
					<span id="colourNames-label" class="property-label"><g:message code="vehicle.colourNames.label" default="Colour Names" /></span>
					
						<span class="property-value" aria-labelledby="colourNames-label"><g:fieldValue bean="${vehicleInstance}" field="colourNames"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.colourCodes}">
				<li class="fieldcontain">
					<span id="colourCodes-label" class="property-label"><g:message code="vehicle.colourCodes.label" default="Colour Codes" /></span>
					
						<span class="property-value" aria-labelledby="colourCodes-label"><g:fieldValue bean="${vehicleInstance}" field="colourCodes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${vehicleInstance?.features}">
				<li class="fieldcontain">
					<span id="features-label" class="property-label"><g:message code="vehicle.features.label" default="Features" /></span>
					
						<span class="property-value" aria-labelledby="features-label"><g:fieldValue bean="${vehicleInstance}" field="features"/></span>
					
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
