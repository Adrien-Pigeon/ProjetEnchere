<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
<style>
*
{
	margin: 0; padding: 0;
	font-family: sans-serif;
	box-sizing: border-box;
	outline: none;
}

body
{
	width: 100%;
	height: 100vh;
	background: #16b;
	display: flex;
	justify-content: center;
	align-items: center;
}

form
{
	width: 400px;
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, .2);
}
form .row
{
	position: relative;
	margin: 20px 0;
}
form input
{
	width: 100%;
	padding: 15px;
	border: 1px solid #777;
	border-radius: 5px;
	padding-right: 110px;
}
form input[type="submit"]
{
	background: #16b;
	color: #fff;
	font-size: 18px;
	border: none;
	cursor: pointer;
	padding-right: 0px;
}
form .row span,
form .row img
{
	position: absolute;
	top: 50%;
	right: 10px;
	color: #555;
	transform: translateY(-50%);
}
form .row img
{
	width: 40px;
	height: 40px;
	cursor: pointer;
}
form h1
{
	color: #16b;
	position: relative;
}
form h1:before
{
	content: '';
	position: absolute;
	width: 40px;
	height: 4px;
	bottom: 2px;
	background: #16b;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath() %>/login" method="post">
		<h1>Login</h1>
		<div class="row">
			<input type="text" name="username" placeholder="username">
			<span>username</span>
		</div>
		<div class="row">
			<input type="password" name="password" class="senha" placeholder="123456">
			<img src="https://icon-library.com/images/icon-eyes/icon-eyes-12.jpg" class="btn">
		</div>
		<input type="submit" value="Connexion">
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