<%@ page import="drive.Sensor" %>



<div class="fieldcontain ${hasErrors(bean: sensorInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="sensor.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${sensorInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sensorInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="sensor.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="description" required="" value="${sensorInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sensorInstance, field: 'journey', 'error')} required">
	<label for="journey">
		<g:message code="sensor.journey.label" default="Journey" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="journey" name="journey.id" from="${drive.Journey.list()}" optionKey="id" required="" value="${sensorInstance?.journey?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: sensorInstance, field: 'points', 'error')} ">
	<label for="points">
		<g:message code="sensor.points.label" default="Points" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${sensorInstance?.points?}" var="p">
    <li><g:link controller="point" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="point" action="create" params="['sensor.id': sensorInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'point.label', default: 'Point')])}</g:link>
</li>
</ul>


</div>

