package documin;

/**
 * Elemento do tipo Texto.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Texto implements Elemento {
	/**
	 * @param prioridade Prioridade do texto.
	 */
	private int prioridade;
	/**
	 * \2param valor Valor do texto.
	 */
	private String valor;

	/**
	 * Inicializa um novo texto.
	 * 
	 * @param valor do texto.
	 * @param prioridade do texto.
	 */
	public Texto(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	/**
	 * Representação completa do elemento texto.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		return this.valor + "\n";
	}

	/**
	 * Representação resumida do elemento texto.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return this.valor + "\n";
	}
	
	/**
	 * Acessa a prioridade do texto.
	 * 
	 * @return Retorna a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
