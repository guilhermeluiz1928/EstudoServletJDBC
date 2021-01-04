package br.com.gui.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gui.dao.CrudCliente;
import br.com.gui.model.Cliente;

public class Inserir implements Acao {

	@Override
	public String acoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String tipo = request.getParameter("tipo");

		if (tipo.equals("redirect")) {
			String usuario = (String) request.getSession().getAttribute("usuario");
			if (usuario == null) {
				return "forward:/Login.jsp";
			}
			return "forward:/Inserir.jsp";
		} else if (tipo.equals("executa")) {
			String sucesso;
			Cliente cliente = new Cliente();
			CrudCliente crud = new CrudCliente();
			cliente.setNome(request.getParameter("nome"));
			cliente.setEndereco(request.getParameter("endereco"));
			sucesso = crud.inserirCliente(cliente);

			if (sucesso.equals("sim")) {
				return "redirect:control?acao=Index";
			}

			return "redirect:control?acao=Index";
		}
		
		return "redirect:control?acao=Index";

	}

}
