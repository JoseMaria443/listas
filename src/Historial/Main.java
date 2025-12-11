package Historial;

public class Main {
    public static void main(String[] args) {
        HistorialNavegacion navegador = new HistorialNavegacion();

        navegador.visitarPagina("google.com", "Google");
        navegador.visitarPagina("youtube.com", "YouTube");
        navegador.visitarPagina("facebook.com", "Facebook");

        navegador.mostrarHistorial();

        System.out.println("\n--- Navegando Atrás ---");
        navegador.atras();

        System.out.println("\n--- Visitando nueva página ---");
        navegador.visitarPagina("twitter.com", "Twitter");

        navegador.mostrarHistorial();
    }
}