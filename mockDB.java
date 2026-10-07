public class mockDB implements DB {
    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public String[][] query(String q) {
        // Matriz de datos de prueba controlada para aislar el SUT
        // Estructura: {NIU, assignatura, Nteo, NPract, NFinal}
        return new String[][] {
                {"111", "Testing", "7.5", "8.0", "9.0"},  // Partición Equivalencia: Aprobado
                {"222", "Testing", "5.0", "5.0", "5.0"},  // Límite Frontera: Aprobado exacto
                {"333", "Testing", "4.9", "4.9", "4.9"},  // Límite Frontera: Suspenso alto
                {"444", "Testing", "0.0", "0.0", "0.0"},  // Partición Equivalencia: Suspenso bajo
                {"555", "Testing", "NP",  "NP",  "NP"},   // Partición Equivalencia: No Presentado
                {"666", "Hardware", "8.0", "8.0", "8.0"}  // Partición Equivalencia: Asignatura diferente
        };
    }

    @Override
    public boolean close() {
        return true;
    }
}