<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Vente</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/AccueilConnecter"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="120"
		height="120" title="Logo" alt="Logo">

	</a>

	<h1>Détail Vente</h1>
	<div>
	<br> <label for="name">Article :</label>
		<p>${article.nomArticle }</p>
		
	<br> <label for="name">description :</label>
		<p>${article.description }</p>
		
	<br> <label for="name">Categorie :</label>
		<p>${article.categorie }</p>
		
	<br> <label for="name">Meilleure Offre :</label>
		<p></p>
		
	<br> <label for="name">Mise à prix :</label>
		<p>${article.prixInitial }</p>
		
	<br> <label for="name">Fin de l'enchère :</label>
		<p>${article.dateFinEncheres }</p>
	
	<br> <label for="name">Retrait :</label>
		<p>${utilisateur.rue}</p>
		<p>${utilisateur.codePostal}</p>

	<br> <label for="name">Vendeur :</label>
		<p>${utilisateur.pseudo }</p>
		 
	<br> <label for="name">Ma Proposition :</label>
	
		
		
	</div>

	<div class="button">
		<button type="submit" name="Encherir">Enchérir</button>
	</div>
	
	<div class="button">
		<a href="<%=request.getContextPath()%>/AccueilConnecter">
			<button name="annuler">Annuler</button>
		</a>
	</div>
</body>
</html>