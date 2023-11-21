package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.conexao.ConexaoApi;
import br.com.alura.screenmatch.conexao.ConexaoGson;
import br.com.alura.screenmatch.modelo.Titulo;
import br.com.alura.screenmatch.modelo.TituloOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PrincipalComBusca {
    public static void main(String[]args) throws IOException, InterruptedException {
//        Declarando as variáveis instanciadas
        Scanner entrada = new Scanner(System.in);
        ArrayList<Titulo> titulos = new ArrayList<>();
        ConexaoGson conexaoGson = new ConexaoGson();
        FileWriter notas = new FileWriter("arquivo.json");
//        // Fim declarando as variáveis instânciadas

//        Declarando as variáveis não instanciadas
        String resposta = "";
        TituloOmdb meuTituloOmdb;
        ConexaoApi conexaoApi;
//        Fim da declaração de variáveis não instanciadas


//        Começo tentando rodar o try
        try {
//            Começo do loop while
            while (!resposta.equalsIgnoreCase("sair")) {
                System.out.println("Informe o nome do filme: ");
                resposta = entrada.nextLine();
                conexaoApi = new ConexaoApi(resposta);

                if (resposta.equalsIgnoreCase("sair")) {
                    break;
                }

//                Referenciando os objetos de conexão
                String json = conexaoApi.getJson();
                meuTituloOmdb = conexaoGson.jsonParaFilme(json);
                Titulo meuTitulo = new Titulo(meuTituloOmdb);

                System.out.println(meuTitulo);

//                Adicionando os titulos ao array <titulos>
                titulos.add(meuTitulo);

//                Escrevendo no documento .json os itens dentro do array<titulos>
                notas.write(conexaoGson.toJson(titulos));
                notas.close();
            }
//            // Fim do loop while
        } catch (NumberFormatException ex) {
            System.out.println("Ocorreu um erro ao converter o ano");
            System.out.println(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.out.println("Houve algum erro ao informar o nome do filme.");
            System.out.println(ex.getMessage());
        } /* catch (conversaoDuracaoException ex) {
             System.out.println(ex.getMessage());
        } */
//        Fim tentando rdar o try
        System.out.println(titulos);
    }
}
