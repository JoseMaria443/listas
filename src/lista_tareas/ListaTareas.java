package lista_tareas;

public class ListaTareas {
    private Tarea cabeza;

    private int nivelPrioridad(String p) {
        if (p.equalsIgnoreCase("alta")) return 3;
        if (p.equalsIgnoreCase("media")) return 2;
        return 1;
    }

    public void agregarTarea(String descripcion, String prioridad) {
        Tarea nueva = new Tarea(descripcion, prioridad);

        if (cabeza == null || nivelPrioridad(prioridad) > nivelPrioridad(cabeza.prioridad)) {
            nueva.siguiente = cabeza;
            cabeza = nueva;
        } else {
            Tarea actual = cabeza;
            while (actual.siguiente != null &&
                    nivelPrioridad(actual.siguiente.prioridad) >= nivelPrioridad(prioridad)) {
                actual = actual.siguiente;
            }
            nueva.siguiente = actual.siguiente;
            actual.siguiente = nueva;
        }
        System.out.println("Tarea agregada: " + descripcion);
    }

    public void completarTarea(String descripcion) {
        if (cabeza == null) return;

        if (cabeza.descripcion.equals(descripcion)) {
            cabeza = cabeza.siguiente;
            System.out.println("Tarea completada: " + descripcion);
            return;
        }

        Tarea actual = cabeza;
        while (actual.siguiente != null && !actual.siguiente.descripcion.equals(descripcion)) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            System.out.println("Tarea completada: " + descripcion);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void mostrarTareas() {
        Tarea actual = cabeza;
        System.out.println("--- Lista de Tareas ---");
        while (actual != null) {
            System.out.println("[" + actual.prioridad + "] " + actual.descripcion);
            actual = actual.siguiente;
        }
    }

    public void buscarTarea(String descripcion) {
        Tarea actual = cabeza;
        while (actual != null) {
            if (actual.descripcion.equals(descripcion)) {
                System.out.println("Tarea encontrada: " + actual.descripcion + " (" + actual.prioridad + ")");
                return;
            }
            actual = actual.siguiente;
        }
        System.out.println("Tarea no encontrada.");
    }
}