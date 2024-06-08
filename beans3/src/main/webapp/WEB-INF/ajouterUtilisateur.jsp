<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@include file="inc/header.jsp" %>
<section>
	<h1 id="titre-principal">Ajout d'un utilisateur</h1>
	<form method="post" class="main">
		<div class="formItem">
			<label>Nom</label>
			<input type="text" name="nom">
		</div>
			
		<div class="formItem">
			<label>Prenom</label>
			<input type="text" name="prenom">
		</div>
			
		<div class="formItem">
			<label>Login</label>
			<input type="text" name="login">
		</div>
			
		<div class="formItem">
			<label>Mot de passe</label>
			<input type="password" name="password">
		</div>
			
		<div class="formItem">
			<input type="submit" value="Ajouter">
		</div>
	</form>
</section>
<%@include file="inc/footer.jsp" %>
	