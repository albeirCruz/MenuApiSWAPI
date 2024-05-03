package com.codigoPrueba.apiSwapi;

import com.codigoPrueba.apiSwapi.herramientas.Api;
import com.codigoPrueba.apiSwapi.herramientas.Json;
import com.codigoPrueba.apiSwapi.modelos.Titulo;
import com.codigoPrueba.apiSwapi.modelos.TituloOmbd;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        Api conexion = new Api();
        Gson gson = new Gson();
        List<String> nombresTitulos = new LinkedList<>();

        int seleccion = 0;
        String json = "";

        for (int i = 0; i < 7; i++) {
            nombresTitulos.add(mostrarNombreTitulo(String.valueOf(i+1)));
        }

        while (seleccion != 8) {
            System.out.println(String.format("\nSelecciona Tu Pelicula:\n" +
                            "1.%s\n" +
                            "2.%s\n" +
                            "3.%s\n" +
                            "4.%s\n" +
                            "5.%s\n" +
                            "6.%s\n" +
                            "7.%s\n" +
                            "8.Salir", nombresTitulos.get(0), nombresTitulos.get(1), nombresTitulos.get(2), nombresTitulos.get(3),
                    nombresTitulos.get(4), nombresTitulos.get(5), nombresTitulos.get(6)));
            seleccion = scan.nextInt();

            switch (seleccion) {
                case 1:
                    mostrarTitulo("1");
                    break;
                case 2:
                    mostrarTitulo("2");
                    break;
                case 3:
                    mostrarTitulo("3");
                    break;
                case 4:
                    mostrarTitulo("4");
                    break;
                case 5:
                    mostrarTitulo("5");
                    break;
                case 6:
                    mostrarTitulo("6");
                    break;
                case 7:
                    mostrarTitulo("7");
                    break;
                case 8:
                    System.out.println("Bye Bye");
                    break;
                default:
                    System.out.println("Fuera de Rango");
                    break;
            }
        }
    }

    public static String mostrarNombreTitulo (String index){
        Api conexion = new Api();
        Gson gson = new Gson();

        String json = "";

        conexion.setNumeroPelicula(index);
        json = conexion.conexionApi();
        TituloOmbd titulo = gson.fromJson(json, TituloOmbd.class);
        Titulo pelicula = new Titulo(titulo);
        return pelicula.getNombre();
    }

    public static void mostrarTitulo (String index){
        Api conexion = new Api();
        Gson gson = new Gson();

        String json = "";

        try {
            conexion.setNumeroPelicula(index);
            json = conexion.conexionApi();
            TituloOmbd titulo = gson.fromJson(json, TituloOmbd.class);
            Titulo pelicula = new Titulo(titulo);
            System.out.println(pelicula);
            Json crearArchivo = new Json();
            crearArchivo.crearArchivoJson(pelicula);
        } catch (RuntimeException | IOException e){
            System.out.println("No funciono y se cerro la consulta"+e.getMessage());
        }

    }
}


