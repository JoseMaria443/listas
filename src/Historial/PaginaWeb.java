package Historial;

import java.util.Date;

public class PaginaWeb {
    String url;
    String titulo;
    Date fechaVisita;
    PaginaWeb siguiente;
    PaginaWeb anterior;

    public PaginaWeb(String url, String titulo) {
        this.url = url;
        this.titulo = titulo;
        this.fechaVisita = new Date();
    }
}