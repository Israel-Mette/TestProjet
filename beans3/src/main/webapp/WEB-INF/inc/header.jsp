<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<% final String APP_ROOT = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf8">
	<title>Accueil</title>
	<link rel="stylesheet" type="text/css" href="<%=APP_ROOT  %>/css/design.css">
</head>
<body>
	<header>Liste des utilisateurs</header>
	<nav>
		<ul>
			<li><a href="<%=APP_ROOT  %>">Accueil</a></li>
			<li><a href="<%=APP_ROOT  %>/list">Lister</a></li>
			<li><a href="<%=APP_ROOT  %>/add">Ajouter</a></li>
		</ul>
	</nav>