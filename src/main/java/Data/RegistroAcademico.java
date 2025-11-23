
package Data;

public class RegistroAcademico {

    private Materia materia;

    // Estados comunes:
    // INSCRITA, APROBADA, REPROBADA, RETIRADA
    private String estado;

    private double notaFinal;   // 0.0 → si aún no tiene nota
    private int anio;           // Año en el que cursó la materia
    private int semestreNumero; // 1–10
    private boolean repetida;   // Si la materia se cursó más de una vez

    public RegistroAcademico(
            Materia materia,
            String estado,
            double notaFinal,
            int anio,
            int semestreNumero,
            boolean repetida
    ) {
        this.materia = materia;
        this.estado = estado;
        this.notaFinal = notaFinal;
        this.anio = anio;
        this.semestreNumero = semestreNumero;
        this.repetida = repetida;
    }

    // Getters
    public Materia getMateria() { return materia; }
    public String getEstado() { return estado; }
    public double getNotaFinal() { return notaFinal; }
    public int getAnio() { return anio; }
    public int getSemestreNumero() { return semestreNumero; }
    public boolean isRepetida() { return repetida; }

    // Helpers útiles
    public boolean fueAprobada() {
        return estado.equalsIgnoreCase("APROBADA");
    }

    public int getCreditosGanados() {
        if (fueAprobada()) return materia.getCreditos();
        return 0;
    }
}
