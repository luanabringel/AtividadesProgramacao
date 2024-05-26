public class LULA{

    private Local[] locais;

    private Comitiva[] comitivas;

    private int posicao;

    private String[] idsTextuais;

    private Comitiva[] totalPessoas;

    public LULA(){

        this.locais = new Local[100];
        this.comitivas = new Comitiva[100];
        this.posicao = -1;
        this.idsTextuais = new String[100];
    }

    public String cadastraLocal(String nome, String idTextual, String ramal){
        Local local = new Local(nome, ramal);
        String localId = new String(idTextual);
        if (Local.verificaLocal(idTextual, idsTextuais)) {
			System.out.println("Local já cadastrado");
			return "Local já cadastrado";
		} else {
			this.locais[posicao++] = local;
            this.idsTextuais[posicao++] = localId;
			System.out.println("Local cadastrado");
			return "Local cadastrado";
		}
    }

    public String cadastraComitiva(int idComitiva, String descricao, String telefone, int pessoas){
        Comitiva comitiva = new Comitiva(idComitiva, descricao, telefone, pessoas);
        if (idComitiva > 99 || idComitiva < 0) {
            throw new IndexOutOfBoundsException("Identificador Inválido");
		}
        else if (Comitiva.verificaComitiva(comitiva, comitivas)) {
			System.out.println("Comitiva já cadastrada");
			return "Comitiva já cadastrada";
		} else {
			this.comitivas[idComitiva] = comitiva;
			System.out.println("Comitiva cadastrada");
			return "Comitiva cadastrada";
		}
    }

    public Comitiva[] getComitivas(){
        return this.comitivas.clone();
    }

    public Local[] getLocais(){
        return this.locais.clone();
    }

    public String exibeLocal(String idTextualLocal){
        int indiceId = 0;
        for(int i =0; i < locais.length; i++){
            if(idsTextuais[i].equals(idTextualLocal)){
                indiceId = i;
                break;
            }
        }
        return idTextualLocal + locais[indiceId].toString();
    }

    public String exibeComitiva(int idComitiva){
        return comitivas[idComitiva].toString();
    }

    public void criarComentarios(String comentario, String idLocal){
        int indiceIdLocal = 0;
        for(int i =0; i < locais.length; i++){
            if(idsTextuais[i].equals(idLocal)){
                indiceIdLocal = i;
            }
        }
    	locais[indiceIdLocal].cadastraComentario(comentario, idLocal);
    }

    public String listarComentarios(String idTextual){
        int indiceLocal = 0;
        for(int i =0; i < locais.length; i++){
            if(idsTextuais[i].equals(idTextual)){
                indiceLocal = i;
            }
        }
    	return locais[indiceLocal].exibirComentarios();
    }

    public void RegistraComitiva(String idTextual, int idComitiva){
    }

    public int RegistraPessoas(String idTextual){
    }
}
