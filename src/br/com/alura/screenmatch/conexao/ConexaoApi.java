package br.com.alura.screenmatch.conexao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoApi {
    private final String busca;
    private String json = "";

    public ConexaoApi(String busca) throws IOException, InterruptedException {
        this.busca = busca;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=a745f28e"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        this.json = response.body();
    }

    public String getJson() {
        return json;
    }

}
