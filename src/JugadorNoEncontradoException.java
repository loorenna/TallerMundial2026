public class JugadorNoEncontradoException extends Exception {
    public JugadorNoEncontradoException(int id) {
        super("❌ No se encontró jugador con ID: " + id);
    }

    public JugadorNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
