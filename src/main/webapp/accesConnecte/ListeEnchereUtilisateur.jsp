<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Détails ventes</title>


</head>
<body>





	<form action="<%=request.getContextPath()%>/ListeEnchereUtilisateur"
		method="post">

		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right"></div>
				<div class="col-md-6 border-right">
					<div class="p-5 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-5">
							<h3 style="text-align: center;">LISTE DE MES ENCHERES</h3>
						</div>
						

							<div class="row mt-2">
								<div class="col-md-12">
									<label for="name">Article:</label> <input type="text" id="name"
										name="nom" value="${articles.nomArticle }">
								</div>
								<div class="col-md-12">
									<label for="name">Description:</label> <input type="text"
										id="name" name="description" value="${articles.description }">

								</div>
								<div class="col-md-12">
									<label for="name">Categorie:<select id="scategorie"
										name="scategorie" value="${articles.categorie.libelle }">

											
									</select></label>


								</div>
								<div class="col-md-12">
									<label for="file">Photo de l'article</label> <input type="file"
										id="file" name="file" multiple>
								</div>
								<div class="col-md-12">
									<label for="msg">Mise à prix:</label> <input type="text"
										id="msg" name="prixInitial" value="${articles.prixInitial }">
								</div>

							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="name">Début de l'enchère:</label> <input
										type="date" id="dateDebut" name="dateDebut"
										value="${articles.dateDebutEncheres }">
								</div>
								<div class="col-md-12">
									<label for="name">Fin de l'enchère:</label> <input type="date"
										id="dateFin" name="dateFin"
										value="${articles.dateFinEncheres }">
								</div>
								<div class="col-md-12">
									<legend>Retrait</legend>
								</div>
								<div class="col-md-12">
									<label for="name">Rue:</label> <input type="text" id="name"
										name="rue" value="${um.rue }">
								</div>
								<div class="col-md-12">
									<label for="name">Code postal:</label> <input type="text"
										id="name" name="codePostal" value="${um.codePostal }">
								</div>
								<div class="col-md-12">
									<label for="name">Ville:</label> <input type="text" id="name"
										name="ville" value="${um.ville }">
								</div>
								<div class="col-md-12">
									<label for="name">Ma Proposition :</label>
								</div>

							</div>
					





						<button
							class="bouton btn btn-default col-lg-12 col-xs-12 text-center  "
							type="submit" name="enregistrer">Supprimer</button>




						<a href="<%=request.getContextPath()%>/AccueilConnecter">
							<button
								class="bouton btn btn-default col-lg-12 col-xs-12 text-center"
								type="button">Annuler</button>
						</a>



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