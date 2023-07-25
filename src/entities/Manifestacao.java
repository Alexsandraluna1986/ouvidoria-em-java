package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Manifestacao {
	private String tipo;
	private String texto;
	Pessoa pessoa;

	public Manifestacao(Pessoa pessoa, String texto) {
		super();
		this.pessoa = pessoa;
		this.texto = texto;
	}

	public Pessoa getPessoa() {
		return getPessoa();
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public void inserirManifestacoes(Connection con) {
		try {
			String sql = "insert into manifestacao (tipo, texto, pessoa_id) values (?, ?, ?)";
			PreparedStatement s = con.prepareStatement(sql);
			s.setString(1, this.tipo);
			s.setString(2, this.texto);
			s.setInt(3, this.pessoa.getPessoaId(con));
			s.executeUpdate();
			System.out.println("dados salvos no banco");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void listar(Connection con) {
		try {
			String sql = "select * from manifestacao";
			Statement s = con.createStatement();
			ResultSet resultado = s.executeQuery(sql);
			while (resultado.next()) {
				System.out.printf("Id: %d / Tipo: %s / Texto: %s, %s%n", resultado.getInt("id"),
						resultado.getString("tipo"),resultado.getString("texto"),
						Pessoa.listarPessoaId(con, resultado.getInt("pessoa_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void apagarManifestacoes(Connection con, int id) {
		String sql;
		if (id ==0) {
			sql = "truncate manifestacao";
		}
		else {
			sql = "delete from manifestacao where id = " + id;
		}
		try {
			Statement s = con.createStatement();
			s.executeUpdate(sql);
		System.out.println("Apagado com sucesso");
		}catch(SQLException e){
			e.printStackTrace();
		}
		{
			
		}
	}
}
