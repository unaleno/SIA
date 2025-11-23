
package Data;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private String codigo;
    private String nombre;
    private int creditos;
    private String tipo;              // P = nivelación/idiomas, B = básicas, C = obligatorias, L = libre elección
    private int semestreSugerido;     // semestre recomendado en el plan de estudios

    private List<Materia> prerrequisitos;

    public Materia(String codigo, String nombre, int creditos, String tipo, int semestreSugerido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        this.semestreSugerido = semestreSugerido;
        this.prerrequisitos = new ArrayList<>();
    }

    // ============================
    // Métodos de acceso
    // ============================
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public String getTipo() { return tipo; }
    public int getSemestreSugerido() { return semestreSugerido; }
    public List<Materia> getPrerrequisitos() { return prerrequisitos; }

    // ============================
    // Agregar prerrequisito
    // ============================
    public void agregarPrerequisito(Materia m) {
        prerrequisitos.add(m);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}