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
<form:form action="comment/create.do?objectId=${objectId }" modelAttribute="comment">
	
	
	<form:hidden path="actor"/>
	<form:hidden path="moment"/>

	<acme:textbox code="comment.text" path="text"/>
	<acme:textbox code="comment.starRating" path="starRating"/>
	
	<a href="javascript:history.back(1)">
	<acme:submit name="save" code="comment.create"/>
	</a>

	<input type="button" name="cancel"
		value="<spring:message code="comment.cancel" />"
		onclick="javascript:history.back(1)" />
		
	
</form:form>
	
	