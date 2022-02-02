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
		<form action="<%=request.getContextPath()%>/mon-compte" method="post">
			<div class="col-lg-6">

			Pseudo :<input type="text" name="spseudo" class="form-control input-md"><br> 
			Prenom :<input type="text" name="sprenom"  class="form-control input-md"><br>
			Telephone :<input type="text" name="stelephone"  class="form-control input-md"><br> 
			Code postal :<input type="text" name="scodePostal" class="form-control input-md"><br>
			Mot de passe actuel :<input type="password" name="smotDePasseActuel"  placeholder="Mot de passe actuel" class="form-control input-md"><br> 
			Nouveau mot de passe :<input type="password" name="snouveauMotDePasse"  placeholder="Nouveau mot de passe" class="form-control input-md"><br>
		</div>
			<div class="col-lg-6">
			Nom :<input type="text" name="snom"   class="form-control input-md"><br>
			Email :<input type="text" name="semail"  class="form-control input-md"><br> 
			Rue :<input type="text" name="srue"  class="form-control input-md"><br>
			Ville :<input type="text" name="sville" class="form-control input-md"><br> 
			Confirmation :<input type="password" name="sconfirmation" placeholder="Confirmation du nouveau mot de passe" class="form-control input-md"><br>
			Credit : <p>  </p><br>
		</div>
			<div class="button">
				<button action=<%=request.getContextPath()%>/mon-profil" type="submit" name="valider">Modifier</button>
			</div>

		</form>
		

	</div>


	

<div class="row">

	<form action="<%=request.getContextPath()%>/GestionModificationProfil"
		method="post">
		
		
			
				
		<div class = "row">
		<div class ="col-md-12">
		
		</div>
	</div>	
		<button type="submit" class=" col-lg-6 btn btn-default">
			<p>Enregistrer</p>
		</button>
	</form>
	
	
	
	<form action="<%=request.getContextPath()%>/SuppressionUtilisateur" method="post">
		<button type="submit" class=" col-lg-6 btn btn-default">
			<p>Supprimer mon compte</p>
		</button>
	</form>
	
</div>
</body>
</html>



</body>
</html>