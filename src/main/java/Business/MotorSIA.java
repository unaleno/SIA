
package Business;

import Data.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MotorSIA: carga la "base de datos" en memoria:
 * - todas las materias del plan (código, nombre, créditos, tipo, semestre)
 * - prerrequisitos (vinculados con agregarPrerequisito)
 * - estudiantes de ejemplo con historial académico
 *
 * Asegúrate de que tu clase Data.Materia tenga:
 * public Materia(String codigo, String nombre, int creditos, String tipo, int semestreSugerido)
 * y método agregarPrerequisito(Materia m)
 *
 * Y que RegistroAcademico tenga el constructor:
 * RegistroAcademico(Materia m, String estado, double notaFinal, int anio, int semestreNumero, boolean repetida)
 */
public class MotorSIA {

    private List<Estudiante> estudiantes;
    private List<Materia> materias;

    public MotorSIA() {

        estudiantes = new ArrayList<>();
        materias = new ArrayList<>();

        // ============================
        // SEMESTRE I
        // ============================
        Materia mat_niv = new Materia("NIV_MAT", "Matemáticas básicas (Nivelación)", 0, "P", 1);
        Materia lec_niv = new Materia("LEC_NIV", "Lecto-escritura (Nivelación)", 0, "P", 1);
        Materia ing1 = new Materia("ING101", "Inglés I", 3, "P", 1);
        Materia caldif = new Materia("CAL101", "Cálculo diferencial", 4, "B", 1);
        Materia fund_mec = new Materia("MEC101", "Fundamentos de mecánica", 3, "B", 1);
        Materia intro_is = new Materia("ISC101", "Introducción a la ingeniería de sistemas y computación", 3, "C", 1);

        materias.add(mat_niv);
        materias.add(lec_niv);
        materias.add(ing1);
        materias.add(caldif);
        materias.add(fund_mec);
        materias.add(intro_is);

        // ============================
        // SEMESTRE II
        // ============================
        Materia ing2 = new Materia("ING102", "Inglés II", 3, "P", 2);
        Materia calint = new Materia("CAL102", "Cálculo integral", 4, "B", 2);
        Materia algLin = new Materia("ALI201", "Álgebra lineal", 3, "B", 2);
        Materia fund_el = new Materia("ELM201", "Fundamentos de electricidad y magnetismo", 3, "B", 2);
        Materia mat_dis1 = new Materia("MDI201", "Matemáticas discretas I", 3, "B", 2);
        Materia progComp = new Materia("PROG101", "Programación de computadores", 3, "C", 2);

        // prerrequisitos
        calint.agregarPrerequisito(caldif);

        materias.add(ing2);
        materias.add(calint);
        materias.add(algLin);
        materias.add(fund_el);
        materias.add(mat_dis1);
        materias.add(progComp);

        // ============================
        // SEMESTRE III
        // ============================
        Materia ing3 = new Materia("ING103", "Inglés III", 3, "P", 3);
        Materia calvar = new Materia("CAL201", "Cálculo en varias variables", 4, "B", 3);
        Materia prob = new Materia("PROB201", "Probabilidad y estadística", 3, "B", 3);
        Materia mat_dis2 = new Materia("MDI202", "Matemáticas discretas II", 3, "B", 3);
        Materia poo = new Materia("POO201", "Programación orientada a objetos", 3, "C", 3);
        Materia elem_comp = new Materia("ELE201", "Elementos de computadores", 3, "C", 3);

        // prerrequisitos
        mat_dis2.agregarPrerequisito(mat_dis1);
        poo.agregarPrerequisito(progComp);

        materias.add(ing3);
        materias.add(calvar);
        materias.add(prob);
        materias.add(mat_dis2);
        materias.add(poo);
        materias.add(elem_comp);

        // ============================
        // SEMESTRE IV
        // ============================
        Materia ing4 = new Materia("ING104", "Inglés IV", 3, "P", 4);
        Materia fis = new Materia("FIS201", "Física", 3, "B", 4);
        Materia eds = new Materia("EDS301", "Estructuras de datos", 3, "C", 4);
        Materia arc_comp = new Materia("ARC301", "Arquitectura de computadores", 3, "C", 4);
        Materia bd = new Materia("BD301", "Bases de datos", 3, "C", 4);
        Materia leng_prog = new Materia("LENG301", "Lenguajes de programación", 3, "C", 4);

        // prerequisitos
        eds.agregarPrerequisito(poo);          // requiere POO
        arc_comp.agregarPrerequisito(elem_comp); // requiere Elementos de computadores
        bd.agregarPrerequisito(eds);
        leng_prog.agregarPrerequisito(mat_dis2);

        materias.add(ing4);
        materias.add(fis);
        materias.add(eds);
        materias.add(arc_comp);
        materias.add(bd);
        materias.add(leng_prog);

        // ============================
        // SEMESTRE V
        // ============================
        Materia ingEco = new Materia("ECO301", "Ingeniería económica", 3, "B", 5);
        Materia gerProj = new Materia("GEP301", "Gerencia y gestión de proyectos", 3, "B", 5);
        Materia modSim = new Materia("SIM301", "Modelos y simulación", 3, "C", 5);
        Materia so = new Materia("SO301", "Sistemas operativos", 3, "C", 5);
        Materia alg = new Materia("ALG301", "Algoritmos", 3, "C", 5);

        // prerequisitos
        so.agregarPrerequisito(arc_comp);
        alg.agregarPrerequisito(eds);

        materias.add(ingEco);
        materias.add(gerProj);
        materias.add(modSim);
        materias.add(so);
        materias.add(alg);

        // ============================
        // SEMESTRE VI
        // ============================
        Materia metNum = new Materia("NUM301", "Métodos numéricos", 3, "B", 6);
        Materia opti = new Materia("OPT301", "Optimización", 3, "C", 6);
        Materia isw1 = new Materia("ISW301", "Ingeniería de software I", 3, "C", 6);
        Materia redes = new Materia("RED301", "Redes de computadores", 3, "C", 6);
        Materia pensSis = new Materia("PEN301", "Pensamiento sistémico", 3, "C", 6);

        // prerequisitos
        isw1.agregarPrerequisito(alg);
        redes.agregarPrerequisito(so);

        materias.add(metNum);
        materias.add(opti);
        materias.add(isw1);
        materias.add(redes);
        materias.add(pensSis);

        // ============================
        // SEMESTRE VII
        // ============================
        Materia isw2 = new Materia("ISW302", "Ingeniería de software II", 3, "C", 7);
        Materia arq_soft = new Materia("ARS401", "Arquitectura de software", 3, "C", 7);
        Materia teoComp = new Materia("TEO301", "Introducción a la teoría de la computación", 3, "B", 7);
        Materia sisInf = new Materia("SI301", "Sistemas de información", 3, "C", 7);
        Materia tpi = new Materia("TPI301", "Taller de proyectos interdisciplinarios", 3, "C", 7);

        // prerequisitos
        isw2.agregarPrerequisito(isw1);
        arq_soft.agregarPrerequisito(isw2);

        materias.add(isw2);
        materias.add(arq_soft);
        materias.add(teoComp);
        materias.add(sisInf);
        materias.add(tpi);

        // ============================
        // SEMESTRE VIII
        // ============================
        Materia compVis = new Materia("CV301", "Computación visual", 3, "C", 8);
        Materia compPar = new Materia("CPD301", "Computación paralela y distribuida", 3, "C", 8);
        Materia introAI = new Materia("AI301", "Introducción a los sistemas inteligentes", 3, "C", 8);
        Materia infra = new Materia("INF301", "Arquitectura de infraestructura y gobierno de TICs", 3, "C", 8);
        Materia crip = new Materia("CRIP301", "Criptografía y seguridad de la información", 3, "C", 8);

        materias.add(compVis);
        materias.add(compPar);
        materias.add(introAI);
        materias.add(infra);
        materias.add(crip);

        // ============================
        // SEMESTRE IX
        // ============================
        Materia libre1 = new Materia("LIB901", "Libre elección I", 12, "L", 9);
        Materia tg1 = new Materia("TG901", "Trabajo de grado I", 6, "C", 9);

        materias.add(libre1);
        materias.add(tg1);

        // ============================
        // SEMESTRE X
        // ============================
        Materia libre2 = new Materia("LIB902", "Libre elección II", 12, "L", 10);
        Materia tg2 = new Materia("TG902", "Trabajo de grado II", 6, "C", 10);

        materias.add(libre2);
        materias.add(tg2);

        // ============================
        // Ahora que todas las materias existen, podemos fijar prerrequisitos
        // (algunos ya se fijaron arriba; agregamos adicionales importantes)
        // ============================

        // CAL102 ya tiene CAL101 (fue agregado antes)
        // MDI202 ya tiene MDI201 (fue agregado antes)
        // POO201 ya tiene PROG101 (fue agregado antes)
        // EDS301 requiere POO201 (fue agregado antes)
        // ARC301 requiere ELE201 (fue agregado antes)
        // BD301 requiere EDS301 (fue agregado antes)
        // LENG301 requiere MDI202 (fue agregado antes)
        // SO301 requiere ARC301 (fue agregado before)
        // ALG301 requiere EDS301 (fue agregado before)
        // ISW301 requiere ALG301 (fue agregado before)
        // RED301 requiere SO301 (fue agregado before)
        // ISW302 requiere ISW301 (fue agregado before)
        // ARQ401 requiere ISW302 (fue agregado before)

        // ============================
        // ESTUDIANTES DE EJEMPLO (con historial usando nuevo RegistroAcademico)
        // ============================

        // Estudiante 1 - Kevin (Ingeniería Electrónica)
        Usuario u1 = new Usuario("kevin", "1234");
        Estudiante e1 = new Estudiante(u1, "Kevin Forero", "Ingeniería Electrónica");
        // Historial: aprobó Cálculo diferencial, cursó POO; agregó años y semestres de ejemplo
        e1.agregarAlHistorial(new RegistroAcademico(caldif, "APROBADA", 4.0, 2022, 1, false));
        e1.agregarAlHistorial(new RegistroAcademico(poo, "CURSANDO", 0.0, 2022, 3, false));
        estudiantes.add(e1);

        // Estudiante 2 - Laura (Ingeniería Industrial)
        Usuario u2 = new Usuario("laura", "abcd");
        Estudiante e2 = new Estudiante(u2, "Laura Ramírez", "Ingeniería Industrial");
        e2.agregarAlHistorial(new RegistroAcademico(caldif, "APROBADA", 4.5, 2021, 1, false));
        e2.agregarAlHistorial(new RegistroAcademico(poo, "APROBADA", 4.2, 2021, 1, false));
        e2.agregarAlHistorial(new RegistroAcademico(fis, "CURSANDO", 0.0, 2022, 4, false));
        estudiantes.add(e2);

        // Estudiante 3 - Andrés (Matemáticas)
        Usuario u3 = new Usuario("andres", "pass");
        Estudiante e3 = new Estudiante(u3, "Andrés Medina", "Matemáticas");
        e3.agregarAlHistorial(new RegistroAcademico(caldif, "APROBADA", 3.8, 2020, 1, false));
        e3.agregarAlHistorial(new RegistroAcademico(calint, "APROBADA", 4.1, 2020, 2, false));
        e3.agregarAlHistorial(new RegistroAcademico(fis, "REPROBADA", 1.8, 2021, 4, false));
        estudiantes.add(e3);

        // Estudiante 4 - Sofía (Ingeniería Química)
        Usuario u4 = new Usuario("sofia", "sofia123");
        Estudiante e4 = new Estudiante(u4, "Sofía Hernández", "Ingeniería Química");
        e4.agregarAlHistorial(new RegistroAcademico(poo, "APROBADA", 4.7, 2021, 1, false));
        e4.agregarAlHistorial(new RegistroAcademico(caldif, "CURSANDO", 0.0, 2022, 1, false));
        e4.agregarAlHistorial(new RegistroAcademico(fis, "CURSANDO", 0.0, 2022, 4, false));
        estudiantes.add(e4);

        // Estudiante 5 - Camilo (Ingeniería de Sistemas)
        Usuario u5 = new Usuario("camilo", "321");
        Estudiante e5 = new Estudiante(u5, "Camilo Pérez", "Ingeniería de Sistemas");
        e5.agregarAlHistorial(new RegistroAcademico(mat_dis1, "APROBADA", 4.3, 2019, 2, false));
        e5.agregarAlHistorial(new RegistroAcademico(poo, "REPROBADA", 2.1, 2020, 3, false));
        e5.agregarAlHistorial(new RegistroAcademico(poo, "CURSANDO", 0.0, 2022, 3, true)); // repetida
        estudiantes.add(e5);
    }

    // ======================================================
    // LOGIN
    // ======================================================
    public Estudiante iniciarSesion(String usuario, String contraseña) {
        for (Estudiante e : estudiantes) {
            if (e.getUsuario().getUsuario().equals(usuario)
                    && e.getUsuario().getContraseña().equals(contraseña)) {
                return e;
            }
        }
        return null;
    }

    // ======================================================
    // LISTA DE MATERIAS DISPONIBLES
    // ======================================================
    public List<Materia> obtenerMateriasDisponibles() {
        return materias;
    }
}
