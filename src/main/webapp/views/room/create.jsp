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
<form:form action="room/administrator/create.do" modelAttribute="room">
	<jstl:if test="${creditCard.id != 0}">
	<form:hidden path="id"/>
	<form:hidden path="version"/>
	</jstl:if>
	
	<acme:textbox code="room.name" path="name"/>
	<acme:textbox code="room.description" path="description"/>
	<acme:textbox code="room.pictures" path="pictures"/>
	<acme:textbox code="room.seats" path="seats"/>
	<form:hidden path="activity"/>
	
	
	<acme:submit name="save" code="room.create"/>
	<jstl:if test="${creditCard.id != 0}">
	<acme:submit name="delete" code="room.delete"/>
	</jstl:if>
	<a href=""><acme:cancel url="" code="room.cancel"/></a>
	
</form:form>
	
	