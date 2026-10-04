import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LlistaTest {

	@Test
	void testAfegirUltim() {
		Llista llista = new Llista();
		boolean resultat = llista.afegirUltim(5);

		// Evalúa la transición de lista vacía a poblada (modificación del estado inicial)
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

		// Evalúa el correcto enlazado secuencial y el conteo acumulativo de elementos
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

		// 1. Valores fuera de límite: posiciones negativas y superiores al tamaño actual
		assertFalse(llista.insertarValor(-1, 99));
		assertFalse(llista.insertarValor(4, 99));
		assertEquals(3, llista.getNElements());

		// 2. Valor límite / Caso frontera inferior: inserción en la posición 0 (modifica el 'primer' nodo)
		assertTrue(llista.insertarValor(0, 5));
		// Estado: [5, 10, 20, 30]
		assertEquals(5, llista.getValor(0));
		assertEquals(10, llista.getValor(1));
		assertEquals(4, llista.getNElements());

		// 3. Partición de equivalencia: inserción en una posición intermedia (requiere recorrer la lista)
		assertTrue(llista.insertarValor(2, 15));
		// Estado: [5, 10, 15, 20, 30]
		assertEquals(15, llista.getValor(2));
		assertEquals(20, llista.getValor(3));
		assertEquals(5, llista.getNElements());

		// 4. Valor límite / Caso frontera superior: inserción al final exacto de la lista
		assertTrue(llista.insertarValor(5, 40));
		// Estado: [5, 10, 15, 20, 30, 40]
		assertEquals(40, llista.getValor(5));
		assertEquals(6, llista.getNElements());

		// 5. Caso especial: Inserción "en el vacío" (sobre una lista sin inicializar)
		Llista llista1 = new Llista();
		assertTrue(llista1.insertarValor(0,99));
		assertEquals(1, llista1.getNElements());
	}

	@Test
	void testEliminaValor() {
		Llista llista = new Llista();
		llista.afegirUltim(1);
		llista.afegirUltim(2);
		llista.afegirUltim(3);
		llista.afegirUltim(4);
		llista.afegirUltim(5);

		// 1. Valores fuera de límite inferior y superior (no deben alterar la lista)
		assertFalse(llista.eliminaValor(-1));
		assertFalse(llista.eliminaValor(5));
		assertEquals(5, llista.getNElements());

		// 2. Valor límite / Caso frontera inferior: eliminación del nodo en la posición 0
		assertTrue(llista.eliminaValor(0));
		assertEquals(2, llista.getValor(0));
		assertEquals(4, llista.getNElements());

		// 3. Partición de equivalencia: eliminación de un nodo intermedio y comprobación del re-enlazado
		assertTrue(llista.eliminaValor(2));
		assertEquals(5, llista.getValor(2));
		assertEquals(3, llista.getNElements());

		llista.afegirUltim(6);
		llista.afegirUltim(7);

		// 4. Valor límite / Caso frontera superior: eliminación del último nodo de la lista
		assertTrue(llista.eliminaValor(4));
		assertEquals(6, llista.getValor(3));
		assertEquals(4, llista.getNElements());

		// 5. Casos destructivos extremos: lista vacía original y vaciado completo manual
		Llista llista1 = new Llista();
		assertFalse(llista1.eliminaValor(0)); // Prueba sobre lista recién creada

		llista1.afegirUltim(2);
		llista1.afegirUltim(3);
		llista1.eliminaValor(0);
		llista1.eliminaValor(0);
		assertEquals(0, llista1.getNElements()); // Comprobación de vaciado total sin corromper la estructura
	}

	@Test
	void testGetValor() {
		Llista llista = new Llista();
		llista.afegirUltim(5);
		llista.afegirUltim(4);
		llista.afegirUltim(2);
		llista.afegirUltim(9);

		// Límite inválido inferior
		assertEquals(-1, llista.getValor(-1));

		// Valores límite: Frontera inferior (0) y superior (3, nElements - 1)
		assertEquals(5, llista.getValor(0));
		assertEquals(9, llista.getValor(3));

		// Particiones de equivalencia (valores intermedios)
		assertEquals(4, llista.getValor(1));
		assertEquals(2, llista.getValor(2));

		// Límite inválido superior
		assertEquals(-1, llista.getValor(4));
	}

	@Test
	void testEsBuida() {
		// Evalúa que la instancia nace con el estado por defecto correcto
		Llista llista = new Llista();
		assertTrue(llista.esBuida());
	}

	@Test
	void testGetNElements() {
		// Evalúa que el contador interno se inicializa correctamente a cero
		Llista llista = new Llista();
		assertEquals(0, llista.getNElements());
	}
}