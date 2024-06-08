<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@include file="inc/header.jsp" %>
<section>
	<h1 id="titre-principal">Ajout d'un utilisateur</h1>
	<form method="post" class="main">
		<div class="formItem">
			<label>Nom</label>
			<input type="text" name="nom" value="${utilisateur.nom }">
			<span class="erreur">${erreurs.nom}</span>
		</div>
			
		<div class="formItem">
			<label>Prenom</label>
			<input type="text" name="prenom" value="${utilisateur.prenom }">
			<span class="erreur">${erreurs.prenom}</span>
		</div>
			
		<div class="formItem">
			<label>Login</label>
			<input type="text" name="login" value="${utilisateur.login }">
			<span class="erreur">${erreurs.login}</span>
		</div>
		
		<div class="formItem">
			<label>Mot de passe</label>
			<input type="password" name="password" value="${utilisateur.password}">
			<span class="erreur">${erreurs.password}</span>
		</div>
			
		<div class="formItem">
			<label>Confirmation de passe</label>
			<input type="password" name="passwordBis" >
			<span class="erreur">${erreurs.passwordBis}</span>
		</div>
			
		<div class="formItem">
			<input type="submit" value="Ajouter">
		</div>
	</form>
</section>
<%@include file="inc/footer.jsp" %>
	