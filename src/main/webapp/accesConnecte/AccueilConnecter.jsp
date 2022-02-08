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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="js/jsProjet.js"></script>
<title>ListEnchères Logged</title>
	
		
</head>
<body>
<a href="<%=request.getContextPath()%>/AccueilConnecter"> <img
		src="<%=request.getContextPath()%>/asset/img/logo.jpg" width="120"
		height="120" title="Logo" alt="Logo">

	</a>



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
        
        <li><a href="<%=request.getContextPath()%>/Deconnexion"><span class="glyphicon glyphicon-log-in"></span> Déconnection</a></li>
      </ul>
    </div>
  </div>
</nav>

	
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
                        <div>
				<select id="scategorie" name="scategorie">
					
					<c:forEach var="item" items="${categories }">
						<option value="${categorie.libelle }">${item.libelle }</option>
					</c:forEach>
				</select>
			</div>
                    </div>

                    <div class="d-flex justify-content-end pt-5">
                        <button class="btn btn-action" type="submit">Rerchercher</button>
                    </div>
 </form>
<div class="">
      <input class="buy" onclick="myFunction()" type="radio" id="achat" name="drone" value="achat"
             checked>
      <label for="achat">achat</label>
      
      <div>
        <input type="checkbox" id="achats" name="check"
               checked>
        <label for="scales">Enchères ouvertes</label><br>
     
        <input type="checkbox" id="encours" name="check">
        <label for="horns">Mes enchères en cours</label><br>
      
        <input type="checkbox" id="remporter" name="check">
        <label for="horns">Mes enchères remporter</label>
      </div>
    
 </div>
    
    <div class="">
      <input class="sell" onclick="myFunction()" type="radio" id="vente" name="drone" value="vente">
      <label for="vente">vente</label>
      <div>
        <input type="checkbox" id="ventes" name="check">
        <label for="scales">Mes ventes en cours</label><br>
      
        <input type="checkbox" id="debute" name="check">
        <label for="horns">Ventes non débutées</label><br>
      
        <input type="checkbox" id="termine" name="check">
        <label for="horns">Ventes terminées</label>
      </div>
    </div>
    



  

 <script>
       function myFunction() {
        if(document.getElementById("vente").checked){
      document.getElementById("achats").disabled = true;
      document.getElementById("remporter").disabled = true;
      document.getElementById("encours").disabled = true;
      document.getElementById("ventes").disabled = false;
      document.getElementById("debute").disabled = false;
      document.getElementById("termine").disabled = false;
        }
        else if(document.getElementById("achat").checked){
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
