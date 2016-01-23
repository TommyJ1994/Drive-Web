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

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'manufacturer', 'error')} required">
	<label for="manufacturer">
		<g:message code="vehicle.manufacturer.label" default="Manufacturer" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="manufacturer" required="" value="${vehicleInstance?.manufacturer}"/>

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

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'engineSize', 'error')} required">
	<label for="engineSize">
		<g:message code="vehicle.engineSize.label" default="Engine Size" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="engineSize" value="${fieldValue(bean: vehicleInstance, field: 'engineSize')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'fuelType', 'error')} required">
	<label for="fuelType">
		<g:message code="vehicle.fuelType.label" default="Fuel Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fuelType" required="" value="${vehicleInstance?.fuelType}"/>

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

