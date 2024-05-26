package lab2;
/**
 * Registro do tempo esperado de estudos de um aluno em uma determinada disciplina remota.
 * Tendo como base a carga horária da disciplina, em que o tempo de estudo esperado deve ser o dobro
 * da carga horaria estabelecida, no mínimo.
 * 
 * @author Luana Bringel Leite
 */
public class RegistroTempoOnline {
    /**
     * Nome da disciplina que o aluno deseja registrar as informações sobre o tempo de 
     * estudos.
     */
    private String nomeDisciplina;
    /**
     * Tempo esperado que o aluno estude. Definido como o dobro da carga horária da disciplina
     * registrada. Padrão de 60h, ou seja, tempo esperado de 120h. Padrão pode ser alterado
     * caso a carga horária seja definida pelo aluno.
     */
    private int tempoOnlineEsperado = 120;
    /**
     * Acumulador para adiconar a quantidade de horas (com a(s) já registrada(s)) que 
     * o aluno passou estudando, até que se alcance a quantidade ideal para cada
     * disciplina.
     */
    private int adicionaTempoOnline;

    /**
     * Constrói a disciplina em que o aluno irá registrar a quantidade ideal de horas
     * dedicadas aos estudos, com base na carga horária da disciplina.
     * 
     * @param nomeDisciplina recebe o nome da primeira disciplina a ser cadastrada.
     * @param tempoOnlineEsperado recebe a carga horária da disciplina, para calcular
     * a quantidade mínima de horas de estudo (o dobro da carga horária).
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
     * Constrói uma nova disciplina em que o aluno vai registrar novas horas de 
     * estudo dedicadas.
     * 
     * @param nomeDisciplina recebe uma String com o nome da disciplina.
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Adiciona a quantidade de horas dedicadas a uma disciplina.
     * 
     * @param tempo recebe o valor dessas horas, inicialmente estabelecido como zero.
     */
    public void adicionaTempoOnline(int tempo) {
        this.adicionaTempoOnline += tempo;
    }

    /**
     * Retorna "true" ou "false" dependendo se a quantidade de horas dedicadas a uma
     * disciplina foi maior ou igual a quantidade mínima.
     * 
     * @return retorna se o aluno atingiu ou não a quantidade mínima de horas dedicadas
     * a uma disciplina, com "true" ou "false"
     */
    public boolean atingiuMetaTempoOnline() {
        return adicionaTempoOnline >= tempoOnlineEsperado;
    }

    /**
     * Retorna a String que representa o nome da disciplina, a quantidade de horas dedicadas
     * para a disciplina e a quantidade de horas mínima.
     * No formato:
     * "AAAA X/Y" onde AAAA é o nome da disciplina, X é a quantidade de horas dedicadas pelo aluno
     * e Y é a quantidade mínima de horas esperada, baseada na carga horária da disciplina.
     * 
     * @return retorna o texto com o nome da disciplina, o tempo dedicado pelo aluno e o tempo esperado.
     */
    public String toString() {
        return nomeDisciplina + " " + String.valueOf(adicionaTempoOnline) + "/" + String.valueOf(tempoOnlineEsperado);
    }
}
