package agenda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import agenda.Contato;

public class ContatoTest {


    @Test
    public void verificaNomeSobrenomeIguais(){
        Contato contato = new Contato(10, "Luana", "Bringel", "9393-4848");
        Contato contato1 = new Contato(6, "Luana", "Bringel", "9393-4848");

        Assertions.assertEquals(true, contato.equals(contato1));
    }

    @Test
    public void verificaNomeSobrenomeDiferentes(){
        Contato contato = new Contato(6, "Luana", "Bringel", "7859-1313");
        Contato contato1 = new Contato(4, "Livia", "Campos", "5485-5555");

        Assertions.assertEquals(false, contato.equals(contato1));
    }

    @Test
    public void verificaContatoJaCadastrado(){
        Contato contato = new Contato(6, "Luana", "Bringel", "9393-9392");
        Contato contato1 = new Contato(4, "Matheus", "Gaudêncio", "5555-5251");
        Contato contato2 = new Contato(1, "Luana", "Bringel", "6796-6741");
        Contato[] arrayContato = new Contato[2];
        arrayContato[1] = contato;
        arrayContato[0] = contato1;

        Assertions.assertEquals(true, Contato.verificaNome(contato2, arrayContato));
    }

    @Test
    public void verificaContatoNaoCadastrado(){
        Contato contato = new Contato(6, "Luana", "Bringel", "9393-9392");
        Contato contato1 = new Contato(4, "Livia", "Campos", "6796-6741");
        Contato contato2 = new Contato(10, "Matehus", "", "6655-5251");
        Contato[] arrayContato = new Contato[2];
        arrayContato[1] = contato;
        arrayContato[0] = contato1;

        Assertions.assertEquals(false, Contato.verificaNome(contato2, arrayContato));
    }

    @Test
    public void ToStringContato(){
        Contato contato = new Contato(4, "Luana", "Bringel", "9393-9392");

        Assertions.assertEquals("Luana" + " " + "Bringel" + "\n" + "9393-9392" + "\n", contato.toString());
    }
    @Test
    public void ContatoSemSobrenome(){
        Contato contato = new Contato(8, "Luana", "", "9393-9392");

        Assertions.assertEquals("Luana" + " "+ "\n" + "9393-9392" + "\n", contato.toString());
    }

    @Test
    public void verificaConstrutor(){
        Contato contato = new Contato(2, "Luana", "Bringel", "9393-9392");
        int posicao = 2;
        String nome = "Luana";
        String sobrenome = "Bringel";
        String telefone = "9393-9392";
        Assertions.assertEquals(posicao, contato.getPosicao());
        Assertions.assertEquals(nome, contato.getNome());
        Assertions.assertEquals(sobrenome, contato.getSobrenome());
        Assertions.assertEquals(telefone, contato.getTelefone());
    }
}
