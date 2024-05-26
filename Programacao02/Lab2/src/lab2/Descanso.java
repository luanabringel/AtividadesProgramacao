package lab2;
/**
 * Registro da rotina de descanso do aluno, tendo como descanso ideal 26 horas por semana, no mínimo.
 * O aluno que não registra horas de descanso ou o número de semanas é considerado cansado.
 * 
 * @author Luana Bringel Leite
 */
public class Descanso {
    /**
     * Número de semanas das horas de descanso registradas pelo aluno. Relaciona-se com 
     * as horas de descanso do aluno (ideal: 26h por semana) para definir se esse 
     * aluno está cansado ou descansado.
     */
    private int numeroSemana;
    /**
     * Número ideal de horas semanais de descanso para o aluno ser considerado
     * descansado.
     */
    private int horaSemanalIdeal;
    /**
     * Número de horas registradas como descanso do aluno.
     */
    private int horasDescanso;
    /**
     * Define se o aluno foi considerado "cansado" ou "descansado", com base na quantidade
     * ideal de horas de descanso por semana e nas horas e numeros de semanas registradas
     * pelo aluno.
     */
    private String StatusGeral;

    /**
     * Constrói o status do aluno (cansado ou descansado). Definindo o valor ideal de horas
     * para descanso semanal e a definição inicial do status do aluno como "cansado".
     */
    public Descanso()  {
        this.horaSemanalIdeal = 26;
        this.StatusGeral = "cansado";
    }

    /**
     * Retorna o status do aluno (cansado ou descansado). Definido a partir da divisão das horas
     * registradas e as semanas em que elas equivalem, comparada com a quantidade ideal de descanso.
     * 
     * @return retorna o status do aluno.
     */
    public String getStatusGeral() {
        if(numeroSemana == 0 || horasDescanso == 0){
           return this.StatusGeral;
        }
        else if( horasDescanso/numeroSemana >= horaSemanalIdeal){
            return "descansado";
        }
        return this.StatusGeral;
    }

    /**
     * Define o valor referente a quantidade de horas equivalentes as semanas registradas
     * pelo aluno.
     * 
     * @param valor recebe o número de horas de descanso.
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    /**
     * Define o valor referente a quantidade de semanas equivalentes as horas registradas
     * pelo aluno.
     * 
     * @param valor recebe o número de semanas em que as horas definidas anteriormente equivalem.
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemana = valor;
    }
}
