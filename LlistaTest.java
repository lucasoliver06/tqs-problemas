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
		fail("Not yet implemented");
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
