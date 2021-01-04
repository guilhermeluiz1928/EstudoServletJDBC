<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudo sobre Servlets</title>
</head>
<body>

	<h1>Cadastro de Clientes:</h1>

	<form action="control">
		<p>
			Nome: <input type="text" name="nome">
		</p>
		<p>
			Endereço: <input type="text" name="endereco">
		</p>
		<input type="hidden" name="acao" value="Inserir">
		<input type="hidden" name="tipo" value="executa">
		<p>
			<input type="submit">
		</p>	
	</form>

</body>
</html>