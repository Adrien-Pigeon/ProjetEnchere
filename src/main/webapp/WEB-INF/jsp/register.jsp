<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="">


<title>Création Compte</title>
</head>
<body>
	<div>
		<h1>ENI-Enchères</h1>
	</div>
	<div class="Titre" align="center">
		<h2>Création Profil</h2>
	</div>

	<div  align="center" >
		<form class="forms-inputs" action="<%=request.getContextPath()%>/CreerCompte" method="post">
			<div>
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle mt-5" width="150px" src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
                    <span class="font-weight-bold">Edogaru</span>
                    <span class="text-black-50">edogaru@mail.com.my</span>
                   
                </div>
            <div>
				<label for="name" >Pseudo:</label> 
				<input type="text" id="name" name="pseudo" required>
			</div>
			<div>
				<label for="name">Nom:</label> 
				<input type="text" id="name" name="nom" required>
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
		
        </div>
        
			
	
            <div class="button" >
				<a href="<%=request.getContextPath()%>/Login"><button type="submit" name="valider">Créer</button></a>
			</div>
		</form>
		    <div class="button">
				<a href="<%=request.getContextPath()%>/AccueilNonConnecter"><button  name="annuler">Annuler</button></a>
			</div>
        </div>
	

</body>
<link rel="stylesheet" href="register.css">
<link rel="stylesheet" href=" https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js">

</html>