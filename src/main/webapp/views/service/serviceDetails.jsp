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
<%@ taglib prefix="acme" tagdir="/WEB-INF/tags" %>


<form:form action="service/serviceDetails.do" modelAttribute="service">
<jstl:if test="${service.id != 0}">
	<form:hidden path="id" />
	<form:hidden path="version" />
</jstl:if>

<acme:textbox code="service.name" path="name" readonly="true"/>
<acme:textbox code="service.url" path="url" readonly="true"/>
<acme:textbox code="service.name" path="description" readonly="true"/>





	


</form:form>

	<br />
	<br />
	<p><spring:message code="comments"/></p>
	<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="comments" requestURI="${requestURI}" id="row">	
	
	<spring:message code="comment.text" var="textHeader" />
	<display:column property="text" title="${textHeader}" sortable="false"  />
	
	<spring:message code="comment.rating" var="ratingHeader" />
	<display:column property="starRating" title="${ratingHeader}" sortable="false"  />
	
<br />
	<br />
</display:table>

	<p><spring:message code="gyms"/></p>
	<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="gyms" requestURI="${requestURI}" id="row">	
	
	<spring:message code="gym.name" var="nameHeader" />
	<display:column title="${nameHeader}" sortable="true"  >
	<a href="gym/show.do?gymId=${row.id }">${row.name}</a>
	</display:column>
	
	<spring:message code="gym.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" sortable="false"  />
	

</display:table>