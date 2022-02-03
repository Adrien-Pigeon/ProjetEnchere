<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListEnchères Logged</title>
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
		<a href="<%=request.getContextPath()%>/VendArticle">Enchères</a>
		<a href="<%=request.getContextPath()%>/VendArticle">Vendre un Article</a>
		<a href="<%=request.getContextPath()%>/PageProfil">Mon Profil</a>
		<a href="<%=request.getContextPath()%>/AccueilNonConnecter">Déconnection</a>	
</div>

				<div class="text-center rounded my-5 haute " align="center">
                    <h1 class="p-3 bordure">Liste des enchères</h1>
                </div>


 <form action="<%= request.getContextPath()%>/AccueilConnecter" method="post" class=" p-5 rounded bordure " style="background: #fff;">
                    <h2>Filtres :</h2>

                    <div class="md-form  active-pink-2 mb-3 mt-0">
                        <input class="form-control" type="text" placeholder="Rechercher..." aria-label="Search">
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Catégorie :</label>
                        <div class="col-sm-10">
                            <select id="inputState" class="form-control">
                                <option selected>Toutes</option>
                                <option>Ameublement</option>
                                <option>Sport&loisir</option>
                                <option>Informatique</option>
                                <option>Vêtement</option>
                            </select>
                        </div>
                    </div>

                    <div class="d-flex justify-content-end pt-5">
                        <button class="btn btn-action" type="submit">Rerchercher</button>
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
<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="img/Aspirateur.jpg" alt="Image titre">
  				<div class="card-body">
    				<h5 class="card-title">Aspirateur</h5>
    				<p class="card-text">Prix: 200 points Fin de l'enchère : 07/01/2022 Vendeur : Jacques</p>
    				<a href="#" class="btn btn-primary">Voir l'article</a>
  				</div>
</div>



</body>
</html>