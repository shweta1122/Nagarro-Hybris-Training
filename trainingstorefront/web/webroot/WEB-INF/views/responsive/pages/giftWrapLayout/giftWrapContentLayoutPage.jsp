<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>

<template:page pageTitle="${pageTitle}">
	<div id="globalMessages">
		<common:globalMessages/>
	</div>



		<cms:pageSlot position="premiumTypeSlotName" var="feature" element="div" >

		<cms:component component="${feature}" />
	</cms:pageSlot>


	<cms:pageSlot position="standardTypeSlotName" var="feature" element="div" >

    		<cms:component component="${feature}" />
    	</cms:pageSlot>

</template:page>