package documin;
/**
 * Constrói o atalho para um documento.
 * 
 * @author Luana Bringel Leite.
 *
 */

public class Atalho implements Elemento{
	/**
	 * @param valor O valor do atalho - ID do documento referenciado.
	 */
	private String valor;
	/**
	 * @param prioridade A prioridade do atalho: média das prioridades dos elementos do documento referenciado.
	 */
	private int prioridade;
	
	/**
	 * Inicialização do valor e da propriedade do atalho.
	 * 
	 * @param valor O valor do atalho.
	 * @param prioridade A prioridade do atalho.
	 */
	public Atalho(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	/**
	 * Representação completa do atalho de um documento.
	 * @return Retorna a representacao completa do atalho.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		return null;
	}
	
	/**
	 * Representação resumida do atalho de um documento.
	 * @return Retorna a representacao resumida do atalho.
	 */
	@Override
	public String getRepresentacaoResumida() {
		return null;
	}

	/**
	 * Acessa a prioridade do atalho.
	 * @return Retorna a prioridade 0.
	 */
	@Override
	public int getPrioridade() {
		return 0;
	}
}