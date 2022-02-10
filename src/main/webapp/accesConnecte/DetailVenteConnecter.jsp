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

    
    
    <nav class="navbar navbar-expand-lg navbar-light bg-dark" style="text-color:white;">
          
      <a class="navbar-brand" href="<%=request.getContextPath()%>/AccueilConnecter">
        <img  src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="85" height="70"  alt="">
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item active">
            <a class="nav-link" style="color:white;" href="<%=request.getContextPath()%>/ListeEnchereUtilisateur">Enchères <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" style="color:white;" href="<%=request.getContextPath()%>/VendArticle">Vendre
                                un Article</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" style="color:white;" href="<%=request.getContextPath()%>/MonProfil">Mon
                                Profil</a>
          </li>
          <li class="nav-item">
            <a class="nav-link " style="color:white;"  href="<%=request.getContextPath()%>/Deconnexion">Déconnection</a>
          </li>
        </ul>
      </div>
    </nav>



	
	<form action="<%=request.getContextPath()%>/AccueilConnecter" method="post">
	
		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right">
			
				</div>
				<div class="col-md-6 border-right">
					<div class="p-5 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-5">
							<h3 style="text-align: center;">Détail Vente</h3>
						</div>
						<div class="row mt-2">
							<div class="col-md-12">
								<label for="name">Article :  ${article.nomArticle }</label>
								
							</div>
							<div class="col-md-12">
								<label for="name">description :  ${article.description }</label>
		
							</div>
							<div class="col-md-12">
								<label for="name">Categorie : ${article.categorie }</label>
						     
							</div>
							<div class="col-md-12">
								<label for="name">Meilleure Offre :  </label>

							</div>
							<div class="col-md-12">
								<label for="name">Mise à prix : ${article.prixInitial }</label>		
							</div>



						</div>
						<div class="row mt-3">
							<div class="col-md-12">
								<label for="name">Fin de l'enchère : ${article.dateFinEncheres }</label>
	
							</div>
							<div class="col-md-12">
								<fieldset>
								<label for="name">Retrait : ${utilisateur.rue}, ${utilisateur.ville} , ${utilisateur.codePostal}<br>
								</label>
								</fieldset>
							</div>
						
							<div class="col-md-12">
								<label for="name">Vendeur : ${utilisateur.pseudo }</label>
							</div>
							<div class="col-md-12">
								<label for="name">Ma Proposition : <input type="text" id="name"
                                    name="rue" placeholder="Saisir un prix" required> </label>
							</div>
							
						</div>





						
							<button class="bouton btn btn-default col-lg-12 col-xs-12 text-center  " type="submit" name="enregistrer">Enchérir</button>
						
							
					
						
							<a href="<%=request.getContextPath()%>/AccueilConnecter" >
							<button class="bouton btn btn-default col-lg-12 col-xs-12 text-center" type="button">Annuler</button>
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