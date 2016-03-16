<%--
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="feePayments" requestURI="${requestURI}" id="row">
	
<!-- Attributes -->
<security:authorize access="hasRole('ADMIN')">
	<spring:message code="feePayment.customer" var="customerHeader"/>
	<display:column property="customer.name" title="${customerHeader}" sortable="true"/>
	
</security:authorize>
	<spring:message code="feePayment.paymentMoment" var="paymentHeader"/>
	<display:column property="paymentMoment" title="${paymentHeader}" sortable="true"/>
	
	<spring:message code="feePayment.gym" var="gymHeader" />
	<display:column property="gym" title="${gymHeader}" sortable="true" />
	
	<spring:message code="feePayment.activeDay" var="activeHeader" />
	<display:column property="activeDay" title="${activeHeader}" sortable="true" />

	<spring:message code="feePayment.inactiveDay" var="inactiveHeader" />
	<display:column property="inactiveDay" title="${inactiveHeader}" sortable="true" />
	
	<security:authorize access="hasRole('ADMIN')">
<display:column>
	<a href="feePayment/administrator/edit.do?feePaymentId=${row.id}"><spring:message code="feePayment.edit"/></a>
	</display:column>
	
</security:authorize>

</display:table>


