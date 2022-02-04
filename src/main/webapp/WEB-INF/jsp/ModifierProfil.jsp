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
	<div class="Titre" align="center">
		<h2>Mon Profil</h2>
	</div>
 
	<div class="Formulaire" align="center">
		<form action="<%=request.getContextPath()%>/ModifierProfil" method="post">
		<div >

			Pseudo :<br> 
			Prenom :<input type="text" name="prenom"  ><br>
			Telephone :<input type="text" name="telephone"  ><br> 
			Code postal :<input type="text" name="codePostal"><br>
			Mot de passe actuel :<input type="password" name="motDePasseActuel"  placeholder="Mot de passe actuel" ><br> 
			Nouveau mot de passe :<input type="password" name="nouveauMotDePasse"  placeholder="Nouveau mot de passe" ><br>
		</div>
		<div >
			Nom :<input type="text" name="nom"   ><br>
			Email :<input type="text" name="email"  ><br> 
			Rue :<input type="text" name="rue"  ><br>
			Ville :<input type="text" name="ville" ><br> 
			Confirmation :<input type="password" name="confirmation" placeholder="Confirmation du nouveau mot de passe" ><br>
			Credit : <p>${utilisateurCo.credit }  </p><br>
		</div>			
		<div align="center" >

			
		<button type="submit" >
			<p>Enregistrer</p>
		</button>
		</div>	
		
	</form>
	
	
	<form action="<%=request.getContextPath()%>/SupprimerProfil" method="post">
		<button type="submit">
			<p>Supprimer mon compte</p>
		</button>
	</form>
	
</div>
</body>
</html>


