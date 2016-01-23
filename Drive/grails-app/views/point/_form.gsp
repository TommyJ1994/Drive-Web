<%@ page import="drive.Point" %>



<div class="fieldcontain ${hasErrors(bean: pointInstance, field: 'sensor', 'error')} required">
	<label for="sensor">
		<g:message code="point.sensor.label" default="Sensor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sensor" name="sensor.id" from="${drive.Sensor.list()}" optionKey="id" required="" value="${pointInstance?.sensor?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: pointInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="point.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="value" required="" value="${pointInstance?.value}"/>

</div>

