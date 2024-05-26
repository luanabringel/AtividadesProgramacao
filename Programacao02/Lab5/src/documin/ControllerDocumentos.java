package documin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Controlador de documentos.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class ControllerDocumentos {
	/**
	 * @param docs Mapa dos documentos.
	 */
	private HashMap<String, Documento> docs;
	
	/**
	 * Constrói o controlador e inicializa o mapa dos documentos.
	 */
	public ControllerDocumentos() {
		this.docs = new HashMap<>();
	}
	
	/**
	 * Constrói o documento, atribuindo titulo e tamanho.
     * 
     * @param titulo O titulo do documento.
     * @param tamanho O tamanho do documento.
     * @return Retorna false caso ja exista um documento com o mesmo titulo ou caso a entrada seja vazia,
     * e true para novos documentos criados.
	 */
	public boolean criarDocumento(String titulo, int tamanho) { 
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (this.docs.containsKey(titulo)) {
			return false;
		}
		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho inválido.");
		}
		Documento documento = new Documento(titulo, tamanho);
		this.docs.put(titulo, documento);
		return true;
	}
	
	/**
	 * Constrói o documento, atribuindo titulo.
     * 
     * @param titulo O titulo do documento.
     * @return Retorna false caso ja exista um documento com o mesmo titulo ou caso a entrada seja vazia,
     * e true para novos documentos criados.
	 */
	public boolean criarDocumento(String titulo){
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (this.docs.containsKey(titulo)) {
			return false;
		}
		Documento documento = new Documento(titulo);
		this.docs.put(titulo, documento);
		return true;
	}
	
	/**
	 * Acessa o HashMap dos documentos.
	 * @return HashMap documentos.
	 */
	public HashMap<String, Documento> getDocumentos() {
		return docs;
	}
	
	/**
	 * Remove um documento.
     * 
     * @param titulo O titulo do elemento.
	 */
	public void removerDocumento(String titulo) {  
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		this.docs.remove(titulo);
	}
	
	/**
	 * Exibição completa de um documento.
	 * 
	 * @param titulo do documento a ser exibido.
	 * @return Retorna todas as representações completas dos elementos no documento.
	 */
	public String[] exibirDocumentoCompleto(String titulo) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}String[] retorna = new String[this.docs.get(titulo).getElementos().size()];
		for (int i = 0; i < this.docs.get(titulo).getElementos().size(); i++) {
			retorna[i] = this.docs.get(titulo).representacaoCompletaElemento(i);
		}return retorna;
	}
	
	/**
	 * Exibição resumida de um documento.
	 * 
	 * @param titulo do documento a ser exibido.
	 * @return String[], com todas as representações resumidas dos elementos no documento.
	 */
	public String[] exibirDocumentoResumido(String titulo) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}String[] retorna = new String[this.docs.get(titulo).getElementos().size()];
		for (int i = 0; i < this.docs.get(titulo).getElementos().size(); i++) {
			retorna[i] = this.docs.get(titulo).representacaoResumidaElemento(i);
		}return retorna;
	}

	/**
	 * Conta a quantidade de elementos no documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @return Retorna um inteiro com o total de elementos contados.
	 */
	public int contarElementosNoDocumento(String titulo) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).quantidadeElementos();
	}
	
	/**
	 * Cria o elemento do tipo texto.
	 * 
	 * @param titulo O titulo do documento.
	 * @param valor O valor do texto.
	 * @param prioridade A prioridade do texto.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarTexto(String titulo, String valor, int prioridade) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).criarTexto(valor, prioridade);
	}

	/**
	 * Cria o elemento do tipo termo.
	 * 
	 * @param titulo O titulo do documento.
	 * @param valor O valor do termo.
	 * @param prioridade A prioridade do termo.
	 * @param separador O separador dos termos.
	 * @param ordem A ordem dos termos.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarTermo(String titulo, String valor, int prioridade, String separador, String ordem) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).criarTermo(valor, prioridade, separador, ordem);
	}

	/**
	 * Cria o elemento do tipo lista.
	 * 
	 * @param titulo O titulo do documento.
	 * @param valor O valor da lista.
	 * @param prioridade A prioridade da lista.
	 * @param separador O separador das listas.
	 * @param caractere O caractere da lista.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarLista(String titulo, String valor, int prioridade, String separador, String caractere) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).criarLista(valor, prioridade, separador, caractere);
	}

	/**
	 * Cria o elemento do tipo titulo no documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @param valor O valor do titulo.
	 * @param prioridade A prioridade do titulo.
	 * @param nivel O nivel do titulo
	 * @param link O link do titulo.
	 * @return Retorna um inteiro com o indice do elemento no array elementos.
	 */
	public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean link) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).criarTitulo(valor, prioridade, nivel, link);
	}
	
	/**
	 * Cria o atalho do documento.
	 * 
	 * @param tituloDoc O documento que vai referenciar.
	 * @param tituloDocReferenciado O titulo do documento que vai ser referenciado.
	 * @return Retorna um inteiro que representa o indice do elemento no array elementos.
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (entradaVazia(tituloDoc) || entradaVazia(tituloDocReferenciado)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(tituloDoc) || documentoInexistente(tituloDocReferenciado)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(tituloDoc).criarAtalho(tituloDocReferenciado);
	}
	
	/**
	 * Representação completa de um elemento da lista no documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @param posicao A posicao do elemento.
	 * @return Retorna a representação textual do elemento.
	 */
	public String representacaoCompletaElemento(String titulo, int posicao) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).representacaoCompletaElemento(posicao);
	}
	
	/**
	 * Representação resumida de um elemento da lista.
	 * 
	 * @param titulo O titulo do documento.
	 * @param posicao A posicao do elemento.
	 * @return Retorna a representação textual do elemento.
	 */
	public String representacaoResumidaElemento(String titulo, int posicao) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).representacaoResumidaElemento(posicao);
	}
	
	/**
	 * Remove um elemento do documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @param posicao A posicao do elemento a ser removido.
	 * @return Retorna true caso seja sucessso e false caso tenha titulo invalido ou o documento
	 * nao tenha sido criado.
	 */
	public boolean removerElemento(String titulo, int posicao) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		return this.docs.get(titulo).removeElemento(posicao);
	}
	
	/**
	 * Altera um elemento para cima no array de elementos.
	 * .
	 * @param titulo O titulo do documento.
	 * @param posicao A posicao do elemento.
	 */
	public void moverParaCima(String titulo, int posicao) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		this.docs.get(titulo).posicaoAcima(posicao);
	}
	
	/**
	 * Muda um elemento para uma posição abaixo no array de elementos.
	 * @param titulo do documento.
	 * @param posicao do elemento.
	 */
	public void moverParaBaixo(String titulo, int posicao) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
		this.docs.get(titulo).posicaoAbaixo(posicao);
	}

	/**
	 * Acessa o array de elementos de um documento.
	 * @param titulo do documento.
	 * @return array dos elementos.
	 */
	public ArrayList<Elemento> getElementosDoDocumento(String titulo) {
		if (entradaVazia(titulo)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(titulo)) {
			throw new NoSuchElementException("Documento não criado.");
		}
    	return docs.get(titulo).getElementos();
    }
	
	/**
	 * Checa se a entrada é vazia.
	 * 
	 * @param titulo do documento.
	 * @return boolean, do status de erro.
	 */
    private boolean entradaVazia(String titulo) {
		if (titulo.trim().equals("")) {
			return true;
		}
		return false;
    }
	
    /**
	 * Checa se o titulo não foi cadastrado.
	 * 
	 * @param titulo do documento.
	 * @return boolean do status de erro.
	 */
    private boolean documentoInexistente(String titulo) {
    	if (!this.docs.containsKey(titulo)) {
    		return true;
    	}
		return false;
    }
}
