import java.util.Arrays;

public class Comitiva {

    private int idComitiva;

    private String descricao;

    private String telefone;

    private int pessoas;

    private int posicao;

    private Comentario[] comentarios;

    public Comitiva(int idComitiva, String descricao, String telefone, int pessoas){
        this.idComitiva = idComitiva;
        this.descricao = descricao;
        this.telefone = telefone;
        this.pessoas = pessoas;
        this.comentarios = new Comentario[100];
        this.posicao = -1;
    }

    public int getIdComitiva(int idComitiva){
        return idComitiva;
    }

    public String getDescricao(String descricao){
        return descricao;
    }

    public String getTelefone(String telefone){
        return telefone;
    }

    public static int getPessoas(int pessoas){
        return pessoas;
    }

    public Comentario[] getComentarios(Comentario[] comentarios){
        return comentarios;
    }

    public static boolean verificaComitiva(Comitiva comitivaAdicionada, Comitiva[] comitivas){
        boolean meuRetorno = false;
        for(int i = 0; i < comitivas.length; i++){
            if(comitivas[i] != null){
                if(comitivas[i].equals(comitivaAdicionada)){
                    meuRetorno = true;
                }
            }
        }
        return meuRetorno;
    }

    @Override
    public String toString(){
        return "ID: " + idComitiva + "\n" 
        + "Comitiva: " + descricao + "\n" 
        + "Integrantes: " + pessoas + "\n"
        + "Contato: " + telefone;
    }

    public void cadastraComentario(String comentario, String idLocal){
        Comentario comentarioAdicionado = new Comentario(comentario, idLocal);
        this.comentarios[posicao++] = comentarioAdicionado;
    }

    public String exibirComentarios() {
    	return Arrays.toString(comentarios);
    }
}
