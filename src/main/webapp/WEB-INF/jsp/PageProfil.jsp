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
			
	</div>


	




</body>
</html>