<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudo sobre Servlets</title>
</head>
<body>

	<h1>Bem Vindo ao Formulário de Login!</h1>

	<form action="control" method="post">
		Usuário: <input type="text" name="usuario"> 
		<p>Senha: <input type="password" name="senha"> 
		<input type="hidden" name="acao" value="Login">
		<p><input type="submit">
	</form>

</body>
</html>