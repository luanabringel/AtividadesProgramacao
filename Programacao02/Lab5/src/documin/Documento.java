package documin;

import java.util.ArrayList;

/**
 * Constrói o documento e os elementos.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Documento {
	/**
	 * @param tamanho Tamanho do documento.
	 */
	private int tamanho;
	/**
	 * @param titulo Título do documento.
	 */
	private String titulo;
	/**
	 * @param elementos Array com todos os elementos.
	 */
	private ArrayList<Elemento> elementos;
	
	/**
	 * Inicializa o documento sem tamanho.
	 * 
	 * @param titulo O titulo do documento
	 */
	public Documento(String titulo) {
		this.titulo = titulo;
		this.elementos = new ArrayList<>();
	}
	
	/**
	 * Inicializa o documento com tamanho.
	 * 
	 * @param titulo O titulo do documento.
	 * @param tamanho O tamanho do documento.
	 */
	public Documento(String titulo, int tamanho) {
		this.elementos = new ArrayList<>();
		this.titulo = titulo;
		this.tamanho = tamanho;
	}
	
	/**
	 * Acessa o título do documento.
	 * 
	 * @return Retorna o título.
	 */
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Acessa o array de elementos do documento.
	 * 
	 * @return Retorna o ArrayList dos elementos.
	 */
	public ArrayList<Elemento> getElementos() {
		return elementos;
	}
	
	/**
	 * Cria o elemento do tipo texto.
	 * 
	 * @param valor do texto.
	 * @param prioridade do texto.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarTexto(String valor, int prioridade) {  
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio.");
		}
		Elemento meuTexto = new Texto(valor, prioridade);
		this.elementos.add(meuTexto);
		return elementos.indexOf(meuTexto);

	}

	/**
	 * Cria o elemento do tipo termo.
	 * 
	 * @param valor do termo.
	 * @param prioridade do termo.
	 * @param separador a string que separa o(s) termo(s).
	 * @param ordem, a ordem em que os termos devem ser exibidos.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarTermo(String valor, int prioridade, String separador, String ordem) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio.");
		}
		Elemento meuTermo = new Termo(valor, prioridade, separador, ordem);
		this.elementos.add(meuTermo);
		return elementos.indexOf(meuTermo);

	}

	/**
	 * Cria o elemento do tipo lista no documento.
	 * 
	 * @param valor O valor da lista.
	 * @param prioridade A prioridade da lista.
	 * @param separador O separador das listas.
	 * @param caractere O caractere da lista.
	 * @return Retorna o inteiro com o indice do elemento no array elementos.
	 */
	public int criarLista(String valor, int prioridade, String separador, String caractere) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio.");
		}
		Elemento minhaLista = new Lista(valor, prioridade, separador, caractere);
		this.elementos.add(minhaLista);
		return elementos.indexOf(minhaLista);

	}

	/**
	 * Cria o elemento do tipo titulo.
	 * 
	 * @param valor O valor do titulo.
	 * @param prioridade A prioridade do titulo.
	 * @param nivel O nivel do titulo
	 * @param link O link do titulo.
	 * @return Retorna o inteiro com o indice do elemento no array elementos.
	 */
	public int criarTitulo(String valor, int prioridade, int nivel, boolean link) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException("Documento cheio.");
		}
		Elemento meuTitulo = new Titulo(valor, prioridade, nivel, link);
		this.elementos.add(meuTitulo);
		return elementos.indexOf(meuTitulo);

	}
	
	/**
	 * Cria o atalho do documento.
	 * 
	 * @param titulo O titulo do documento referenciado.
	 * @return Retorna inteiro que com o indice do elemento no array elementos.
	 */
	public int criarAtalho(String titulo) {
		if (this.tamanho != 0 && (this.elementos.size() + 1) > this.tamanho) {
			throw new IllegalArgumentException();
		}
		int soma = calcularMediaPrioridades();
		Elemento atalho = new Atalho(titulo, soma);
		this.elementos.add(atalho);
		return elementos.indexOf(atalho);
	}
	
	/**
	 * Calcula a soma das prioridades.
	 * 
	 * @return Retorna a soma de todas as prioridades.
	 */
	private int calcularMediaPrioridades() {
		int soma = 0;
		for (int i = 0; i < elementos.size(); i++) {
			soma += this.elementos.get(i).getPrioridade();
		}
		return soma;
	}

	/**
	 * Representação completa do elemento.
	 * 
	 * @param posicao A posicao do elemento.
	 * @return Retorna a representação textual do elemento.
	 */
	public String representacaoCompletaElemento(int posicao) {
		if (this.elementos.get(posicao).getClass().getName().equals("documin.Atalho")) {
			String concatena = "";
			for (int i = 0; i < elementos.size(); i++) {
				if (this.elementos.get(i).getPrioridade() == 4 || this.elementos.get(i).getPrioridade() == 5) {
					concatena += this.elementos.get(i).getRepresentacaoCompleta();
				}
			}return concatena;
		}
		return this.elementos.get(posicao).getRepresentacaoCompleta();
	}

	/**
	 * Representação resumida do elemento.
	 * 
	 * @param posicao A posicao do elemento.
	 * @return Retorna a representação textual do elemento.
	 */
	public String representacaoResumidaElemento(int posicao) {
		if (this.elementos.get(posicao).getClass().getName().equals("documin.Atalho")) {
			String junta = "";
			for (int i = 0; i < elementos.size(); i++) {
				if (this.elementos.get(i).getPrioridade() == 4 || this.elementos.get(i).getPrioridade() == 5) {
					junta += this.elementos.get(i).getRepresentacaoResumida();
				}
			}return junta;
		}
		return this.elementos.get(posicao).getRepresentacaoResumida();
	}

	/**
	 * Remove um elemento do documento.
	 * 
	 * @param posicao A posicao do elemento.
	 * @return Retorna true para removido e false para nao removido.
	 */
	public boolean removeElemento(int posicao) {
		if (this.elementos.get(posicao) != null) {
			this.elementos.remove(posicao);
			return true;
		}
		return false;
	}

	/**
	 * Altera um elemento para baixo no array de elementos.
	 * 
	 * @param posicao A posicao do elemento.
	 */
	public void posicaoAbaixo(int posicao) {
		Elemento guardaPosicao = this.elementos.get(posicao + 1);
		if (this.elementos.contains(this.elementos.get(posicao + 1))) {
			this.elementos.add(posicao + 1, this.elementos.get(posicao));
			this.elementos.add(posicao, guardaPosicao);
		} 
	}

	/**
	 * Altera um elemento para cima no array de elementos.
	 * 
	 * @param posicao A posicao do elemento.
	 */
	public void posicaoAcima(int posicao) {
		Elemento guardaPosicao = this.elementos.get(posicao - 1);
		if (posicao != 0) {
			this.elementos.add(posicao - 1, this.elementos.get(posicao));
			this.elementos.add(posicao, guardaPosicao);
		} 	
	}

	/**
	 * Conta a quantidade de elementos no documento.
	 * 
	 * @return Retorna o total de elementos.
	 */
	public int quantidadeElementos() {
		return this.elementos.size();
	}
	
	/**
	 * Exibição completa do documento.
	 * 
	 * @return Retorna todas as representações completas dos elementos.
	 */
	public String[] exibeDocumentoCompleto() {
    	String[] documento = new String[this.elementos.size()];
    	for (int i = 0; i < this.elementos.size(); i++) {
    		documento[i] = elementos.get(i).getRepresentacaoCompleta();
    	}
		return documento;
    }
	
	/**
	 * Exibição resumoda do documento.
	 * @return Retorna todas as representações resumidas dos elementos.
	 */
	public String[] exibeDocumentoResumido() {
    	String[] documento = new String[this.elementos.size()];
    	for (int i = 0; i < this.elementos.size(); i++) {
    		documento[i] = elementos.get(i).getRepresentacaoResumida();
    	}
		return documento;
    }
}
