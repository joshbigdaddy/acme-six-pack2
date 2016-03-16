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
	name="messages" requestURI="${requestURI}" id="row">
	<!-- Action links -->
		<!-- Attributes -->

	
		<spring:message code="message.subject" var="subject" />
		<display:column property="subject" title="${subject}" sortable="false" />
		<spring:message code="message.date" var="date" />
		<display:column property="sendMoment" title="${date}" sortable="true" />

		<display:column >
			<a href="folder/message.do?messageId=${row.id}">
				<spring:message	code="folder.message" />
			</a>
		</display:column>
	

</display:table>
