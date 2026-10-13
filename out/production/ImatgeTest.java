package out.production;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ImatgeTest {

	// Test del estado inicial al instanciar el objeto
	@Test
	void testImatge() {
		Imatge img = new Imatge();
		assertEquals(0, img.getNFiles());
		assertEquals(0, img.getNCols());
	}

	// Test de creación de matriz con valores normales
	@Test
	void testCreaImatgeValid() {
		Imatge img = new Imatge();
		img.CreaImatge(3, 4);
		
		assertEquals(3, img.getNFiles());
		assertEquals(4, img.getNCols());
	}
	
	// Test de creación fallida forzando las fronteras (0 o negativos)
	@Test
	void testCreaImatgeInvalid() {
		Imatge img = new Imatge();
		
		// Probamos con 0 filas (inválido, el mínimo lógico es 1)
		assertThrows(AssertionError.class, () -> {
			img.CreaImatge(0, 4);
		});
		
		// Probamos con columnas en negativo
		assertThrows(AssertionError.class, () -> {
			img.CreaImatge(3, -1);
		});
	}

	// Test de lectura del atributo filas
	@Test
	void testGetNFiles() {
		Imatge img = new Imatge();
		img.CreaImatge(2, 4);
		
		assertEquals(2, img.getNFiles());
	}

	// Test de lectura del atributo columnas
	@Test
	void testGetNCols() {
		Imatge img = new Imatge();
		img.CreaImatge(2, 4);
		
		assertEquals(4, img.getNCols());
	}

	// Test de escritura/lectura en los límites extremos válidos de la matriz
	@Test
	void testSetandGetValueValid() {
		Imatge img = new Imatge();
		img.CreaImatge(4, 4); // Índices válidos van del 0 al 3
		
		// Límite inferior exacto
		img.setValue(0, 0, 1.5f);
		assertEquals(1.5f, img.getValue(0, 0));	
		
		// Límite superior exacto
		img.setValue(3, 3, 9.9f);
		assertEquals(9.9f, img.getValue(3, 3));	
	}
	
	// Test de escritura/lectura que revienta justo al pasarse un número de la frontera
	@Test
	void testSetandGetValueInvalid() {
		Imatge img = new Imatge();
		img.CreaImatge(4, 4); // Índices válidos van del 0 al 3
		
		// Nos pasamos por abajo (fila -1)
		assertThrows(AssertionError.class, () -> {
			img.setValue(-1, 0, 4.0f);
		});
		
		// Nos pasamos por arriba (fila 4 no existe)
		assertThrows(AssertionError.class, () -> {
			img.getValue(4, 3); 
		});
	}
}