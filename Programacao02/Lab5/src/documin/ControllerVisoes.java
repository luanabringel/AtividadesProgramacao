package documin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Controlador das visões, dos documentos.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class ControllerVisoes {
	/**
	 * @param visoes O array das visões.
	 */
	private ArrayList<String[]> visoes;
	
	/**
	 * Constrói o controlador e inicialização das visoes.
	 */
	public ControllerVisoes() {	
		this.visoes = new ArrayList<>();
		//this.controle = new DocumentosController();
	}
	
	/**
	 * Cria a visao completa de um documento.
	 * 
	 * @param tituloDoc O titulo do documento.
	 * @param docs O hashmap dos documentos.
	 * @return Retorna um inteiro com o indice da visão no array.
	 */
    public int criarVisaoCompleta(String tituloDoc, HashMap<String, Documento> docs) {
    	if (entradaVazia(tituloDoc)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(tituloDoc, docs)) {
			throw new NoSuchElementException("Documento não criado.");
		}
    	int tamanho = docs.get(tituloDoc).getElementos().size();
    	String[] visao = new String[tamanho];
    	for (int i = 0; i < tamanho; i++) {
    		visao[i] = docs.get(tituloDoc).representacaoCompletaElemento(i);
    	}visoes.add(visao);
		return visoes.indexOf(visao);
    }
    
    /**
	 * Cria a visao resumida de um documento.
	 * 
	 * @param tituloDoc O titulo do documento.
	 * @param docs O hashmap dos documentos.
	 * @return Retorna um inteiro com o indice da visão no array.
	 */
    public int criarVisaoResumida(String tituloDoc, HashMap<String, Documento> docs) {
    	if (entradaVazia(tituloDoc)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(tituloDoc, docs)) {
			throw new NoSuchElementException("Documento não criado.");
		}
    	int tamanho = docs.get(tituloDoc).getElementos().size();
    	String[] visao = new String[tamanho];
    	for (int i = 0; i < tamanho; i++) {
    		visao[i] = docs.get(tituloDoc).representacaoResumidaElemento(i);
    	}visoes.add(visao);
		return visoes.indexOf(visao);
    }
    
    /**
	 * Cria a visao de um documento a partir das prioridades.
	 * 
	 * @param tituloDoc titulo do documento.
	 * @param prioridade A prioridade dos elementos.
	 * @param docs O hashmap dos documentos.
	 * @return Retorna um inteiro com o indice da visão no array.
	 */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade, HashMap<String, Documento> docs) {
    	if (entradaVazia(tituloDoc)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(tituloDoc, docs)) {
			throw new NoSuchElementException("Documento não criado.");
		}
    	int tamanho = docs.get(tituloDoc).getElementos().size();
    	int contador = 0;
    	for (int i = 0; i < tamanho; i++) {
    		if (docs.get(tituloDoc).getElementos().get(i).getPrioridade() >= prioridade) {
    			contador += 1;
    		}
    	}
    	String[] visao = new String[contador];
    	contador = 0;
    	for (int i = 0; i < tamanho; i++) {
    		if (docs.get(tituloDoc).getElementos().get(i).getPrioridade() > prioridade - 1) {
    			visao[contador] = docs.get(tituloDoc).representacaoCompletaElemento(i);
    			contador += 1;
    		}
    	}visoes.add(visao);
		return visoes.indexOf(visao);
    } 
    
    /**
	 * Cria a visao do titulo de um documento.
	 * 
	 * @param tituloDoc O titulo do documento.
	 * @param docs O hashmap dos documentos.
	 * @return Retorna um inteiro com o indice da visão no array.
	 */
    public int criarVisaoTitulo(String tituloDoc, HashMap<String, Documento> docs) {
    	if (entradaVazia(tituloDoc)) {
			throw new IllegalArgumentException("Titulo Inválido.");
		}
		if (documentoInexistente(tituloDoc, docs)) {
			throw new NoSuchElementException("Documento não criado.");
		}
    	int tamanho = docs.get(tituloDoc).getElementos().size();
    	int contador = 0;
    	for (int i = 0; i < tamanho; i++) {
    		if (docs.get(tituloDoc).getElementos().get(i).getClass().getName().equals("documin.Titulo")) {
    			contador += 1;
    		}
    	}
    	String[] visao = new String[contador];
    	contador = 0;
    	for (int i = 0; i < tamanho; i++) {
    		if (docs.get(tituloDoc).getElementos().get(i).getClass().getName().equals("documin.Titulo")) {
    			visao[contador] = docs.get(tituloDoc).representacaoResumidaElemento(i);
    			contador += 1;
    		}
    	}visoes.add(visao);
		return visoes.indexOf(visao);
    }
    
    /**
     * Constrói a visao do documento com a identificacao especifica.
     * 
     * @param visaoId a visao do documento.
     * @return Retorna o array da visao.
     */
    public String[] exibirVisao(int visaoId) {
		return visoes.get(visaoId);	
    }
    
    /**
     * Checa entradas vazias.
     * 
     * @param titulo O titulo
     * @return Retorna true caso nao seja vazia e false caso seja.
     */
    private boolean entradaVazia(String titulo) {
		if (titulo.trim().equals("")) {
			return true;
		}
		return false;
    }
	
    /**
     * Checa se o documento já existe.
     * 
     * @param titulo O titulo
     * @param docs O mapa dos documentos
     * @return Retorna true caso ja exista e false caso nao.
     */
    private boolean documentoInexistente(String titulo, HashMap<String, Documento> docs) {
    	if (!docs.containsKey(titulo)) {
    		return true;
    	}
		return false;
    }
}
