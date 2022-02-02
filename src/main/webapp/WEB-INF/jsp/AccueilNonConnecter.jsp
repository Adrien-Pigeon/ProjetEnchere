<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row" align="right" >	
		<a href="<%=request.getContextPath()%>/login">Inscription - Se Connecter</a>	
</div>

<div class="row">	
		<h3 align="center">Liste des enchères</h3>
</div>


<form action="<%= request.getContextPath()%>/AccueilConnecter" method="get">
<div >
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
</div>

</body>
</html>