abstract class Persona {
    //Atributos privados
    private int    id;
    private String nombre;
    private int    edad;
    private String nacionalidad;

    //Constructor
    public Persona(int id, String nombre, int edad, String nacionalidad) {
        // VALIDACIÓN en constructor
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        if (edad < 0 || edad > 120)
            throw new IllegalArgumentException("Edad inválida: " + edad);

        this.id          = id;
        this.nombre      = nombre.trim();
        this.edad        = edad;
        this.nacionalidad = nacionalidad;
    }

    //Getters
    public int    getId()            { return id; }
    public String getNombre()        { return nombre; }
    public int    getEdad()           { return edad; }
    public String getNacionalidad()   { return nacionalidad; }

    //Setters con validación
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad < 0 || edad > 120)
            throw new IllegalArgumentException("Edad inválida");
        this.edad = edad;
    }

    //Metodo abstracto, todas las hijas tienen q implementarlo
    public abstract String describir();

    //Método concreto disponible para todas las hijas
    public String toString() {
        return "[ID:" + id + "] " + nombre +
                " (" + edad + " años) — " + nacionalidad;
    }



}
