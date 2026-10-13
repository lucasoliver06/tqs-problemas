package out.production;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProcessadorTest {

	// Test del caso válido usando exactamente el ejemplo visual del PDF
	@Test
	void testCircularShiftingValid() {
		// 1. Preparamos la imagen de entrada M1 (3x3)
		Imatge m1 = new Imatge();
		m1.CreaImatge(3, 3);
				
		// Rellenamos M1 con los valores del PDF (del 1 al 9)
		float valor = 1.0f;
		for (int f = 0; f < 3; f++) {
			for (int c = 0; c < 3; c++) {
				m1.setValue(f, c, valor);
				valor++;
			}
		}
		
		// 2. Preparamos M2 (4x5)
		Imatge m2 = new Imatge();
		m2.CreaImatge(4, 5);
		
		// Ejecutamos el desplazamiento
		Processador.CircularShifting(m1, m2, 3, 2);
		
		// Comprobamos los valores clave del PDF
		assertEquals(9.0f, m2.getValue(0, 0)); // El 9 pega la vuelta y aparece al principio
		assertEquals(0.0f, m2.getValue(0, 1));
		assertEquals(0.0f, m2.getValue(0, 2));
		assertEquals(7.0f, m2.getValue(0, 3)); // El 7 se mueve 3 posiciones a la derecha
		assertEquals(8.0f, m2.getValue(0, 4)); // El 8 se mueve 3 posiciones a la derecha
		
		assertEquals(6.0f, m2.getValue(3, 0));
		assertEquals(4.0f, m2.getValue(3, 3));
		assertEquals(5.0f, m2.getValue(3, 4));
	}
	
	// Test de frontera válida: la imagen de entrada es EXACTAMENTE del mismo tamaño que la de salida
	@Test
	void testCircularShiftingValidFrontera() {
		Imatge m1 = new Imatge();
		m1.CreaImatge(3, 3);
		m1.setValue(0, 0, 5.0f); // Ponemos un solo valor para rastrearlo
		
		Imatge m2 = new Imatge();
		m2.CreaImatge(3, 3); // Límite exacto: M1 <= M2 se cumple con igualdad
		
		Processador.CircularShifting(m1, m2, 1, 1);
		
		// En una matriz 3x3, desplazar (0,0) con incr_x=1 e incr_y=1 lo deja en (1,1)
		assertEquals(5.0f, m2.getValue(1, 1));
	}
	
	// Test de caso inválido general: matriz de entrada mucho más grande en ambas dimensiones
	@Test
	void testCircularShiftingInvalid() {
		Imatge m1 = new Imatge();
		m1.CreaImatge(5, 5);
				
		float valor = 1.0f;
		for (int f = 0; f < 5; f++) {
			for (int c = 0; c < 5; c++) {
				m1.setValue(f, c, valor);
				valor++;
			}
		}
		
		Imatge m2 = new Imatge();
		m2.CreaImatge(3, 3);
		
		// Falla porque 5 > 3
		assertThrows(AssertionError.class, () -> {
			Processador.CircularShifting(m1, m2, 2, 2);
		});	
	}
	
	// Test de frontera inválida: la matriz de entrada se pasa SOLO por una fila
	@Test
	void testCircularShiftingInvalidFrontera() {
		Imatge m1 = new Imatge();
		m1.CreaImatge(4, 3); // 4 filas, 3 columnas
		
		Imatge m2 = new Imatge();
		m2.CreaImatge(3, 3); // 3 filas, 3 columnas
		
		// El "portero" debe detectar que 4 filas no caben en 3, aunque las columnas sí quepan
		assertThrows(AssertionError.class, () -> {
			Processador.CircularShifting(m1, m2, 1, 1);
		});
	}

}