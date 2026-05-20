import java.util.ArrayList;
public interface Calificable {

    // Constante de la interfaz
    double CALIFICACION_MAXIMA = 10.0;
    double CALIFICACION_MINIMA = 0.0;

    // MÉTODOS ABSTRACTOS — toda clase que implemente
    // esta interfaz DEBE tener estos métodos
    double calcularCalificacion();
    String getNivelRendimiento();

    // MÉTODO DEFAULT (Java 8+) — tiene implementación opcional
    default boolean superaPromedioMundial() {
        return calcularCalificacion() >= 6.0;
    }

}