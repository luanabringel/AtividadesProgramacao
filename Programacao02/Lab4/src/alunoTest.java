
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class alunoTest {

	@Test
	void construtorInvalido() {
		try {
			Aluno aluno = new Aluno("", "Luana Bringel", "cc");
		}
		catch(IllegalArgumentException e) {
			assertEquals("PARÂMETRO VAZIO RECEBIDO", e.getMessage());
		}
	}
	
	@Test
	void construtorInvalidoComNull() {
		try {
			Aluno aluno = new Aluno(null, "Luana Bringel", "cc");
		}
		catch(IllegalArgumentException e) {
			assertEquals("PARÂMETRO VAZIO RECEBIDO", e.getMessage());
		}
	}
	
	@Test
	void toStringTest() {
		Aluno aluno = new Aluno("1111", "Luana Bringel", "cc");
		assertEquals("Aluno: 1111 - Luana Bringel - cc", aluno.toString());
	}

}
