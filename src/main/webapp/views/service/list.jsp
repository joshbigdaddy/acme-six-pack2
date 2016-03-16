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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="services" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->

	
	<!-- Attributes -->
	
	<display:column>
			<a href="service/serviceDetails.do?serviceId=${row.id}">
				<spring:message	code="service.details" />
			</a>
		</display:column>
		
	<spring:message code="service.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="false"  />
	<spring:message code="service.bookins" var="bookinsHeader" />
	<display:column title="${bookinsHeader}" sortable="false"  > <jstl:out value="${fn:length(row.bookServices)}"/></display:column>
	<display:column>
			<a href="service/showGyms.do?serviceId=${row.id}">
				<spring:message	code="service.gyms" />
			</a>
		</display:column>
		
<security:authorize access="isAuthenticated()">
<display:column>
			<a href="comment/create.do?objectId=${row.id}">
				<spring:message	code="comment" />
			</a>
		</display:column>
</security:authorize>
</display:table>

<!-- Action links -->


