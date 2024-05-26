package documin;

import java.text.Collator;
import java.util.Arrays;

/**
 * Elemento do tipo Termo.
 * 
 * @author Luana Bringel Leite.
 *
 */
public class Termo implements Elemento {
	/**
	 * @param valor Valor do termo.
	 */
	private String valor;
	/**
	 * @param prioridade Prioridade do termo.
	 */
	private int prioridade;
	/**
	 * @param separador Separador do termo.
	 */
	private String separador;
	/**
	 * @param ordem Ordem do termo.
	 */
	private String ordem;
	
	/**
	 * Inicializa o termo.
	 * 
	 * @param valor do termo.
	 * @param prioridade do termo.
	 * @param separador do termo.
	 * @param ordem do termo.
	 */
	public Termo(String valor, int prioridade, String separador, String ordem) {
		this.valor = valor;
		this.prioridade = prioridade;
		this.separador = separador;
		this.ordem = ordem;
	}
	
	/**
	 * Representação completa do elemento termo.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoCompleta() {
		String[] nomes = separador();
		if (this.ordem.equals("ALFABÉTICA")) {
			return ordemAlfabeticaCompleta(nomes);
		} else if(this.ordem.equals("TAMANHO")) {
			return ordemTamanhoCompleta(nomes);
		}
		return semOrdemCompleta(nomes) + "\n";
	}

	/**
	 * Representação resumida do elemento termo.
	 * 
	 * @return Retorna a representação.
	 */
	@Override
	public String getRepresentacaoResumida() {
		String[] nomes = separador();
		if (this.ordem.equals("ALFABÉTICA")) {
			return ordemAlfabeticaResumida(nomes);
		} else if(this.ordem.equals("TAMANHO")) {
			return ordemTamanhoResumida(nomes);
		}
		return semOrdemResumida(nomes) + "\n";
	}
	
	/**
	 * Separa os valores por meio do separador do termo.
	 * 
	 * @return Retorna os valores separados.
	 */
	private String[] separador() {
		return this.valor.split(separador);
	}
	
	/**
	 * Compara o tamanho das Strings (ordenação).
	 * 
	 * @param b String
	 * @param a String
	 * @return Retorna inteiros indicando do maior para o menor ou igual.
	 */
	private int compare(String a, String b) {
		if (a.length() > b.length()) {
			return 1;
		} 
		if (a.length() < b.length()) {
			return -1;
		}
		return 0;
	}
	
	/**
	 * Representação resumida do termo sem ordem.
	 * 
	 * @param nome Os valores do termo.
	 * @return String representação do termo.
	 */
	private String semOrdemResumida(String[] nome) {
		String ordenado = "";
		for (int i = 0; i < nome.length; i++) {
			if (i == nome.length - 1) {
					ordenado += nome[i].trim();
				} else {
					ordenado += nome[i].trim() + " " + this.separador + " ";
				}
		}
		return ordenado;
	}
	
	/**
	 * Representação completa do termo sem ordem de forma.
	 * 
	 * @param nome Nomes  dos valores do termo.
	 * @return String representação do termo.
	 */
	private String semOrdemCompleta(String[] nome) {
		String ordenado = "";
		ordenado += "Total termos: " + nome.length + "\n- ";
		for (int i = 0; i < nome.length; i++) {
			if (i == nome.length - 1) {
					ordenado += nome[i].trim();
				} else {
					ordenado += nome[i].trim() + ", ";
				}
		}
		return ordenado;
	}
	
	/**
	 * Representação do termo com ordem de tamanho, e na forma resumida.
	 * 
	 * @param nome Nomes dos valores do termo.
	 * @return String representação do termo.
	 */
	private String ordemTamanhoResumida(String[] nomes) {
		String ordenado = "";
		for (int i = 0; i < nomes.length; i++) {
		for (int j = 0; j < nomes.length; j++) {
			if(compare(nomes[i], nomes[j]) == 1) {
				String aux = nomes[i];
				nomes[i] = nomes[j];
				nomes[j] = aux;
			}
		}
	}
		for(int i = 0; i < nomes.length; i++) {
			if (i == nomes.length -1) {
				ordenado += nomes[i].trim();
			} else {
				ordenado += nomes[i].trim() + " " + this.separador + " ";
			}
		}
		return ordenado;
	}
	
	/**
	 * Representação do termo com ordem de tamanho, e na forma completa.
	 * 
	 * @param nomes NOmes dos valores do termo.
	 * @return String representação do termo.
	 */
	private String ordemTamanhoCompleta(String[] nomes) {
		String ordenado = "";
		ordenado += "Total termos: " + nomes.length + "\n- ";
		for (int i = 0; i < nomes.length; i++) {
		for (int j = 0; j < nomes.length; j++) {
			if(compare(nomes[i], nomes[j]) == 1) {
				String aux = nomes[i];
				nomes[i] = nomes[j];
				nomes[j] = aux;
			}
		}
	}
		for(int i = 0; i < nomes.length; i++) {
			if (i == nomes.length - 1) {
				ordenado += nomes[i].trim();
			} else {
				ordenado += nomes[i].trim() + ", ";
			}
		}
		return ordenado;
	}
	
	/**
	 * Representação do termo com ordem alfabética, e na forma resumida.
	 * 
	 * @param nomes Nomes dos valores do termo.
	 * @return String representação do termo.
	 */
	private String ordemAlfabeticaResumida(String[] nomes) {
		String ordenado = "";
		Arrays.sort(nomes, Collator.getInstance());
		for (int i = 0; i < nomes.length; i++) {
			if (i != nomes.length - 1) {
				ordenado += nomes[i].trim() + " " + this.separador + " ";
			} else {
				ordenado += nomes[i].trim();
			}
		}
		return ordenado;
	}
	
	/**
	 * Representação do termo com ordem alfabética, e na forma completa.
	 * 
	 * @param nomes Nomes dos valores do termo.
	 * @return String representação do termo.
	 */
	private String ordemAlfabeticaCompleta(String[] nomes) {
		String ordenado = "";
		ordenado += "Total termos: " + nomes.length + "\n- ";
		Arrays.sort(nomes, Collator.getInstance());
		for (int i = 0; i < nomes.length; i++) {
			if (i != nomes.length - 1) {
				ordenado += nomes[i].trim() + ", ";
			} else {
				ordenado += nomes[i].trim();
			}
		}
		return ordenado;
	}
	
	/**
	 * Acessa a prioridade do termo.
	 * 
	 * @return retorna a prioridade.
	 */
	@Override
	public int getPrioridade() {
		return this.prioridade;
	}
}
