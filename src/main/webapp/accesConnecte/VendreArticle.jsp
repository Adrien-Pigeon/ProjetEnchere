<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EnchereArticle</title>
</head>
<body>
	<h1>NOUVELLE VENTE</h1>
	
	<img alt="logo" src="webapp/img/logo.jpg">
	
	<div class="Formulaire">
		<form action="<%=request.getContextPath()%>/VendArticle" method="post">
		
			<div>
				<label for="name">Article:</label> 
				<input type="text" id="name"name="nom" required>
			</div>
			
			<div>
				<label for="name">Description:</label> 
				<input type="text" id="name"name="description" required>
			</div>
			
			<div>
			<label for="name">Categorie:</label> 
				<select id="scategorie" name="scategorie">
					<option></option>
					<c:forEach var="item" items="${categories }">
						
						<option value="${categorie.libelle}">${item.libelle }</option>
					</c:forEach>
					

				</select>
			</div>
			
		
			
			<div>
				<label for="mail">Photo de l'article</label> 
				<input type="email" id="name"name="photo" required>
			</div>
			
			<div>
				<label for="msg">Mise à prix:</label>
				<input type="text" id="msg" name="prixInitial"  >
			</div>
			
			<div>
				<label for="name">Début de l'enchère:</label> 
				<input type="date" id="dateDebut"name="dateDebut" required>
			</div>
			
			<div>
				<label for="name">Fin de l'enchère:</label> 
				<input type="date" id="dateFin"name="dateFin" required>
			</div>
			
			<div>
				<label for="name">Rue:</label> 
				<input type="text" id="name"name="rue" required>
			</div>
			
			<div>
				<label for="name">Code postal:</label> 
				<input type="text" id="name"name="codePostal" required>
			</div>
			
			<div>
				<label for="name">Ville:</label> 
				<input type="text" id="name"name="ville" required>
			</div>
			
		</form>
		
		
		
		
			<div class="button">
				<button type="submit" name="enregistrer">Enregistrer</button>
			</div>

		
		<div class="button">
				<a href="<%=request.getContextPath()%>/AccueilConnecter">
				<button  name="annuler">Annuler</button></a>
			</div>

</body>
</html>