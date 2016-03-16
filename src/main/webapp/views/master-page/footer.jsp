<%--
 * footer.jsp
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 --%>
 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="date" class="java.util.Date" />

<hr />

<b>Copyright &copy; <fmt:formatDate value="${date}" pattern="yyyy" /> Acme-Six-Pack Co., Inc.</b>
	<spring:message code="terminos.condiciones" />
	<a href="legal/terms.do" target="_blank"><spring:message
			code="terminos.condiciones.enlace" /></a>