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
			System.out.println("\n|------ MENU DE OPCOES ------|\n"
					+ "| -- |-----------------------|\n"
					+ "| OP |    Descrição da OP    |");
			System.out.println("| 0  | Sair");
			System.out.println("| 1  | Adicionar Time");
			System.out.println("| 2  | Adicionar Jogador");		
			System.out.println("| 3  | Registrar Jogo");
			System.out.println("| 4  | Listar Jogadores");
			System.out.println("| 5  | Listar Times");
			System.out.println("| 6  | Selecionar Jogadores");
			System.out.println("| 7  | Selecionar Time");
			System.out.println("| 8  | Ver Resultado Jogo");
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
				Time t = new Time(cod, nomeTime, datafundacao);
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
				List<Jogador> jogadores = jogadordao.listarTodosJogadores();
				System.out.println("| Cod Jogador | Cod Time | Idade    |       Nome      |\n" + 
						"|-------------|----------|----------|-----------------|");
				for(int i = 0; i < jogadores.size(); i++) {
					System.out.println(jogadores.get(i).toString());
				}
				break;
			case 5:
				List<Time> times = timedao.listarTodosTimes();
				System.out.println("| Cod Time |   Fundacao   | Nome Time       |\n" + 
						"|----------|--------------|-----------------|");
				for(int i = 0; i < times.size(); i++) 
					System.out.println(times.get(i).toString());
				break;
			case 6:
				System.out.println("Olá, digite uma opcao para selecao\n"
						+ "1. Verifica se um jogador está em um time Especifico\n"
						+ "2. Selecionar jogadores com idade X\n"
						+ "3. Selecionar jogador por código\n"
						+ "4. Selecionar todos os jogadores");
				int codigoTime, idadeJogador, codigoJogador, opQuery = sc.nextInt();
				if(opQuery == 1) {
					System.out.println("Digite o código do Jogador");
					codigoJogador = sc.nextInt();
					System.out.println("Digite o código do Time");
					codigoTime = sc.nextInt();
					Jogador novo = jogadordao.verJogadorDeTime(codigoTime,codigoJogador);
					if(novo.equals(null)) 
						System.out.println("Este jogador não está neste time");
					else
						System.out.println("Seu jogador está no time\n"
								+ "| Cod Jogador | Cod Time | Idade    |       Nome      |\n" + 
								"|-------------|----------|----------|-----------------|");
						System.out.println(novo.toString());
				}else if(opQuery == 2) {
					System.out.println("Qual idade dos jogadores?");
					idadeJogador = sc.nextInt();
					jogadores = jogadordao.listarJogadoresPorIdade(idadeJogador);
					if(!(jogadores.isEmpty())) {
						System.out.println("Encontramos estes jogadores com esta idade\n| Cod Jogador | Cod Time | Idade    |       Nome      |\n" + 
								"|-------------|----------|----------|-----------------|");
						for(int i = 0; i < jogadores.size(); i++) {
							System.out.println(jogadores.get(i).toString());
						}
					}else {
						System.out.println("Não acredito que nenhum time tem um jogador com idade que você solicitou, "
								+ "que tal tentar na próxima?");
					}
				}else if(opQuery == 3) {
					System.out.println("Digite o código do jogador");
					codigoJogador = sc.nextInt();
					Jogador novo = jogadordao.verJogadorPorCodigo(codigoJogador);
					if(novo.equals(null)) {
						System.out.println("Você acredita que não existe nenhum jogador com esse código? Pois é.");
					}else {
						System.out.println("\nEncontramos o jogador do codigo " + codigoJogador + " algumas infos sobre ele abaixo\n"
								+ "| Cod Jogador | Cod Time | Idade    |       Nome      |\n" +
								"|-------------|----------|----------|-----------------|\n"
								+ novo.toString());
					}
				}else if (opQuery == 4) {
					List<Jogo> jogos = jogodao.listarTodosJogos();
					System.out.println("| Cod Jogo | Cod Time A | Cod Time B | Resultado |\n" + 
							"|----------|------------|------------|-----------|");
					for(int i = 0; i < jogos.size(); i++) {
						System.out.println(jogos.get(i).toString());
					}
				}else {
					System.out.println("Essa opção ainda não tá disponível :/");
				}
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				System.out.println("Ops... Parece que tu digitou algo inválido.\n"
						+ "Vamos tentar novamente? Y/ sim ou N/ nao");
				char tentar = sc.next().charAt(0);
				if(tentar == 'n' || tentar == 'n') opcao = 0;
			}
		}while(opcao != 0);
	}
}
