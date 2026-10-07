import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstadistiquesEnginyeriaTest {

    private EstadistiquesEnginyeria estadistiques;

    @BeforeEach
    void setUp() {
        // Setup del mock object y SUT mediante Inversión de Control
        DB mockDB = new mockDB();
        estadistiques = new EstadistiquesEnginyeria(mockDB);
    }

    @Test
    void testPerCentAprovats() {
        // Partición de equivalencia válida (Aprobados) y Límite frontera (5.0)
        // Total alumnos "Testing": 5. Aprobados: 2 (7.5 y 5.0). Resultado esperado: 40.0%
        double resultat = estadistiques.PerCentAprovats("Testing", "NTeo");
        assertEquals(40.0, resultat, 0.01);
    }

    @Test
    void testPerCentSuspesos() {
        // Partición de equivalencia válida (Suspensos) y Límite frontera (4.9 y 0.0)
        // Total alumnos "Testing": 5. Suspensos: 2 (4.9 y 0.0). Resultado esperado: 40.0%
        double resultat = estadistiques.PerCentSuspesos("Testing", "NTeo");
        assertEquals(40.0, resultat, 0.01);
    }

    @Test
    void testPerCentNoPresentats() {
        // Partición de equivalencia para excepción NumberFormatException controlada ("NP")
        // Total alumnos "Testing": 5. NP: 1. Resultado esperado: 20.0%
        double resultat = estadistiques.PerCentNoPresentats("Testing", "NTeo");
        assertEquals(20.0, resultat, 0.01);
    }

    @Test
    void testAssignaturaSenseAlumnes() {
        // Valores fuera de rango / Límite de conjunto vacío
        // Evita división por cero devolviendo 0.0%
        double resultat = estadistiques.PerCentAprovats("Matematiques", "NTeo");
        assertEquals(0.0, resultat, 0.01);
    }

    @Test
    void testColumnaNotaInvalida() {
        // Partición de equivalencia inválida para el parámetro 'Nota'
        double resultat = estadistiques.PerCentAprovats("Testing", "NotaFalsa");
        assertEquals(0.0, resultat, 0.01);
    }
}