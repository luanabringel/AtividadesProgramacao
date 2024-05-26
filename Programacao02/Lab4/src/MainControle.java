import java.util.Scanner;
/**
 * Main para imprimir e receber informações do usuário, com os comandos necessarios para
 * controlar e criar alunos e grupos.
 * 
 * @author Luana Bringel Leite
 *
 */

public class MainControle {
	/**
	 * Construindo o main de controle.
	 * 
	 * @param args Argumentos.
	 */
    public static void main(String[] args){
        Controle controle = new Controle();
        Scanner scanner = new Scanner(System.in);
        String escolha = "";
        while (true) {
            escolha = menu(scanner);
            comando(escolha, controle, scanner);
        }
    }
    /**
     * Exibe o menu e captura a escolha do/a usuário/a.
     *
     * @param scanner Para captura da opção do usuário.
     * @return O comando escolhido.
     */
    private static String menu(Scanner scanner) {
        System.out.println(
                "\n---\nMENU\n" +
                        "(C)adastrar Aluno\n" +
                        "(E)xibir Aluno\n" +
                        "(N)ovo Grupo\n" +
                        "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
                        "(O)lhaí quais Grupos o Aluno Tá.\n" +
                        "(S)im, quero Fechar o Programa!\n" +
                        "\n" +
                        "Opção> ");
        return scanner.next().toUpperCase();
    }

    /**
     * Interpreta a opção escolhida por quem está usando o sistema.
     *
     * @param opcao   Opção digitada.
     * @param controle  O controle que estamos manipulando.
     * @param scanner Objeto scanner para o caso do comando precisar de mais input.
     */
    private static void comando(String opcao, Controle controle, Scanner scanner) {
        switch (opcao) {
            case "C":
                cadastrarAluno(controle, scanner);
                break;
            case "E":
                exibirAluno(controle, scanner);
                break;
            case "N":
                cadastrarGrupo(controle, scanner);
                break;
            case "A":
                alocarPertinencia(controle, scanner);
                break;
            case "O":
                listarGruposAluno(controle, scanner);
                break;
            case "S":
                sai();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    /**
     * Cadastra os alunos.
     * 
     * @param controle Controle de alunos e grupos.
     * @param scanner Scanner do teclado.
     */
	private static void cadastrarAluno(Controle controle, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Curso: ");
        String curso = scanner.nextLine();
        System.out.println(controle.cadastrarAluno(matricula, nome, curso));
    }

	/**
	 * Exibe as informações do aluno.
	 * 
	 * @param controle Controle de alunos e grupos.
	 * @param scanner Scanner do teclado.
	 */
    private static void exibirAluno(Controle controle, Scanner scanner) {
        scanner.nextLine();
        System.out.println("Matricula: ");
        String matricula = scanner.nextLine();
        System.out.println(controle.exibirAluno(matricula));
    }

    /**
     * Cadastra os grupos.
     * 
     * @param controle O controle de alunos e grupos.
     * @param scanner Scanner do teclado.
     */
    private static void cadastrarGrupo(Controle controle, Scanner scanner) {
        System.out.println("Grupo: ");
        String nome = scanner.next();
        System.out.println("Tamanho: ");
        int tamanho = scanner.nextInt();
        System.out.println(controle.cadastrarGrupo(nome));
    }

    /**
     * Verifica se a opção é de alocar ou verificar pertinencia.
     * Alocando alunos em grupos ou verificando se um aluno faz parte de um determinado grupo.
     * 
     * @param controle O controle de alunos e grupos.
     * @param scanner Scanner do teclado.
     */
    public static void alocarPertinencia(Controle controle, Scanner scanner){
        scanner.nextLine();
        System.out.println("(A)locar Aluno ou (P)ertinência a Grupo? ");
        String opcao = scanner.nextLine().toUpperCase();
        if(opcao.equals("A")){
            System.out.println("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.println("Grupo: ");
            String grupo = scanner.nextLine();
            System.out.println(controle.alocarAluno(matricula, grupo));
        }else if(opcao.equals("P")){
            System.out.println("Grupo: ");
            String grupo = scanner.nextLine();
            System.out.println("Aluno: ");
            String matricula = scanner.nextLine();
            System.out.println(controle.verificarPertinencia(grupo, matricula));
        }
    }

    /**
     * Lista os grupos que o aluno faz parte.
     * 
     * @param controle O controle de alunos e grupos.
     * @param scanner Scanner do teclado.
     */
    public static void listarGruposAluno(Controle controle, Scanner scanner){
        scanner.nextLine();
        System.out.println("Aluno: ");
        String matricula = scanner.nextLine();
        System.out.println(controle.listarGruposAluno(matricula));
    }

    /**
     * Sai da aplicação.
     */
    private static void sai() {
        System.out.println("\nTchau! Obrigada! o/");
        System.exit(0);
    }
}