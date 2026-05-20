import java.util.*;

public class GestorMundial {

    private ArrayList<Jugador> jugadores;
    private ArrayList<Tecnico> tecnicos;
    private Scanner sc;
    private int contadorId;

    public GestorMundial() {
        jugadores = new ArrayList<>();
        tecnicos = new ArrayList<>();
        sc = new Scanner(System.in);
        contadorId = 1;
    }

    public void agregarJugador() {

        System.out.println("\n➕ REGISTRAR NUEVO JUGADOR");

        try {

            System.out.print("Nombre: ");
            String nombre = sc.nextLine().trim();

            int edad = leerEntero("Edad", 15, 50);

            System.out.print("Nacionalidad: ");
            String nac = sc.nextLine().trim();

            System.out.print("Posición (Delantero/Mediocampista/Defensa/Portero): ");
            String pos = sc.nextLine().trim();

            int dorsal = leerEntero("Dorsal (1-99):", 1, 99);

            System.out.print("Equipo: ");
            String equipo = sc.nextLine().trim();

            int goles = leerEntero("Goles", 0, 999);

            int asistencias =
                    leerEntero("Asistencias", 0, 999);

            int minutosJugados =
                    leerEntero("Minutos jugados", 0, 99999);

            Jugador j = new Jugador(
                    contadorId++,
                    nombre,
                    edad,
                    nac,
                    pos,
                    dorsal,
                    equipo,
                    goles,
                    asistencias,
                    minutosJugados
            );

            jugadores.add(j);

            System.out.println(
                    "✅ Jugador registrado correctamente."
            );

        } catch (IllegalArgumentException e) {

            System.out.println("❌ " + e.getMessage());
        }
    }

    public void listarJugadores() {
        System.out.println("\n📋 LISTA DE JUGADORES");

        if (jugadores.isEmpty()) {
            System.out.println("⚠️ No hay jugadores registrados.");
            return;
        }

        for (Jugador j : jugadores) {
            System.out.println(j.describir());
            System.out.println("─────────────────────");
        }
    }

    public Jugador buscarJugadorPorId(int id) throws JugadorNoEncontradoException {

        for (Jugador j : jugadores) {
            if (j.getId() == id) {
                return j;
            }
        }

        throw new JugadorNoEncontradoException(id);
    }

    public void buscarJugadorPorIdMenu() {

        try {
            int id = leerEntero("ID", 1, Integer.MAX_VALUE);

            Jugador j = buscarJugadorPorId(id);

            System.out.println("\n✅ JUGADOR ENCONTRADO");
            System.out.println(j.describir());

        } catch (JugadorNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarGoles() {

        try {
            int id = leerEntero("ID del jugador", 1, Integer.MAX_VALUE);

            Jugador j = buscarJugadorPorId(id);

            int goles = leerEntero("Nuevos goles", 0, 999);

            j.setGoles(goles);

            System.out.println("✅ Goles actualizados correctamente.");

        } catch (JugadorNoEncontradoException e) {
            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    public void eliminarJugador() {

        try {
            int id = leerEntero("ID del jugador", 1, Integer.MAX_VALUE);

            Jugador j = buscarJugadorPorId(id);

            jugadores.remove(j);

            System.out.println("✅ Jugador eliminado correctamente.");

        } catch (JugadorNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarEstadisticas() {

        System.out.println("\n📊 ESTADÍSTICAS");
        System.out.println("Total jugadores: " + jugadores.size());

        int totalGoles = 0;
        Jugador goleador = null;

        for (Jugador j : jugadores) {
            totalGoles += j.getGoles();

            if (goleador == null || j.getGoles() > goleador.getGoles()) {
                goleador = j;
            }
        }

        System.out.println("Total goles: " + totalGoles);

        if (goleador != null) {
            System.out.println("🥇 Máximo goleador: " + goleador.getNombre());
        }
    }

    private int leerEntero(String campo, int min, int max) {

        while (true) {

            try {
                System.out.print(campo + ": ");

                int valor = Integer.parseInt(sc.nextLine());

                if (valor < min || valor > max) {
                    System.out.println("⚠️ Valor fuera de rango.");
                    continue;
                }

                return valor;

            } catch (NumberFormatException e) {
                System.out.println("❌ Debes ingresar un número entero.");
            }
        }
    }

    public void exportarTodos() {

        if (jugadores.isEmpty()) {
            System.out.println("⚠️ No hay jugadores para exportar.");
            return;
        }

        System.out.println("\n📤 DATOS EXPORTADOS");

        for (Jugador j : jugadores) {
            System.out.println(j.exportarCSV());
        }
    }

    public void actualizarAsistencias() {

        try {

            int id = leerEntero("ID del jugador", 1, Integer.MAX_VALUE);

            Jugador j = buscarJugadorPorId(id);

            int asistencias =
                    leerEntero("Nuevas asistencias", 0, 999);

            j.setAsistencias(asistencias);

            System.out.println(
                    "✅ Asistencias actualizadas correctamente."
            );

        } catch (JugadorNoEncontradoException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("❌ " + e.getMessage());
        }
    }
    public void actualizarMinutosJugados() {

        try {

            int id =
                    leerEntero("ID del jugador", 1, Integer.MAX_VALUE);

            Jugador j = buscarJugadorPorId(id);

            int minutos =
                    leerEntero("Nuevos minutos jugados", 0, 999999);

            j.setMinutosJugados(minutos);

            System.out.println(
                    "✅ Minutos actualizados correctamente."
            );

        } catch (JugadorNoEncontradoException e) {

            System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("❌ " + e.getMessage());
        }
    }

}