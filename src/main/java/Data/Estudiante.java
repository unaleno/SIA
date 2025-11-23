package Data;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

    private Usuario usuario;
    private String nombreCompleto;
    private String programa;

    private List<RegistroAcademico> historial;
    private List<Materia> materiasInscritas;

    public Estudiante(Usuario usuario, String nombreCompleto, String programa) {
        this.usuario = usuario;
        this.nombreCompleto = nombreCompleto;
        this.programa = programa;

        this.historial = new ArrayList<>();
        this.materiasInscritas = new ArrayList<>();
    }

    // ================================
    // GETTERS BÁSICOS
    // ================================

    public Usuario getUsuario() { return usuario; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getPrograma() { return programa; }
    public List<RegistroAcademico> getHistorial() { return historial; }
    public List<Materia> getMateriasInscritas() { return materiasInscritas; }

    // ================================
    // MANEJO DE HISTORIA ACADÉMICA
    // ================================

    public void agregarAlHistorial(RegistroAcademico r) {
        historial.add(r);
    }

    public boolean haAprobado(Materia m) {
        for (RegistroAcademico r : historial) {
            if (r.getMateria().getCodigo().equals(m.getCodigo()) &&
                r.fueAprobada()) {
                return true;
            }
        }
        return false;
    }

    public boolean haCursado(Materia m) {
        for (RegistroAcademico r : historial) {
            if (r.getMateria().getCodigo().equals(m.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    public int obtenerCreditosAprobados() {
        int total = 0;
        for (RegistroAcademico r : historial) {
            total += r.getCreditosGanados();
        }
        return total;
    }

    // ================================
    // MANEJO DE INSCRIPCIÓN
    // ================================

    public void inscribirMateria(Materia m) {
        if (!materiasInscritas.contains(m)) {
            materiasInscritas.add(m);
        }
    }

    public int obtenerCreditosInscritos() {
        int total = 0;
        for (Materia m : materiasInscritas) {
            total += m.getCreditos();
        }
        return total;
    }

    // Subir de semestre automáticamente (opcional)
    public int getUltimoSemestreCursado() {
        int max = 1;
        for (RegistroAcademico r : historial) {
            if (r.getSemestreNumero() > max) {
                max = r.getSemestreNumero();
            }
        }
        return max;
    }

    public int getSemestreSugerido() {
        return getUltimoSemestreCursado() + 1;
    }
}