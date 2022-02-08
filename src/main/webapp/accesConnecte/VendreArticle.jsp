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
<a href="<%=request.getContextPath()%>/AccueilConnecter"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="120"
		height="120" title="Logo" alt="Logo">

	</a>
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
					
					<c:forEach var="item" items="${categories }">
						
						<option value="${item.noCategorie}">${item.libelle }</option>
					</c:forEach>
					
				

				</select>
			</div>
			
		
			
			<div>
				<label for="mail">Photo de l'article</label> 
				<input type="email" id="name"name="photo" >
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
				<fieldset>
				<legend>Retrait</legend>
			<div>
				<label for="name">Rue:</label> 
				<input type="text" id="name"name="rue" placeholder="${utilisateur.rue }" required >
			</div>
			
			<div>
				<label for="name">Code postal:</label> 
				<input type="text" id="name"name="codePostal" placeholder="${utilisateur.codePostal }" required>
			</div>
			
			<div>
				<label for="name">Ville:</label> 
				<input type="text" id="name"name="ville" placeholder="${utilisateur.ville }" required>
			</div>
			</fieldset>
			</div>
		
		
		
		
		
			<div class="button">
				<button type="submit" name="enregistrer">Enregistrer</button>
			</div>
</form>
	</div>	
		<div class="button">
				<a href="<%=request.getContextPath()%>/AccueilConnecter">
				<button  name="annuler">Annuler</button></a>
			</div>

</body>
</html>