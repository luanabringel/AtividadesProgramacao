package documin;

/**
 * Elemento do tipo Lista.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Lista implements Elemento {
	/**
	 * @param Valor da lista.
	 */
	private String valor;
	/**
	 * @param prioridade Prioridade da lista.
	 */
	private int prioridade;
	/**
	 * @param separador Separador da lista.
	 */
	private String separador;
	/**
	 * @param caractere Caractere da lsita.
	 */
	private String caractere;

	/**
	 * Inicializa o elemento lista.
	 * 
	 * @param valor da lista.
	 * @param prioridade da lista.
	 * @param separador da lista.
	 * @param caractere da lista.
	 */
	public Lista(String valor, int prioridade, String separador, String caractere) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.separador = separador;
		this.caractere = caractere;

	}
	
	/**
	 * Representação completa do elemento lista.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		String completa = "";
		for (int i = 0; i < separaValor().length; i++) {
			completa += this.caractere + " " + separaValor()[i].trim() + "\n";
		}
		return completa;
	}

	/**
	 * Representação resumida do elemento lista.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoResumida() {
		String[] lista = separaValor();
		String resumida = "";
		for (int i = 0; i < lista.length; i++) {
			if (i == (lista.length -1)) {
				resumida += lista[i].trim();
			} else if (i < lista.length) {
				resumida += lista[i].trim() + ", ";
			}
		}
		return resumida + "\n";
	}
	
	/**
	 * Separa os valores com separador.
	 * 
	 * @return Retorna os valores separados.
	 */
	private String[] separaValor() {   
		if (this.separador.equals("|")) {
			this.separador = "[|]";
		}
		String[] lista = this.valor.split(this.separador); 
		return lista;
	}
	
	/**
	 * Acessa a prioridade da lista.
	 * 
	 * @return Retorna a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
