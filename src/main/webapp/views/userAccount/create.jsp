<%--
 * action-1.jsp
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>

<%@ taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<form:form action="userAccount/actor/create.do"
	modelAttribute="customer">
	<form:hidden path="userAccount.authorities" />
	<form:hidden path="version" />
	<form:hidden path="id" />
	<form:hidden path="comments" />
	<form:hidden path="feePayments" />
	<form:hidden path="bookService" />
	<form:hidden path="creditCard" />
	<form:hidden path="socialIdentity" />
	<form:hidden path="folders" />

	<acme:textbox code="userAccount.userName" path="userAccount.username" />

	<acme:password code="userAccount.password" path="userAccount.password" />

	<acme:textbox code="userAccount.name" path="name" />

	<acme:textbox code="userAccount.surname" path="surname" />

	<acme:textbox code="userAccount.phone" path="contactPhone" />

	<acme:submit name="save" code="userAccount.create" />

	<acme:cancel url="javascript: relativeRedir('Acme-Supermarket');"
		code="userAccount.cancel" />

</form:form>

<p>
	<spring:message code="terminos.condiciones" />
	<a href="Acme-Six-Pack/terms_and_conditions.do" target="_blank"><spring:message
			code="terminos.condiciones.enlace" /></A>
</p>

