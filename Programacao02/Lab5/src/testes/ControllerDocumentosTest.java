package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import documin.ControllerDocumentos;

class ControllerDocumentosTest {
	private ControllerDocumentos controlador;
	
	@BeforeEach
	void Inicializa() {
		this.controlador = new ControllerDocumentos();
	}
	
	@Test
	void cadastraDocumento() {
		assertEquals(true, controlador.criarDocumento("Teste"));
	}
	
	@Test
	void cadastraDocumentoTituloVazio() {
		try {
			controlador.criarDocumento("");
			fail("Nao deveria aceitar título vazio!");
		}catch(IllegalArgumentException e) {
			assertEquals("Titulo Inválido.", e.getMessage());
		}
	}
	
	@Test
	void cadastraDocumentoTamanho() {
		assertEquals(true, controlador.criarDocumento("Teste", 10));
	}
	
	@Test
	void cadastraDocumentoTamanhoInvalido() {
		try {
			controlador.criarDocumento("Teste", 0);
			fail("Nao deveria aceitar tamanho inválido!");
		}catch(IllegalArgumentException e) {
			assertEquals("Tamanho inválido.", e.getMessage());
		}
	}
	
	@Test
	void cadastraDocumentoJaCadastrado() {
		assertEquals(true, controlador.criarDocumento("Teste"));
		assertEquals(false, controlador.criarDocumento("Teste"));
	}
	
	@Test
	void exibirDocumentoCompleto() {
		controlador.criarDocumento("Teste", 1);
		controlador.criarTexto("Teste", "texto", 0);
		String[] exemplo = new String[1];
		exemplo[0] = "texto\n";
		assertArrayEquals(exemplo, controlador.exibirDocumentoCompleto("Teste"));
	}
	
	@Test
	void exibirDocumentoResumido() {
		controlador.criarDocumento("Teste", 3);
		controlador.criarTexto("Teste", "texto", 0);
		controlador.criarTermo("Teste", "termo1/termo2", 4, "/", "Alfabética");
		String[] exemplo = new String[2];
		exemplo[0] = "texto\n";
		exemplo[1] = "termo1 / termo2\n";
		assertArrayEquals(exemplo, controlador.exibirDocumentoResumido("Teste"));
	}
	
	@Test
	void removerDocumento() {
		controlador.criarDocumento("Teste");
		controlador.removerDocumento("Teste");
		try {
			controlador.exibirDocumentoCompleto("Teste");
			fail("Nao deveria aceitar titulo inválido, documento inexistente!");
		}catch(NoSuchElementException e) {
			assertEquals("Documento não criado.", e.getMessage());
		}
	}
	
	@Test
	void quantidadeElementos() {
		controlador.criarDocumento("Teste");
		assertEquals(0, controlador.contarElementosNoDocumento("Teste"));
	}
	
	@Test
	void cadastrarTexto() {
		controlador.criarDocumento("Teste", 10);
		assertEquals(0, controlador.criarTexto("Teste", "textotest", 2));
	}
	
	@Test
	void cadastrarTermo() {
		controlador.criarDocumento("Teste", 10);
		assertEquals(0, controlador.criarTermo("Teste", "termotest", 5, "|", "Tamanho"));
		assertEquals(1, controlador.criarTermo("Teste", "termotest2", 2, "|", "Tamanho"));
	}
	
	@Test
	void cadastrarLista() {
		controlador.criarDocumento("Teste", 10);
		controlador.criarTermo("Teste", "termotest", 5, "|", "Nenhum");
		controlador.criarTermo("Teste", "termotest2", 2, "|", "Tamanho");
		assertEquals(2, controlador.criarLista("Teste", "listatest", 0, "|", "-"));
	}
	
	@Test
	void testCadastrarTitulo() {
		controlador.criarDocumento("Teste", 10);
		controlador.criarTermo("Teste", "termotest", 5, "|", "Tamanho");
		controlador.criarTermo("Teste", "termotest2", 2, "|", "Alfabética");
		assertEquals(2, controlador.criarTitulo("Teste", "titulotest", 1, 3, false));
	}

	@Test
	void cadastrarElementoDocumentoLotado() {
		controlador.criarDocumento("Teste", 5);
		controlador.criarTermo("Teste", "termotest", 5, "", "Tamanho");
		controlador.criarTermo("Teste", "termotest1/termotest2", 2, "/", "Alfabética");
		controlador.criarTitulo("Teste", "titulotest", 1, 3, false);
		controlador.criarLista("Teste", "lista1|lista2|lista3|lista4", 0, "|", "-");
		controlador.criarTexto("Teste", "textotest", 2);
		try {
			controlador.criarTexto("Teste", "textotest2", 4);
			fail("Nao deveria aceitar um novo cadastro, documento cheio!");
		}catch(IllegalArgumentException e) {
			assertEquals("Documento cheio.", e.getMessage());
		}
	}
	
	@Test
	void representacaoCompletaElemento() {
		controlador.criarDocumento("Teste1");
		controlador.criarDocumento("Teste", 10);
		controlador.criarTexto("Teste", "textotest", 5);
		assertEquals("textotest\n", controlador.representacaoCompletaElemento("Teste", 0));
		controlador.criarTermo("Teste", "termo1/termo2", 2, "/", "Alfabética");
		assertEquals("Total termos: 2\n"
				+ "- termo1, termo2\n", controlador.representacaoCompletaElemento("Teste", 1));
		controlador.criarTitulo("Teste", "titulotest", 4, 4, false);
		assertEquals("4. titulotest\n", controlador.representacaoCompletaElemento("Teste", 2));
		controlador.criarLista("Teste", "lista1|lista2|lista3|lista4", 0, "|", "-");
		assertEquals("- lista1\n"
				+ "- lista2\n"
				+ "- lista3\n"
				+ "- lista4\n", controlador.representacaoCompletaElemento("Teste", 3));
		controlador.criarAtalho("Teste", "Teste1");
		controlador.representacaoResumidaElemento("Teste", 4);
		assertEquals("textotest\n" + "4. titulotest\n", controlador.representacaoResumidaElemento("Teste", 4));
	}
	
	@Test
	void representacaoResumidaElemento() {
		controlador.criarDocumento("Teste1");
		controlador.criarDocumento("Teste", 10);
		controlador.criarTexto("Teste", "textotest", 5);
		assertEquals("textotest\n", controlador.representacaoResumidaElemento("Teste", 0));
		controlador.criarTermo("Teste", "termo1/termo2", 4, "/", "Alfabética");
		assertEquals("termo1 / termo2\n", controlador.representacaoResumidaElemento("Teste", 1));
		controlador.criarTitulo("Teste", "titulotest", 0, 1, false);
		assertEquals("1. titulotest\n", controlador.representacaoResumidaElemento("Teste", 2));
		controlador.criarLista("Teste", "lista1|lista2|lista3|lista4", 0, "|", "-");
		assertEquals("lista1, lista2, lista3, lista4\n", controlador.representacaoResumidaElemento("Teste", 3));
		controlador.criarAtalho("Teste", "Teste1");
		assertEquals("textotest\n" + "termo1 / termo2\n", controlador.representacaoResumidaElemento("Teste", 4));
	}
	
	@Test
	void criarAtalho() {
		controlador.criarDocumento("Teste");
		controlador.criarDocumento("Teste1");
		assertEquals(0, controlador.criarAtalho("Teste1", "Teste"));
	}
	
	@Test
	void removerElemento() {
		controlador.criarDocumento("Teste");
		controlador.criarTexto("Teste", "textotest", 2);
		controlador.criarTermo("Teste", "termo1/termo2", 2, "/", "Alfabética");
		assertEquals(2, controlador.contarElementosNoDocumento("Teste"));
		assertEquals(true, controlador.removerElemento("Teste", 0));
		assertEquals(1, controlador.contarElementosNoDocumento("Teste"));
	}
	
	@Test
	void moverParaCima() {
		controlador.criarDocumento("Teste");
		controlador.criarTermo("Teste", "termo1/termo2", 2, "/", "Alfabética");
		controlador.criarTexto("Teste", "textotest", 2);
		assertEquals("textotest\n", controlador.representacaoResumidaElemento("Teste", 1));
		controlador.moverParaCima("Teste", 1);
		assertEquals("textotest\n", controlador.representacaoResumidaElemento("Teste", 0));
	}
	
	@Test
	void moverParaBaixo() {
		controlador.criarDocumento("Teste");
		controlador.criarTexto("Teste", "textotest", 2);
		controlador.criarTermo("Teste", "termo1/termo2", 2, "/", "Alfabética");
		assertEquals("textotest\n", controlador.representacaoResumidaElemento("Teste", 0));
		controlador.moverParaBaixo("Teste", 0);
		assertEquals("textotest\n", controlador.representacaoResumidaElemento("Teste", 1));
	}
}
