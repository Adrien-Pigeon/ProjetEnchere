<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListEnchères Not Logged</title>



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
      <a class="navbar-brand" href="<%=request.getContextPath()%>/AccueilConnecter">ENI-Enchères</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        
			<li class="active"><a href="<%=request.getContextPath()%>/ListeEnchereUtilisateurServlet">Enchères</a></li>
      	 	<li><a href="<%=request.getContextPath()%>/VendArticle">Vendre un Article</a></li>
        	<li><a href="<%=request.getContextPath()%>/PageProfil">Mon Profil</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="<%=request.getContextPath()%>/CreerCompte"><span class="glyphicon glyphicon-user"></span> S'enregistrer</a></li>
        <li><a href="<%=request.getContextPath()%>/Deconnexion"><span class="glyphicon glyphicon-log-in"></span> Déconnection</a></li>
      </ul>
    </div>
  </div>
</nav>
	<a href="<%=request.getContextPath()%>/"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="120"
		height="120" title="Logo" alt="Logo">

	</a>

	<div class="row" align="right">
		<a href="<%=request.getContextPath()%>/Login">Inscription - Se
			Connecter</a>
	</div>

	<div class="row">
		<h3 align="center">Liste des enchères</h3>
	</div>


	<form action="<%=request.getContextPath()%>/Rechercher"
		method="post">

		<div>

			<label for="sfiltres">Filtres:</label>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-search"></span></span> <input type="text"
					name="srecherche" class="form-control"
					placeholder="Le nom de l'article contient">
			</div>

			<label for="scategorie">Catégories:</label>


			<div>
				<select id="scategorie" name="scategorie">
					<option>toutes</option>
					<c:forEach var="item" items="${categories }">

						<option value="${item.noCategorie}">${item.libelle }</option>
					</c:forEach>


				</select>
			</div>

		</div>
		<div>
			<button type="submit" class="btn btn-default" name="search">Rechercher</button>
		</div>
	</form>

	<c:forEach var="item" items="${listeArticles }">
		<div></div>
		<div>${item.description }</div>
		<div>Prix : ${item.prixVente }</div>
		<div>Fin de l'enchère : ${item.dateFinEncheres }</div>
		<div>Vendeur : jojo</div>
	</c:forEach>


</body>
</html>