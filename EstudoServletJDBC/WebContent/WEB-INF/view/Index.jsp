<%@page import="br.com.gui.dao.CrudCliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="br.com.gui.model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Estudo sobre Servlets</title>
</head>
<body>

	<%
		String usuario = (String) request.getSession().getAttribute("usuario");
	%>

	<p>
	<h1>
		Bem Vindo:
		<%=usuario%></h1>
	</p>

	<p>
	<h1>Lista de Clientes:</h1>
	</p>

	<%
		CrudCliente crud = new CrudCliente();
	List<Cliente> lista = new ArrayList<Cliente>();
	lista = crud.listarClientes();
	%>

	<table border="1">
		<tr>
			<td>Código</td>
			<td>Nome</td>
			<td>Endereço</td>
			<td></td>
			<td></td>
		</tr>
		<%
			for (Cliente cl : lista) {
		%>
		<tr>
			<td><%=cl.getId()%></td>
			<td><%=cl.getNome()%></td>
			<td><%=cl.getEndereco()%></td>
			<td><a
				href="/EstudoServletJDBC/control?acao=Editar&tipo=redirect&nome=<%=cl.getNome()%>&endereco=<%=cl.getEndereco()%>&id=<%=cl.getId()%>">Editar</a></td>
			<td><a
				href="/EstudoServletJDBC/control?acao=Excluir&id=<%=cl.getId()%>">Excluir</a></td>
		</tr>
		<%
			}
		%>

	</table>

	<br>
	<a href="/EstudoServletJDBC/control?acao=Inserir&tipo=redirect">Novo</a>
	<p>
		<a href="/EstudoServletJDBC/control?acao=Deslogar">Deslogar</a>
	</p>

</body>
</html>