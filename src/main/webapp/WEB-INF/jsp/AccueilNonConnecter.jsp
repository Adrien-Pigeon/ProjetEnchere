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
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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


<title>ListEnchères Not Logged</title>
</head>
<body >
	

	<nav class="navbar navbar-light bg-dark" style="margin-bottom:4%;">
  <a class="navbar-brand" href="<%=request.getContextPath()%>/">
    <img  src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="85" height="70"  alt="">
  </a>
  
<a href="<%=request.getContextPath()%>/Login" style="margin-right:5%;color:white;"><span
							class="glyphicon glyphicon-user"></span> Inscription - Se
							Connecter</a>
  
</nav>


	<div class="row">
		<h1 align="center">Liste des enchères</h1>
	</div>

<div style="margin-left:10%;">
	<form action="<%=request.getContextPath()%>/Rechercher" method="get">





		<label for="sfiltres">Filtres:</label>
		<nav class="navbar navbar-light bg-light" style="width: 40%">


			<input class="form-control mr-sm-2" style ="margin:0;" type="search"
				placeholder="Rechercher un article..." aria-label="Search"
				name="srecherche">


		</nav>

	<div>	
		<label for="scategorie" name="scategorie">Catégories:</label>

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
	</div>
<div style="text-align:center;">
	<c:forEach var="item" items="${listeArticles }">

	
		<div class="card" style="width: 20rem;margin:4%;display:inline-block;height:20rem;">
			<img class="card-img-top" src="./asset/img/img.png"
				alt="" height="230rem">
			<div class="card-body">
				<p class="card-text">
					<label>Article : </label> <a
						href="<%=request.getContextPath()%>/DetailVenteNonCo?noArticle=${item.noArticle }">${item.nomArticle }</a>

				<div>${item.description }</div>
				<div>Prix : ${item.prixVente }</div>
		<div>Fin de l'enchère : ${item.dateFinEncheres }</div>
		<div>Vendeur : ${item.utilisateurPseudo }</div></p>
				
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