
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<form:form action="feePayment/administrator/edit.do" modelAttribute="feePayment">

	<form:hidden path="id" />
	<form:hidden path="version" />	
	<form:hidden path="paymentMoment" />
	<form:hidden path="activeDay" />
	
	<form:label path="inactiveDay">
		<spring:message code="feePayment.inactiveDay" />:
	</form:label>
	<form:input path="inactiveDay" />
	<form:errors cssClass="error" path="inactiveDay" />
	<br />
	
	<form:hidden path="customer" />
	<form:hidden path="gym" />
	<form:hidden path="creditCard" />
	
	

	
	<input type="submit" name="save"
		value="<spring:message code="feePayment.save" />" />&nbsp; 
		
		
<a href="feePayment/administrator/list.do">
	<input type="button" name="cancel"
		value="<spring:message code="feePayment.cancel" />"
		onclick="javascript: relativeRedir('feePayment/administrator/list.do');" /></a>
		
	<br />


</form:form>
	
	