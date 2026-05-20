import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GestorMundial gestor = new GestorMundial();
        Scanner sc = new Scanner(System.in);

        int opcion;

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   ⚽ SISTEMA MUNDIAL FIFA 2026 🏆    ║");
        System.out.println("╚══════════════════════════════════════╝");

        do {

            System.out.println("\n═══════ MENÚ PRINCIPAL ═══════");
            System.out.println("1. ➕ Registrar Jugador");
            System.out.println("2. 📋 Listar Jugadores");
            System.out.println("3. 🔍 Buscar Jugador por ID");
            System.out.println("4. ✏️ Actualizar Goles");
            System.out.println("5. 🎯 Actualizar Asistencias");
            System.out.println("6. 🎯 Actualizar Minutos Jugados");
            System.out.println("7. 🗑️ Eliminar Jugador");
            System.out.println("8. 📊 Ver Estadísticas");
            System.out.println("9. 📤 Exportar CSV");
            System.out.println("0. 🚪 Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("❌ Debes ingresar un número.");
                opcion = -1;
                continue;
            }

            switch (opcion) {

                case 1:
                    gestor.agregarJugador();
                    break;

                case 2:
                    gestor.listarJugadores();
                    break;

                case 3:
                    gestor.buscarJugadorPorIdMenu();
                    break;

                case 4:
                    gestor.actualizarGoles();
                    break;
                case 5:
                    gestor.actualizarAsistencias();
                    break;
                case 6:
                    gestor.actualizarMinutosJugados();
                    break;

                case 7:
                    gestor.eliminarJugador();
                    break;

                case 8:
                    gestor.mostrarEstadisticas();
                    break;

                case 9:
                    gestor.exportarTodos();
                    break;

                case 0:
                    System.out.println("👋 Programa finalizado.");
                    break;

                default:
                    System.out.println("⚠️ Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}