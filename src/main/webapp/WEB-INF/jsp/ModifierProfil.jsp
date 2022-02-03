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
			Prenom :<input type="text" name="sprenom"  ><br>
			Telephone :<input type="text" name="stelephone"  ><br> 
			Code postal :<input type="text" name="scodePostal"><br>
			Mot de passe actuel :<input type="password" name="smotDePasseActuel"  placeholder="Mot de passe actuel" ><br> 
			Nouveau mot de passe :<input type="password" name="snouveauMotDePasse"  placeholder="Nouveau mot de passe" ><br>
		</div>
		<div >
			Nom :<input type="text" name="snom"   ><br>
			Email :<input type="text" name="semail"  ><br> 
			Rue :<input type="text" name="srue"  ><br>
			Ville :<input type="text" name="sville" ><br> 
			Confirmation :<input type="password" name="sconfirmation" placeholder="Confirmation du nouveau mot de passe" ><br>
			Credit : <p>  </p><br>
		</div>			
		</form>
	</div>	
<div align="center" >

	<form action="<%=request.getContextPath()%>/EnregistrerProfil"	method="post">		
		<button type="submit" >
			<p>Enregistrer</p>
		</button>
	</form>
	
	<form action="<%=request.getContextPath()%>/SuppressionProfil" method="post">
		<button type="submit">
			<p>Supprimer mon compte</p>
		</button>
	</form>
	
</div>
</body>
</html>


