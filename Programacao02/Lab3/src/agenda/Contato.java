package agenda;

/**
 * Contato que podem ser cadastrados dentro da agenda.
 *
 * @author Luana Bringel Leite
 */
public class Contato {
	/**
	 * Recebe a posição do contato que será manipulado.
	 */
	private int posicao;

	/**
	 * Recebe o nome do contato.
	 */
	private String nome;

	/**
	 * Recebe o sobrenome do contato.
	 */
	private String sobrenome;

	/**
	 * Recebe o telefone do contato.
	 */
	private String telefone;

	/**
	 * Cria o contato a paritr do nome, posição, sobrenome e telefone digitados pelo
	 * usuário.
	 * 
	 * @param posicao   posicao do contato no array dos contatos (array Contato)
	 *                  escolhido pelo usuário.
	 * @param nome      nome do contato digitado pelo usuário.
	 * @param sobrenome sobrenome do contato digitado pelo usuário.
	 * @param telefone  telefone do contato digitado pelo usuário.
	 */
	public Contato(int posicao, String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.posicao = posicao;
	}

	/**
	 * Recebe o valor da posicao do contato, determinada pelo usuário.
	 * 
	 * @return Retorna a posição do contato registrado. (em inteiro).
	 */
	public int getPosicao() {
		return posicao;
	}

	/**
	 * Recebe o valor de telefone, determinado pelo usuário.
	 * 
	 * @return Retorna o telefone do contato registrado (em String).
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Recebe o valor do nome do contato, determiando pelo usuário.
	 * 
	 * @return Retorna o nome do contato registrado (em String).
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Recebe o valor do sobrenome do contato, determinado pelo usuário.
	 * 
	 * @return Retornar o sobrenome do contato registrado (em String).
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Retorna um texto com as informações do contato escolhido pelo usuário.
	 * 
	 * @return Retornar um texto com as informações do contato.
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome + "\n" + this.telefone + "\n";
	}

	/**
	 * Compara se dois nomes e sobrenomes, que o usuário quer cadastrar, são iguais.
	 * 
	 * @param o objeto que faz a comparação dos nomes e sobrenomes.
	 * @return Retornar se o nome e o sobrenome de dois contatos são iguais (true)
	 *         ou não (false).
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Contato contato = (Contato) o;
		return nome.equals(contato.nome) && sobrenome.equals(contato.sobrenome);
	}

	/**
	 * Compara se dois contatos tem o mesmo nome e sobrenome.
	 * 
	 * @param contatoAdicionado Contato que vai ser cadastrado no array de contatos.
	 * @param contatos          Array de contatos ja cadastrados.
	 * @return Retornar se o valor já for cadastrado (true) ou não (false).
	 */
	public static boolean verificaNome(Contato contatoAdicionado, Contato[] contatos) {
		boolean meuReturn = false;
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				if (contatos[i].equals(contatoAdicionado)) {
					meuReturn = true;
				}
			}
		}
		return meuReturn;
	}
}