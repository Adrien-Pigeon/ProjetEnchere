<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
       <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jsProjet.js"></script>
<title>Liste Enchères Log</title>
	
</head>

<body>
	<a href="<%=request.getContextPath()%>/AccueilConnecter"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="120"
		height="120" title="Logo" alt="Logo">

	</a>
	<h1>LISTE DE MES ENCHERES</h1>

	

	<div class="Formulaire">
		<form action="<%=request.getContextPath()%>/ListeEnchereUtilisateur" method="post">

			<div>
				<label for="name">Article:</label> <input type="text" id="name"
					name="nom" value="${article.nomArticle }">
			</div>

			<div>
				<label for="name">Description:</label> <input type="text" id="name"
					name="description" value="${article. }">
			</div>

			<div>
				<label for="name">Categorie:</label> <select id="scategorie"
					name="scategorie">

					<c:forEach var="item" items="${categories }">

						<option value="${item.noCategorie}">${item.libelle }</option>
					</c:forEach>



				</select>
			</div>


			
				<div>
					<label for="file">Photo de l'article</label> <input
						type="file" id="file" name="file" multiple>
				</div>
				

				<div>
					<label for="msg">Mise à prix:</label> <input type="text" id="msg"
						name="prixInitial">
				</div>

				<div>
					<label for="name">Début de l'enchère:</label> <input type="date"
						id="dateDebut" name="dateDebut" required>
				</div>

				<div>
					<label for="name">Fin de l'enchère:</label> <input type="date"
						id="dateFin" name="dateFin" required>
				</div>
				<div>
					<fieldset>
						<legend>Retrait</legend>
						<div>
							<label for="name">Rue:</label> <input type="text" id="name"
								name="rue" placeholder="${utilisateur.rue }" required>
						</div>

						<div>
							<label for="name">Code postal:</label> <input type="text"
								id="name" name="codePostal"
								placeholder="${utilisateur.codePostal }" required>
						</div>

						<div>
							<label for="name">Ville:</label> <input type="text" id="name"
								name="ville" placeholder="${utilisateur.ville }" required>
						</div>
					</fieldset>
				</div>





				<div class="button">
					<button type="submit" name="Supprimer">Supprimer</button>
				</div>
			</form>
	</div>
	<div class="button">
		<a href="<%=request.getContextPath()%>/AccueilConnecter">
			<button name="annuler">Annuler</button>
		</a>
	</div>
 
</body>

<link rel="stylesheet" href="Style.css">
</html>
