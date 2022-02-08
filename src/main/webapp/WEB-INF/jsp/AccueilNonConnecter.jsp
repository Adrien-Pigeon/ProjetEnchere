<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ListEnchères Not Logged</title>



</head>
<body>
	<h1>ENI-Enchères</h1>
	<div class="row" align="right">
		<a href="<%=request.getContextPath()%>/Login">Inscription - Se
			Connecter</a>
	</div>

	<div class="row">
		<h3 align="center">Liste des enchères</h3>
	</div>


	<form action="<%=request.getContextPath()%>/AccueilNonConnecter"
		method="get">

		<div>

			<label for="sfiltres">Filtres:</label>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1"><span
					class="glyphicon glyphicon-search"></span></span> <input type="text"
					name="srecherche" class="form-control"
					placeholder="Le nom de l'article contient">
			</div>

			<label for="scategorie">Catégories:</label>


			<div>
				<select id="scategorie" name="scategorie">
					<option>toutes</option>
					<c:forEach var="item" items="${categories }">
						
						<option value="${categorie.libelle}">${item.libelle }</option>
					</c:forEach>
					

				</select>
			</div>

		</div>
		<div>
			<button type="submit" class="btn btn-default" name="search">Rechercher</button>
		</div>
	</form>
	
	

</body>
</html>