package agenda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgendaTest {

    @Test
    public void ContatoJaCadastrado(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Livia", "", "5575-6564");
        Contato contato2 = new Contato(3, "Luana", "Bringel", "9999-9554");

        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());

        Assertions.assertEquals("Contato já cadastrado", agenda.cadastraContato(contato2.getPosicao(), contato2.getNome(), contato2.getSobrenome(), contato2.getTelefone()));
    }

    @Test
    public void ContatoCadastrado(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Livia", "", "5575-6564");
        Contato contato2 = new Contato(3, "Matheus", "Gaudencio", "555-4446");

        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());

        Assertions.assertEquals("Contato cadastrado!", agenda.cadastraContato(contato2.getPosicao(), contato2.getNome(), contato2.getSobrenome(), contato2.getTelefone()));
    }
    
    @Test
    public void ContatoRemovidoFavoritos(){

        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        agenda.cadastraFavorito(1, 1);
        agenda.removeFavorito(1);

        Assertions.assertNull(agenda.getFavorito(1));
    }

    @Test
    public void ContatoSemFavoritos(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Matheus", "Gaudencio", "7952-4191");

        String[] contatos = new String[2];
        contatos[0] = contato.toString();
        contatos[1] = contato1.toString();

        String[] tags = new String[1];
        tags[0] = "UFCG";

        Agenda agenda1 = new Agenda();
        agenda1.cadastraContato(1, contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda1.cadastraContato(2, contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());

        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        agenda.cadastraContato(2, "Matheus", "Gaudencio", "7952-4191");

        Assertions.assertEquals(agenda1.getContato(0), agenda.getContato(0));
    }

    @Test
    public void exibirContato(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato2 = new Contato(2, "Matheus", "Gaudencio", "777-7785");

        Contato[] contatos = new Contato[2];
        contatos[0] = contato;
        contatos[1] = contato2;

        String[] tags = new String[2];
        tags[0] = "UFCG";

        Agenda agenda1 = new Agenda();
        agenda1.cadastraContato(1, contatos[0].getNome(), contatos[0].getSobrenome(), contatos[0].getTelefone());
        agenda1.cadastraContato(2, contatos[1].getNome(), contatos[1].getSobrenome(), contatos[1].getTelefone());
        agenda1.cadastraFavorito(1, 1);
        
        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        agenda.cadastraContato(2, "Matheus", "Gaudencio", "777-7785");
        agenda.cadastraFavorito(1, 1);

        Assertions.assertEquals(agenda1.getContato(1), agenda.getContato(1));
        Assertions.assertEquals(agenda1.getContato(2), agenda.getContato(2));
    }
    @Test
    public void exibirPosicaoInvalida(){

        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        agenda.cadastraContato(2, "Bruna", "Picanço", "98956715");

        Assertions.assertEquals("Posição Inválida!", agenda.getContato(4));
    }

    @Test
    public void ContatoJaFavoritado(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Bruna", "Picanço", "98956715");


        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());
        agenda.cadastraFavorito(1,1);


        Assertions.assertEquals(true, agenda.existe(1));
    }

    @Test
    public void ContatoNaoFavoritado(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Bruna", "Picanço", "98956715");


        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());
        agenda.cadastraFavorito(1,1);

        Assertions.assertEquals(false, agenda.existe(2));
    }

    @Test
    public void favoritoJaCadastrado(){

        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        agenda.cadastraContato(2, "Bruna", "Picanço", "98956715");
        agenda.cadastraFavorito(1, 1);

        Assertions.assertEquals("Favorito já cadastrado", agenda.cadastraFavorito(1,2));
    }
    
    @Test
    public void contatoAdicionadoFavorito(){

        Agenda agenda = new Agenda();
        agenda.cadastraContato(1, "Luana", "Bringel", "9999-9554");
        
        Assertions.assertEquals("Favorito cadastrado na posição 1!", agenda.cadastraFavorito(1,1));
    }

    @Test
    public void ContatoRemovido(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Bruna", "Picanço", "98956715");


        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());

        Assertions.assertEquals("Contato removido", agenda.removeContato("1"));
    }
    
    @Test
    public void PosicaoInvalidaContatoNaoRemovido(){
        Contato contato = new Contato(1, "Luana", "Bringel", "9999-9554");
        Contato contato1 = new Contato(2, "Bruna", "Picanço", "98956715");


        Agenda agenda = new Agenda();
        agenda.cadastraContato(contato.getPosicao(), contato.getNome(), contato.getSobrenome(), contato.getTelefone());
        agenda.cadastraContato(contato1.getPosicao(), contato1.getNome(), contato1.getSobrenome(), contato1.getTelefone());

        Assertions.assertEquals("Posição inválida!", agenda.removeContato("10"));
    }
    @Test
    public void PosicaoInvalida(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(101, "Luana", "Bringel", "99999554");
        Contato contato1 = new Contato(-1, "Luana", "Bringel", "9999-9554");
        Contato contato2 = new Contato(0, "Luana", "Bringel", "9999-9554");


        Assertions.assertEquals(true, agenda.verificaPosicao(contato.getPosicao()));
        Assertions.assertEquals(true, agenda.verificaPosicao(contato1.getPosicao()));
        Assertions.assertEquals(true, agenda.verificaPosicao(contato2.getPosicao()));
    }
    
    @Test
    public void PosicaoValida(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(1, "Luana", "Bringel", "99999554");
        Contato contato1 = new Contato(100, "Luana", "Bringel", "9999-9554");
        Contato contato2 = new Contato(50, "Luana", "Bringel", "9999-9554");


        Assertions.assertEquals(false, agenda.verificaPosicao(contato.getPosicao()));
        Assertions.assertEquals(false, agenda.verificaPosicao(contato1.getPosicao()));
        Assertions.assertEquals(false, agenda.verificaPosicao(contato2.getPosicao()));
    }

    @Test
    public void NomeVazio(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(10, "", "Bringel", "939395115");


        Assertions.assertEquals(true, agenda.verificaNome(contato.getNome()));
    }
    @Test
    public void NomeNaoVazio(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(10, "Luana", "Bringel", "9999-9554");


        Assertions.assertEquals(false, agenda.verificaNome(contato.getNome()));
    }

    @Test
    public void TelefoneVazio(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(6, "Luana", "Bringel", "");


        Assertions.assertEquals(true, agenda.verificaTelefone(contato.getTelefone()));
    }

    @Test
    public void TelefoneNaoVazio(){
        Agenda agenda = new Agenda();
        Contato contato = new Contato(6, "Luana", "Bringel", "9999-9554");


        Assertions.assertEquals(false, agenda.verificaTelefone(contato.getTelefone()));
    }
}