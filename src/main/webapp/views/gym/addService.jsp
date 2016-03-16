
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="jstl"	uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>


<display:table pagesize="5" class="displaytag" keepStatus="true"
	name="services" requestURI="${requestURI}" id="row">

	<spring:message code="service.name" var="nameHeader" />
	<display:column property="name" title="${nameHeader}" sortable="true" />
	
	<spring:message code="service.description" var="descriptionHeader" />
	<display:column property="description" title="${descriptionHeader}" sortable="true" />
	
	<display:column>
	<a href="gym/administrator/addService.do?serviceId=${row.id}&gymId=${gymId}"><spring:message code="gym.addService"/></a>
	</display:column>

</display:table>



<a href="gym/show.do?gymId=${gym.id}">
	<input type="button" name="cancel"
		value="<spring:message code="gym.cancel" />"
		onclick="javascript: relativeRedir('gym/show.do?gymId=${gym.id}');" /></a>
		
	<br />



	