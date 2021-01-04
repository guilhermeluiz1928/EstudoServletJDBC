package br.com.gui.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gui.dao.CrudCliente;
import br.com.gui.model.Cliente;

public class Editar implements Acao {

	@Override
	public String acoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipo = request.getParameter("tipo");

		if (tipo.equals("redirect")) {
			String usuario = (String) request.getSession().getAttribute("usuario");
			if (usuario == null) {
				return "forward:/Login.jsp";
			}
			return "forward:/Editar.jsp";
		} else if (tipo.equals("executa")) {
			Cliente cliente = new Cliente();
			cliente.setId(Integer.parseInt(request.getParameter("id")));
			cliente.setNome(request.getParameter("nome"));
			cliente.setEndereco(request.getParameter("endereco"));

			CrudCliente crud = new CrudCliente();
			String sucesso = crud.alterarCliente(cliente);

			if (sucesso.equals("sim")) {
				return "redirect:control?acao=Index";
			}

			return "redirect:control?acao=Index";
		}
		
		return "redirect:control?acao=Index";

	}

}
