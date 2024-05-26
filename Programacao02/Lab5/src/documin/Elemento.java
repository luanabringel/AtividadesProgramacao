package documin;

/**
 * Constrói a interface para os elementos.
 * 
 * @author Luana Bringel Leite.
 *
 */
public interface Elemento {
	/**
	 * Representação completa dos elementos.
	 * 
	 * @return String da representação textual completa.
	 */
	
	public String getRepresentacaoCompleta();
	/**
	 * Representação resumida dos elementos.
	 * 
	 * @return String da representação textual resumida.
	 */
	
	public String getRepresentacaoResumida();
	/**
	 * Acessa a prioridade dos elementos.
	 * 
	 * @return Retorna a prioridade.
	 */
	public int getPrioridade();
}
