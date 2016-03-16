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

<display:table pagesize="5" class="displaytag" keepStatus="true" name="morePopularGyms" requestURI="${requestURI}" id="morePopularGyms">
<spring:message code="administrator.morePopularGyms" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="lessPopularGyms" requestURI="${requestURI}" id="lessPopularGyms">
<spring:message code="administrator.lessPopularGyms" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="morePopularServices" requestURI="${requestURI}" id="morePopularServices">
<spring:message code="administrator.morePopularServices" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="lessPopularServices" requestURI="${requestURI}" id="lessPopularServices">
<spring:message code="administrator.lessPopularServices" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="moreFeesCustomer" requestURI="${requestURI}" id="moreFeesCustomer">
<spring:message code="administrator.moreFeesCustomer" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="lessFeesCustomer" requestURI="${requestURI}" id="lessFeesCustomer">
<spring:message code="administrator.lessFeesCustomer" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>



<display:table pagesize="5" class="displaytag" keepStatus="true" name="actorMoreMessages" requestURI="${requestURI}" id="actorMoreMessages">
<spring:message code="administrator.actorMoreMessages" var="name" />

<display:column property="name" title="${name}" sortable="true" />
</display:table>

<p><spring:message code="administrator.averageMessages"/> : <jstl:out value="${averageMessages}"/>



<display:table pagesize="5" class="displaytag" keepStatus="true" name="moreCommentedGyms" requestURI="${requestURI}" id="moreCommentedGyms">
<spring:message code="administrator.moreCommentedGyms" var="name" />
<display:column property="name" title="${name}" sortable="true" />
</display:table>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="moreCommentedServices" requestURI="${requestURI}" id="moreCommentedServices">
<spring:message code="administrator.moreCommentedServices" var="name" />
<display:column property="name" title="${name}" sortable="true" />
</display:table>

<p><spring:message code="administrator.averageCommentsActors"/> : <jstl:out value="${averageCommentsActors}"/>
<p><spring:message code="administrator.averageCommentsGym"/> : <jstl:out value="${averageCommentsGym}"/>
<p><spring:message code="administrator.averageCommentsService"/> : <jstl:out value="${averageCommentsService}"/>

<display:table pagesize="5" class="displaytag" keepStatus="true" name="customerMoreDeletedComments" requestURI="${requestURI}" id="customerMoreDeletedComments">
<spring:message code="administrator.customerMoreDeletedComments" var="name" />
<display:column property="name" title="${name}" sortable="true" />
</display:table>


