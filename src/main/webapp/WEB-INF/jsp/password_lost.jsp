<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       

	<title>Mot de passe oublié</title>
    </head>

    <body>
        <div>Mot de passe oublié</div>
        
        <form method="get" action="<%=request.getContextPath()%>/Login">	
        
		<div>
		 <input type="email" placeholder="Adresse mail" name="mail" value="" >

            <button type="submit" name="oublie">Envoyer</button>           
          
           
		<input type="submit" value="Annuler">
		</div>
	</form>
    </body>
</html>