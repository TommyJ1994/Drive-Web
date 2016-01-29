<%@ page import="drive.Driver" %>



<div class="fieldcontain ${hasErrors(bean: driverInstance, field: 'gender', 'error')} required">
	<label for="gender">
		<g:message code="driver.gender.label" default="Gender" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="gender" required="" value="${driverInstance?.gender}"/>

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

