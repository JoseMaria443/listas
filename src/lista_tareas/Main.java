package lista_tareas;

public class Main {
    public static void main(String[] args) {
        ListaTareas lista = new ListaTareas();

        lista.agregarTarea("Comprar leche", "baja");
        lista.agregarTarea("Estudiar para examen", "alta");
        lista.agregarTarea("Lavar el coche", "media");

        System.out.println("\n--- Tareas ordenadas automáticamente ---");
        lista.mostrarTareas();

        System.out.println("\n--- Completando tarea ---");
        lista.completarTarea("Estudiar para examen");
        lista.mostrarTareas();
    }
}