package br.com.gui.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gui.database.Database;

public class Login implements Acao {

	public String acoes(HttpServletRequest request, HttpServletResponse response) {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");

		Database database = new Database();
		Connection conn = database.conectaBd();

		try {
			String sql = "SELECT USUARIO FROM USUARIOS WHERE USUARIO=? AND SENHA=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, usuario);
			pst.setString(2, senha);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				request.getSession().setAttribute("usuario", usuario);
				return "redirect:control?acao=Index";
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao consultar usuário: " + ex);
		} finally {
			database.desconectaBd(conn);
		}
		return "forward:/Login.jsp";

	}

}
