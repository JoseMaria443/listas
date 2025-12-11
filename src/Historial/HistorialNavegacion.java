package Historial;

public class HistorialNavegacion {
    private PaginaWeb cabeza;
    private PaginaWeb actual;
    private int tamanoActual = 0;
    private final int MAX_HISTORIAL = 10;

    public void visitarPagina(String url, String titulo) {
        PaginaWeb nueva = new PaginaWeb(url, titulo);

        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
            tamanoActual++;
        } else {
            if (actual.siguiente != null) {
                borrarFuturo(actual.siguiente);
            }

            actual.siguiente = nueva;
            nueva.anterior = actual;
            actual = nueva;
            tamanoActual++;
        }

        if (tamanoActual > MAX_HISTORIAL) {
            eliminarMasAntigua();
        }

        System.out.println("Visitando: " + titulo);
    }

    private void borrarFuturo(PaginaWeb desde) {
        PaginaWeb temp = desde;
        while (temp != null) {
            tamanoActual--;
            temp = temp.siguiente;
        }
        actual.siguiente = null;
    }

    private void eliminarMasAntigua() {
        if (cabeza != null) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) cabeza.anterior = null;
            tamanoActual--;
        }
    }

    public void atras() {
        if (actual != null && actual.anterior != null) {
            actual = actual.anterior;
            System.out.println("Atrás -> " + actual.titulo);
        } else {
            System.out.println("No hay historial previo.");
        }
    }

    public void adelante() {
        if (actual != null && actual.siguiente != null) {
            actual = actual.siguiente;
            System.out.println("Adelante -> " + actual.titulo);
        } else {
            System.out.println("No hay historial siguiente.");
        }
    }

    public void mostrarHistorial() {
        PaginaWeb temp = cabeza;
        System.out.println("--- Historial ---");
        while (temp != null) {
            String marcador = (temp == actual) ? " <(ACTUAL)" : "";
            System.out.println(temp.fechaVisita + " | " + temp.titulo + marcador);
            temp = temp.siguiente;
        }
    }
}