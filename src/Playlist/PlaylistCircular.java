package Playlist;

public class PlaylistCircular {
    private Cancion actual;
    private Cancion cabeza;

    public void agregarCancion(String titulo, String artista) {
        Cancion nueva = new Cancion(titulo, artista);
        if (cabeza == null) {
            cabeza = nueva;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
            actual = cabeza;
        } else {
            Cancion cola = cabeza.anterior;
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
        }
        System.out.println("Canción agregada: " + titulo);
    }

    public void reproducirSiguiente() {
        if (actual != null) {
            actual = actual.siguiente;
            mostrarActual();
        }
    }

    public void reproducirAnterior() {
        if (actual != null) {
            actual = actual.anterior;
            mostrarActual();
        }
    }

    public void eliminarActual() {
        if (actual == null) return;

        if (actual.siguiente == actual) {
            cabeza = null;
            actual = null;
        } else {
            Cancion anteriorNode = actual.anterior;
            Cancion siguienteNode = actual.siguiente;

            anteriorNode.siguiente = siguienteNode;
            siguienteNode.anterior = anteriorNode;

            if (actual == cabeza) cabeza = siguienteNode;
            actual = siguienteNode;
        }
        System.out.println("Canción eliminada.");
        mostrarActual();
    }

    public void mostrarActual() {
        if (actual != null) {
            System.out.println("Reproduciendo: " + actual.titulo + " - " + actual.artista);
        } else {
            System.out.println("Playlist vacía.");
        }
    }
}