<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div>
		<h1>ENI-Enchères</h1>
	</div>
	<div class="Titre">
		<h2>Mon Profil</h2>
	</div>

	<div class="Formulaire">
		<form action="<%=request.getContextPath()%>/CreerCompte" method="post">
			<div>
				<label for="name">Pseudo:</label> 
				<input type="text" id="name"name="pseudo" required>
			</div>
			<div>
				<label for="name">Nom:</label> 
				<input type="text" id="name"name="nom" required>
			</div>
			<div>
				<label for="name">Prenom:</label> 
				<input type="text" id="mail"name="prenom" required>
			</div>
			
		
			
			<div>
				<label for="mail">Email:</label> 
				<input type="email" id="name"name="email" required>
			</div>
			<div>
				<label for="msg">Telephone:</label>
				<input type="text" id="msg" name="telephone"  >
			</div>
			
			<div>
				<label for="name">Rue:</label> 
				<input type="text" id="name"name="rue" required>
			</div>
			<div>
				<label for="name">Ville:</label> 
				<input type="text" id="name"name="ville" required>
			</div>
			<div>
			
				<label for="name">Code postal:</label> 
				<input type="text" id="name"name="codePostal" required>
			</div>
			
			<div>
				<label for="name">Mot de passe:</label> 
				<input type="text" id="name"name="password" required>
			</div>
			<div>
				<label for="name">Confirmation:</label> 
				<input type="text" id="name"name="password_conf"required>
			</div>
			<div class="button">
				<a href="<%=request.getContextPath()%>/Login"><button type="submit" name="valider">Créer</button></a>
			</div>

		</form>
		<div class="button">
				<a href="<%=request.getContextPath()%>/AccueilNonConnecter"><button  name="annuler">Annuler</button></a>
			</div>

	</div>


	




</body>
</html>