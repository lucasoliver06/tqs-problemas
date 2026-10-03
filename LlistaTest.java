import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LlistaTest {

	@Test
	void testAfegirUltim() {
		Llista llista = new Llista();
		boolean resultat = llista.afegirUltim(5);
		
		assertFalse(llista.esBuida());
		assertEquals(1, llista.getNElements());
		assertTrue(resultat);
		
	}
	
	@Test
	void testAfegirMultiplesElements() {
		Llista llista = new Llista();
		boolean resultat1 = llista.afegirUltim(1);
		boolean resultat2 = llista.afegirUltim(3);
		boolean resultat3 = llista.afegirUltim(5);
		
		assertEquals(3, llista.getNElements());
		assertTrue(resultat1);
		assertTrue(resultat2);
		assertTrue(resultat3);
		assertFalse(llista.esBuida());
	}

	@Test
	void testInsertarValor() {
		Llista llista = new Llista();
		llista.afegirUltim(10);
		llista.afegirUltim(20);
		llista.afegirUltim(30);
		// Estado inicial: [10, 20, 30]. Tamaño: 3

		// 1. Límites inválidos (Posición negativa y posición > nElements)
		assertFalse(llista.insertarValor(-1, 99));
		assertFalse(llista.insertarValor(4, 99));
		assertEquals(3, llista.getNElements()); // El tamaño no debe cambiar

		// 2. Límite frontera 0 (Insertar al principio)
		assertTrue(llista.insertarValor(0, 5));
		// Estado: [5, 10, 20, 30]
		assertEquals(5, llista.getValor(0));
		assertEquals(10, llista.getValor(1));
		assertEquals(4, llista.getNElements());

		// 3. Partición equivalente (Insertar en el medio)
		assertTrue(llista.insertarValor(2, 15));
		// Estado: [5, 10, 15, 20, 30]
		assertEquals(15, llista.getValor(2));
		assertEquals(20, llista.getValor(3));
		assertEquals(5, llista.getNElements());

		// 4. Límite frontera nElements (Insertar exactamente al final)
		assertTrue(llista.insertarValor(5, 40));
		// Estado: [5, 10, 15, 20, 30, 40]
		assertEquals(40, llista.getValor(5));
		assertEquals(6, llista.getNElements());
	}

	@Test
	void testEliminaValor() {
		fail("Not yet implemented");
	}

	@Test
	void testGetValor() {
		Llista llista = new Llista();
		llista.afegirUltim(5);
		llista.afegirUltim(4);
		llista.afegirUltim(2);
		llista.afegirUltim(9);
				
		assertEquals(-1, llista.getValor(-1));
		assertEquals(5, llista.getValor(0));
		assertEquals(4, llista.getValor(1));
		
		assertEquals(2, llista.getValor(2));
		assertEquals(9, llista.getValor(3));
		assertEquals(-1, llista.getValor(4));

	}

	@Test
	void testEsBuida() {
		Llista llista = new Llista();
		assertTrue(llista.esBuida());
		
	}

	@Test
	void testGetNElements() {
		Llista llista = new Llista();
		assertEquals(0, llista.getNElements());
	}

}
