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
	name="folders" requestURI="${requestURI}" id="row">
	<!-- Action links -->
		<!-- Attributes -->

	
		<spring:message code="folder.name" var="folderName" />
		<display:column property="name" title="${folderName}" sortable="false" />

		<display:column >
			<a href="folder/edit.do?folderId=${row.id}">
				<spring:message	code="folder.edit" />
			</a>
		</display:column>
			<display:column >
			<a href="folder/messages.do?folderId=${row.id}">
				<spring:message	code="folder.messages" />
			</a>
		</display:column>
	

</display:table>


	<div>
		<a href="folder/create.do"> <spring:message
				code="folder.create" />
		</a>
	</div>
