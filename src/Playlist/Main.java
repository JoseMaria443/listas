package Playlist;

public class Main {
    public static void main(String[] args) {
        PlaylistCircular playlist = new PlaylistCircular();

        playlist.agregarCancion("Bohemian Rhapsody", "Queen");
        playlist.agregarCancion("Billie Jean", "Michael Jackson");
        playlist.agregarCancion("Imagine", "John Lennon");

        System.out.println("\n--- Reproduciendo ---");
        playlist.mostrarActual();

        System.out.println(">> Siguiente");
        playlist.reproducirSiguiente();

        System.out.println(">> Siguiente");
        playlist.reproducirSiguiente();

        System.out.println(">> Siguiente (Circular)");
        playlist.reproducirSiguiente();

        System.out.println("<< Anterior (Circular)");
        playlist.reproducirAnterior();
    }
}