<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListEnchères Not Logged</title>
<style>
body {
	width: 100%;
	height: 100vh;
	background: silver;
	justify-content: center;
	align-items: center;
}

h1 {
	text-align: left;
	display: inline;
}
</style>



</head>
<body>
	<h1>ENI-Enchères</h1>
<div class="row" align="right" >	
		<a href="<%=request.getContextPath()%>/Login">Inscription - Se Connecter</a>	
</div>

<div class="row">	
		<h3 align="center">Liste des enchères</h3>
</div>


<form action="<%= request.getContextPath()%>/AccueilNonConnecter" method="get">

	<div >
	 
		<label for="sfiltres">Filtres:</label>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"><span
				class="glyphicon glyphicon-search"></span></span> <input type="text" name ="srecherche"
				class="form-control" placeholder="Le nom de l'article contient">
		</div>

			<label for="scategorie">Catégories:</label>
			
			<div >
				<select id="scategorie" name="scategorie" >
				<option value ="0">-Choisir Catégorie-</option>
				
				</select>
			</div>

	</div>
	<div >
		<button type="submit" class="btn btn-default" name = "search">Rechercher</button>
	</div>
</form>
<div >
			<p>Achats</p>
		<div>
		  <input type="checkbox" id="scales" name="scales" checked>
		  <label for="scales">encheres ouvertes</label>
		</div>
		
		<div>
		  <input type="checkbox" id="horns" name="horns">
		  <label for="horns">mes encheres en cours</label>
		</div>
		<div>
		  <input type="checkbox" id="horns" name="horns">
		  <label for="horns">mes encheres en cours</label>
		</div>
</div>		
<div  >
			<p>Ventes</p>
		<div>
		  <input type="checkbox" id="scales" name="scales" >
		  <label for="scales">mes ventes en cours</label>
		</div>
		<div>
			<input type="checkbox" id="horns" name="horns">
			<label for="horns">ventes non debutées</label>
		</div>
		<div>
			<input type="checkbox" id="horns" name="horns">
			<label for="horns">ventes terminées</label>
		</div>
</div>

</body>
</html>