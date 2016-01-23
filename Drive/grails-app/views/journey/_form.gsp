<%@ page import="drive.Journey" %>



<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'endTime', 'error')} required">
	<label for="endTime">
		<g:message code="journey.endTime.label" default="End Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="endTime" precision="day"  value="${journeyInstance?.endTime}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'heavyAccelerationCount', 'error')} required">
	<label for="heavyAccelerationCount">
		<g:message code="journey.heavyAccelerationCount.label" default="Heavy Acceleration Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="heavyAccelerationCount" type="number" value="${journeyInstance.heavyAccelerationCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'heavyBrakingCount', 'error')} required">
	<label for="heavyBrakingCount">
		<g:message code="journey.heavyBrakingCount.label" default="Heavy Braking Count" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="heavyBrakingCount" type="number" value="${journeyInstance.heavyBrakingCount}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'sensors', 'error')} ">
	<label for="sensors">
		<g:message code="journey.sensors.label" default="Sensors" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${journeyInstance?.sensors?}" var="s">
    <li><g:link controller="sensor" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="sensor" action="create" params="['journey.id': journeyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'sensor.label', default: 'Sensor')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'startTime', 'error')} required">
	<label for="startTime">
		<g:message code="journey.startTime.label" default="Start Time" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startTime" precision="day"  value="${journeyInstance?.startTime}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'vehicle', 'error')} required">
	<label for="vehicle">
		<g:message code="journey.vehicle.label" default="Vehicle" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="vehicle" name="vehicle.id" from="${drive.Vehicle.list()}" optionKey="id" required="" value="${journeyInstance?.vehicle?.id}" class="many-to-one"/>

</div>

