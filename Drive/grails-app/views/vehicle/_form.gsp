<%@ page import="drive.Vehicle" %>



<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'identifier', 'error')} required">
	<label for="identifier">
		<g:message code="vehicle.identifier.label" default="Identifier" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="identifier" required="" value="${vehicleInstance?.identifier}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'driver', 'error')} required">
	<label for="driver">
		<g:message code="vehicle.driver.label" default="Driver" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="driver" name="driver.id" from="${drive.Driver.list()}" optionKey="id" required="" value="${vehicleInstance?.driver?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'make', 'error')} required">
	<label for="make">
		<g:message code="vehicle.make.label" default="Make" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="make" required="" value="${vehicleInstance?.make}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'model', 'error')} required">
	<label for="model">
		<g:message code="vehicle.model.label" default="Model" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="model" required="" value="${vehicleInstance?.model}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'year', 'error')} required">
	<label for="year">
		<g:message code="vehicle.year.label" default="Year" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="year" type="number" value="${vehicleInstance.year}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'engineConfiguration', 'error')} ">
	<label for="engineConfiguration">
		<g:message code="vehicle.engineConfiguration.label" default="Engine Configuration" />
		
	</label>
	<g:textField name="engineConfiguration" value="${vehicleInstance?.engineConfiguration}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'engineDisplacement', 'error')} required">
	<label for="engineDisplacement">
		<g:message code="vehicle.engineDisplacement.label" default="Engine Displacement" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="engineDisplacement" type="number" value="${vehicleInstance.engineDisplacement}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'manufacturerEngineCode', 'error')} ">
	<label for="manufacturerEngineCode">
		<g:message code="vehicle.manufacturerEngineCode.label" default="Manufacturer Engine Code" />
		
	</label>
	<g:textField name="manufacturerEngineCode" value="${vehicleInstance?.manufacturerEngineCode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'totalEngineValves', 'error')} required">
	<label for="totalEngineValves">
		<g:message code="vehicle.totalEngineValves.label" default="Total Engine Valves" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="totalEngineValves" type="number" value="${vehicleInstance.totalEngineValves}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'cylinders', 'error')} required">
	<label for="cylinders">
		<g:message code="vehicle.cylinders.label" default="Cylinders" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="cylinders" type="number" value="${vehicleInstance.cylinders}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'compressionRatio', 'error')} ">
	<label for="compressionRatio">
		<g:message code="vehicle.compressionRatio.label" default="Compression Ratio" />
		
	</label>
	<g:field name="compressionRatio" value="${fieldValue(bean: vehicleInstance, field: 'compressionRatio')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'engineSize', 'error')} ">
	<label for="engineSize">
		<g:message code="vehicle.engineSize.label" default="Engine Size" />
		
	</label>
	<g:field name="engineSize" value="${fieldValue(bean: vehicleInstance, field: 'engineSize')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'horsepower', 'error')} ">
	<label for="horsepower">
		<g:message code="vehicle.horsepower.label" default="Horsepower" />
		
	</label>
	<g:field name="horsepower" value="${fieldValue(bean: vehicleInstance, field: 'horsepower')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'torque', 'error')} ">
	<label for="torque">
		<g:message code="vehicle.torque.label" default="Torque" />
		
	</label>
	<g:field name="torque" value="${fieldValue(bean: vehicleInstance, field: 'torque')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'fuelType', 'error')} ">
	<label for="fuelType">
		<g:message code="vehicle.fuelType.label" default="Fuel Type" />
		
	</label>
	<g:textField name="fuelType" value="${vehicleInstance?.fuelType}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'drivenWheels', 'error')} ">
	<label for="drivenWheels">
		<g:message code="vehicle.drivenWheels.label" default="Driven Wheels" />
		
	</label>
	<g:textField name="drivenWheels" value="${vehicleInstance?.drivenWheels}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'transmissionType', 'error')} ">
	<label for="transmissionType">
		<g:message code="vehicle.transmissionType.label" default="Transmission Type" />
		
	</label>
	<g:textField name="transmissionType" value="${vehicleInstance?.transmissionType}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehicleStyle', 'error')} ">
	<label for="vehicleStyle">
		<g:message code="vehicle.vehicleStyle.label" default="Vehicle Style" />
		
	</label>
	<g:textField name="vehicleStyle" value="${vehicleInstance?.vehicleStyle}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'numberOfSpeeds', 'error')} required">
	<label for="numberOfSpeeds">
		<g:message code="vehicle.numberOfSpeeds.label" default="Number Of Speeds" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numberOfSpeeds" type="number" value="${vehicleInstance.numberOfSpeeds}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'numOfDoors', 'error')} required">
	<label for="numOfDoors">
		<g:message code="vehicle.numOfDoors.label" default="Num Of Doors" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numOfDoors" type="number" value="${vehicleInstance.numOfDoors}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'mpgHighway', 'error')} required">
	<label for="mpgHighway">
		<g:message code="vehicle.mpgHighway.label" default="Mpg Highway" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="mpgHighway" type="number" value="${vehicleInstance.mpgHighway}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'mpgCity', 'error')} required">
	<label for="mpgCity">
		<g:message code="vehicle.mpgCity.label" default="Mpg City" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="mpgCity" type="number" value="${vehicleInstance.mpgCity}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'newPrice', 'error')} required">
	<label for="newPrice">
		<g:message code="vehicle.newPrice.label" default="New Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="newPrice" type="number" value="${vehicleInstance.newPrice}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'usedPrice', 'error')} required">
	<label for="usedPrice">
		<g:message code="vehicle.usedPrice.label" default="Used Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="usedPrice" type="number" value="${vehicleInstance.usedPrice}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'colourNames', 'error')} ">
	<label for="colourNames">
		<g:message code="vehicle.colourNames.label" default="Colour Names" />
		
	</label>
	<g:textField name="colourNames" value="${vehicleInstance?.colourNames}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'colourCodes', 'error')} ">
	<label for="colourCodes">
		<g:message code="vehicle.colourCodes.label" default="Colour Codes" />
		
	</label>
	<g:textField name="colourCodes" value="${vehicleInstance?.colourCodes}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'features', 'error')} ">
	<label for="features">
		<g:message code="vehicle.features.label" default="Features" />
		
	</label>
	<g:textField name="features" value="${vehicleInstance?.features}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'journeys', 'error')} ">
	<label for="journeys">
		<g:message code="vehicle.journeys.label" default="Journeys" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${vehicleInstance?.journeys?}" var="j">
    <li><g:link controller="journey" action="show" id="${j.id}">${j?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="journey" action="create" params="['vehicle.id': vehicleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'journey.label', default: 'Journey')])}</g:link>
</li>
</ul>


</div>

