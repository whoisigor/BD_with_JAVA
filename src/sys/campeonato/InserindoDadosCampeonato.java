package sys.campeonato;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import campeonato.Jogador;
import campeonato.Jogo;
import campeonato.Time;
import dao.JogadorDAO;
import dao.JogadorImpl;
import dao.JogoDAO;
import dao.JogoImpl;
import dao.TimeDAO;
import dao.TimeImpl;

public class InserindoDadosCampeonato {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner dados = new Scanner(System.in);
		TimeDAO timedao = new TimeImpl();
		JogadorDAO jogadordao = new JogadorImpl();
		JogoDAO jogodao = new JogoImpl();
		
		int opcao = 0;
		do {
			System.out.println("-------MENU---------");
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Time");
			System.out.println("2 - Inserir Jogador");		
			System.out.println("3 - Inserir Jogo");
			System.out.println("4 - Listar Jogos");
			System.out.println("5 - Listar Jogadores");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Digite o codigo do time");
				int cod = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do time");
				String nomeTime = dados.nextLine();
				System.out.println("Digite data fundação do time");
				String datafundacao = dados.nextLine();
				Time t = new Time(cod,nomeTime, datafundacao);
				timedao.salvarTime(t);
				break;
			case 2:
				System.out.println("Digite o codigo do jogador");
				int codJogador = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o codigo do time");
				int codTime = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o nome do jogador");
				String nome = dados.nextLine();
				System.out.println("Digite a idade do jogador");
				int idade = dados.nextInt();
				Jogador n = new Jogador(codJogador,codTime,nome,idade);
				jogadordao.salvarJogador(n);
				break;
			case 3:
				System.out.println("Digite o codigo do jogo");
				int codJogo = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o codigo do time A");
				int codTimeA = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o codigo do time B");
				int codTimeB = dados.nextInt();
				dados = new Scanner(System.in);
				System.out.println("Digite o resultado do jogo");
				String resultado = dados.nextLine();
				Jogo j = new Jogo(codJogo,codTimeA, codTimeB, resultado);
				jogodao.salvarJogo(j);
				break;
			case 4:
				List<Jogo> jogos = jogodao.listarTodosJogos();
				System.out.println("----- LISTA DE JOGOS -----");
				for(int i = 0; i < jogos.size(); i++) {
					System.out.println("Cod Jogo:" + jogos.get(i).getCod());
					System.out.println("Cod Time A:" + jogos.get(i).getTimea_cod());
					System.out.println("Cod Time B:" + jogos.get(i).getTimeb_cod());
					System.out.println("Resultado:" + jogos.get(i).getResultado() + "\n------------------");
				}
				break;
			case 5:
				List<Jogador> jogadores = jogadordao.listarTodosJogadores();
				System.out.println("----- LISTA DE JOGADORES -----");
				for(int i = 0; i < jogadores.size(); i++) {
					System.out.println("Cod jogador:"  + jogadores.get(i).getCod());
					System.out.println("Nome: " + jogadores.get(i).getNome());
					System.out.println("Cod Time Atual: " + jogadores.get(i).getTime_cod());
					System.out.println("Idade: " + jogadores.get(i).getIdade() + "\n------------------");
				}
				break;
			}
		}while(opcao != 0);
	}
}
