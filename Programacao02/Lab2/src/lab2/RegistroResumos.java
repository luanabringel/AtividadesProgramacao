package lab2;
/**
 * Registro de resumos, com uma quantidade limite estabelecida, feitos ao longo do período
 * com a finalidade de acompanhar os estudos do aluno. Cada vez que chega ao limite máximo
 * estabelecido, os resumos adiconados após o ultimo espaço, ocuparão os espaços iniciais, ou
 * seja, é registrado no lugar do primeiro resumo.
 * 
 * @author Luana Bringel Leite
 */
public class RegistroResumos {
    /**
     * Recebe, em formato String, as informações sobre a quantidade de resumos cadastrados,
     * assim como os títulos e os resumos registrados pelo aluno. Finalidade de estruturar
     * a String para estar pronta para o print na tela do aluno.
     */
    private String meuPrint;
    /**
     * Recebe um array de tamanho fixo com os resumos registrados pelo aluno.
     */
    private String[] arrayResumos;
    /**
     * Recebe um array de tamanho fixo com os temas (títulos) registrados pelo aluno.
     */
    private String[] arrayTemas;
    /**
     * Recebe um array com todos os temas e os resumos referentes aos temas registrados.
     */
    private String[] arrayTemaResumo;
    /**
     * Quantidade de resumos que o aluno registrou até o momento.
     */
    private int numeroDeResumos;
    /**
     * Acumulador da quantidade de resumos que o aluno registrou até o momento.
     * Zera a cada vez que a quantidade se igualar ao tamanho linite do array que vai receber os resumos.
     * Funciona como um índicie, para determinar a posição de cada novo resumo registrado.
     */
    private int quantidadeResumos;
    /**
     * Determina o tamanho do array que contém os resumos cadastrados pelo aluno até o momento.
     */
    private int tamanhoArrayResumos;
    /**
     * Determina se a condição é verdadeira ou falsa, identificando se o parametro utilizado
     * será o acumulador da quantidade de resumos ou o a quantidade de resumos cadastradas.
     */
    private boolean determinaQuantidade;

    /**
     * Constrói o determinante da quantidade de resumos.
     * Determina a quantidade de resumos a serem cadastradas pelo aluno.
     * 
     * @param numeroDeResumos cria o array dos títulos/temas dos resumos e o array dos resumos cadastrados, 
     * ambos de tamanho fixo estabelecidos no parametro.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.numeroDeResumos = numeroDeResumos;
        this.arrayResumos = new String[numeroDeResumos];
        this.arrayTemas = new String[numeroDeResumos];
        this.determinaQuantidade = false;
    }

    /**
     * Determina o que cada array criado anteriormente irá receber. 
     * Array de resumos recebe os resumos cadastrados e o array dos temas recebe os títulos
     * de cada resumo a ser registrado. Se a quantidade de resumos cadastrados for maior do
     * que o tamanho do array, os últimos resumos registrados (que passaram do tamanho limite)
     * serão registrados nas posições iniciais.
     * 
     * @param tema recebe o título do resumo.
     * @param resumo recebe o próprio resumo.
     */
    public void adiciona(String tema, String resumo) {
        this.arrayResumos[quantidadeResumos] = resumo;
        this.arrayTemas[quantidadeResumos] = tema;
        this.quantidadeResumos += 1;
        if(quantidadeResumos == numeroDeResumos){
            quantidadeResumos = 0;
            determinaQuantidade = true;
        }
    }

    /**
     * Certifica-se se a quantidade de resumos cadastradas vai ser ou não zeradas, dependendo
     * se o valor é referente a posição ou a quantidade de resumos registrados.
     * Zera se o array chegar ao tamanho limite, reiniciando das posições inicias novamente.
     * Retorna um valor inteiro se for referente ao número total de resumos cadastrados.
     * 
     * @return retorna o valor total de resumos ou o contador para a posição dos resumos.
     */
    private int verificaDeterminaQuantidade() {
        if(determinaQuantidade){
            return numeroDeResumos;
        }else{
            return quantidadeResumos;
        }
    }

    /**
     * Retorna uma String (para cada resumo já registrado) com o tema do resumo e a sua descrição.
     * Separados por ":", no formato "título/tema: descrição/resumo".
     * 
     * @return retorna o array com o tema e a descrição do resumo.
     */
    public String[] pegaResumos() {
        this.arrayTemaResumo = new String[numeroDeResumos];
        int quantidade = verificaDeterminaQuantidade();
        for(int i = 0; i < quantidade; i++){
            arrayTemaResumo[i] = arrayTemas[i] + ": " + arrayResumos[i];
        }
        return arrayTemaResumo;
    }

    /**
     * Retorna o valor referente a quantidade de resumos já registrados pelo aluno.
     * 
     * @return retorna a quantidade de resumos cadastradas.
     */
    public int conta() {
        int quantidade = verificaDeterminaQuantidade();
        this.tamanhoArrayResumos = quantidade;
        return tamanhoArrayResumos;
    }

    /**
     * Retorna duas Strings (em linhas diferentes(\n)).
     * A primeira com a quantidade de resumos cadastrados até o momento.
     * A segunda com o título do tema de cada resumo cadastrado, separados por "|". 
     * No formato:
     * "- X resumo(s) cadastrado(s)" onde X é a quantidade total de resumos registrados pelo aluno.
     * "- AAAA | BBBB | CCCC" onde AAAA, BBBB e CCCC são os temas/títulos de cada resumo registrado.
     * 
     * @return retorna as informações dos resumos cadastrados pelo aluno, bem como seus temas.
     */
    public String imprimeResumos() {
        int quantidade = verificaDeterminaQuantidade();
        meuPrint = "- " + quantidade + " resumo(s) cadastrado(s)\n" + "- ";
        for(int i = 0; i < quantidade; i++){
            if(i == quantidade-1){
                meuPrint += arrayTemas[i];
            }else{
                meuPrint += arrayTemas[i] + " | ";
            }
        }
        return meuPrint;
    }

    /**
     * Retorna "true" ou "false" dependendo se o título do tema do resumo registrado pelo aluno
     * está ou não presente nos resumos cadastrados.
     * 
     * @param tema representa o título do tema do resumo a ser procurado.
     * @return retorna se há o tema procurado ou não com "true" ou "false".
     */
    public boolean temResumo(String tema) {
        boolean integraTema = false; 
        for(String NomeDoTema : arrayTemas){
            if(NomeDoTema == null){
                break;
            }
            else if(NomeDoTema.equals(tema)){
                integraTema = true;
            }
        }
        return integraTema;
    }
}
