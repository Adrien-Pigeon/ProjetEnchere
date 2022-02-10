<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profil</title>

<link rel="stylesheet" href="Style.css">
<link rel="stylesheet"
	href=" https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js">



</head>






<body>
	<div class="container rounded bg-white mt-5 mb-5">
		<div class="row" align="center">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<img class="rounded-circle mt-5" width="150px"
						src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg">
					
				</div>
			</div>
			<div class="col-md-5 border-right">
				<div class="p-3 py-5">



					<form action="<%=request.getContextPath()%>/PageProfil"
						method="post">
						<div class="row">
							<h3 class="formulaire text-center">Profil</h3>
							<br> <br>
							<div class="col-lg-offset-3 col-lg-12 col-xs-12 blocProfil">
								<div class="col-lg-12 col-xs-12 text-center">

									<p>
										<strong>Pseudo : </strong> ${utilisateur.pseudo }
									</p>
									<p>
										<strong>Nom : </strong> ${utilisateur.nom }
									</p>
									<p>
										<strong>Prénom : </strong> ${utilisateur.prenom }
									</p>
									<p>
										<strong>Email : </strong> ${utilisateur.email }
									</p>
									<p>
										<strong>Téléphone : </strong> ${utilisateur.telephone }
									</p>
									<p>
										<strong>Rue : </strong> ${utilisateur.rue }
									</p>
									<p>
										<strong>Code postal :</strong> ${utilisateur.codePostal }
									</p>
									<p>
										<strong>Ville :</strong> ${utilisateur.ville }
									</p>


								</div>
							</div>
							
						</div>
						
</form>
					
					<div>
					<%


						boolean btnOn = (boolean) request.getAttribute("btnOn");


							if (btnOn == true) {

			
					%>
					
						<div class="col-md-6 text-center">
							<a href="<%=request.getContextPath()%>/ModifierProfil">
								<button
									class="bouton btn btn-default col-lg-12 col-xs-12 text-center"
									type="button">Modifier</button>
							</a>
						</div>
					<%} %>
					
						<div class="col-md-6 text-center">
							<a href="<%=request.getContextPath()%>/AccueilConnecter">
								<button
									class="bouton btn btn-default col-lg-12 col-xs-12 text-center"
									type="button">Retour</button>
							</a>
						</div>
					</div>

				</div>
				

			</div>

		</div>
	</div>





</body>
</html>