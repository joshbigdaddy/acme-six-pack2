<%--
 * action-1.jsp
 *
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
<%@taglib prefix="acme" tagdir="/WEB-INF/tags" %>
<form:form action="creditcard/customer/create.do" modelAttribute="creditcard">
	<jstl:if test="${creditCard.id != 0}">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<form:hidden path="brandName"/>
	<form:hidden path="holderName"/>
	<form:hidden path="number"/>
	<form:hidden path="expirationYear"/>
	<form:hidden path="expirationMonth"/>
	<form:hidden path="cvvCode"/>
	<h1><spring:message code="creditCard.alreadyHave" /></h1>
	</jstl:if>
	<jstl:if test="${creditCard.id == 0}">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	<acme:textbox code="creditcard.brandName" path="brandName"/>
	<acme:textbox code="creditcard.holderName" path="holderName"/>
	<acme:textbox code="creditcard.number" path="number"/>
	<acme:textbox code="creditcard.expirationYear" path="expirationYear"/>
	<acme:textbox code="creditcard.expirationMonth" path="expirationMonth"/>
	<acme:textbox code="creditcard.cvvCode" path="cvvCode"/>
	
	<acme:submit name="create" code="creditCard.create"/>
	</jstl:if>
	<a href=""><acme:cancel url="" code="creditCard.cancel"/></a>
</form:form>
	
	