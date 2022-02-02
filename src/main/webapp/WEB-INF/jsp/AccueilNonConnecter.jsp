<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-lg-12 text-right">
		<a href="<%=request.getContextPath()%>/login">S'inscrire-se Connecter</a>
		
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<h3 class="text-center">Liste des enchères</h3>
	</div>
</div>


<form action="<%= request.getContextPath()%>/AccueilNonConnecter" method="get">
<div class="row text-center">
	<div class="col-lg-6 pad">
	
		<label class="col-md-4 control-label" for="sfiltres">Filtres:</label>
		<div class="input-group">
			<span class="input-group-addon" id="basic-addon1"><span
				class="glyphicon glyphicon-search"></span></span> <input type="text" name ="srecherche"
				class="form-control" placeholder="Le nom de l'article contient">
		</div>

			<label class="col-md-4 control-label" for="scategorie">Catégories:</label>
			
			<div class="col-md-4">
				<select id="scategorie" name="scategorie" class="form-control">
				<option value ="0">-Choisir Catégorie-</option>
				
				</select>
			</div>

	</div>
	<div class="col-lg-6">

		<button type="submit" class="btn btn-default" name = "search">Rechercher</button>

	</div>
</form>
</div>


<div class="row">


	<div class="col-lg-5 article">
		<div class="col-lg-3 image">
		




</div>
</body>
</html>