

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Modifier Profil</title>


</head>
<body>
	
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand"  href="<%=request.getContextPath()%>/AccueilConnecter"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="40"
		height="25" title="Logo" alt="Logo">
		</a>
      <a class="navbar-brand" href="<%=request.getContextPath()%>/AccueilConnecter">ENI-Enchères</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li></li>
			<li class="active"><a href="<%=request.getContextPath()%>/ListeEnchereUtilisateur">Enchères</a></li>
      	 	<li><a href="<%=request.getContextPath()%>/VendArticle">Vendre un Article</a></li>
        	<li><a href="<%=request.getContextPath()%>/PageProfil">Mon Profil</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        
        <li><a href="<%=request.getContextPath()%>/Deconnexion"><span class="glyphicon glyphicon-log-in"></span> Déconnection</a></li>
      </ul>
    </div>
  </div>
</nav>

	<form action="<%=request.getContextPath()%>/VendArticle" method="post">

		<div class="container rounded bg-white mt-5 mb-5">
			<div class="row">
				<div class="col-md-3 border-right">
					<div
						class="d-flex flex-column align-items-center text-center p-3 py-5">
						<img class="rounded-circle mt-5" width="150px"
							src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
							class="font-weight-bold"> ${utilisateur.nom}</span> <span
							class="text-black-50">${utilisateur.email }</span>
					</div>
				</div>

				<div class="col-md-5 border-right">
					<div class="p-3 py-5">
						<div
							class="d-flex justify-content-between align-items-center mb-3">
							<h3>NOUVELLE VENTE</h3>
						</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<label for="name">Article:</label> <input type="text" id="name"
									name="nom">
							</div>
							<div class="col-md-6">
								<label for="name">Description:</label> <input type="text"
									id="name" name="description">
							</div>
						</div>
						<div class="row mt-2">
							<div class="col-md-6">
								<label for="name">Categorie:</label> <select id="scategorie"
									name="scategorie">

									<c:forEach var="item" items="${categories }">

										<option value="${item.noCategorie}">${item.libelle }</option>
									</c:forEach>



								</select>
							</div>
							<div class="col-md-6">
								<label for="msg">Mise à prix:</label> <input type="text"
									id="msg" name="prixInitial">
							</div>
						</div>

						<div class="row mt-2">
							<div class="col-md-6">
								<label for="file">Photo de l'article</label> <input type="file"
									id="file" name="file" multiple>
								<c:forEach items="${imagenames }" var="imagename">
									<img alt=""
										src="${pageContext.request.contextPath }/Images/${imagename}">
								</c:forEach>
							</div>

						</div>

						<div class="row mt-2">
							<div class="col-md-6">
								<label for="name">Début de l'enchère:</label> <input type="date"
									id="dateDebut" name="dateDebut">
							</div>
							<div class="col-md-6">
								<label for="name">Fin de l'enchère:</label> <input type="date"
									id="dateFin" name="dateFin">
							</div>

						</div>

						<div class="row mt-2">
							<div class="col-md-6">
								<div
									class="d-flex justify-content-between align-items-center mb-3">
									<h3>Retrait</h3>
								</div>

							</div>

							<div class="row mt-2">
								<div class="col-md-6">
									<label for="name">Rue :</label>
								</div>

								<div class="col-md-6">
									<input type="text" id="name" name="rue"
										value="${utilisateur.rue }" required>

								</div>
							</div>
						</div>

						<div class="row mt-2">
							<div class="col-md-6">
								<label for="name">Code postal :</label>
							</div>

							<div class="col-md-6">
								<input type="text" id="name" name="rue"
									value="${utilisateur.codePostal }" required>

							</div>
						</div>

						<div class="row mt-2">
							<div class="col-md-6">
								<label for="name">Ville:</label>
							</div>

							<div class="col-md-6">
								<input type="text" id="name" name="codePostal"
									value="${utilisateur.ville }" required>

							</div>
						</div>
						
						
						<div class="row mt-2">
							<div class="col-md-6">
								<a href="<%=request.getContextPath()%>/AccueilConnecter" >
							<button class="bouton btn btn-default col-lg-12 col-xs-12 text-center" type="button">Retour</button>
							</a>	
							</div>

							<div class="col-md-6">
							<button class="bouton btn btn-default col-lg-12 col-xs-12 text-center  " type="submit" name="enregistrer">Enregistrer</button>
							
							</div>
						</div>
					</div>

				</div>
			</div>


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



	</form>
</body>
</html>







