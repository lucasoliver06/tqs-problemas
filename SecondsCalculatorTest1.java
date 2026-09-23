import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
class SecondsCalculatorTest1 {

	@Test
	void testSegonsFins() {
		SecondsCalculator sec = new SecondsCalculator();
		
		// Test h/m/s
		assertEquals(0, sec.SegonsFins(1, 1, 1980, 0, 0, 0));
		
		assertEquals(86400, sec.SegonsFins(2, 1, 1980, 0, 0, 0)); //Test segundos un dia
		
		// Test mesos
		assertEquals(5184000, sec.SegonsFins(1, 3, 1980, 0, 0, 0)); // Test mes amb 29 dies
		assertEquals(7862400, sec.SegonsFins(1, 4, 1980, 0, 0, 0)); // Test mes amb 30 dies
		assertEquals(36720000, sec.SegonsFins(1, 3, 1981, 0, 0, 0)); // Test mes amb 30 dies
		
		// Test anys
		assertEquals(126230400, sec.SegonsFins(1, 1, 1984, 0, 0, 0)); //Test any no traspas
		assertEquals(157852800, sec.SegonsFins(1, 1, 1985, 0, 0, 0)); //Test dos anys traspas
		
		//Tests negativos
		assertEquals(-1, sec.SegonsFins(-1, 1, 1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(1, -1, 1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(1, 1, -1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, -1, 0, 0));
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, 0, -1, 0));
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, 0, 0, -1));
		
		//-----------------------------------------------------------

		//Test límit i frontera segons
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, 0, 0, 60));
		assertEquals(59, sec.SegonsFins(1, 1, 1980, 0, 0, 59));
		assertEquals(58, sec.SegonsFins(1, 1, 1980, 0, 0, 58));
		assertEquals(1, sec.SegonsFins(1, 1, 1980, 0, 0, 1));
		
		//Test límit i frontera minuts
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, 0, 60, 0));
		assertEquals(3540, sec.SegonsFins(1, 1, 1980, 0, 59, 0));
		assertEquals(3480, sec.SegonsFins(1, 1, 1980, 0, 58, 0));
		assertEquals(60, sec.SegonsFins(1, 1, 1980, 0, 1, 0));

		//Test límit i frontera hores
		assertEquals(-1, sec.SegonsFins(1, 1, 1980, 24, 0, 0));
		assertEquals(82800, sec.SegonsFins(1, 1, 1980, 23, 0, 0));
		assertEquals(79200, sec.SegonsFins(1, 1, 1980, 22, 0, 0));
		assertEquals(3600, sec.SegonsFins(1, 1, 1980, 1, 0, 0));
		
		//------------------------------------------
		//Test límit i frontera dies
		assertEquals(-1, sec.SegonsFins(0, 1, 1980, 0, 0, 0));		

		// Límite superior Enero (31 días)
		assertEquals(2505600, sec.SegonsFins(30, 1, 1980, 0, 0, 0));
		assertEquals(2592000, sec.SegonsFins(31, 1, 1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(32, 1, 1980, 0, 0, 0));		

		// Límite superior Abril (30 días)
		assertEquals(10281600, sec.SegonsFins(29, 4, 1980, 0, 0, 0));
		assertEquals(10368000, sec.SegonsFins(30, 4, 1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(31, 4, 1980, 0, 0, 0));	

		// Límite superior Febrero bisiesto (29 días) 
		assertEquals(5011200, sec.SegonsFins(28, 2, 1980, 0, 0, 0));		
		assertEquals(5097600, sec.SegonsFins(29, 2, 1980, 0, 0, 0));		
		assertEquals(-1, sec.SegonsFins(30, 2, 1980, 0, 0, 0));	

		// Límite superior Febrero no bisiesto (28 días)
		assertEquals(36547200, sec.SegonsFins(27, 2, 1981, 0, 0, 0));		
		assertEquals(36633600, sec.SegonsFins(28, 2, 1981, 0, 0, 0));	
		assertEquals(-1, sec.SegonsFins(29, 2, 1981, 0, 0, 0));
		
		//------------------------------------------
		
		//Test límit i frontera mesos
		assertEquals(-1, sec.SegonsFins(1, 0, 1980, 0, 0, 0));
		assertEquals(0, sec.SegonsFins(1, 1, 1980, 0, 0, 0));
		assertEquals(2678400, sec.SegonsFins(1, 2, 1980, 0, 0, 0));
		assertEquals(26352000, sec.SegonsFins(1, 11, 1980, 0, 0, 0));
		assertEquals(28944000, sec.SegonsFins(1, 12, 1980, 0, 0, 0));
		assertEquals(-1, sec.SegonsFins(1, 13, 1980, 0, 0, 0));
		
		//Test límit i frontera anys
		assertEquals(-1, sec.SegonsFins(1, 1, 1979, 0, 0, 0));
		assertEquals(0, sec.SegonsFins(1, 1, 1980, 0, 0, 0));
		assertEquals(31622400, sec.SegonsFins(1, 1, 1981, 0, 0, 0));
		
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
		assertEquals(-1, sec.getDiesDelMes(13, 1979));
		assertEquals(-1, sec.getDiesDelMes(0,2000));
	}
}
