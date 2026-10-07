public class EstadistiquesEnginyeria {
    private DB db;

    // Inyección de dependencias para permitir el uso del Mock Object
    public EstadistiquesEnginyeria(DB db) {
        this.db = db;
    }

    public double PerCentAprovats(String Assignatura, String Nota) {
        return calcularEstadistica(Assignatura, Nota, "APROVAT");
    }

    public double PerCentSuspesos(String Assignatura, String Nota) {
        return calcularEstadistica(Assignatura, Nota, "SUSPES");
    }

    public double PerCentNoPresentats(String Assignatura, String Nota) {
        return calcularEstadistica(Assignatura, Nota, "NP");
    }

    private double calcularEstadistica(String assignatura, String tipoNota, String tipoCalculo) {
        int columnaNota = -1;
        if (tipoNota.equals("NTeo")) columnaNota = 2;
        else if (tipoNota.equals("NPract")) columnaNota = 3;
        else if (tipoNota.equals("NFinal")) columnaNota = 4;

        if (columnaNota == -1) return 0.0;

        this.db.connect();
        String[][] alumnes = this.db.query("SELECT * FROM alumnes");
        this.db.close();

        int totalAlumnesAssignatura = 0;
        int comptadorObjectiu = 0;

        for (int i = 0; i < alumnes.length; i++) {
            if (alumnes[i][1].equals(assignatura)) {
                totalAlumnesAssignatura++;
                String notaStr = alumnes[i][columnaNota];

                try {
                    double notaNum = Double.parseDouble(notaStr);

                    if (tipoCalculo.equals("APROVAT") && notaNum >= 5.0) {
                        comptadorObjectiu++;
                    } else if (tipoCalculo.equals("SUSPES") && notaNum < 5.0) {
                        comptadorObjectiu++;
                    }
                } catch (NumberFormatException e) {
                    if (tipoCalculo.equals("NP") && notaStr.equals("NP")) {
                        comptadorObjectiu++;
                    }
                }
            }
        }

        if (totalAlumnesAssignatura == 0) return 0.0;
        return ((double) comptadorObjectiu / totalAlumnesAssignatura) * 100.0;
    }
}