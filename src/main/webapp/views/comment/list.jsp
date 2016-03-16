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

<!-- Listing grid -->

<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="comments" requestURI="${requestURI}" id="row">
	
	<!-- Action links -->
	
	<!-- Attributes -->
	
	<spring:message code="comment.text" var="textHeader" />
	<display:column property="text" title="${textHeader}" sortable="false"  />
	
	<spring:message code="comment.starRating" var="starRatingHeader" />
	<display:column property="starRating" title="${starRatingHeader}" sortable="false"  />
	
	<security:authorize access="hasRole('ADMIN')">
	
	<spring:message code="comment.delete" var="deleteHeader" />
	<display:column title="${deleteHeader}">
	<jstl:if test="${row.deleted == false}">
	<a href=comment/administrator/delete.do?commentId=${row.id}>
		<input type="button" name="delete"
		value="<spring:message code="comment.delete" />"
		onclick="return confirm('<spring:message code="comment.delete.confirm" />')" />
	</a>
	</jstl:if>
	<jstl:if test="${row.deleted == true}">
	<spring:message code="comment.deleted" />
	</jstl:if>
	</display:column>
	</security:authorize>

	
</display:table>

<!-- Action links -->
