package br.com.gui.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index implements Acao {

	@Override
	public String acoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = (String) request.getSession().getAttribute("usuario");
		if (usuario == null) {
			return "forward:/Login.jsp";
		}
		return "forward:/Index.jsp";
	}

}
