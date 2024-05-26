package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 *
 * @author Luana Bringel Leite
 */
public class Agenda {

	/**
	 * Cria o array dos contatos registrados.
	 */
	public Contato[] contatos;

	/**
	 * Cria o array dos contatos favoritados.
	 */
	public Contato[] favoritos;

	/**
	 * Recebe o nome do contato cadastrado.
	 */
	public String nome;

	/**
	 * Recebe o sobrenome do contato cadastrado.
	 */
	public String sobrenome;

	/**
	 * Recebe o telefone do contato cadastrado.
	 */
	public String telefone;

	/**
	 * Cria uma agenda. Determina o tamanho máximo dos contatos (100) e o tamanho
	 * máximo dos favoritos (10).
	 */
	public Agenda() {
		this.favoritos = new Contato[10];
		this.contatos = new Contato[100];
	}

	/**
	 * Acessa a lista de contatos registrados.
	 *
	 * @return Retorna o array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa a lista de contatos favoritados.
	 *
	 * @return Retorna o array de favoritos.
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa as infromações cadastradas do contato escolhido pelo usuário.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Retorna as infromações do contato, e se não houver contato na posição
	 *         retorna null.
	 */
	public String getContato(int posicao) {
		if (contatos[posicao] != null && existe(posicao + 1)) {
			return "❤️ " + contatos[posicao].toString();
		} else if (contatos[posicao] != null) {
			return contatos[posicao].toString();
		} else {
			return "Posição Inválida!";
		}
	}

	/**
	 * Cadastra um contato em uma posição. Se um contato já estiver cadastrado na
	 * posição escolhida, o novo contato será sobrescrito no contato anterior.
	 *
	 * @param posicao   Posição do contato, determinado pelo usuário.
	 * @param nome      Nome do contato, determinado pelo usuário.
	 * @param sobrenome Sobrenome do contato, determinado pelo usuário.
	 * @param telefone  Telefone do contato, determinado pelo usuário.
	 * @return Retornar um texto avisando se o contato foi cadastrado ou se esse
	 *         contato já havia sido cadastrado anteriormente.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato contato = new Contato(posicao, nome, sobrenome, telefone);
		this.telefone = telefone;
		this.nome = nome;
		this.sobrenome = sobrenome;
		if (Contato.verificaNome(contato, contatos)) {
			System.out.println("Contato já cadastrado");
			return "Contato já cadastrado";
		} else {
			this.contatos[posicao - 1] = contato;
			System.out.println("Contato cadastrado!");
			return "Contato cadastrado!";
		}
	}

	/**
	 * Verifica se o contato já está cadastrado no array dos favoritos.
	 *
	 * @param posicaoContato Posicao do contato que será verificado no array de
	 *                       favoritos.
	 * @return Retorna se o contato já está registrado (true) ou não (false).
	 */
	public boolean existe(int posicaoContato) {
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				if (favoritos[i].equals(contatos[posicaoContato - 1])) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Cadastra um contato no array dos favoritos.
	 *
	 * @param posicaoContato  Posicao do contato que o usuário quer cadastrar como
	 *                        favorito.
	 * @param posicaoFavorito Posição que o contato favoritado no array dos
	 *                        favoritos.
	 * @return Retornar um texto avisando se o contato foi favoritado ou não.
	 */
	public String cadastraFavorito(int posicaoContato, int posicaoFavorito) {
		if (existe(posicaoContato)) {
			System.out.println("Favorito já cadastrado");
			return "Favorito já cadastrado";
		} else {
			favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
			System.out.println("Favorito cadastrado na posição " + posicaoFavorito + "!");
			return "Favorito cadastrado na posição " + posicaoFavorito + "!";
		}
	}

	/**
	 * Remove um contato determinado pelo usuário dos favoritos.
	 * 
	 * @param posicaoFavorito recebe a posição em que o favorito foi registrado.
	 */
	public void removeFavorito(int posicaoFavorito) {
		posicaoFavorito--;
		this.favoritos[posicaoFavorito] = null;
	}

	/**
	 * Acessa o array de favoritos e retorna o contato na posição escolhida.
	 * 
	 * @param posicaoFavorito Recebe a posição em que o contato está favoritado.
	 * @return Retorna o valor da posição escolhida.
	 */
	public Contato getFavorito(int posicaoFavorito) {
		return this.favoritos[posicaoFavorito];
	}

	/**
	 * Verifica a posição para saber se é valida ou não.
	 * 
	 * @param posicao Posicao determinada pelo usuário para o contato ser
	 *                cadastrado.
	 * @return Retorna true para uma posição inválida, e false caso a posição seja
	 *         válida.
	 */
	public boolean verificaPosicao(int posicao) {
		return posicao > 100 || posicao < 1;
	}

	/**
	 * Verifica se o nome é vazio ou não.
	 * 
	 * @param nome Nome do contato cadastrado, determinado pelo usuário.
	 * @return Retonar true se o nome for vazio, e retorna false para o nome não
	 *         vazio.
	 */
	public boolean verificaNome(String nome) {
		return nome.isEmpty();
	}

	/**
	 * Verifica se o telefone é vazio ou não.
	 * 
	 * @param telefone Telefone do contato cadastrado, determinado pelo usuário.
	 * @return Retornar true para o telefone vazio, e false se o telefone for não
	 *         vazio.
	 */
	public boolean verificaTelefone(String telefone) {
		return telefone.isEmpty();
	}

	/**
	 * Remove um contato permanentemente, seja ele favorito ou não.
	 *
	 * @param posicoes Posição em que o contato que será removido foi adicionado.
	 * @return Retornar um texto avisando se o contato foi removido ou não.
	 */
	public String removeContato(String posicoes) {
		for (int i = 0; i < contatos.length; i++) {
			for (String j : posicoes.split(",")) {
				if (i == Integer.parseInt(j)) {
					if (contatos[i - 1] != null) {
						for (int k = 0; k < favoritos.length; k++) {
							if (favoritos[k] != null) {
								if (favoritos[k].equals(contatos[i - 1])) {
									favoritos[k] = null;
								}
							}
						}
						contatos[i - 1] = null;
						return "Contato removido";
					} else {
						System.out.println("Posição inválida!");
						return "Posição inválida!";
					}
				}
			}
		}
		return "Posição inválida!";
	}
}