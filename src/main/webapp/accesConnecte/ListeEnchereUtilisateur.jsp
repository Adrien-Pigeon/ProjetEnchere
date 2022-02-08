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
<h1>ENI-Enchères</h1>
		 <div class="row" align="right">
		<a href="<%=request.getContextPath()%>/ListeEnchereUtilisateurServlet">Enchères</a>
				<a href="<%=request.getContextPath()%>/VendArticle">Vendre un Article</a>
				<a href="<%=request.getContextPath()%>/PageProfil">Mon Profil</a>
				<a href="<%=request.getContextPath()%>/Deconnexion" >Déconnection</a>	
			
	</div>
<body>

 
				<div class="text-center rounded my-5 haute " align="center">
                    <h1 class="p-3 bordure">Liste des enchères</h1>
                </div>


 <form action="<%= request.getContextPath()%>/ListeEnchereUtilisateurServlet" method="post" class=" p-5 rounded bordure " style="background: #fff;">
                    <h2>Filtres :</h2>

                    <div class="md-form  active-pink-2 mb-3 mt-0">
                        <input class="form-control" type="text" placeholder="Rechercher..." aria-label="Search">
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword" class="col-sm-2 col-form-label">Catégorie :</label>
                        <div>
				<select id="scategorie" name="scategorie">
					<option>toutes</option>
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
 <div>
	<div>
      <input class="buy" onclick="myFunction()" type="radio" id="achat" name="drone" value="achat"
             checked>
      <label for="achat">Achat</label>
      
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
    
    <div>
      <input class="sell" onclick="myFunction()" type="radio" id="vente" name="drone" value="vente" disabled="disabled">
      <label for="vente">Vente</label>
	      <div>
	        <input type="checkbox" id="ventes" name="check">
	        <label for="scales">Mes ventes en cours</label><br>
	      
	        <input type="checkbox" id="debute" name="check">
	        <label for="horns">Ventes non débutées</label><br>
	      
	        <input type="checkbox" id="termine" name="check">
	        <label for="horns">Ventes terminées</label>
	      </div>     
      
    </div>
      
  </div>    



    
<div class="carteArticle" style="width: 18rem;">
  			<img class="card-img-top" src="img/Aspirateur.jpg" alt="Image titre">
  				<div class="card-body">
    				<h5 class="card-title">Aspirateur</h5>
    				<p class="card-text">Prix: 200 points Fin de l'enchère : 07/01/2022 Vendeur : Jacques</p>
    				<a href="#" class="btn btn-primary">Voir l'article</a>
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

<link rel="stylesheet" href="Style.css">
</html>
