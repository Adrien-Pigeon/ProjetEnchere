<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="Style.css">
    <title>A WEB PAGE</title>
</head>
<body>
    <div>
        <h1>ENI-Enchères</h1>
    </div>
        <div class="Titre">
            <h2>Mon Profil</h2>
        </div>

        <div class="Formulaire">
            <form action="/Accueil" method="post">
                <div>
                    <label for="name">Pseudo:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="mail">Prenom:</label>
                    <input type="email" id="mail" name="user_mail">
                </div>
                <div>
                    <label for="msg">Telephone:</label>
                    <textarea id="msg" name="user_message"></textarea>
                </div>
                <div>
                    <label for="name">Code postal:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="name">Mot de passe:</label>
                    <input type="text" id="name" name="user_name">
                </div>
            </form>
            

            </div>
            <div class="Formulaire2"> 
                <form action="/" method="post">
                <div>
                    <label for="name">Nom:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="name">Email:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="name">Rue:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="name">Ville:</label>
                    <input type="text" id="name" name="user_name">
                </div>
                <div>
                    <label for="name">Confirmation:</label>
                    <input type="text" id="name" name="user_name">
                </div>
            </form>

        </div>

        <div class="button">
            <div class="button">
                <button type="submit">Créer</button>
            </div>

            <div class="button">
                <button type="submit">Annuler</button>
            </div>

        </div>
    
</body>
</html>