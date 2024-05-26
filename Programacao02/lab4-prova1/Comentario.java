public class Comentario {
    
    private String local;

    private String comentario;

    public Comentario(String local, String comentario){
        this.comentario = comentario;
        this.local = local;
    }

    public String getLocal(String local){
        return local;
    }

    public String getComentario(String comentario){
        return comentario;
    }

    public String toString(){
        return local + " - " + comentario;
    }
}
