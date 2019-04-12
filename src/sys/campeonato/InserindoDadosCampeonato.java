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
			System.out.println("\n*        MENU DE OPCOES      *\n"
					+ "| -- |-----------------------|\n"
					+ "| OP |    Descrição da OP    |");
			System.out.println("| 0  | Sair");
			System.out.println("| 1  | Adicionar Time");
			System.out.println("| 2  | Adicionar Jogador");		
			System.out.println("| 3  | Registrar Jogo");
			System.out.println("| 4  | Selecionar Jogadores");
			System.out.println("| 5  | Selecionar Time");
			System.out.println("| 6  | Ver Resultado Jogo");
			System.out.println("| 7  | Deletar Jogador");
			System.out.println("| 8  | Deletar Time");
			System.out.println("| 9  | Deletar Jogo");
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
					List<Jogador> jogadores = jogadordao.listarJogadoresPorIdade(idadeJogador);
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
					List<Jogador> jogador = jogadordao.listarTodosJogadores();
					System.out.println("| Cod Jogador  | Cod Time | Idade    |       Nome      |\n" + 
							"|--------------|----------|----------|-----------------|");
					for(int i = 0; i < jogador.size(); i++) {
						System.out.println(jogador.get(i).toString());
					}
				}else {
					System.out.println("Essa opção ainda não tá disponível :/");
				}
				break;
			case 5:
				System.out.println("Selecione uma opção de busca\n"
						+ "1. Selecione times que vencedores\n"
						+ "2. Selecione todos os times\n"
						+ "3. Selecionar time por código");
				opQuery = sc.nextInt();
				if(opQuery == 1) {
					List<Time> vencedores = timedao.verTimesVencedores();
					System.out.println("Lista com times que venceram os últimos jogos");
					for(int i = 0; i < vencedores.size(); i++) {
						System.out.println(vencedores.get(i).toString());
					}
					System.out.println("Times empatados não são mostrados nesta lista.");
				}else if(opQuery == 2) {
					List<Time> times = timedao.listarTodosTimes();
					System.out.println("| Cod Time  |   Fundacao   | Nome Time       |\n" + 
							"|-----------|--------------|-----------------|");
					for(int i = 0; i < times.size(); i++) 
						System.out.println(times.get(i).toString());
					break;
				}else if (opQuery == 3) {
					System.out.println("Digite o código do time");
					codTime = sc.nextInt();
					Time resultTime = timedao.verTimePorCodigo(codTime);
					if(!resultTime.equals(null)) {
						System.out.println("Time Encontrado\n| Cod Time  |   Fundacao   | Nome Time       |\n" + 
								"|-----------|--------------|-----------------|\n" + 
								resultTime.toString());
					}else {
						System.out.println("Este time não existe :/");
					}
				}else {
					System.out.println("Essa opção ainda não tá disponível :/");
				}
				break;
			case 6:
				System.out.println("Digite o c�digo do Jogo");
				Jogo jogo = jogodao.verJogoPorCodigo(codJogo = sc.nextInt());
				if(!(jogo.equals(null))) {
					Time timeA = timedao.verTimePorCodigo(jogo.getTimea_cod());
					Time timeB = timedao.verTimePorCodigo(jogo.getTimeb_cod());
					String placar[] = new String[2];
					String xPlacar = jogo.getResultado();
					placar = xPlacar.split("x");
					System.out.println("Encontramos seu jogo no nosso B.D\n"
							+ "\nTime A: " + timeA.getNome() + " Marcou: " + placar[0]
							+ "\nTime B: " + timeB.getNome() + " Marcou: " + placar[1]
							+ "\nResultado do Jogo: "
							+ jogo.getResultado());
				}else {
					System.out.println("Este jogo não existe");
				}
				break;
			case 7:
				List<Jogador> jogador = jogadordao.listarTodosJogadores();
				System.out.println("Digite o código do jogador");
				codJogador = sc.nextInt();
				for(int i = 0; i < jogador.size(); i++) {
					if(jogador.get(i).getCod() == codJogador) {
						jogadordao.deletarJogador(jogador.get(i));
						System.out.println("Jogador deletado com sucesso.");
						break;
					}else {
						if(i == (jogador.size() - 1)) {
							System.out.println("Este código de jogador não existe.");
						}
					}
				}
				break;
			case 8:
				List<Time> times = timedao.listarTodosTimes();
				System.out.println("Digite o código do Time");
				codTime = sc.nextInt();
				for(int i = 0; i < times.size(); i++) {
					if(times.get(i).getCod() == codTime) {
						timedao.deletarTime(times.get(i));
						System.out.println("Time deletado com sucesso.");
						break;
					}else {
						if(i == (times.size() - 1)) {
							System.out.println("Este c�digo de time n�o existe"); /*NÃO CONSIGO APAGAR TIME PLACIDO HELPME*/
						}
					}
				}
				break;
			case 9:
				List<Jogo> jogos = jogodao.listarTodosJogos();
				System.out.println("Digite o código do Jogo");
				codJogo = sc.nextInt();
				for(int i = 0; i < jogos.size(); i++) {
					if(jogos.get(i).getCod() == codJogo) {
						jogodao.deletarJogo(jogos.get(i));
						System.out.println("Jogo deletado com sucesso.");
						break;
					}else {
						if(i == (jogos.size() - 1)) {
							System.out.println("Este código de jogo não existe.");
						}
					}
				}
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
