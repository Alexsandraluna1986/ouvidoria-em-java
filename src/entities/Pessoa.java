package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + "]";
	}

	public int getPessoaId(Connection con) {
		String sql = "select id from pessoa where cpf = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, this.cpf);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return resultado.getInt("id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void inserir(Connection con) {
		String sql = "insert into pessoa (nome, cpf) values ('" + this.nome + "','" + this.cpf + "')";
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
			System.out.println("dados salvos no banco");
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		}
	public static String listarPessoaId (Connection con, int id) {
		String sql = "select * from Pessoa where id = (?)";
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, id);
			ResultSet resultado = s.executeQuery();
			resultado.next();
			return "Nome: " + resultado.getString("Nome") + "CPF: " + resultado.getString("cpf");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}
	}


