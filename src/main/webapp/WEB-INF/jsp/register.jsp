<!DOCTYPE html>
<html>
<head>
<title>Enregistrement</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
	integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
	crossorigin="anonymous">
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" href="css/register.css">
</head>
<body>
	<div class="main-block">
		<div class="left-part">
			<i class="fas fa-graduation-cap"></i>
			<h1>Register</h1>
		</div>
		<br>
		<div style="width:30%;">
			<p style="color: red;">${erreur }</p>
		</div>
		<form action="<%=request.getContextPath()%>/CreerCompte" method="post">
			
			<div class="info">


				<div class="row mt-2">
					<div class="col-md-6">
						<label class="labels">Pseudo</label><input type="text"
							class="form-control" name="pseudo" value="${utilisateur.pseudo}">
					</div>
					<div class="col-md-6">
						<label class="labels">Nom</label><input type="text"
							class="form-control" name="nom" value="${utilisateur.nom}">
					</div>
					<div class="col-md-6">
						<label class="labels">Prénom</label><input type="text"
							class="form-control" name="prenom" value="${utilisateur.prenom}">
					</div>
					<div class="col-md-12">
						<label class="labels">Email/Login</label><input type="text"
							class="form-control" name="email" value="${utilisateur.email}">
					</div>




				</div>
				<div class="row mt-2">
					<div class="col-md-12">
						<label class="labels">Numéro Mobile</label><input type="text"
							class="form-control" name="telephone"
							value="${utilisateur.telephone}">
					</div>
					<div class="col-md-12">
						<label class="labels">Address </label><input type="text"
							class="form-control" name="rue" value="${utilisateur.rue}">
					</div>
					<div class="col-md-12">
						<label class="labels">Code Postale</label><input type="text"
							class="form-control" name="codePostal"
							value="${utilisateur.codePostal}">
					</div>
					<div class="col-md-12">
						<label class="labels">Ville</label><input type="text"
							class="form-control" name="ville" value=" ${utilisateur.ville}">
					</div>
					<div class="col-md-12">
						<label class="labels">Mot de passe</label><input type="password"
							class="form-control" name="password" required>
					</div>
					<div class="col-md-12">
						<label class="labels">Confirmation mot de passe</label><input
							type="password" class="form-control" name="password_conf">
					</div>
				</div>

				<div class="mt-5 text-center">
					<button class="btn btn-primary profile-button" type="submit">S'enregistrer</button>
					<a href="<%=request.getContextPath()%>/">
						<button class="btn btn-primary profile-button" type="button">Annuler</button>
					</a>
				</div>


			</div>

		</form>
	</div>


</body>
</html>