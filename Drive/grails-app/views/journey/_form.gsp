engineData << [0, speedPoint, 0, 0, rpmPoint, 0, 0]<%@ page import="drive.Journey" %>



<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageAmbientAirTemperature', 'error')} ">
	<label for="averageAmbientAirTemperature">
		<g:message code="journey.averageAmbientAirTemperature.label" default="Average Ambient Air Temperature" />
		
	</label>
	<g:field type="number" name="averageAmbientAirTemperature" value="${journeyInstance.averageAmbientAirTemperature}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageEngineLoad', 'error')} ">
	<label for="averageEngineLoad">
		<g:message code="journey.averageEngineLoad.label" default="Average Engine Load" />
		
	</label>
	<g:field type="number" name="averageEngineLoad" value="${journeyInstance.averageEngineLoad}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageGForce', 'error')} ">
	<label for="averageGForce">
		<g:message code="journey.averageGForce.label" default="Average GF orce" />
		
	</label>
	<g:field type="number" name="averageGForce" value="${journeyInstance.averageGForce}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageMPG', 'error')} ">
	<label for="averageMPG">
		<g:message code="journey.averageMPG.label" default="Average MPG" />
		
	</label>
	<g:field type="number" name="averageMPG" value="${journeyInstance.averageMPG}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averagePercentageCoasting', 'error')} ">
	<label for="averagePercentageCoasting">
		<g:message code="journey.averagePercentageCoasting.label" default="Average Percentage Coasting" />
		
	</label>
	<g:field type="number" name="averagePercentageCoasting" value="${journeyInstance.averagePercentageCoasting}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averagePercentageHighRPM', 'error')} ">
	<label for="averagePercentageHighRPM">
		<g:message code="journey.averagePercentageHighRPM.label" default="Average Percentage High RPM" />
		
	</label>
	<g:field type="number" name="averagePercentageHighRPM" value="${journeyInstance.averagePercentageHighRPM}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averagePercentageIdle', 'error')} ">
	<label for="averagePercentageIdle">
		<g:message code="journey.averagePercentageIdle.label" default="Average Percentage Idle" />
		
	</label>
	<g:field type="number" name="averagePercentageIdle" value="${journeyInstance.averagePercentageIdle}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageRPM', 'error')} ">
	<label for="averageRPM">
		<g:message code="journey.averageRPM.label" default="Average RPM" />
		
	</label>
	<g:field type="number" name="averageRPM" value="${journeyInstance.averageRPM}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageSpeed', 'error')} ">
	<label for="averageSpeed">
		<g:message code="journey.averageSpeed.label" default="Average Speed" />
		
	</label>
	<g:field type="number" name="averageSpeed" value="${journeyInstance.averageSpeed}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'averageThrottlePosition', 'error')} ">
	<label for="averageThrottlePosition">
		<g:message code="journey.averageThrottlePosition.label" default="Average Throttle Position" />
		
	</label>
	<g:field type="number" name="averageThrottlePosition" value="${journeyInstance.averageThrottlePosition}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'endTime', 'error')} ">
	<label for="endTime">
		<g:message code="journey.endTime.label" default="End Time" />
		
	</label>
	<g:datePicker name="endTime" precision="day" value="${journeyInstance?.endTime}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'heavyAccelerationCount', 'error')} ">
	<label for="heavyAccelerationCount">
		<g:message code="journey.heavyAccelerationCount.label" default="Heavy Acceleration Count" />
		
	</label>
	<g:field type="number" name="heavyAccelerationCount" value="${journeyInstance.heavyAccelerationCount}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'heavyBrakingCount', 'error')} ">
	<label for="heavyBrakingCount">
		<g:message code="journey.heavyBrakingCount.label" default="Heavy Braking Count" />
		
	</label>
	<g:field type="number" name="heavyBrakingCount" value="${journeyInstance.heavyBrakingCount}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'journeyTimeLength', 'error')} ">
	<label for="journeyTimeLength">
		<g:message code="journey.journeyTimeLength.label" default="Journey Time Length" />
		
	</label>
	<g:field type="number" name="journeyTimeLength" value="${journeyInstance.journeyTimeLength}" />

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

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'startTime', 'error')} ">
	<label for="startTime">
		<g:message code="journey.startTime.label" default="Start Time" />
		
	</label>
	<g:datePicker name="startTime" precision="day" value="${journeyInstance?.startTime}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'topAccelerationGforce', 'error')} ">
	<label for="topAccelerationGforce">
		<g:message code="journey.topAccelerationGforce.label" default="Top Acceleration Gforce" />
		
	</label>
	<g:field type="number" name="topAccelerationGforce" value="${journeyInstance.topAccelerationGforce}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'topDecelerationGforce', 'error')} ">
	<label for="topDecelerationGforce">
		<g:message code="journey.topDecelerationGforce.label" default="Top Deceleration Gforce" />
		
	</label>
	<g:field type="number" name="topDecelerationGforce" value="${journeyInstance.topDecelerationGforce}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'topRPM', 'error')} ">
	<label for="topRPM">
		<g:message code="journey.topRPM.label" default="Top RPM" />
		
	</label>
	<g:field type="number" name="topRPM" value="${journeyInstance.topRPM}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'topSpeed', 'error')} ">
	<label for="topSpeed">
		<g:message code="journey.topSpeed.label" default="Top Speed" />
		
	</label>
	<g:field type="number" name="topSpeed" value="${journeyInstance.topSpeed}" />

</div>

<div class="fieldcontain ${hasErrors(bean: journeyInstance, field: 'vehicle', 'error')} ">
	<label for="vehicle">
		<g:message code="journey.vehicle.label" default="Vehicle" />
		
	</label>
	<g:select id="vehicle" name="vehicle.id" from="${drive.Vehicle.list()}" optionKey="id" required="" value="${journeyInstance?.vehicle?.id}" class="many-to-one"/>

</div>

