package br.com.alura.screenmatch.excecao;

public class conversaoDuracaoException extends RuntimeException {
    private String mensagem;
    public conversaoDuracaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage() {
        return this.mensagem;
    }
}
