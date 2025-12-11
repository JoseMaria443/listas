package lista_tareas;

public class Tarea {
    String descripcion;
    String prioridad;
    Tarea siguiente;

    public Tarea(String descripcion, String prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.siguiente = null;
    }
}