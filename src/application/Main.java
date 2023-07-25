package application;

import java.sql.Connection;
import java.util.Scanner;

import bd.BD;
import entities.Elogio;
import entities.Manifestacao;
import entities.Pessoa;
import entities.Reclamacao;
import entities.Sugestao;

public class Main {
	public static void main(String[] args) {

		Connection con = BD.getConnection();
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		String nome, cpf;
		System.out.println("------------------------SEJA BEM-VINDO(A) A OUVIDORIA---------------------------");
		System.out.println("Digite seu nome: ");
		nome = sc.nextLine();
		System.out.println("Digite seu CPF: ");
		cpf = sc.nextLine();
		Pessoa pessoa = new Pessoa(nome, cpf);
		pessoa.inserir(con);

		while (opcao != 6) {

			System.out.println("--SE DESEJA INSERIR UMA MANIFESTAÇÃO-- ");
			System.out.println();
			System.out.println("DIGITE:  1- Elogio  2- Reclamação  3- Sugestão");
			System.out.println();
			System.out.println("SE DESEJA LISTAR AS MANIFESTAÇÕES - DIGITE 4");
			System.out.println();
			System.out.println("SE DESEJA APAGAR MANIFESTAÇÕES - DIGITE 5 ");
			System.out.println();
			System.out.println("SE DESEJA SAIR DO SISTEMA - DIGITE 6 ");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1: 
				System.out.println(" Digite o seu elogio: ");
				String texto = sc.nextLine();
				Manifestacao elogio = new Elogio(texto, pessoa);
				elogio.inserirManifestacoes(con);
				
				break;
			case 2:
				System.out.println(" Digite a sua reclamação: ");
				texto = sc.nextLine();
				Manifestacao reclamacoes = new Reclamacao(texto, pessoa);
				reclamacoes.inserirManifestacoes(con);
				
				break;
			case 3:
				System.out.println(" Digite sua sugestão: ");
				texto = sc.nextLine();
				Manifestacao sugestoes = new Sugestao(texto, pessoa);
				sugestoes.inserirManifestacoes(con);
				
				break;
			case 4:
				System.out.println("Lista de manifestações: ");
				System.out.println();
				Manifestacao.listar(con);
				break;
			case 5:
				Manifestacao.listar(con);
				System.out.println("Qual o item que deseja apagar? ");
				int item = sc.nextInt();
				Manifestacao.apagarManifestacoes(con, item);
				break;
			case 6:
				System.out.println("Obrigado(a) pela visita.");
				break;
			}
		}
		System.out.println("Obrigado(a) pela visita.");
		sc.close();
	}
}
