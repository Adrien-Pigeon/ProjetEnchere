<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>A WEB PAGE</title>
</head>
<body>
	
	<form action="<%=request.getContextPath()%>/PageProfil" method="post">
		<div class="row">
			<h3 class="formulaire text-center">Profil Utilisateur</h3>
			<br>
			<br>
			<div class="col-lg-offset-3 col-lg-6 col-xs-12 blocProfil">
				<div class="col-lg-6 col-xs-6 text-center">

					<p>
						<strong>Pseudo : </strong>
					</p>
					<p>
						<strong>Nom : </strong>
					</p>
					<p>
						<strong>Prénom : </strong>
					</p>
					<p>
						<strong>Email : </strong>
					</p>
					<p>
						<strong>Téléphone : </strong>
					</p>
					<p>
						<strong>Rue : </strong>
					</p>
					<p>
						<strong>Code postal :</strong>
					</p>
					<p>
						<strong>Ville :</strong>
					</p>
				
					<%
					Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
					%>
					<p>
						<strong>${utilisateur.pseudo }</strong>
					</p>
					<p>${utilisateur.nom }</p>
					<p>${utilisateur.prenom }</p>
					<p>${utilisateur.email }</p>
					<p>${utilisateur.telephone }</p>
					<p>${utilisateur.rue }</p>
					<p>${utilisateur.codePostal }</p>
					<p>${utilisateur.ville }</p>
				</div>
			</div>
		</div>

	</form>
	<div>
		<%
		boolean btnOn = (boolean) request.getAttribute("btnOn");
		if (btnOn == true) {
		%>
		<form action="<%=request.getContextPath()%>/ModifierProfil"
			method="get">
			<input type="submit" class="bouton btn btn-default" value="Modifier"
				name="Modifier">

		</form>
		<%
		}
		%>
	</div>









</body>
</html>