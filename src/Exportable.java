public interface Exportable {

    // Toda clase exportable debe poder dar sus datos
    String exportarDatos();   // formato legible
    String exportarCSV();    // formato CSV
}
