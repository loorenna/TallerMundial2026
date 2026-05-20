public class Jugador extends Persona implements Calificable, Exportable {

    // Atributos propios del Jugador (privados = encapsulamiento)
    private String posicion;       // "Delantero", "Portero", etc.
    private int    dorsal;
    private int    goles;
    private int    asistencias;
    private int    minutosJugados;
    private String equipo;

    // Constructor — llama al super (Persona)
    public Jugador(
            int id,
            String nombre,
            int edad,
            String nacionalidad,
            String posicion,
            int dorsal,
            String equipo,
            int goles,
            int asistencias,
            int minutosJugados
    ){
        super(id, nombre, edad, nacionalidad); // Constructor padre

        // Validar dorsal (1-99)
        if (dorsal < 1 || dorsal > 99)
            throw new IllegalArgumentException("Dorsal inválido: " + dorsal);

        this.posicion       = posicion;
        this.dorsal         = dorsal;
        this.goles = goles;
        this.asistencias = asistencias;
        this.minutosJugados = minutosJugados;
        this.equipo         = equipo;
    }

    // Getters y Setters con validación
    public int getGoles() { return goles; }
    public void setGoles(int goles) {
        if (goles < 0) throw new IllegalArgumentException("Goles no puede ser negativo");
        this.goles = goles;
    }
    public int    getDorsal()         { return dorsal; }
    public int    getAsistencias()    { return asistencias; }
    public String getPosicion()       { return posicion; }
    public String getEquipo()         { return equipo; }
    public int    getMinutosJugados() { return minutosJugados; }

    public void setAsistencias(int asistencias) {

        if (asistencias < 0) {
            throw new IllegalArgumentException(
                    "Las asistencias no pueden ser negativas."
            );
        }

        this.asistencias = asistencias;
    }

    public void setMinutosJugados(int minutosJugados) {
        this.minutosJugados = minutosJugados;
    }

    // MÉTODO PROPIO — Cálculo goles por 90 minutos
    public double calcularGolesP90() {
        if (minutosJugados == 0) return 0.0;
        return ((double) goles / minutosJugados) * 90;
    }

    // MÉTODO PROPIO — ¿Es titular? (más de 45 min/partido)
    public boolean esTitular() {
        return minutosJugados > 45;
    }

    // IMPLEMENTACIÓN de Calificable (interfaz)
    @Override
    public double calcularCalificacion() {
        // Fórmula: goles*3 + asistencias*1.5 + (minutos/90)*0.5
        double calif = (goles * 3.0)
                + (asistencias * 1.5)
                + ((minutosJugados / 90.0) * 0.5);
        // Conversión: limitar a escala 0-10
        return Math.min(calif, 10.0);
    }

    @Override
    public String getNivelRendimiento() {
        double c = calcularCalificacion();
        if (c >= 8) return "⭐ ESTRELLA";
        if (c >= 6) return "✅ BUENO";
        if (c >= 4) return "⚠️ REGULAR";
        return "❌ BAJO";
    }

    // IMPLEMENTACIÓN de Exportable (interfaz)
    @Override
    public String exportarDatos() {
        return "Jugador: " + getNombre() + " | Equipo: " + equipo
                + " | Goles: " + goles + " | Calif: "
                + String.format("%.2f", calcularCalificacion());
    }

    @Override
    public String exportarCSV() {
        // CONVERSIÓN: int/double → String para CSV
        return getId() + "," + getNombre() + ","
                + getNacionalidad() + "," + posicion + ","
                + dorsal + "," + goles + ","
                + asistencias + "," + equipo;
    }

    // OVERRIDE de Persona — POLIMORFISMO
    @Override
    public String describir() {
        return "⚽ JUGADOR: " + toString()
                + "\n   Posición: " + posicion
                + " | Dorsal: #" + dorsal
                + " | Equipo: " + equipo
                + "\n   Goles: " + goles
                + " | Asistencias: " + asistencias
                + " | Minutos: " + minutosJugados
                + "\n   Calificación: " + String.format("%.2f", calcularCalificacion())
                + " — " + getNivelRendimiento();
    }
}