<%@ page language="java" contentType="text/html; charset=UTF8" pageEncoding="UTF8"%>
<%@include file="inc/header.jsp" %>
<section>
	<%
	if(request.getAttribute("status") != null)
	{%>
		<div class="alert alert-${status ? 'success' : 'danger' }">
		${ statusMessage }
	</div><%
	}
	%>

	<h1 id="titre-principal">Authentification</h1>
	<form method="post" class="main">
			
		<div class="formItem">
			<label>Login</label>
			<input type="text" name="login" value="${login }">
		</div>
		
		<div class="formItem">
			<label>Mot de passe</label>
			<input type="password" name="password">		
		</div>
			
		<div class="formItem">
			<input type="submit" value="Connexion">
		</div>
	</form>
</section>
<%@include file="inc/footer.jsp" %>
	