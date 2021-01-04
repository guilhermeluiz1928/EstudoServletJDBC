package br.com.gui.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gui.dao.CrudCliente;
import br.com.gui.model.Cliente;

public class Excluir implements Acao {

	@Override
	public String acoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cliente cliente = new Cliente();
		cliente.setId(Integer.parseInt(request.getParameter("id")));
		CrudCliente crud = new CrudCliente();
		String sucesso = crud.excluirCliente(cliente);

		if (sucesso.equals("sim")) {
			return "redirect:control?acao=Index";
		}

		return "redirect:control?acao=Index";
	}

}
