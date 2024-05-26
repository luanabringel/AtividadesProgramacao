package lab2;
import java.util.Arrays;
/**
 * Registro de disciplinas, com um padrão de 4 notas para cada disciplina (caso alguma não seja
 * registrada, é dita como zero), e cálcula-se a média aritmética, definindo a partir dela se o 
 * aluno foi aprovado ou não, caso seja maior ou igual a 7.0. Caso, alguma nota se repita,
 * leva-se em consideração a última cadastrada.
 * Também cadastra-se horas de estudos acumulativas para cada disciplina.
 * 
 * @author Luana Bringel Leite
 */
public class Disciplina {
    /**
     * Nome da disciplina em que o aluno deseja registrar as informações sobre notas
     * e tempo de estudos.
     */
    private String nomeDisciplina;
    /**
     * Quantidade de horas que o aluno dedicou aos estudos daquela disciplina registrada.
     */
    private int horas;
    /**
     * Quantidade de notas obtidas pelo aluno e que serão registradas.
     */
    private double[] arrayNotas = new double[4];
    /**
     * Acumulador que soma a nota registrada pelo aluno com a anterior ou a soma das anteriores.
     * Inicialmente definida como zero.
     */
    private double somaNotas;
    /**
     * Recebe o valor da divisão da soma das 4 notas registradas pela quantidade de notas registradas,
     * ou seja, a média aritmética do aluno.
     */
    private double mediaNotas;

    /**
     * Constrói a disciplina em que o aluno irá registrar as notas e obter as informações.
     * 
     * @param nomeDisciplina recebe o nome da disciplina que o aluno deseja registrar.
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * Acumula as horas de estudos do aluno em uma determinada disciplina.
     *  
     * @param horas recebe o valor referente as horas dedicadas aos estudos, inicialmente
     * definida como zero.
     */
    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    /**
     * Constrói um array de tamanho fixo com as notas registradas pelo aluno.
     * Define a média do aluno com base nas notas recebidas no @param valorNota.
     * 
     * @param valorNota recebe as notas cadastradas.
     * @param nota recebe o tamanho do array, ou seja, quantidade de notas a serem recebidas (de 1 a 4).
     * Caso não receba alguma nota, será considerada como 0.0 (zero) a(s) nota(s) que nao foi registrada.
     */
    public void cadastraNota(int nota, double valorNota) {
        this.arrayNotas[nota-1] = valorNota;
        somaNotas += valorNota;
        mediaNotas = somaNotas/4;
    }

    /**
     * Retorna "true" ou "false" dependendo se a média do aluno for maior ou igual a
     * 7.0 ou menor que 7.0.
     * 
     * @return retorna se o aluno foi aprovado ou não, com "true" ou "false".
     */
    public boolean aprovado() {
        return mediaNotas >= 7.0;
    }

    /**
     * Retorna uma String que representa o nome da disciplina, as horas de estudos dedicadas a
     * essa disciplina, a média aritmética e a lista de notas obtidas pelo aluno.
     * No formato:
     * "AAAA X Y.Y [B.B B.B B.B B.B]" onde A é o nome da disciplina, X são as horas de estudos,
     * Y.Y é a média aritmética das notas e B.B são as notas registradas pelo aluno.
     * 
     * @return retorna o texto com as informações da disciplina, como o nome da disciplina, horas de estudo,
     * média e as notas. 
     */
    public String toString() {
        return nomeDisciplina + " " + Integer.toString(horas) + " " + String.valueOf(mediaNotas) + " " + Arrays.toString(arrayNotas);
    }
}
