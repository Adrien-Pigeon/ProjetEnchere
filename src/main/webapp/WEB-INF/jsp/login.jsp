<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de Connection</title>
<style>


body
{
	width: 100%;
	height: 100vh;
	background: silver;
	justify-content: center;
	align-items: center;
}
h1{
	text-align: left;	
	display:  inline;
	}

</style>



</head>
<body>
<h1>ENI-Enchères</h1>
	<form action="<%=request.getContextPath() %>/login" method="post">
		
  		
	
		<div class="row">
			<span>username</span>
			<input type="text" name="username" placeholder="username">			
		</div>
			
		<div class="row">
		<span>password</span>
		<input type="password" name="password" class="senha" placeholder="123456">		
		</div>		
			
		
		<div class="row">
		<input name = "connexion" type="submit" value="Connexion">
			<div class="row">
			<a href=" ">Mot de passe oublié</a>
			<input type="checkbox" id="scales" name="scales">
	  		<label for="scales">Se souvenir de moi</label>	
	  		
	  		</div>
		</div>
		
		<div>
		<input type="button" value="Créer un compte">
		</div>
	</form>
    <script>
        const senha = document.querySelector('.senha');
	const btn = document.querySelector('.btn');

	btn.onclick = () =>
	{
		if (senha.type === 'password') 
		{
			senha.type = 'text'
			btn.src = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR8SA14-A-zoRaiJ2GdUiESsisaFiHNYrUZtjtjZqnth0D_KdfkwzQWIdCjbzhAoYKPTvs&usqp=CAU'
		}
		else
		{
			senha.type = 'password'
			btn.src = 'https://icon-library.com/images/icon-eyes/icon-eyes-12.jpg'
		}
	}
    </script>
</body>
</html>