package documin;

/**
 * Constrói o controlador do sistema total.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Facade {
	/**
	 * Constrói o controlador de documentos.
	 */
    private ControllerDocumentos documentoController;
    /**
     * @param visao O Controlador de visões.
     */
    private ControllerVisoes visao;
    
    /**
     * Constrói e inicializa os controladores.
     */
    public Facade() {
        this.documentoController = new ControllerDocumentos();
        this.visao = new ControllerVisoes();
    }

    /**
	 * Cria um documento, sem tamanho.
	 * @param titulo do documento.
	 * @return boolean, de sucesso do cadastro.
	 */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    
    /**
	 * Cria um documento com tamanho.
	 * 
	 * @param titulo O titulo do documento.
	 * @param tamanho O tamanho do documento.
	 * @return Retorna true caso sucesso do cadastro e false caso nao.
	 */
    public boolean criarDocumento(String titulo, int tamanho) {
    	return this.documentoController.criarDocumento(titulo, tamanho);
    }

    /**
	 * Remove um documento.
	 * 
	 * @param titulo O titulo do documento.
	 */
    public void removerDocumento(String titulo) {
    	this.documentoController.removerDocumento(titulo);
    }
    
    /**
	 * Conta a quantidade de elementos no documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @return Retorna o total de elementos.
	 */
    public int contarElementos(String titulo) {
		return this.documentoController.contarElementosNoDocumento(titulo);
    }
    
    /**
	 * Exibição completa do documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @return Retorna todas as representações completas dos elementos.
	 */
    public String[] exibirDocumentoCompleto(String titulo) {
		return this.documentoController.exibirDocumentoCompleto(titulo);
    	
    }
    
    /**
	 * Exibição resumida do documento.
	 * 
	 * @param titulo O titulo do documento.
	 * @return Retorna todas as representações resumidas dos elementos.
	 */
    public String[] exibirDocumentoResumido(String titulo) {
		return this.documentoController.exibirDocumentoResumido(titulo);
    	
    }
    
    /**
	 * Cria o elemento do tipo texto no documento.
	 * 
	 * @param tituloDoc O titulo do documento.
	 * @param valor O valor do texto.
	 * @param prioridade A prioridade do texto.
	 * @return Retorna o indice do elemento no array elementos.
	 */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
    	return this.documentoController.criarTexto(tituloDoc, valor, prioridade);
    }
    
    /**
	 * Cria o elemento do tipo titulo no documento.
	 * 
	 * @param tituloDoc do documento onde o titulo deve ser criado.
	 * @param valor do titulo.
	 * @param prioridade do titulo.
	 * @param nivel, nivel do titulo
	 * @param linkavel do titulo.
	 * @return Retorna o indice do elemento no array elementos.
	 */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
    	return this.documentoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
    }
    
    /**
	 * Cria o elemento do tipo lista no documento.
	 * 
	 * @param tituloDoc do documento onde a lista deve ser criado.
	 * @param valorLista da lista.
	 * @param prioridade da lista.
	 * @param separador a string que separa a(s) lista(s).
	 * @param charLista, caractere da lista.
	 * @return Retorna o indice do elemento no array elementos.
	 */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
    	return this.documentoController.criarLista(tituloDoc, valorLista, prioridade, separador, charLista);
    }
    
    /**
	 * Cria o elemento do tipo termo no documento.
	 * 
	 * @param tituloDoc do documento onde o termo deve ser criado.
	 * @param valorTermos do termo.
	 * @param prioridade do termo.
	 * @param separador a string que separa o(s) termo(s).
	 * @param ordem, a ordem em que os termos devem ser exibidos.
	 * @return Retorna o indice do elemento no array elementos.
	 */
    public int criarTermo(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
    	return this.documentoController.criarTermo(tituloDoc, valorTermos, prioridade, separador, ordem);
    }
    
    /**
	 * Representação completa de um elemento da lista no documento.
	 * 
	 * @param tituloDoc do documento.
	 * @param elementoPosicao do elemento.
	 * @return A representação textual do elemento.
	 */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.representacaoCompletaElemento(tituloDoc, elementoPosicao);
    }
    
    /**
	 * Representação resumida de um elemento da lista.
	 * 
	 * @param tituloDoc do documento.
	 * @param elementoPosicao, posicao do elemento.
	 * @return A representação textual do elemento.
	 */
    public String pegarrepresentacaoResumida(String tituloDoc, int elementoPosicao) {
    	return this.documentoController.representacaoResumidaElemento(tituloDoc, elementoPosicao);
    }
    
    /**
	 * Remove um elemento do documento.
	 * 
	 * @param tituloDoc do documento.
	 * @param elementoPosicao do elemento a ser removido.
	 * @return Retorna true caso removido e falso caso nao.
	 */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return this.documentoController.removerElemento(tituloDoc, elementoPosicao);
    	
    }
    
    /**
	 * Altera o elemento para cima no array de elementos.
	 * 
	 * @param tituloDoc do documento.
	 * @param elementoPosicao do elemento.
	 */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaCima(tituloDoc, elementoPosicao);
    }
    
    /**
	 * Altera o elemento para baixo no array de elementos.
	 * 
	 * @param tituloDoc do documento onde está o elemento.
	 * @param elementoPosicao do elemento.
	 */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
    	this.documentoController.moverParaBaixo(tituloDoc, elementoPosicao);
    }
    /**
	 * Cria o atalho no documento.
	 * 
	 * @param tituloDoc que vai referenciar.
	 * @param tituloDocReferenciado titulo do documento que vai ser referenciado
	 * @return int, inteiro que representa a posição do elemento no array elementos.
	 */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
    	return 0;
    }
    
    /**
	 * Cria uma visao completa do documento.
	 * 
	 * @param tituloDoc titulo do documento.
	 * @return int, inteiro indicando a posição da visão no array de visoes.
	 */
    public int criarVisaoCompleta(String tituloDoc) {
    	return this.visao.criarVisaoCompleta(tituloDoc, this.documentoController.getDocumentos());
    }
    
    /**
	 * Cria uma visao resumida do documento.
	 * 
	 * @param tituloDoc titulo do documento.
	 * @return Retorna o indice do elemento no array de visoes.
	 */
    public int criarVisaoResumida(String tituloDoc) {
    	return this.visao.criarVisaoResumida(tituloDoc, this.documentoController.getDocumentos());
    }
    
    /**
	 * Cria uma visao a partir das prioridades.
	 * 
	 * @param tituloDoc titulo do documento.
	 * @param prioridade dos elementos.
	 * @return Retorna o indice do elemento no array de visoes.
	 */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
    	return this.visao.criarVisaoPrioritaria(tituloDoc, prioridade, this.documentoController.getDocumentos());
    } 
    
    /**
	 * Cria uma visao do titulo de um documento.
	 * 
	 * @param tituloDoc titulo do documento.
	 * @return Retorna o indice do elemento no array de visoes.
	 */
    public int criarVisaoTitulo(String tituloDoc) {
    	return this.visao.criarVisaoTitulo(tituloDoc, this.documentoController.getDocumentos());
    }
    
    /**
     * Exibição da visão.
     * 
     * @param visaoId A posicao da visao no array visoes.
     * @return Retorna o array de visão.
     */
    public String[] exibirVisao(int visaoId) {
    	return this.visao.exibirVisao(visaoId);
    }
}
