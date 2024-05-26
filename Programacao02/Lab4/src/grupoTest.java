
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class grupoTest {

	@Test
	void construtorApenasNome() {
		Grupo grupo = new Grupo("listas");
		
		assertEquals(-1, grupo.getTamanho());
		assertEquals("listas", grupo.getNome());
	}
	
	@Test
	void construtorComTamnho() {
		Grupo grupo = new Grupo("listas", 10);
		
		assertEquals(10, grupo.getTamanho());
		assertEquals("listas", grupo.getNome());
	}
	
	@Test
	void construtorTamanhoMenorQueZero() {
		try {
			Grupo grupo = new Grupo("listas", -1);
		}
		catch(IllegalArgumentException e) {
			assertEquals("TAMANHO DO GRUPO INVÁLIDO", e.getMessage());
		}
	}
	
	@Test
	void construtorNomeNull() {
		try {
			Grupo grupo = new Grupo(null, 12);
		}
		catch(IllegalArgumentException e) {
			assertEquals("PARÂMETRO NULL RECEBIDO", e.getMessage());
		}
	}
	
	@Test
	void construtorNomeVazio() {
		try {
			Grupo grupo = new Grupo("", 12);
		}
		catch(IllegalArgumentException e) {
			assertEquals("PARÂMETRO VAZIO RECEBIDO", e.getMessage());
		}
	}
	
	@Test
	void cadastrarAluno() {
		Aluno aluno = new Aluno("1212", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 12);
		assertEquals("ALUNO ALOCADO!", grupo.cadastrarAluno(aluno.getMatricula(), aluno));
	}
	
	@Test
	void cadastrarAlunoRepetido() {
		Aluno aluno = new Aluno("1212", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 12);
		grupo.cadastrarAluno(aluno.getMatricula(), aluno);
		assertEquals("ALUNO NÃO CADASTRADO!", grupo.cadastrarAluno(aluno.getMatricula(), aluno));
	}
	
	@Test
	void toStringTest() {
		Aluno aluno = new Aluno("1212", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista", 12);
		grupo.cadastrarAluno(aluno.getMatricula(), aluno);
		assertEquals("- lista 1/12", grupo.toString());
	}
	
	@Test
	void toStringTest2() {
		Aluno aluno = new Aluno("1212", "Luana Bringel", "cc");
		Grupo grupo = new Grupo("lista");
		grupo.cadastrarAluno(aluno.getMatricula(), aluno);
		assertEquals("- lista 1/Ilimitado", grupo.toString());
	}
}
