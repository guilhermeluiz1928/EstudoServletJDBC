<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudo sobre Servlets</title>
</head>
<body>

	<h1>Alteração de Cadastro:</h1>

	<form action="control">
		<p>
			Nome: <input type="text" name="nome"
				value="<%=request.getParameter("nome")%>">
		</p>
		<p>
			Endereço: <input type="text" name="endereco"
				value="<%=request.getParameter("endereco")%>">
		</p>
		<input type="hidden" name="id" value="<%=request.getParameter("id")%>">
		<input type="hidden" name="acao" value="Editar">
		<input type="hidden" name="tipo" value="executa">
		<p>
			<input type="submit">
		</p>	
	</form>

</body>
</html>