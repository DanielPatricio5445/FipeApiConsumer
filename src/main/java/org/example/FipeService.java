package org.example;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.IOException;

public class FipeService {
    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
    private static final Gson gson = new Gson();

    public static void listarMarcas() throws IOException {
        String json = HttpClient.fazerRequisicao(BASE_URL);
        JsonArray marcas = gson.fromJson(json, JsonArray.class);

        System.out.println("Lista de Marcas:");
        for (var marca : marcas) {
            JsonObject obj = marca.getAsJsonObject();
            System.out.println(obj.get("codigo").getAsString() + ": " + obj.get("nome").getAsString());
        }
    }

    public static void listarModelos(String idMarca) throws IOException {
        String json = HttpClient.fazerRequisicao(BASE_URL + "/" + idMarca + "/modelos");
        JsonObject responseObject = gson.fromJson(json, JsonObject.class);
        JsonArray modelos = responseObject.getAsJsonArray("modelos");

        System.out.println("Lista de Modelos:");
        for (var modelo : modelos) {
            JsonObject obj = modelo.getAsJsonObject();
            System.out.println(obj.get("codigo").getAsString() + ": " + obj.get("nome").getAsString());
        }
    }

    public static void listarAnos(String idMarca, String idModelo) throws IOException {
        String json = HttpClient.fazerRequisicao(BASE_URL + "/" + idMarca + "/modelos/" + idModelo + "/anos");
        JsonArray anos = gson.fromJson(json, JsonArray.class);

        System.out.println("Lista de Anos:");
        for (var ano : anos) {
            JsonObject obj = ano.getAsJsonObject();
            System.out.println(obj.get("codigo").getAsString());
        }
    }

    public static void obterPreco(String idMarca, String idModelo, String ano) throws IOException {
        String json = HttpClient.fazerRequisicao(BASE_URL + "/" + idMarca + "/modelos/" + idModelo + "/anos/" + ano);
        JsonObject obj = gson.fromJson(json, JsonObject.class);

        System.out.println("Preço: " + obj.get("Valor").getAsString());
    }
}
