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
<title>D�tails ventes</title>


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

						<c:forEach items="${article }" var="art">
							<div class="row mt-2">
								<div class="col-md-12">
									<label for="name">Article: ${art.description}</label>
								</div>
								<div class="col-md-12">
									<label for="name">Description: ${art.description}</label>

								</div>
								<div class="col-md-12">
									<label for="name">Categorie: ${art.categorie} </label>


								</div>
								<div class="col-md-12">
									<label for="file">Photo de l'article</label>
								</div>
								<div class="col-md-12">
									<label for="msg">Mise � prix: ${art.prixInitial}</label>
								</div>

							</div>
							<div class="row mt-3">
								<div class="col-md-12">
									<label for="name">D�but de l'ench�re:
										${art.dateDebutEncheres}</label>
								</div>
								<div class="col-md-12">
									<label for="name">Fin de l'ench�re:
										${art.dateFinEncheres}</label>
								</div>
								<div class="col-md-12">
									<div class="d-flex justify-content-between align-items-center ">
										<h5 style="text-align: center;">Retrait</h5>
									</div>
								</div>
								<div class="col-md-12">
									<label for="name">Rue: ${art.lieuRetrait.rue}</label>
								</div>
								<div class="col-md-12">
									<label for="name">Code postal : ${art.lieuRetrait.codePostal}</label>
								</div>
								<div class="col-md-12">
									<label for="name">Ville: ${art.lieuRetrait.ville}</label>
								</div>
								<div class="col-md-12">
									<label for="name"></label>
								</div>

							</div>


						</c:forEach>



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