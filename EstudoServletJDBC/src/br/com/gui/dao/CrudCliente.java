package br.com.gui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gui.database.Database;
import br.com.gui.model.Cliente;

public class CrudCliente {

	public String inserirCliente(Cliente cliente) {

		Database db = new Database();
		Connection conn = db.conectaBd();
		String sql = "INSERT INTO CLIENTE (NOME, ENDERECO) VALUES (?,?)";
		String retorno = null;

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEndereco());
			int sucesso = pst.executeUpdate();
			if (sucesso > 0) {
				retorno = "sim";
			} else {
				retorno = "nao";
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao inserir cliente:" + ex);
		}

		return retorno;
	}
	
	public String alterarCliente(Cliente cliente) {

		String retorno = null;

		Database db = new Database();
		Connection conn = db.conectaBd();

		String sql = "UPDATE CLIENTE SET NOME=?, ENDERECO=? WHERE ID=?";

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEndereco());
			pst.setInt(3, cliente.getId());
			int sucesso = pst.executeUpdate();
			if (sucesso > 0) {
				retorno = "sim";
			} else {
				retorno = "nao";
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao alterar cliente: " + ex);
		} finally {
			db.desconectaBd(conn);
		}
		return retorno;

	}
	
	public String excluirCliente(Cliente cliente) {

		String retorno = null;
		String sql = "DELETE FROM CLIENTE WHERE ID=?";

		Database db = new Database();
		Connection conn = db.conectaBd();

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, cliente.getId());
			int sucesso = pst.executeUpdate();
			if (sucesso > 0) {
				retorno = "sim";
			} else {
				retorno = "nao";
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao excluir cliente: " + ex);
		}

		return retorno;
	}
	
	public List<Cliente> listarClientes() {

		List<Cliente> lista = new ArrayList<Cliente>();

		String sql = "SELECT ID, NOME, ENDERECO FROM CLIENTE";

		Database database = new Database();
		Connection conn = database.conectaBd();
		Cliente cliente = new Cliente();

		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Cliente cl = new Cliente();
				cl.setId(rs.getInt("ID"));
				cl.setNome(rs.getString("NOME"));
				cl.setEndereco(rs.getString("ENDERECO"));
				lista.add(cl);
			}
		} catch (SQLException ex) {
			System.out.println("Erro ao listar clientes: " + ex);
		} finally {
			database.desconectaBd(conn);
		}

		return lista;
	}

}
