import java.util.ArrayList;
import java.util.HashMap;

/**
 * Controlador de alunos e grupos da UFCG.
 * 
 * @author Luana Bringel Leite
 *
 */
public class Controle {
	/**
	 * @param alunos HashMap dos alunos.
	 */
    private HashMap<String, Aluno> alunos;
    /**
     * @param grupos HashMap dos grupos.
     */
    private HashMap<String, Grupo> grupos;
    
    /**
     * Constrói o controlador de alunos e grupos.
     * 
     */
    public Controle(){
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
    }
    
    /**
     * Cadastra o aluno com a chave matrícula, construíndo o objeto aluno com matrícula, nome e curso.
     * 
     * @param matricula A matricula do aluno.
     * @param nome O nome do aluno.
     * @param curso O curso do aluno.
     * @return Retorna uma mensagem informando se o cadastro foi realizado ou se a mátricula já
     * existia anteriormente.
     */
    public String cadastrarAluno(String matricula, String nome, String curso){
    	Aluno aluno = new Aluno(matricula, nome, curso);
        if(!existeAluno(matricula)){
            this.alunos.put(matricula, aluno);
            return "CADASTRO REALIZADO!";
        }else{
            return "MATRICULA JÁ CADASTRADA!";
        }
    }

    /**
     * Verifica se um grupo já existe ou não, através do nome do grupo.
     * 
     * @param grupo O grupo a verificar a existencia
     * @return Retorna um booleando afirmando se o grupo já existe ou não.
     */
    private boolean existeGrupo(String grupo){
        return this.grupos.containsKey(grupo);
    }

    /**
     * Verifica se um aluno existe, através da matrícula.
     * 
     * @param matricula A matrícula do aluno
     * @return Retorna um boolenao afirmando se o aluno já existe ou não.
     */
    private boolean existeAluno(String matricula){
        return this.alunos.containsKey(matricula);
    }

    /**
     * Aloca um determinado aluno em um determinado grupo.
     * 
     * @param matricula A matrícula do aluno.
     * @param nome O nome do grupo.
     * @return Retorna uma mensagem se o aluno não for cadastrado, ou o grupo não seja cadastrado,
     * ou retorna o cadastro do aluno ao grupo.
     */
    public String alocarAluno(String matricula, String nome){
        if(!existeAluno(matricula)){
            return "ALUNO NÃO CADASTRADO";
        }else if(!existeGrupo(nome)){
            return "GRUPO NÃO CADASTRADO";
        }
        return this.grupos.get(nome).cadastrarAluno(matricula, this.alunos.get(matricula));
    }

    /**
     * Verifica se um aluno pertence a um determinado grupo ou não.
     * 
     * @param matricula A matrícula do aluno.
     * @param grupo O nome de um grupo.
     * @return Retorna uma mensagem avisando se o grupo ou aluno não são cadastrados, ou 
     * avisa se o aluno pertence ou não ao grupo.
     */
    public String verificarPertinencia(String matricula, String grupo){
        String myReturn = "GRUPO NÃO CADASTRADO!"; 
        Grupo grupoI = this.grupos.get(grupo);
        if(!existeAluno(matricula)){
            myReturn = "ALUNO NÃO CADASTRADO!";
        }
        if(grupoI != null){
            if(grupoI.existeAluno(matricula)){
                myReturn = "ALUNO PERTENCE AO GRUPO!";
            }else{
                myReturn = "ALUNO NÃO PERTENCE AO GRUPO!";
            }
        }
        return myReturn;
    }

    /**
     * Cadastra novos grupos sem a informação do tamanho limite dele (máximo de alunos).
     * 
     * @param nome O nome do grupo.
     * @return Retorna uma mensagem avisando se o grupo foi cadastrado ou se o grupo
     * já havia sido cadastrado anteriormente.
     */
    public String cadastrarGrupo(String nome){
        Grupo grupo = new Grupo(nome);
        if(!existeGrupo(nome)){
            this.grupos.put(nome, grupo);
            return "CADASTRO REALIZADO!";
        }else{
        return "GRUPO JÁ CADASTRADO!";
        }
    }
        
    /**
     * Cadastra novos grupos com a informação do tamanho limite dele (máximo de alunos).
     * 
     * @param nome O nome do grupo.
     * @param tamanho O tamanho do grupo.
     * @return Retorna uma mensagem avisando se o grupo foi cadastrado ou se o grupo
     * já havia sido cadastrado anteriormente.
     */
    public String cadastrarGrupo(String nome, int tamanho){
        Grupo grupo = new Grupo(nome, tamanho);
        if(!existeGrupo(nome)){
            this.grupos.put(nome, grupo);
            return "CADASTRO REALIZADO!";
        }else{
        return "GRUPO JÁ CADASTRADO!";
        }
    }

    /**
     * Exibe um determinado aluno, exibindo as suas informações como matrícula, nome e curso.
     * 
     * @param matricula A matrícula do aluno.
     * @return Retorna uma mensagem com as informações do aluno desejado, ou informa que o aluno
     * não é cadastrado.
     */
    public String exibirAluno(String matricula){
        if(this.alunos.containsKey(matricula)){
            return this.alunos.get(matricula).toString();
        }else{
            return "ALUNO NÃO CADASTRADO!";
        }
    }

    /**
     * Verifica se um determinado aluno participa ou não de um determinado grupo.
     * 
     * @param nome O nome do grupo.
     * @param matricula A matrícula do aluno.
     * @return Retorna um booleando para caso o aluno participe ou não do grupo desejado.
     */
    public boolean participaGrupo(String nome, String matricula){
        if(this.grupos.get(nome) != null){
            if(this.grupos.get(nome).existeAluno(matricula)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Imprime uma lista com todos os grupos que um determinado aluno faz parte, assim como
     * também a quantidade de alunos participantes e a máxima.
     * 
     * @param matricula A matrícula do aluno.
     * @return Retorna um texto com a lista com os grupos e informações dos grupos que o aluno participa.
     */
    public ArrayList<String> listarGruposAluno(String matricula){
        ArrayList<String> lista = new ArrayList<>();
        for(String grupo : this.grupos.keySet()){
            if(this.grupos.get(grupo).existeAluno(matricula)){
                lista.add(this.grupos.get(grupo).toString().trim());
            }
        }
        return lista;
    }
}