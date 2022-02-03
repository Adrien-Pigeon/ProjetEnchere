<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.eni.projetEnchere.bo.Utilisateur"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="Style.css">
<title>A WEB PAGE</title>
</head>
<body>
	<%-- <div>
		<h1>ENI-Enchères</h1>
	</div>
	<div class="Titre" align="center">
		<h2>Mon Profil</h2>
	</div>
	

	<div class="Formulaire" align="center">
	<form action="<%=request.getContextPath()%>/PageProfil" method="post">
		
		<div >
			Pseudo :<input type="text" name="pseudo" ><br> 
			Prenom :<input type="text" name="prenom"  ><br>
			Telephone :<input type="text" name="telephone"  ><br> 
			Code postal :<input type="text" name="codePostal"><br>
			
		</div>
		<div >
			Nom :<input type="text" name="nom"   ><br>
			Email :<input type="text" name="email"  ><br> 
			Rue :<input type="text" name="rue"  ><br>
			Ville :<input type="text" name="ville" ><br>			
		</div>
			
	</div> --%>
	<form action="<%=request.getContextPath()%>/PageProfil" method="post">
	<div class="row">
<h3 class="formulaire text-center">Profil Utilisateur</h3>
<br><br>
	<div class="col-lg-offset-3 col-lg-6 col-xs-12 blocProfil">
			<div class="col-lg-6 col-xs-6">

				<p><strong>Pseudo : </strong></p>
				<p><strong>Nom : </strong></p>
				<p><strong>Prénom : </strong></p>
				<p><strong>Email : </strong></p>
				<p><strong>Téléphone : </strong></p>
				<p><strong>Rue : </strong></p>
				<p><strong>Code postal :</strong></p>
				<p><strong>Ville :</strong></p>
			</div>
			<div class="col-lg-6 col-xs-6 text-center">
				<% 
					
					Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
				%> 
				<p><strong><%=utilisateur.getPseudo()%></strong></p>
				<p><%=utilisateur.getNom()%></p>
				<p><%=utilisateur.getPrenom()%></p>
				<p><%=utilisateur.getEmail()%></p>
				<p><%=utilisateur.getTelephone()%></p>
				<p><%=utilisateur.getRue()%></p>
				<p><%=utilisateur.getCodePostal()%></p>
				<p><%=utilisateur.getVille()%></p>
			</div>
			
			<%
				boolean btnOn = (boolean) request.getAttribute("btnOn");
				if (btnOn == true) {
			%>
			<form action="<%=request.getContextPath()%>/GestionModificationProfil" method="get" >
			<input type="submit" class="bouton btn btn-default" value="Modifier" name="Modifier"> 
			</form>
			<%
				}
			%>
	</div>
</div>
</form>


	




</body>
</html>