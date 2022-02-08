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
	
	
	<h4 class="title-element">Récupération de mot de passe</h4>
<?php if($section == 'code') { ?>
Un code de vérification vous a été envoyé par mail: <?= $_SESSION['recup_mail'] ?>
<br/>
<form method="post">
   <input type="text" placeholder="Code de vérification" name="verif_code"/><br/>
   <input type="submit" value="Valider" name="verif_submit"/>
</form>
<?php } elseif($section == "changemdp") { ?>
Nouveau mot de passe pour <?= $_SESSION['recup_mail'] ?>
<form method="post">
   <input type="password" placeholder="Nouveau mot de passe" name="change_mdp"/><br/>
   <input type="password" placeholder="Confirmation du mot de passe" name="change_mdpc"/><br/>
   <input type="submit" value="Valider" name="change_submit"/>
</form>
<?php } else { ?>
<form method="post">
   <input type="email" placeholder="Votre adresse mail" name="recup_mail"/><br/>
   <input type="submit" value="Valider" name="recup_submit"/>
</form>
<?php } ?>
<?php if(isset($error)) { echo '<span style="color:red">'.$error.'</span>'; } else { echo ""; } ?>
	
    </body>
</html>