package br.com.gui.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gui.control.Acao;

@WebServlet("/control")
public class ServletControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tipAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.gui.control." + tipAcao;
		String url = null;
		
		// redireciona se não acha nenhuma ação
		if (tipAcao == null) {
			return;
		}

		// trata as acoes
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			url = acao.acoes(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		// trata as requisições
		String[] tipreq = url.split(":");
		if (tipreq[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipreq[1]);
			rd.forward(request, response);
		} else if (tipreq[0].equals("redirect")) {
			response.sendRedirect(tipreq[1]);
		}

	}

}
