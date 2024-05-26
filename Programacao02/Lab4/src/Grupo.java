import java.util.ArrayList;
import java.util.HashMap;
/**
 * Construção do objeto grupo, com nome e tamanho (opcional).
 * 
 * @author Luana Bringel Leite
 *
 */

public class Grupo{
	/**
	 * Booleano para saber se o grupo tem tamanho máximo.
	 */
    private boolean limite;
    /**
     * Inteiro do tamanho máximo do grupo.
     */
    private int tamanho;
    /**
     * Nome do grupo.
     */
    private String nome;
    /**
     * HashMap dos alunos.
     */
    private HashMap<String, Aluno> alunos;

    /**
     * Constrói um grupo com nome e sem receber o tamanho.
     * 
     * @param nome Nome do grupo.
     */
    public Grupo(String nome){
        if(nome != null){
            if(!nome.equals("")){
                this.nome = nome;
                this.limite = false;
                this.tamanho = -1;
                this.alunos = new HashMap<>();
            }else{
                throw new IllegalArgumentException("PARÂMETRO VAZIO RECEBIDO");
            }
        }else{
            throw new NullPointerException("PARÂMETRO NULL RECEBIDO");
        }
    }

     /**
     * Constrói um grupo com nome e tamanho recebidos do usuário.
     * 
     * @param nome O nome do grupo.
     * @param tamanho O tamanho do grupo(limite de pessoas).
     */
    public Grupo(String nome, int tamanho){
        if(nome == null){
            throw new IllegalArgumentException("PARÂMETRO NULL RECEBIDO");
        }else if(nome.equals("")){
            throw new IllegalArgumentException("PARÂMETRO VAZIO RECEBIDO");
        }else if(tamanho < 0){
            throw new IllegalArgumentException("TAMANHO DO GRUPO INVÁLIDO");
        }else{
            this.nome = nome;
            this.tamanho = tamanho;
            this.limite = true;
            this.alunos = new HashMap<>(tamanho);
        }
    }

    /**
     * Aloca um determinado aluno em um determinado grupo por vez.
     * 
     * @param matricula A matricula do aluno.
     * @param aluno O objeto aluno.
     * @return Retorna uma mensagem se o grupo ja esta cheio, se o aluno foi alocado ou se o aluno
     * não é cadastrado.
     */
    public String cadastrarAluno(String matricula, Aluno aluno){
        if(this.limite == true && this.tamanho == this.alunos.size()){
            return "GRUPO CHEIO";
        }else{
            if(!this.alunos.containsKey(matricula)){
                this.alunos.put(matricula, aluno);
                return "ALUNO ALOCADO!";
            }
        }
        return "ALUNO NÃO CADASTRADO!";
    }

    /**
     * Verifica a existência de um aluno no grupo.
     * 
     * @param matricula A matricula do aluno.
     * @return Retorna se o aluno existe ou não é cadastrado ainda.
     */
    public boolean existeAluno(String matricula){
        return this.alunos.containsKey(matricula);
    }

    /**
     * Acessa o nome do grupo.
     * 
     * @return Retorna uma string com o nome do grupo.
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Acessa o tamanho do grupo.
     * 
     * @return Retorna uma string com o tamanho do grupo.
     */
    public int getTamanho() {
    	return this.tamanho;
    }

    /**
     * ArrayList com o nome do grupo, os cursos dos alunos existentes e quantidade de alunos
     * em cada grupo.
     * 
     * @return Retorna uma lista para cada grupo com as informações do nome, os cursos dos alunos
     * cadastrados e a quantidade de alunos.
     */
    public ArrayList<String> cursosCadastrados(){
        ArrayList<String> cursosAlunos = new ArrayList<String>();
        ArrayList<String> registra = new ArrayList<String>();
        for(String aluno : this.alunos.keySet()){
            String nomeCurso = this.alunos.get(aluno).getCurso();
            int contador = 0;
            if(!registra.contains(nomeCurso)){
                registra.add(nomeCurso);
                for(String alunos : this.alunos.keySet()){
                    if(this.alunos.get(alunos).getCurso().equals(nomeCurso)){
                        contador++;
                    }
                }
                cursosAlunos.add(nomeCurso + ": " + contador);
            }
        }
        return cursosAlunos;
    }

    /**
     * Verifica se um grupo criado já existe.
     * 
     * @return Retorna um booleano se o grupo é igual ou não a outro grupo.
     */
    public boolean equals(Object o){
        if(o == null){
            return false;
        }else if(this.getClass() != o.getClass()){
            return false;
        }else{
            Grupo grupo = (Grupo) o;
            return this.nome.equals(grupo.nome);
        }
    }

    /**
     * Retorna o hashCode do nome do grupo.
     * 
     * @return Retorna um inteiro do hasCode do grupo.
     */
    @Override
    public int hashCode(){
        return this.nome.hashCode();
    }

    /**
     * Formatação da mensagem que vai aparecer com as infromações dos grupos.
     * 
     * @return Retorna a mensagem com o nome do grupo, tamanho e a ocupação do grupo.
     */
    @Override
    public String toString(){
        return "- " + this.nome + " " + this.alunos.size() + "/" + (this.limite? this.tamanho: "Ilimitado");
    }
}