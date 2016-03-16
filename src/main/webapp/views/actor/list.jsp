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
<%--

 --%>


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="actor" requestURI="${requestURI}" id="row">
	<!-- Action links -->
		<!-- Attributes -->

	
		<spring:message code="actor.username" var="userName" />
		<display:column property="userAccount.username" title="${userName}" sortable="true" />

		<display:column >
			<a href="message/send.do?userId=${row.id}">
				<spring:message	code="actor.send" />
			</a>
		</display:column>
</display:table>
