package com.codigoPrueba.apiSwapi.modelos;

public class Titulo {

    private String nombre;
    private String prologo;
    private String fechaLanzamiento;


    public Titulo(String nombre, String prologo, String fechaLanzamiento) {
        this.nombre = nombre;
        this.prologo = prologo;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Titulo(TituloOmbd titulo) {
        this.nombre = titulo.title();
        this.prologo = titulo.opening_crawl();
        this.fechaLanzamiento = titulo.release_date();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre+ "\n"+
                "\nPrologo: \n" + prologo+ "\n"+
                "\nFechaLanzamiento: " + fechaLanzamiento;

    }
}
