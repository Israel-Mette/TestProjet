<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@include file="inc/header.jsp" %>
	<section>
		<h1 id="titre-principal">Modification d'un utilisateur</h1>
		<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");  %>
		<form method="post" class="main">
		<div class="formItem">
			<label>Nom</label><br>
		<input type="text" name="nom" value=<%= utilisateur.getNom() %>><br>
		</div>
		
		<div class="formItem">
			<label>Prenom</label><br>
		<input type="text" name="prenom" value=<%= utilisateur.getPrenom() %>><br>
		</div>
		
		<div class="formItem">
			<label>Login</label><br>
		<input type="text" name="login" value=<%= utilisateur.getLogin() %>><br>
		</div>
		
		<div class="formItem">
			<label>Mot de passe</label><br>
		<input type="password" name="password" value=<%= utilisateur.getPassword() %>><br>
		</div>
		
		<div class="formItem">
			<input type="submit" value="Modifier"><br>
		</div>
		
	</form>
	</section>
	<%@include file="inc/footer.jsp" %>