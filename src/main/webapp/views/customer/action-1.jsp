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


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="gyms" requestURI="${requestURI}" id="row">
	
<!-- Attributes -->
	<spring:message code="gym.pictures" var="pictureHeader" />
	<display:column property="picture" title="${pictureHeader}" sortable="true" />
	
	<a href="gym/mostrar.do?gymId=${row.id}">
	<spring:message code="gym.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="true" />
	</a>
	<spring:message code="gym.postalAddress" var="postalAddressHeader" />
	<display:column property="postalAddress" title="${postalAddressHeader}" sortable="true" />
	
	<spring:message code="gym.fee" var="feeHeader" />
	<display:column property="fee" title="${feeHeader}" sortable="true" />
	
	<spring:message code="gym.totalCustomers" var="totalCustomersHeader" />
	<display:column property="totalCustomers" title="${totalCustomersHeader}" sortable="true" />
	
	

</display:table>


