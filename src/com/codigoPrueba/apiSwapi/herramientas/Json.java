package com.codigoPrueba.apiSwapi.herramientas;

import com.codigoPrueba.apiSwapi.modelos.Titulo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Json {
    public void crearArchivoJson(Titulo titulo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(titulo.getNombre()+".json");
        escritura.write(gson.toJson(titulo));
        escritura.close();
    }
}
