/**
 * Construção do objeto aluno, com matrícula, nome completo e curso.
 * 
 * @author Luana Bringel Leite
 *
 */
public class Aluno {
	/**
	 * @param nome O nome completo do aluno.
	 */
    private String nome;
    /**
     * @param curso O curso do aluno.
     */
    private String curso;
    /**
     * @param matricula A matrícula do aluno.
     */
    private String matricula;
    
    /**
     * Constrói o aluno, atribuindo matricula, nome e curso.
     * 
     * @param matricula A matricula do aluno.
     * @param nome O nome do aluno.
     * @param curso O curso do aluno.
     * @throws IllegalArgumentException Retorna uma mensagem avisando que o parametro recebido é vazio.
     */
    public Aluno(String matricula, String nome, String curso){
        if(matricula != null && nome != null && curso != null){
            if(!matricula.equals("") && !nome.equals("") && !curso.equals("")){
                this.matricula = matricula;
                this.nome = nome;
                this.curso = curso;
            }
        }else{
            throw new IllegalArgumentException("PARÂMETRO VAZIO RECEBIDO");
        }
    }

    /**
     * Acessa o curso do aluno.
     * 
     * @return Retorna a strindo com o curso do aluno. 
     */
    public String getCurso() {
        return this.curso;
    }
    
    /**
     * Acessa a matrícula do aluno.
     * 
     * @return Retorna a strindo com a matrícula do aluno. 
     */
    public String getMatricula() {
    	return this.matricula;
    }

    /**
     * Cria um resumo sobre o aluno, com as informações da matricula, nome e curso.
     * 
     * @return Retorna em formato de texto as informações do aluno, com matricula, nome e curso.
     */
    public String toString(){
        return "Aluno: " + this.matricula + " - " + this.nome + " - " + this.curso;
    }

    /**
     * Gera o hashCode da matrícula do aluno.
     * 
     * @return Retorna um inteiro do hashCode referente a matricula do aluno.
     */
    @Override
    public int hashCode() {
        return this.matricula.hashCode();
    }

    /**
     * Verifica se um aluno criado já existe, através da matricula.
     * 
     * @return Retorna um booleano se o aluno é igual ou não a outro aluno.
     */
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }else if(this.getClass() != o.getClass()){
            return false;
        }else{
            Aluno aluno = (Aluno) o;
            return this.matricula.equals(aluno.matricula);
        }
    }
}
