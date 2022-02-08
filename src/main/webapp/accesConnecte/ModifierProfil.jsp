<!DOCTYPE html>
<html lang="fr">
<head>
	<link rel="stylesheet" href="Style.css">
	<link rel="stylesheet"
		href=" https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Modifier Profil</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/ModifierProfil"
		method="post">
		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" width="150px"
							src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
							class="font-weight-bold"> ${utilisateur.nom}</span>
							<span
							class="text-black-50">${utilisateur.email }</span>
					</div>
				</div>
				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h4 class="text-right" >Modification Profil</h4>
						</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<label class="labels">Pseudo</label><input type="text"
									class="form-control" name="pseudo"
									value="${utilisateur.pseudo}">
							</div>
							<div class="col-md-6">
								<label class="labels">Nom</label><input type="text"
									class="form-control" name="nom" value="${utilisateur.nom}">
							</div>
							<div class="col-md-6">
								<label class="labels">Prénom</label><input type="text"
									class="form-control" name="prenom"
									value="${utilisateur.prenom}">
							</div>
							<div class="col-md-12">
								<label class="labels">Email/Login</label><input type="text"
									class="form-control" name="email" value="${utilisateur.email}">
							</div>
							<div class="col-md-12">
								<label class="labels">Mot de passe actuel</label><input
									type="text" class="form-control" name="password" required>
							</div>



						</div>
						<div class="row mt-3">
							<div class="col-md-12">
								<label class="labels">Numéro Mobile</label><input type="text"
									class="form-control" name="telephone"
									value="${utilisateur.telephone}">
							</div>
							<div class="col-md-12">
								<label class="labels">Address Line 1</label><input type="text"
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
								<label class="labels">nouveau mot de passe</label><input
									type="text" class="form-control" name="nouveauMotDePasse">
							</div>
							<div class="col-md-12">
								<label class="labels">Confirmation mot de passe</label><input
									type="text" class="form-control" name="password_conf">
							</div>
						</div>





						<div class="mt-5 text-center">
							<button class="btn btn-primary profile-button" type="submit">enregistrer</button>
						</div>
				
						<div class="mt-5 text-center">
							<a href="<%=request.getContextPath()%>/SupprimerProfil" ><button class="btn btn-primary profile-button" type="button">Delete
								Profile</button></a>
						</div>
					
						<script>
                        const senha = document.querySelector('.senha');
                        const btn = document.querySelector('.btn');
                    
                        btn.onclick = () =>
                        {
                            if (senha.type === 'password') 
                            {
                                senha.type = 'text'
                                btn.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8SA14-A-zoRaiJ2GdUiESsisaFiHNYrUZtjtjZqnth0D_KdfkwzQWIdCjbzhAoYKPTvs&usqp=CAU'
                            }
                            else
                            {
                                senha.type = 'password'
                                btn.src = 'https://icon-library.com/images/icon-eyes/icon-eyes-12.jpg'
                            }
                        }
                        </script>

					</div>
				</div>

			</div>
		</div>
	</form>



	

</body>
</html>