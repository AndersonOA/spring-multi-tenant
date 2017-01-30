<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html lang="pt-br" itemscope itemtype="http://schema.org/WebSite">
	<head>
    	<meta charset="UTF-8">
    	<meta name="viewport" content="width=device-width,initial-scale=1">
			
		<title><decorator:title /></title>
		<meta name="robots" content="index, follow"/>
		<meta name="multi-tenancy_version" content="<spring:message code="multi-tenancy.api.version" />" />
		
		<link rel="shortcut icon" href="../_cdn/_img/favicon.png"/>
		<link href='https://fonts.googleapis.com/css?family=Open Sans:300,400,600,700,800' rel='stylesheet' type='text/css'>
    	<style>*, *:after, *:before{font-family: 'Open Sans', sans-serif;}</style>
        
    	<link rel="stylesheet" href="../_cdn/_css/reset.css"/>
    	<link rel="stylesheet" href="../_cdn/_css/multi-tenancy-control.css"/>
        
    	<!--[if lt IE 9]>
        	<script src="../_cdn/_js/html5shiv.js"></script>
    	<![endif]-->
        
    	<script src="../_cdn/_js/jquery.js"></script>
    	<script src="../_cdn/_js/jmask.js"></script>
    	<script src="../_cdn/_js/multi-tenancy-plugins.js"></script>
		<script src="../_cdn/_js/multi-tenancy-control.js"></script>
			
	</head>
	<body>
		<decorator:body />
	</body>
</html>