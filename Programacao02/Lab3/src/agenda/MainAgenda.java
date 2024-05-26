package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface da agenda com menu e textos que interagem com o usuário. A agenda
 * criada mantem os contatos registrados pelo usuário (valor mámixmo de 100
 * contatos), há opções de manipulções com os contatos, como: cadastrar, listar,
 * remover, favoritar e exibir. Bônus: comando remover permanentemente um
 * contato da agenda.
 *
 * @author Luana Bringel Leite
 *
 */
public class MainAgenda {
	/**
	 * Cria uma agenda que recebe contatos.
	 * 
	 * @param args Argumentos do main.
	 */
	public static void main(String[] args) {
		/**
		 * Cria uma agenda.
		 */
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo.
			 */
			carregaAgenda("src/main/java/agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Lê uma agenda de um arquivo csv.
	 *
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda          A agenda que deve ser populada com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();

		int carregados = leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 *
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println("\n---\n" + "MENU\n" + "(C)adastrar Contato\n" + "(L)istar Contatos\n" + "(E)xibir Contato\n"
				+ "(F)avoritos\n" + "(A)dicionar Favorito\n" + "(R)emover Favorito\n" + "(X)Remover Contato\n"
				+ "(S)air\n" + "\n" + "Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 *
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			cadastraFavorito(agenda, scanner);
			break;
		case "X":
			removeContato(scanner, agenda);
			break;
		case "S":
			sai();
			break;
		case "R":
			removeFavorito(scanner, agenda);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Formata o contato para impressão na interface.
	 *
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + 1 + " - " + contato.getNome() + " " + contato.getSobrenome();
	}

	/**
	 * Cadastra um novo contato na agenda. Contato só pode ser cadastrado se o nome
	 * e telefone não forem vázios, obrigatoriamente.
	 *
	 * @param agenda  A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		int posicao;
		System.out.print("\nPosição na agenda> ");
		posicao = scanner.nextInt();
		clearBuffer(scanner);
		if (agenda.verificaPosicao(posicao)) {
			System.out.println("Posição Inválida");
		} else {
			System.out.print("\nNome> ");
			String nome = scanner.nextLine();
			if (agenda.verificaNome(nome)) {
				System.out.println("Contato Inválido");
			} else {
				System.out.print("\nSobrenome> ");
				String sobrenome = scanner.nextLine();
				System.out.print("\nTelefone> ");
				String telefone = scanner.nextLine();
				if (agenda.verificaTelefone(telefone)) {
					System.out.println("Contato Inválido");
				} else {
					agenda.cadastraContato(posicao, nome, sobrenome, telefone);
				}
			}
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Cadastra um favorito a partir do array de contatos.
	 *
	 * @param agenda  A agenda de contatos.
	 * @param scanner Scanner para leitura de dados.
	 */
	private static void cadastraFavorito(Agenda agenda, Scanner scanner) {
		int posicaoContato;
		int posicaoFavorito;
		System.out.println("Contato>");
		posicaoContato = scanner.nextInt();
		System.out.println("Posicao>");
		posicaoFavorito = scanner.nextInt();
		agenda.cadastraFavorito(posicaoContato, posicaoFavorito);
	}

	/**
	 * Imprime a lista de contatos favoritados da agenda. "Contato[] favoritos" é o
	 * array dos contatos favoritados pelo usuário.
	 *
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\nLista de Favoritos: ");
		Contato[] favoritos = agenda.getFavoritos();
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				System.out.println(formataContato(i, favoritos[i]));
			}
		}
	}

	/**
	 * Exibe os detalhes do contato escolhido pelo usuário da agenda.
	 *
	 * @param agenda  A agenda manipulada.
	 * @param scanner Scanner para ler o contato escolhido pelo usuário.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		String contato = agenda.getContato(posicao - 1);
		System.out.println("Dados do contato:\n" + contato);
	}

	/**
	 * Limpeza do buffer do teclado.
	 *
	 * @param scanner Scanner para leitura de entradas.
	 */
	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}

	/**
	 * Remove um contato cadastrado permanentemente, seja ele favorito ou não.
	 *
	 * @param agenda  Agenda de contatos.
	 * @param scanner Scanner para leitura de dados digitados pelo usuário.
	 */
	private static void removeContato(Scanner scanner, Agenda agenda) {
		String posicoes;
		System.out.print("\nContato(s)> ");
		posicoes = scanner.next();
		clearBuffer(scanner);
		agenda.removeContato(posicoes);
	}

	/**
	 * Remove um contato, determinado pelo usuário, dos favoritos.
	 * 
	 * @param agenda  Agenda de contatos.
	 * @param scanner Scanner para leitura de dados digitados pelo usuário.
	 */
	private static void removeFavorito(Scanner scanner, Agenda agenda) {
		int posicaoFavorito;
		System.out.print("\nPosicao> ");
		posicaoFavorito = scanner.nextInt();
		agenda.removeFavorito(posicaoFavorito);
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}
}