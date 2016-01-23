<%@ page import="drive.Driver" %>



<div class="fieldcontain ${hasErrors(bean: driverInstance, field: 'age', 'error')} required">
	<label for="age">
		<g:message code="driver.age.label" default="Age" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="age" type="number" value="${driverInstance.age}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: driverInstance, field: 'dateOfBirth', 'error')} required">
	<label for="dateOfBirth">
		<g:message code="driver.dateOfBirth.label" default="Date Of Birth" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateOfBirth" precision="day"  value="${driverInstance?.dateOfBirth}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: driverInstance, field: 'country', 'error')} required">
	<label for="country">
		<g:message code="driver.country.label" default="Country" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="country" required="" value="${driverInstance?.country}"/>

</div>

