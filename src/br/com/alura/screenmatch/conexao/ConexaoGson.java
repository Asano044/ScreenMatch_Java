package br.com.alura.screenmatch.conexao;

import br.com.alura.screenmatch.modelo.Titulo;
import br.com.alura.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ConexaoGson {
//    Declarando as variáveis
    private String json;

//    Criando a conexão com a biblioteca Gson
    Gson gson = new GsonBuilder().
            setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public TituloOmdb jsonParaFilme(String json) {
        return gson.fromJson(json, TituloOmdb.class);
    }

    public String toJson(ArrayList<Titulo> titulos) {
        return gson.toJson(titulos);
    }
}
