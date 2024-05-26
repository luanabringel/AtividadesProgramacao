package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.ControllerDocumentos;
import documin.ControllerVisoes;

class ControllerVisoesTest {
	private ControllerVisoes controladorV;
	private ControllerDocumentos controladorD;
	
	@BeforeEach
	void Inicializa() {
		this.controladorV = new ControllerVisoes();
		this.controladorD = new ControllerDocumentos();
	}
	
	@Test
	void criarVisaoCompleta() {
		controladorD.criarDocumento("Teste");
		controladorD.criarTexto("Teste", "textotest", 2);
		controladorD.criarTermo("Teste", "termo1/termo2", 4, "/", "Alfabética");
		assertEquals(0, controladorV.criarVisaoCompleta("Teste", controladorD.getDocumentos()));
	}
	
	@Test
	void criarVisaoResumida() {
		controladorD.criarDocumento("Teste1");
		controladorD.criarTexto("Teste1", "textotest", 2);
		controladorD.criarTermo("Teste1", "termo1/termo2", 4, "/", "Alfabética");
		assertEquals(0, controladorV.criarVisaoResumida("Teste1", controladorD.getDocumentos()));
	}
	
	@Test
	void criarVisaoPrioritaria() {
		controladorD.criarDocumento("Teste");
		controladorD.criarTexto("Teste", "textotest", 2);
		controladorD.criarTermo("Teste", "termo1/termo2", 4, "/", "Alfabética");
		assertEquals(0, controladorV.criarVisaoPrioritaria("Teste", 3, controladorD.getDocumentos()));
	}
	
	@Test
	void criarVisaoTitulo() {
		controladorD.criarDocumento("Teste");
		controladorD.criarTexto("Teste", "textotest", 2);
		controladorD.criarTitulo("Teste", "titulotest", 1, 3, false);
		controladorD.criarTermo("Teste", "termo1/termo2", 4, "/", "Alfabética");
		assertEquals(0, controladorV.criarVisaoTitulo("Teste", controladorD.getDocumentos()));
	}
	
	@Test
	void exibirVisao() {
		controladorD.criarDocumento("Teste");
		controladorD.criarTexto("Teste", "textotest", 2);
		controladorD.criarTitulo("Teste", "titulotest", 1, 3, false);
		controladorD.criarTermo("Teste", "termo1/termo2", 3, "/", "Alfabética");
		assertEquals(0, controladorV.criarVisaoCompleta("Teste", controladorD.getDocumentos()));
		assertEquals(1, controladorV.criarVisaoResumida("Teste", controladorD.getDocumentos()));
		assertEquals(2, controladorV.criarVisaoPrioritaria("Teste", 3, controladorD.getDocumentos()));
		assertEquals(3, controladorV.criarVisaoTitulo("Teste", controladorD.getDocumentos()));
		String[] exemplo1 = {"textotest\n", "3. titulotest\n", "Total termos: 2\n- termo1, termo2\n"};
		String[] exemplo2 = {"textotest\n", "3. titulotest\n", "termo1 / termo2\n"};
		String[] exemplo3 = {"Total termos: 2\n- termo1, termo2\n"};
		String[] exemplo4 = {"3. titulotest\n"};
		assertArrayEquals(exemplo1, controladorV.exibirVisao(0));
		assertArrayEquals(exemplo2, controladorV.exibirVisao(1));
		assertArrayEquals(exemplo3, controladorV.exibirVisao(2));
		assertArrayEquals(exemplo4, controladorV.exibirVisao(3));
	}
}
