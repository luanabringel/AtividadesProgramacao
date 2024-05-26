
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class controleTest {

	@Test
	void cadastrarAlunoValido() {
		Controle controle = new Controle();
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarAluno("1111", "Luana Bringel", "cc"));
	}
	
	@Test
	void cadastrarAlunoJaCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		assertEquals("MATRICULA JÁ CADASTRADA!", controle.cadastrarAluno("1111", "Luana Bringel", "cc"));
	}
	
	@Test
	void grupoValidoSemTamanho() {
		Controle controle = new Controle();
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarGrupo("listas"));
	}
	
	@Test
	void grupoValidoComTamanho() {
		Controle controle = new Controle();
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarGrupo("listas", 10));
	}
	
	@Test
	void cadastrarGrupoJaCadastradoSemTamanho() {
		Controle controle = new Controle();
		controle.cadastrarGrupo("listas");
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastrarGrupo("listas"));
	}
	
	@Test
	void cadastrarGrupoJaCadastradoComTamanhosDiferentes() {
		Controle controle = new Controle();
		controle.cadastrarGrupo("listas", 10);
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastrarGrupo("listas", 5));
	}
	
	@Test
	void cadastrarGrupoJaCadastradoComTamanhosIguais() {
		Controle controle = new Controle();
		controle.cadastrarGrupo("listas", 10);
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastrarGrupo("listas", 10));
	}
	
	@Test
	void exibirAlunoNaoCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		assertEquals("ALUNO NÃO CADASTRADO!", controle.exibirAluno("1111"));
	}
	
	@Test
	void exibirAluno() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		assertEquals("Aluno: 1111 - Luana Bringel - cc", controle.exibirAluno("1111"));
	}
	
	
	@Test
	void alocarAlunoNaoCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("listas", 10);
		controle.cadastrarGrupo("listas", 10);
		assertEquals("ALUNO NÃO CADASTRADO", controle.alocarAluno("1111", "listas"));
	}
	
	@Test
	void alocarAlunoGrupoNaoCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		assertEquals("GRUPO NÃO CADASTRADO", controle.alocarAluno("1111", "colecoes"));
	}
	
	@Test
	void alocarAluno() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		assertEquals("ALUNO ALOCADO!", controle.alocarAluno("1111", "lista"));
	}
	
	@Test
	void alocarAlunoLimite1() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 1);
		controle.cadastrarGrupo("lista", 1);
		assertEquals("ALUNO ALOCADO!", controle.alocarAluno("1111", "lista"));
	}
	
	@Test
	void verificarPertinenciaAlunoNaoPertence() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO!", controle.verificarPertinencia("1111", "lista"));
	}
	
	@Test
	void verificarPertinenciaAlunoPertence() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1111", "Luana Bringel", "cc");
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		controle.alocarAluno("1111", "lista");
		assertEquals("ALUNO PERTENCE AO GRUPO!", controle.verificarPertinencia("1111", "lista"));
	}
	
	@Test
	void verificarPertinenciaAlunoNaoCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		assertEquals("ALUNO NÃO CADASTRADO!", controle.verificarPertinencia("1111", "colecoes"));
	}
	
	@Test
	void verificarPertinenciaGrupoNaoCadastrado() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("listas", 10);
		assertEquals("GRUPO NÃO CADASTRADO!", controle.verificarPertinencia("1112", "colecoes"));
	}
	
	@Test
	void listarGruposAluno() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		controle.alocarAluno("1112", "lista");
		assertEquals("[- lista 1/10]", controle.listarGruposAluno("1112"));
	}
	
	@Test
	void listarGruposAlunoSemGrupo() {
		Controle controle = new Controle();
		controle.cadastrarAluno("1112", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 10);
		controle.cadastrarGrupo("lista", 10);
		assertEquals("[]", controle.listarGruposAluno("1112"));
	}
	
}
