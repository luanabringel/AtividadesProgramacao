public class Local {

    private String nome;

    private String ramal;

    private String idTextual;

    private String[] comitivas;

    public Local(String nome, String ramal){
        this.nome = nome;
        this.ramal = ramal;
    }

    public Local(String idTextual){
        this.idTextual = idTextual;
    }
    
    public String getNome(String nome){
        return nome;
    }

    public String getIdTextual(String idTextual){
        return idTextual;
    }

    public String getRamal(String ramal){
        return ramal;
    }

    public static boolean verificaLocal(String idTextualAdicionado, String[] idTextual){
        boolean meuReturn = false;
        for(int i = 0; i < idTextual.length; i++){
            if(idTextual[i] != null){
                if(idTextual[i].equals(idTextualAdicionado)){
                    meuReturn = true;
                }
            }
        }
        return meuReturn;
    }

    @Override
    public String toString(){
        return " - " + nome + " - " + ramal;
    }

    public int incrementaPessoas(){
        int totalPessoas = 0;
        totalPessoas += Comitiva.getPessoas();
        return totalPessoas;
    }
}
