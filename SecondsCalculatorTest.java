import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class SecondsCalculatorTest {

	@Test
	void testSegonsFins() {
		SecondsCalculator sec = new SecondsCalculator();

		// Test h/m/s
		assertEquals(0, sec.SegonsFins(1, 1, 1980, 0, 0, 0));
		assertEquals(1, sec.SegonsFins(1, 1, 1980, 0, 0, 1));
		assertEquals(60, sec.SegonsFins(1, 1, 1980, 0, 1, 0));
		assertEquals(3600, sec.SegonsFins(1, 1, 1980, 1, 0, 0));

		// Test dies
		assertEquals(86400, sec.SegonsFins(2, 1, 1980, 0, 0, 0));

		// Test mesos
		assertEquals(2678400, sec.SegonsFins(1, 2, 1980, 0, 0, 0)); // Test mes amb 31 dies
		assertEquals(5184000, sec.SegonsFins(1, 3, 1980, 0, 0, 0)); // Test mes amb 29 dies
		assertEquals(7862400, sec.SegonsFins(1, 4, 1980, 0, 0, 0)); // Test  mes amb 30 dies
		assertEquals(36720000, sec.SegonsFins(1, 3, 1981, 0, 0, 0)); // Test  mes amb 30 dies

		// Test anys
		assertEquals(31622400, sec.SegonsFins(1, 1, 1981, 0, 0, 0)); //Test any traspas
		assertEquals(126230400, sec.SegonsFins(1, 1, 1984, 0, 0, 0)); //Test any no traspas
		assertEquals(157852800, sec.SegonsFins(1, 1, 1985, 0, 0, 0)); //Test dos anys traspas

		//Tests negativos
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(-1, 1, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, -1, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, -1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, -1, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, 0, -1, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, 0, 0, -1);
		});

		//Tests fueras de límite
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(0, 1, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 0, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1979, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(32, 1, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 13, 1981, 0, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, 24, 0, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, 0, 60, 0);
		});
		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(1, 1, 1981, 0, 0, 60);
		});

		//----------------------------------------------------------------------------------------------
		//TEST PAIRWISE

		// Casos válidos
		assertEquals(667785600L, sec.SegonsFins(28, 2, 2001, 0, 0, 0)); // 28-2-2001
		assertEquals(638668800L, sec.SegonsFins(28, 3, 2000, 0, 0, 0)); // 28-3-2000
		assertEquals(3797020800L, sec.SegonsFins(28, 4, 2100, 0, 0, 0)); // 28-4-2100
		assertEquals(762393600L, sec.SegonsFins(28, 2, 2004, 0, 0, 0)); // 28-2-2004
		assertEquals(636249600L, sec.SegonsFins(29, 2, 2000, 0, 0, 0)); // 29-2-2000
		assertEquals(670291200L, sec.SegonsFins(29, 3, 2001, 0, 0, 0)); // 29-3-2001
		assertEquals(767664000L, sec.SegonsFins(29, 4, 2004, 0, 0, 0)); // 29-4-2004
		assertEquals(765072000L, sec.SegonsFins(30, 3, 2004, 0, 0, 0)); // 30-3-2004
		assertEquals(641520000L, sec.SegonsFins(30, 4, 2000, 0, 0, 0)); // 30-4-2000
		assertEquals(3794601600L, sec.SegonsFins(31, 3, 2100, 0, 0, 0)); // 31-3-2100

		// Casos inválidos actualizados a Diseño por Contrato (DbC)

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(29, 2, 2100, 0, 0, 0); // 29-2-2100
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(30, 2, 2001, 0, 0, 0); // 30-2-2001
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(30, 2, 2100, 0, 0, 0); // 30-2-2100
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(31, 2, 2004, 0, 0, 0); // 31-2-2004
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(31, 4, 2001, 0, 0, 0); // 31-4-2001
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(31, 2, 2000, 0, 0, 0); // 31-2-2000
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(32, 2, 2000, 0, 0, 0); // 32-2-2000
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(32, 3, 2001, 0, 0, 0); // 32-3-2001
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(32, 4, 2004, 0, 0, 0); // 32-4-2004
		});

		assertThrows(AssertionError.class, () -> {
			sec.SegonsFins(32, 2, 2100, 0, 0, 0); // 32-2-2100
		});

	}

	@Test
	void testIsAnyTraspas() {
		SecondsCalculator sec = new SecondsCalculator();
		
		assertEquals(true, sec.getIsAnyTraspas(2000));
		assertEquals(true, sec.getIsAnyTraspas(2004));
		assertEquals(false, sec.getIsAnyTraspas(2100));
		assertEquals(false, sec.getIsAnyTraspas(1999));
	}
	
	@Test
	void testDiesDelMes() {
		SecondsCalculator sec = new SecondsCalculator();
		
		assertEquals(31, sec.getDiesDelMes(1,2000));
		assertEquals(31, sec.getDiesDelMes(3,2000));
		assertEquals(31, sec.getDiesDelMes(5,2000));
		assertEquals(30, sec.getDiesDelMes(4,2000));
		assertEquals(30, sec.getDiesDelMes(6,2000));
		assertEquals(31, sec.getDiesDelMes(7,2000));
		assertEquals(31, sec.getDiesDelMes(8,2000));
		assertEquals(30, sec.getDiesDelMes(9,2000));
		assertEquals(31, sec.getDiesDelMes(10,2000));
		assertEquals(30, sec.getDiesDelMes(11,2000));
		assertEquals(31, sec.getDiesDelMes(12,2000));
		assertEquals(29, sec.getDiesDelMes(2,2000));
		assertEquals(28, sec.getDiesDelMes(2,2100));
		assertEquals(29, sec.getDiesDelMes(2,2004));
		assertEquals(28, sec.getDiesDelMes(2,1999));

		// Casos inválidos actualizados a Diseño por Contrato (DbC)
		assertThrows(AssertionError.class, () -> {
			sec.getDiesDelMes(13, 1979);
		});

		assertThrows(AssertionError.class, () -> {
			sec.getDiesDelMes(0,2000);
		});
	}
}
