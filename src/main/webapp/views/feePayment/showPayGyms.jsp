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
	name="feePayment" requestURI="${requestURI}" id="row">
	
<!-- Attributes -->
	<a href="bookService/customer/create.do?feePayment=${row.id}">
	
	<spring:message code="feePayment.gym.name" var="nameHeader" />
	<display:column property="gym.name" title="${nameHeader}" sortable="true" />
	
	<spring:message code="feePayment.gym.description" var="descriptionHeader" />
	<display:column property="gym.description" title="${descriptionHeader}" sortable="true" />
	</a>
	
</display:table>


