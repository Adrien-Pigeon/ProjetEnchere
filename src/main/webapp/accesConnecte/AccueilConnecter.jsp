
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jsProjet.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>ListEnchères Logged</title>


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

	


	<div class="row">
		<h1 align="center" style="margin-top:4%;margin-bottom:3%;">Liste des enchères</h1>
	</div>

<div style="margin-left:10%;">
	<form action="<%=request.getContextPath()%>/Rechercher" method="post">





		<label for="sfiltres">Filtres:</label>
		<nav class="navbar navbar-light bg-light" style="width: 40%">


			<input class="form-control mr-sm-2" style ="margin:0;" type="search"
				placeholder="Rechercher un article..." aria-label="Search"
				name="srecherche">


		</nav>

		<label for="scategorie" name="scategorie">Catégories:</label>


		<div>
			<select id="scategorie" name="scategorie" style="width:20%;height:6%;">
				<option value="0">Choisissez une catégorie</option>
				<option value="150">toutes</option>
				<c:forEach var="item" items="${categories }">

					<option value="${item.noCategorie}">${item.libelle }</option>
				</c:forEach>


			</select>

			<button type="submit" class="btn btn-secondary" name="search">Rechercher</button>

		</div>
	</form>
	<div >
	<div class="" style = "display:inline-block;margin-right:15%;" >
		<input class="buy" onclick="myFunction()" type="radio" id="achat"
			name="drone" value="achat" checked> <label for="achat">achat</label>

		<div style ="margin-left:%;" >
			<input type="checkbox" id="achats" name="check" checked> <label
				for="scales">Enchères ouvertes</label><br> <input
				type="checkbox" id="encours" name="check"> <label
				for="horns">Mes enchères en cours</label><br> <input
				type="checkbox" id="remporter" name="check"> <label
				for="horns">Mes enchères remporter</label>
		</div>

	</div>

	<div class="" style = "display:inline-block;">
		<input class="sell" onclick="myFunction()" type="radio" id="vente"
			name="drone" value="vente"> <label for="vente">vente</label>
		<div>
			<input type="checkbox" id="ventes" name="check"> <label
				for="scales">Mes ventes en cours</label><br> <input
				type="checkbox" id="debute" name="check"> <label for="horns">Ventes
				non débutées</label><br> <input type="checkbox" id="termine"
				name="check"> <label for="horns">Ventes terminées</label>
		</div>
	</div>
	</div>
	<div style="text-align:center;">
	<c:forEach var="item" items="${listeArticles }">

	
		<div class="card" style="width: 20rem;margin:4%;display:inline-block;height:20rem;">
			<img class="card-img-top" src="./asset/img/img.png"
				alt="" height="230rem">
			<div class="card-body">
				<p class="card-text">
					<label>Article : </label> <a
						href="<%=request.getContextPath()%>/DetailVente?noArticle=${item.noArticle }">${item.nomArticle }</a>

				<div>${item.description }</div>
				<div>Prix : ${item.prixVente }</div>
		<div>Fin de l'enchère : ${item.dateFinEncheres }</div>
		<form action="<%=request.getContextPath()%>/PageProfil" method="post">
			<div>
				<label>Vendeur : </label>
				<a href="<%=request.getContextPath()%>/PageProfil?pseudo=${item.utilisateurPseudo }">${item.utilisateurPseudo }</a>
					
			</div>
		</form>
				
  </div>
</div>
		

	</c:forEach>
</div>
	





	<script>
		function myFunction() {
			if (document.getElementById("vente").checked) {
				document.getElementById("achats").disabled = true;
				document.getElementById("remporter").disabled = true;
				document.getElementById("encours").disabled = true;
				document.getElementById("ventes").disabled = false;
				document.getElementById("debute").disabled = false;
				document.getElementById("termine").disabled = false;
			} else if (document.getElementById("achat").checked) {
				document.getElementById("ventes").disabled = true;
				document.getElementById("debute").disabled = true;
				document.getElementById("termine").disabled = true;
				document.getElementById("achats").disabled = false;
				document.getElementById("encours").disabled = false;
				document.getElementById("remporter").disabled = false;
			}
		}
	</script>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/monScriptProjet.js"></script>
</body>
</html>