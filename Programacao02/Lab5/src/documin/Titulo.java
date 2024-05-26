package documin;

/**
 * Elemento do tipo Titulo.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Titulo implements Elemento {
	/**
	 * @param titulo Valor do titulo.
	 */
	private String valor;
	/**
	 * @param prioridade Prioridade do titulo.
	 */
	private int prioridade;
	/**
	 * @param nivel Nível do titulo.
	 */
	private int nivel;
	/**
	 * @param link Link do titulo.
	 */
	private boolean link;
	
	/**
	 * Inicializa um novo titulo.
	 * 
	 * @param valor do titulo.
	 * @param prioridade do titulo.
	 * @param nivel do titulo.
	 * @param link o titulo é linkavel ou não.
	 */
	public Titulo(String valor, int prioridade, int nivel, boolean link) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.nivel = nivel;
		this.link = link;
	}

	/**
	 * Representação completa do elemento titulo.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		if (this.link == false) {
			return this.nivel + ". " + this.valor + "\n";
		}
		return this.nivel + ". " + this.valor + " -- " +this.nivel + "-" 
		+ this.valor.toUpperCase().replaceAll(" ", "") + "\n";

	}

	/**
	 * Pega a representação resumida do elemento titulo.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return this.nivel + ". " + this.valor + "\n";
	}
	
	/**
	 * Acessa a prioridade do titulo.
	 * 
	 * @return Retorna a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return prioridade;
	}
}
