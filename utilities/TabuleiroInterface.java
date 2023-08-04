public interface TabuleiroInterface {
    void inicializar();

    void imprimir();

    boolean colunaValida(int coluna);

    boolean colunaCheia(int coluna);

    boolean posicaoValida(int linha, int coluna);

    Cor getPeca(int linha, int coluna) throws IllegalArgumentException;

    void setPeca(int linha, int coluna, Cor cor) throws IllegalArgumentException;

    int obterLinhaInsercao(int coluna);

    void inserirPeca(int coluna, Cor cor);

    int getColunas();

    int getLinhas();

    void adicionarPeca(int linhaInsercao, int coluna, Cor cor);
}
